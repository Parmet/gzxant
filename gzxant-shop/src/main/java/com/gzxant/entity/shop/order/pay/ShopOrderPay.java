package com.gzxant.entity.shop.order.pay;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;

/**
 * <p>
 * 商城-订单支付表
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
@TableName("shop_order_pay")
public class ShopOrderPay extends BaseEntity<ShopOrderPay> {

    private static final long serialVersionUID = 1L;

	@TableField("order_id")
	private Long orderId;
	@TableField("pay_state")
	private Integer payState;
	@TableField("pay_time")
	private Date payTime;
	@TableField("pay_note")
	private String payNote;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPayNote() {
		return payNote;
	}

	public void setPayNote(String payNote) {
		this.payNote = payNote;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ShopOrderPay{" +
			"orderId=" + orderId +
			", payState=" + payState +
			", payTime=" + payTime +
			", payNote=" + payNote +
			"}";
	}
}
