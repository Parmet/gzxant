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
     * 获取用户的 私人菜单
     * @param userId
     * @return
     */
    List<ShopSku> selectMenusByUserId(Long userId);

    List<ShopSku> CaseMenu(Long userId);

    /**
     * 获取菜单树
     * @return
     */
    List<JsTree> getMenuTree();

    /**
     * 保存菜单
     * @param shopSku
     */
    void add(ShopSku shopSku);

    /**
     * 更新菜单
     * @param shopSku
     */
    void update(ShopSku shopSku);

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
