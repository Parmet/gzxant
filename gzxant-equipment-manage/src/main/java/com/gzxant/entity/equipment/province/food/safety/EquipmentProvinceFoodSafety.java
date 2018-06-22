package com.gzxant.entity.equipment.province.food.safety;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 省食品安全监督抽检
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-20
 */
@TableName("equipment_province_food_safety")
public class EquipmentProvinceFoodSafety extends DataEntity<EquipmentProvinceFoodSafety> {

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
	@TableField("food_name")
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
     * 生产日期/批号
     */
	@TableField("prodect_date")
	private String prodectDate;
    /**
     * 公告号
     */
	@TableField("announcement_number")
	private String announcementNumber;
    /**
     * 任务来源/项目名称
     */
	@TableField("task_source")
	private String taskSource;
    /**
     * 商标
     */
	private String trademark;
    /**
     * 公告日期
     */
	@TableField("announcement_date")
	private String announcementDate;
    /**
     * 标题
     */
	private String title;
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

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getClassification() {
		return classification;
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

	public String getProdectDate() {
		return prodectDate;
	}

	public void setProdectDate(String prodectDate) {
		this.prodectDate = prodectDate;
	}

	public String getAnnouncementNumber() {
		return announcementNumber;
	}

	public void setAnnouncementNumber(String announcementNumber) {
		this.announcementNumber = announcementNumber;
	}

	public String getTaskSource() {
		return taskSource;
	}

	public void setTaskSource(String taskSource) {
		this.taskSource = taskSource;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
			", foodName=" + foodName +
			", classification=" + classification +
			", samplingResult=" + samplingResult +
			", prodectDate=" + prodectDate +
			", announcementNumber=" + announcementNumber +
			", taskSource=" + taskSource +
			", trademark=" + trademark +
			", announcementDate=" + announcementDate +
			", title=" + title +
			", updateId=" + updateId +
			"}";
	}
}
