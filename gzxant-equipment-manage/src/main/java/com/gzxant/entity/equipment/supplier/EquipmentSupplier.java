package com.gzxant.entity.equipment.supplier;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 供应商
 * </p>
 *
 * @author mojinsheng
 * @since 2018-07-01
 */
@TableName("equipment_supplier")
public class EquipmentSupplier extends DataEntity<EquipmentSupplier> {

    private static final long serialVersionUID = 1L;

    /**
     * 注册邮箱
     */
	private String emial;
    /**
     * 企业总部所在地是否在国内
     */
	@TableField("enterprise_where")
	private String enterpriseWhere;
    /**
     * 国内总部地址
     */
	@TableField("domestic_address")
	private String domesticAddress;
    /**
     * 企业性质
     */
	@TableField("enterprise_nature")
	private String enterpriseNature;
    /**
     * 企业中文名称
     */
	@TableField("enterprise_chinese_name")
	private String enterpriseChineseName;
    /**
     * 企业英文名称
     */
	@TableField("enterprise_english_name")
	private String enterpriseEnglishName;
    /**
     * 企业网站
     */
	@TableField("enterprise_website")
	private String enterpriseWebsite;
    /**
     * 企业规模
     */
	@TableField("enterprise_scale")
	private String enterpriseScale;
    /**
     * 年产值
     */
	@TableField("output_value")
	private String outputValue;
    /**
     * 经营范围
     */
	@TableField("business_scope")
	private String businessScope;
    /**
     * 主攻行业
     */
	@TableField("announcement_number")
	private String announcementNumber;
    /**
     * 企业简介
     */
	@TableField("enterprise_introduction")
	private String enterpriseIntroduction;
    /**
     * 联系人姓名
     */
	@TableField("contact_name")
	private String contactName;
    /**
     * 职位
     */
	private String position;
    /**
     * 办公电话
     */
	private String phone;
    /**
     * 手机号码
     */
	@TableField("cellphone_number")
	private String cellphoneNumber;
    /**
     * 传真
     */
	private String fax;
    /**
     * 通信地址
     */
	@TableField("contact_address")
	private String contactAddress;
    /**
     * 邮政编码
     */
	@TableField("postal_code")
	private String postalCode;
	@TableField("update_id")
	private Long updateId;


	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getEnterpriseWhere() {
		return enterpriseWhere;
	}

	public void setEnterpriseWhere(String enterpriseWhere) {
		this.enterpriseWhere = enterpriseWhere;
	}

	public String getDomesticAddress() {
		return domesticAddress;
	}

	public void setDomesticAddress(String domesticAddress) {
		this.domesticAddress = domesticAddress;
	}

	public String getEnterpriseNature() {
		return enterpriseNature;
	}

	public void setEnterpriseNature(String enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}

	public String getEnterpriseChineseName() {
		return enterpriseChineseName;
	}

	public void setEnterpriseChineseName(String enterpriseChineseName) {
		this.enterpriseChineseName = enterpriseChineseName;
	}

	public String getEnterpriseEnglishName() {
		return enterpriseEnglishName;
	}

	public void setEnterpriseEnglishName(String enterpriseEnglishName) {
		this.enterpriseEnglishName = enterpriseEnglishName;
	}

	public String getEnterpriseWebsite() {
		return enterpriseWebsite;
	}

	public void setEnterpriseWebsite(String enterpriseWebsite) {
		this.enterpriseWebsite = enterpriseWebsite;
	}

	public String getEnterpriseScale() {
		return enterpriseScale;
	}

	public void setEnterpriseScale(String enterpriseScale) {
		this.enterpriseScale = enterpriseScale;
	}

	public String getOutputValue() {
		return outputValue;
	}

	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getAnnouncementNumber() {
		return announcementNumber;
	}

	public void setAnnouncementNumber(String announcementNumber) {
		this.announcementNumber = announcementNumber;
	}

	public String getEnterpriseIntroduction() {
		return enterpriseIntroduction;
	}

	public void setEnterpriseIntroduction(String enterpriseIntroduction) {
		this.enterpriseIntroduction = enterpriseIntroduction;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
		return "EquipmentSupplier{" +
			"emial=" + emial +
			", enterpriseWhere=" + enterpriseWhere +
			", domesticAddress=" + domesticAddress +
			", enterpriseNature=" + enterpriseNature +
			", enterpriseChineseName=" + enterpriseChineseName +
			", enterpriseEnglishName=" + enterpriseEnglishName +
			", enterpriseWebsite=" + enterpriseWebsite +
			", enterpriseScale=" + enterpriseScale +
			", outputValue=" + outputValue +
			", businessScope=" + businessScope +
			", announcementNumber=" + announcementNumber +
			", enterpriseIntroduction=" + enterpriseIntroduction +
			", contactName=" + contactName +
			", position=" + position +
			", phone=" + phone +
			", cellphoneNumber=" + cellphoneNumber +
			", fax=" + fax +
			", contactAddress=" + contactAddress +
			", postalCode=" + postalCode +
			", updateId=" + updateId +
			"}";
	}
}
