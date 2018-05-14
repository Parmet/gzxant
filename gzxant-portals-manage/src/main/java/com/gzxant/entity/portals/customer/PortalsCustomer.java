package com.gzxant.entity.portals.customer;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 客户管理
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@TableName("portals_customer")
public class PortalsCustomer extends DataEntity<PortalsCustomer> {

    private static final long serialVersionUID = 1L;

    /**
     * 客户名称
     */
	@TableField("customer_name")
	private String customerName;
    /**
     * 客户logo图
     */
	@TableField("customer_logo")
	private String customerLogo;
    /**
     * 客户网站链接地址
     */
	@TableField("customer_address")
	private String customerAddress;
    /**
     * 标题我们的客户
     */
	@TableField("customer_title")
	private String customerTitle;
    /**
     * 标题下内容
     */
	@TableField("customer_content")
	private String customerContent;
	@TableField("update_id")
	private Long updateId;


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

	public String getCustomerTitle() {
		return customerTitle;
	}

	public void setCustomerTitle(String customerTitle) {
		this.customerTitle = customerTitle;
	}

	public String getCustomerContent() {
		return customerContent;
	}

	public void setCustomerContent(String customerContent) {
		this.customerContent = customerContent;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PortalsCustomer{" +
			"customerName=" + customerName +
			", customerLogo=" + customerLogo +
			", customerAddress=" + customerAddress +
			", customerTitle=" + customerTitle +
			", customerContent=" + customerContent +
			", updateId=" + updateId +
			"}";
	}
}
