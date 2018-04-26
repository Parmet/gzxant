package com.gzxant.service.shop.sku;


import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.dao.shop.sku.ShopSkuDao;
import com.gzxant.entity.SysMenu;
import com.gzxant.entity.shop.sku.ShopSku;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * sku 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopSkuService extends BaseService<ShopSkuDao, ShopSku> implements IShopSkuService {

    /**
     * 菜单管理 菜单树
     *
     * @return
     */
    @Override
    public List<JsTree> getMenuTree() {
        List<SysMenu> shopSkus = selectList(Condition.create().orderBy("sort", true));
        return makeTree(shopSkus);
    }
}
