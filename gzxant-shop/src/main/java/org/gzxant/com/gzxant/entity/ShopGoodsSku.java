package com.gzxant.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;

/**
 * <p>
 * 商城sku值
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-19
 */
@TableName("shop_goods_sku")
public class ShopGoodsSku extends BaseEntity<ShopGoodsSku> {

    private static final long serialVersionUID = 1L;

    /**
     * 排序
     */
    @TableId("goods_id")
	private Long goodsId;
	private String sku;
	@TableField("sku_val")
	private String skuVal;
	private Integer sort;


	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSkuVal() {
		return skuVal;
	}

	public void setSkuVal(String skuVal) {
		this.skuVal = skuVal;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	protected Serializable pkVal() {
		return this.goodsId;
	}

	@Override
	public String toString() {
		return "ShopGoodsSku{" +
			", goodsId=" + goodsId +
			", sku=" + sku +
			", skuVal=" + skuVal +
			", sort=" + sort +
			"}";
	}
}
