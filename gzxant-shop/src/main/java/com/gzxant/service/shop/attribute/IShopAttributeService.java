package com.gzxant.service.shop.attribute;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.entity.shop.attribute.ShopAttribute;

import java.util.List;

/**
 * <p>
 * attribute 服务类
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
public interface IShopAttributeService extends IBaseService<ShopAttribute> {
    /**
     * 获取用户的 私人菜单
     * @param userId
     * @return
     */
    List<ShopAttribute> selectMenusByUserId(Long userId);

    List<ShopAttribute> CaseMenu(Long userId);

    /**
     * 获取菜单树
     * @return
     */
    List<JsTree> getMenuTree();

    /**
     * 保存菜单
     * @param shopSku
     */
    void add(ShopAttribute shopSku);

    /**
     * 更新菜单
     * @param shopSku
     */
    void update(ShopAttribute shopSku);

    /**
     * 把菜单设置为失效
     * @param id
     */
    void disableMenu(Long id);

    /**
     * 删除菜单
     * @param id
     */
    Boolean deleteMenu(Long id);
}
