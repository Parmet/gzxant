package com.gzxant.entity.car.booking.driver;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 司机信息
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-10
 */
@TableName("car_booking_driver")
public class CarBookingDriver extends DataEntity<CarBookingDriver> {

    private static final long serialVersionUID = 1L;

    /**
     * 司机编号
     */
	private String number;
    /**
     * 司机姓名
     */
	private String name;
    /**
     * 性别
     */
	private String sex;
    /**
     * 服务城市
     */
	private String city;
    /**
     * 联系电话
     */
	private String phone;
    /**
     * 生日
     */
	private Date birthday;
    /**
     * 头像
     */
	private String avatar;
    /**
     * 身份证号码
     */
	@TableField("id_card")
	private String idCard;
    /**
     * 驾驶证号码
     */
	private String license;
    /**
     * 驾驶证照片
     */
	@TableField("license_photo")
	private String licensePhoto;
    /**
     * 驾驶证领证日期
     */
	@TableField("license_receive_date")
	private Date licenseReceiveDate;
    /**
     * 驾驶证起始日期
     */
	@TableField("license_start_date")
	private Date licenseStartDate;
    /**
     * 驾驶证截至日期
     */
	@TableField("license_end_date")
	private Date licenseEndDate;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicensePhoto() {
		return licensePhoto;
	}

	public void setLicensePhoto(String licensePhoto) {
		this.licensePhoto = licensePhoto;
	}

	public Date getLicenseReceiveDate() {
		return licenseReceiveDate;
	}

	public void setLicenseReceiveDate(Date licenseReceiveDate) {
		this.licenseReceiveDate = licenseReceiveDate;
	}

	public Date getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public Date getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarBookingDriver{" +
			"number=" + number +
			", name=" + name +
			", sex=" + sex +
			", city=" + city +
			", phone=" + phone +
			", birthday=" + birthday +
			", avatar=" + avatar +
			", idCard=" + idCard +
			", license=" + license +
			", licensePhoto=" + licensePhoto +
			", licenseReceiveDate=" + licenseReceiveDate +
			", licenseStartDate=" + licenseStartDate +
			", licenseEndDate=" + licenseEndDate +
			"}";
	}
}
