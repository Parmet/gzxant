package com.gzxant.entity.car.booking.order;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 车辆预定订单
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-10
 */
@TableName("car_booking_order")
public class CarBookingOrder extends DataEntity<CarBookingOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
	private String number;
	/**
     * 客人联系电话
     */
	@TableField("guest_phone")
	private String guestPhone;
    /**
     * 订单类型 [CTRIP：携程定价，SELF：自主定价]
     */
	@TableField("order_type")
	private String orderType;
    /**
     * 产品类型 [HOME_MEET_AIRPORT：国内接机，HOME_OFF_AIRPORT：国内送机，HOME_MEET_TRAIN：国内接火车，HOME_OFF_TRAIN：国内送火车]
     */
	@TableField("product_type")
	private String productType;
    /**
     * 车型类型 [ECONOMICAL：经济的，COMFORTABLE：舒适的，DELUXE：豪华的，BUSSINESS：商务的]
     */
	@TableField("car_type")
	private String carType;
    /**
     * 用车城市
     */
	private String city;
    /**
     * 用车时间
     */
	@TableField("use_time")
	private String useTime;
    /**
     * 预定时间
     */
	@TableField("booking_time")
	private String bookingTime;
    /**
     * 订单状态 [PENDING_ORDER：待接单，PENDING_CAR：待派车，SEND_CAR：已派车，CHANGE_CAR：已改派司机，COMPLETED：已完成，CUSTOMER_CANCLE：客户取消，SELF_CALCLE：我方取消]
     */
	@TableField("order_state")
	private String orderState;
    /**
     * 收银状态 [PENDING_PAY：待付款，PAY：已付款，REFUNDED：已退款]
     */
	@TableField("pay_state")
	private String payState;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGuestPhone() {
		return guestPhone;
	}

	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarBookingOrder{" +
			"number=" + number +
			", orderType=" + orderType +
			", productType=" + productType +
			", carType=" + carType +
			", city=" + city +
			", useTime=" + useTime +
			", bookingTime=" + bookingTime +
			", orderState=" + orderState +
			", payState=" + payState +
			", updateId=" + updateId +
			"}";
	}
}
