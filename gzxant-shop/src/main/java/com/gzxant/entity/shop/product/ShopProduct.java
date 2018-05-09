package com.gzxant.entity.shop.product;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 商城-产品表
 * </p>
 *
 * @author zt
 * @since 2018-04-27
 */
@TableName("shop_product")
public class ShopProduct extends DataEntity<ShopProduct> {

    private static final long serialVersionUID = 1L;

    /**
     * 产品分类id
     */
	@TableField("category_id")
	private Long categoryId;
    /**
     * 产品品牌id
     */
	@TableField("brand_id")
	private Long brandId;
	private String name;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ShopProduct{" +
			"categoryId=" + categoryId +
			", brandId=" + brandId +
			", name=" + name +
			", updateId=" + updateId +
			"}";
	}
}
