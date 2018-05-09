package com.gzxant.service.shop.attribute;


import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.constant.Global;
import com.gzxant.dao.shop.attribute.ShopAttributeDao;
import com.gzxant.entity.shop.attribute.ShopAttribute;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * attribute 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopAttributeService extends BaseService<ShopAttributeDao, ShopAttribute> implements IShopAttributeService {

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;


    /**
     * 根据属性的id 或者该用户具有的菜单列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<ShopAttribute> selectMenusByUserId(Long userId) {
        return this.baseMapper.selectMenusByUserId(userId);
    }


    /**
     * 查询系统用户 侧边栏菜单
     *
     * @param userId
     * @return
     */
    @Cacheable(cacheNames="books", key="#userId")
    @Override
    public List<ShopAttribute> CaseMenu(Long userId) {

        Map<Long, List<ShopAttribute>> map = new HashMap();
        List<ShopAttribute> shopSkus = this.baseMapper.selectMenusByUserId(userId);

        for (ShopAttribute shopSku : shopSkus) {
            List<ShopAttribute> parentMenu = map.get(shopSku.getParentId());
            if (parentMenu == null) {
                parentMenu = new ArrayList();
            }
            parentMenu.add(shopSku);
            map.put(shopSku.getParentId(), parentMenu);
        }
        List<ShopAttribute> retList = MakeMenu(map, 0L);
        Collections.sort(retList);
        return retList;
    }

    /**
     * 查询系统用户 侧边栏菜单
     *
     * @param supId
     * @return
     */
    public List<ShopAttribute> MakeMenu(Map<Long, List<ShopAttribute>> map, Long supId) {
        List<ShopAttribute> shopSkus = new ArrayList();
        List<ShopAttribute> menuList = map.get(supId);
        if (menuList != null) {
            for (ShopAttribute me : menuList) {
                me.setChildren(MakeMenu(map, me.getId()));
                shopSkus.add(me);
            }
        }
        return shopSkus;
    }


    /**
     * 菜单管理 菜单树
     *
     * @return
     */
    @Override
    public List<JsTree> getMenuTree() {
        List<ShopAttribute> shopSkus = selectList(Condition.create().orderBy("sort", true));
        return makeTree(shopSkus);
    }


    /**
     * 新增菜单
     *
     * @param shopSku
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void add(ShopAttribute shopSku) {

        insert(shopSku);
        if (Global.TOP_TREE_NODE.equals(shopSku.getParentId())) {
            shopSku.setPath(shopSku.getId() + ".");
        } else {

            shopSku.setPath(shopSku.getPath() + shopSku.getId() + ".");
        }
        updateById(shopSku);
    }


    /**
     * 更新菜单
     *
     * @param shopSku
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void update(ShopAttribute shopSku) {
        updateById(shopSku);
    }

    /**
     * 把菜单设置为失效
     *
     * @param id
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void disableMenu(Long id) {
        ShopAttribute shopSku = selectById(id);
        Optional.ofNullable(shopSku).orElseThrow(() -> new SlifeException(HttpCodeEnum.NOT_FOUND));

        List<ShopAttribute> delList = selectList(Condition.create().like("path", shopSku.getPath(), SqlLike.RIGHT));
        delList.stream().parallel().forEach(menu -> menu.setShowFlag(Global.NO));
        updateBatchById(delList);
        //TODO 判断是否有角色，有角色要清理角色与资源关系
    }


    /**
     * 删除菜单和子菜单
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public Boolean deleteMenu(Long id) {
        ShopAttribute shopSku = selectById(id);
        Optional.ofNullable(shopSku).orElseThrow(() -> new SlifeException(HttpCodeEnum.NOT_FOUND));

        List<ShopAttribute> delList = selectList(Condition.create().like("path", shopSku.getPath(), SqlLike.RIGHT));
        List<Long> ids = delList.stream().parallel().map(menu -> menu.getId()).collect(Collectors.toList());
        deleteBatchIds(ids);
        //删除对应的角色关联
        sysRoleMenuService.delete(Condition.create().in("sys_menu_id", ids));
        return true;
    }
}
