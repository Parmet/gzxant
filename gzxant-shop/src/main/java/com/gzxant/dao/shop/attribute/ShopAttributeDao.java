package com.gzxant.dao.shop.attribute;

import com.gzxant.base.dao.TreeDao;
import com.gzxant.entity.shop.attribute.ShopAttribute;

import java.util.List;

/**
 * <p>
  * attribute Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
public interface ShopAttributeDao extends TreeDao<ShopAttribute> {
    /**
     * 查询 用户的所有菜单
     *
     * @param userId
     * @return
     */
    List<ShopAttribute> selectMenusByUserId(Long userId);
}