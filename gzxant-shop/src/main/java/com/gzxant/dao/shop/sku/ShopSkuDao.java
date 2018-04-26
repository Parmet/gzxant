package com.gzxant.dao.shop.sku;

import com.gzxant.base.dao.TreeDao;
import com.gzxant.entity.shop.sku.ShopSku;

import java.util.List;

/**
 * <p>
  * sku Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
public interface ShopSkuDao extends TreeDao<ShopSku> {
    /**
     * 查询 用户的所有菜单
     *
     * @param userId
     * @return
     */
    List<ShopSku> selectMenusByUserId(Long userId);
}