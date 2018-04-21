package com.gzxant.entity.shop.order.goods;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;

/**
 * <p>
 * 商城-订单商品表
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
@TableName("shop_order_goods")
public class ShopOrderGoods extends BaseEntity<ShopOrderGoods> {

    private static final long serialVersionUID = 1L;

    @TableId("order_id")
	private Long orderId;
	@TableField("goods_id")
	private Long goodsId;
	private Integer number;
	@TableField("seller_id")
	private Long sellerId;
	@TableField("seller_name")
	private String sellerName;
	@TableField("goods_name")
	private String goodsName;
	@TableField("total_price")
	private Double totalPrice;
	private Integer sort;


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	protected Serializable pkVal() {
		return this.orderId;
	}

	@Override
	public String toString() {
		return "ShopOrderGoods{" +
			"orderId=" + orderId +
			", goodsId=" + goodsId +
			", number=" + number +
			", sellerId=" + sellerId +
			", sellerName=" + sellerName +
			", goodsName=" + goodsName +
			", totalPrice=" + totalPrice +
			", sort=" + sort +
			"}";
	}
}
