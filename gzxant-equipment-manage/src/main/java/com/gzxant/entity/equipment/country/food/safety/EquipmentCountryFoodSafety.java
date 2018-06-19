package com.gzxant.entity.equipment.country.food.safety;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;

/**
 * <p>
 * 国家食品安全监督抽检(合格)
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-17
 */
@TableName("equipment_country_food_safety")
public class EquipmentCountryFoodSafety extends BaseEntity<EquipmentCountryFoodSafety> {

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
     * 食物的名称
     */
	@TableField("food_name")
	private String foodName;
    /**
     * 规格型号
     */
	@TableField("specifications_model")
	private String specificationsModel;
    /**
     * 抽检类型
     */
	@TableField("sampling_type")
	private String samplingType;
    /**
     * 食品类型
     */
	@TableField("food_type")
	private String foodType;
    /**
     * 生产日期
     */
	@TableField("produce_date")
	private String produceDate;
    /**
     * 分类
     */
	private String classification;
    /**
     * 公告号
     */
	@TableField("announcement_number")
	private String announcementNumber;
    /**
     * 抽检项目
     */
	@TableField("sampling_produce")
	private String samplingProduce;
    /**
     * 公告日期
     */
	@TableField("announcement_date")
	private String announcementDate;
    /**
     * 商标
     */
	private String trademark;
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

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
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
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(String produceDate) {
		this.produceDate = produceDate;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getAnnouncementNumber() {
		return announcementNumber;
	}

	public void setAnnouncementNumber(String announcementNumber) {
		this.announcementNumber = announcementNumber;
	}

	public String getSamplingProduce() {
		return samplingProduce;
	}

	public void setSamplingProduce(String samplingProduce) {
		this.samplingProduce = samplingProduce;
	}

	public String getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
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
		return "EquipmentCountryFoodSafety{" +
			"enterpriseName=" + enterpriseName +
			", enterpriseAddress=" + enterpriseAddress +
			", samplingName=" + samplingName +
			", province=" + province +
			", foodName=" + foodName +
			", specificationsModel=" + specificationsModel +
			", samplingType=" + samplingType +
			", foodType=" + foodType +
			", produceDate=" + produceDate +
			", classification=" + classification +
			", announcementNumber=" + announcementNumber +
			", samplingProduce=" + samplingProduce +
			", announcementDate=" + announcementDate +
			", trademark=" + trademark +
			", samplingResult=" + samplingResult +
			", title=" + title +
			", updateId=" + updateId +
			"}";
	}
}
