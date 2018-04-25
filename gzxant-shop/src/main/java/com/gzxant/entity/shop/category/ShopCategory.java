package com.gzxant.entity.shop.category;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.TreeEntity;

/**
 * <p>
 * 商城-分类表
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-24
 */
@TableName("shop_category")
public class ShopCategory extends TreeEntity<ShopCategory> {

    private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ShopCategory{" +
			"name=" + name +
			", parentId=" + parentId +
			", path=" + path +
			", sort=" + sort +
			", icon=" + icon +
			"}";
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}
}
