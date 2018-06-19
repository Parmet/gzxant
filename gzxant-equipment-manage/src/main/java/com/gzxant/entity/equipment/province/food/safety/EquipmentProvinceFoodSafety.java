package com.gzxant.entity.equipment.province.food.safety;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;

/**
 * <p>
 * 省食品安全监督抽检
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-17
 */
@TableName("equipment_province_food_safety")
public class EquipmentProvinceFoodSafety extends BaseEntity<EquipmentProvinceFoodSafety> {

    private static final long serialVersionUID = 1L;

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
     * 食品名称
     */
	@TableField("foodName")
	private String foodName;
    /**
     * 分类
     */
	private String classification;
    /**
     * 不合格||检测结果||标准值
     */
	@TableField("sampling_result")
	private String samplingResult;
	/**
	 * 广东/总局国抽
	 */
	@TableField("taskSource")
	private String taskSource;
    /**
     * 生产日期/批号
     */
	@TableField("prodect_date")
	private Date prodectDate;
    /**
     * 公告号
     */
	@TableField("announcement_number")
	private Date announcementNumber;
    /**
     * 公告日期
     */
	@TableField("announcement_date")
	private Date announcementDate;
    /**
     * 标题
     */
	private String title;
	private Integer Sampling;
	@TableField("update_id")
	private Long updateId;


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

	public String getFoodType() {
		return foodName;
	}

	public void setFoodType(String foodType) {
		this.foodName = foodType;
	}

	public String getClassification() {
		return classification;
	}

	public String getTaskSource() {
		return taskSource;
	}

	public void setTaskSource(String taskSource) {
		this.taskSource = taskSource;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getSamplingResult() {
		return samplingResult;
	}

	public void setSamplingResult(String samplingResult) {
		this.samplingResult = samplingResult;
	}

	public Date getProdectDate() {
		return prodectDate;
	}

	public void setProdectDate(Date prodectDate) {
		this.prodectDate = prodectDate;
	}

	public Date getAnnouncementNumber() {
		return announcementNumber;
	}

	public void setAnnouncementNumber(Date announcementNumber) {
		this.announcementNumber = announcementNumber;
	}

	public Date getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSampling() {
		return Sampling;
	}

	public void setSampling(Integer Sampling) {
		this.Sampling = Sampling;
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
		return "EquipmentProvinceFoodSafety{" +
			"enterpriseName=" + enterpriseName +
			", enterpriseAddress=" + enterpriseAddress +
			", samplingName=" + samplingName +
			", province=" + province +
			", specificationsModel=" + specificationsModel +
			", samplingType=" + samplingType +
			", foodType=" + foodName +
			", classification=" + classification +
				", taskSource=" + taskSource +
			", samplingResult=" + samplingResult +
			", prodectDate=" + prodectDate +
			", announcementNumber=" + announcementNumber +
			", announcementDate=" + announcementDate +
			", title=" + title +
			", Sampling=" + Sampling +
			", updateId=" + updateId +
			"}";
	}
}
