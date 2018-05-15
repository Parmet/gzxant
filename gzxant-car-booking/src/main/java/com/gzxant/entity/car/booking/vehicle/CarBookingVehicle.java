package com.gzxant.entity.car.booking.vehicle;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 车辆信息
 * </p>
 *
 * @author mojin
 * @since 2018-05-14
 */
@TableName("car_booking_vehicle")
public class CarBookingVehicle extends DataEntity<CarBookingVehicle> {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆编号
     */
	private String number;
    /**
     * 车辆品牌
     */
	private String brands;
    /**
     * 车牌号码
     */
	@TableField("license_plate")
	private String licensePlate;
    /**
     * 服务城市
     */
	private String city;
    /**
     * 车辆颜色
     */
	private String color;
    /**
     * 车辆类型
     */
	private String type;
    /**
     * 座位数
     */
	@TableField("vehicle_count")
	private Long vehicleCount;
    /**
     * 行李数
     */
	@TableField("luggage_count")
	private Long luggageCount;
    /**
     * 车辆出厂日期
     */
	@TableField("produce_date")
	private Date produceDate;
    /**
     * 车辆照片
     */
	@TableField("vehicle_photo")
	private String vehiclePhoto;
    /**
     * 车辆所属人(车主)
     */
	private String owner;
    /**
     * 运营证照片
     */
	@TableField("operations_photo")
	private String operationsPhoto;
    /**
     * 营运证有效期
     */
	@TableField("operations_end_date")
	private Date operationsEndDate;
    /**
     * 行驶证号码
     */
	private String license;
    /**
     * 行驶证截至日期
     */
	@TableField("license_end_date")
	private Date licenseEndDate;
    /**
     * 车辆年检证照片
     */
	@TableField("chack_photo")
	private String chackPhoto;
    /**
     * 车辆年检证截至日期
     */
	@TableField("chack_end_date")
	private Date chackEndDate;
    /**
     * 车辆保险证明照片
     */
	@TableField("insurance_photo")
	private String insurancePhoto;
    /**
     * 车辆保险证明截至日期
     */
	@TableField("insurance_end_date")
	private Date insuranceEndDate;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getVehicleCount() {
		return vehicleCount;
	}

	public void setVehicleCount(Long vehicleCount) {
		this.vehicleCount = vehicleCount;
	}

	public Long getLuggageCount() {
		return luggageCount;
	}

	public void setLuggageCount(Long luggageCount) {
		this.luggageCount = luggageCount;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public String getVehiclePhoto() {
		return vehiclePhoto;
	}

	public void setVehiclePhoto(String vehiclePhoto) {
		this.vehiclePhoto = vehiclePhoto;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOperationsPhoto() {
		return operationsPhoto;
	}

	public void setOperationsPhoto(String operationsPhoto) {
		this.operationsPhoto = operationsPhoto;
	}

	public Date getOperationsEndDate() {
		return operationsEndDate;
	}

	public void setOperationsEndDate(Date operationsEndDate) {
		this.operationsEndDate = operationsEndDate;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Date getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	public String getChackPhoto() {
		return chackPhoto;
	}

	public void setChackPhoto(String chackPhoto) {
		this.chackPhoto = chackPhoto;
	}

	public Date getChackEndDate() {
		return chackEndDate;
	}

	public void setChackEndDate(Date chackEndDate) {
		this.chackEndDate = chackEndDate;
	}

	public String getInsurancePhoto() {
		return insurancePhoto;
	}

	public void setInsurancePhoto(String insurancePhoto) {
		this.insurancePhoto = insurancePhoto;
	}

	public Date getInsuranceEndDate() {
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(Date insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarBookingVehicle{" +
			"number=" + number +
			", brands=" + brands +
			", licensePlate=" + licensePlate +
			", city=" + city +
			", color=" + color +
			", type=" + type +
			", vehicleCount=" + vehicleCount +
			", luggageCount=" + luggageCount +
			", produceDate=" + produceDate +
			", vehiclePhoto=" + vehiclePhoto +
			", owner=" + owner +
			", operationsPhoto=" + operationsPhoto +
			", operationsEndDate=" + operationsEndDate +
			", license=" + license +
			", licenseEndDate=" + licenseEndDate +
			", chackPhoto=" + chackPhoto +
			", chackEndDate=" + chackEndDate +
			", insurancePhoto=" + insurancePhoto +
			", insuranceEndDate=" + insuranceEndDate +
			"}";
	}
}
