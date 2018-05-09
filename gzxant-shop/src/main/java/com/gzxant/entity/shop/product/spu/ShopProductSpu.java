package com.gzxant.entity.shop.product.spu;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 产品属性表
 * </p>
 *
 * @author zt
 * @since 2018-04-27
 */
@TableName("shop_product_spu")
public class ShopProductSpu extends DataEntity<ShopProductSpu> {

    private static final long serialVersionUID = 1L;

    @TableId("product_id")
	private Long productId;
	@TableField("spu_id")
	private Long spuId;
	private Long sort;
    /**
     * 显示标记Y：显示；N：不显示
     */
	@TableField("view_flag")
	private String viewFlag;


	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSpuId() {
		return spuId;
	}

	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(String viewFlag) {
		this.viewFlag = viewFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.productId;
	}

	@Override
	public String toString() {
		return "ShopProductSpu{" +
			"productId=" + productId +
			", spuId=" + spuId +
			", sort=" + sort +
			", viewFlag=" + viewFlag +
			"}";
	}
}
