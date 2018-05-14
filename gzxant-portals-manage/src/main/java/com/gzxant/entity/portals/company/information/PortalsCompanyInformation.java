package com.gzxant.entity.portals.company.information;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 公司信息
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
@TableName("portals_company_information")
public class PortalsCompanyInformation extends DataEntity<PortalsCompanyInformation> {

    private static final long serialVersionUID = 1L;

    /**
     * 公司logo
     */
	private String logo;
    /**
     * 首页轮播图片
     */
	private String shuffling;
    /**
     * 公司联系电话
     */
	private String phone;
    /**
     * 公司联系邮箱
     */
	private String email;
    /**
     * 公司联系qq
     */
	private String qq;
    /**
     * 公司地理位置
     */
	private String address;
    /**
     * 公司客户名称
     */
	@TableField("customer_name")
	private String customerName;
    /**
     * 公司客户的logo
     */
	@TableField("customer_logo")
	private String customerLogo;
    /**
     * 公司客户网站地址
     */
	@TableField("customer_address")
	private String customerAddress;


	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getShuffling() {
		return shuffling;
	}

	public void setShuffling(String shuffling) {
		this.shuffling = shuffling;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLogo() {
		return customerLogo;
	}

	public void setCustomerLogo(String customerLogo) {
		this.customerLogo = customerLogo;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PortalsCompanyInformation{" +
			"logo=" + logo +
			", shuffling=" + shuffling +
			", phone=" + phone +
			", email=" + email +
			", qq=" + qq +
			", address=" + address +
			", customerName=" + customerName +
			", customerLogo=" + customerLogo +
			", customerAddress=" + customerAddress +
			"}";
	}
}
