package com.gzxant.entity.equipment.healthcare.food;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 国家保健食品安全监督抽检
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-20
 */
@TableName("equipment_healthcare_food")
public class EquipmentHealthcareFood extends DataEntity<EquipmentHealthcareFood> {

    private static final long serialVersionUID = 1L;

    /**
     * 标称产品名称
     */
	@TableField("prodeuct_name")
	private String prodeuctName;
    /**
     * 标称批准文号
     */
	private String announcement;
    /**
     * 批号
     */
	private String number;
    /**
     * 标称生产企业名称
     */
	@TableField("enterprise_name")
	private String enterpriseName;
    /**
     * 标称生产企业地址
     */
	@TableField("enterprise_address")
	private String enterpriseAddress;
    /**
     * 被抽样单位的名称
     */
	@TableField("sampling_name")
	private String samplingName;
    /**
     * 被抽样的省份
     */
	private String province;
    /**
     * 规格
     */
	@TableField("specifications_model")
	private String specificationsModel;
    /**
     * 抽检类型
     */
	@TableField("sampling_type")
	private String samplingType;
    /**
     * 分类
     */
	private String classification;
    /**
     * 分类
     */
	private String mechanism;
    /**
     * 产品类别
     */
	@TableField("prodeuce_type")
	private String prodeuceType;
    /**
     * 抽检项目
     */
	@TableField("sampling_produce")
	private String samplingProduce;
    /**
     * 检测项目
     */
	@TableField("testing_produce")
	private String testingProduce;
    /**
     * 公告号
     */
	@TableField("announcement_number")
	private String announcementNumber;
    /**
     * 公告日期
     */
	@TableField("announcement_date")
	private String announcementDate;
    /**
     * 不合格||检测结果||标准值
     */
	@TableField("sampling_result")
	private String samplingResult;
    /**
     * 标题
     */
	private String title;
	@TableField("update_id")
	private Long updateId;


	public String getProdeuctName() {
		return prodeuctName;
	}

	public void setProdeuctName(String prodeuctName) {
		this.prodeuctName = prodeuctName;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseAddress() {
		return enterpriseAddress;
	}

	public void setEnterpriseAddress(String enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}

	public String getSamplingName() {
		return samplingName;
	}

	public void setSamplingName(String samplingName) {
		this.samplingName = samplingName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSpecificationsModel() {
		return specificationsModel;
	}

	public void setSpecificationsModel(String specificationsModel) {
		this.specificationsModel = specificationsModel;
	}

	public String getSamplingType() {
		return samplingType;
	}

	public void setSamplingType(String samplingType) {
		this.samplingType = samplingType;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getMechanism() {
		return mechanism;
	}

	public void setMechanism(String mechanism) {
		this.mechanism = mechanism;
	}

	public String getProdeuceType() {
		return prodeuceType;
	}

	public void setProdeuceType(String prodeuceType) {
		this.prodeuceType = prodeuceType;
	}

	public String getSamplingProduce() {
		return samplingProduce;
	}

	public void setSamplingProduce(String samplingProduce) {
		this.samplingProduce = samplingProduce;
	}

	public String getTestingProduce() {
		return testingProduce;
	}

	public void setTestingProduce(String testingProduce) {
		this.testingProduce = testingProduce;
	}

	public String getAnnouncementNumber() {
		return announcementNumber;
	}

	public void setAnnouncementNumber(String announcementNumber) {
		this.announcementNumber = announcementNumber;
	}

	public String getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getSamplingResult() {
		return samplingResult;
	}

	public void setSamplingResult(String samplingResult) {
		this.samplingResult = samplingResult;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "EquipmentHealthcareFood{" +
			"prodeuctName=" + prodeuctName +
			", announcement=" + announcement +
			", number=" + number +
			", enterpriseName=" + enterpriseName +
			", enterpriseAddress=" + enterpriseAddress +
			", samplingName=" + samplingName +
			", province=" + province +
			", specificationsModel=" + specificationsModel +
			", samplingType=" + samplingType +
			", classification=" + classification +
			", mechanism=" + mechanism +
			", prodeuceType=" + prodeuceType +
			", samplingProduce=" + samplingProduce +
			", testingProduce=" + testingProduce +
			", announcementNumber=" + announcementNumber +
			", announcementDate=" + announcementDate +
			", samplingResult=" + samplingResult +
			", title=" + title +
			", updateId=" + updateId +
			"}";
	}
}
