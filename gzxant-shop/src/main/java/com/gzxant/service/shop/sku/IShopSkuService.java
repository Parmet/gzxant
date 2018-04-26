package com.gzxant.service.shop.sku;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.entity.shop.sku.ShopSku;

import java.util.List;

/**
 * <p>
 * sku 服务类
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
public interface IShopSkuService extends IBaseService<ShopSku> {

    /**
     * 获取菜单树
     * @return
     */
    List<JsTree> getMenuTree();
}
