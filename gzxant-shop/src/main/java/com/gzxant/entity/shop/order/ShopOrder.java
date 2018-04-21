package com.gzxant.entity.shop.order;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 商城-订单表
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
@TableName("shop_order")
public class ShopOrder extends DataEntity<ShopOrder> {

    private static final long serialVersionUID = 1L;

	@TableField("user_id")
	private Long userId;
	private String state;
	@TableField("total_price")
	private Double totalPrice;
	@TableField("actual_price")
	private Double actualPrice;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ShopOrder{" +
			"userId=" + userId +
			", state=" + state +
			", totalPrice=" + totalPrice +
			", actualPrice=" + actualPrice +
			"}";
	}
}
