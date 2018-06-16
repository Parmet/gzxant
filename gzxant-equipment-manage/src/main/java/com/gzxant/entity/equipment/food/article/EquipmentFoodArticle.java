package com.gzxant.entity.equipment.food.article;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;

/**
 * <p>
 * 抽检食品文章表
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-15
 */
@TableName("equipment_food_article")
public class EquipmentFoodArticle extends BaseEntity<EquipmentFoodArticle> {

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
	private String specifications;
    /**
     * 抽检类型
     */
	private String samplingtype;
    /**
     * 食品类型
     */
	@TableField("food_type")
	private String foodType;
    /**
     * 生产日期
     */
	@TableField("produce_date")
	private Date produceDate;
    /**
     * 食品分类
     */
	@TableField("food_classification")
	private String foodClassification;
    /**
     * 分类
     */
	private String classification;
	private String announcement;
    /**
     * 抽检项目
     */
	@TableField("sampling_produce")
	private String samplingProduce;
    /**
     * 公告日期
     */
	@TableField("announcement_date")
	private Date announcementDate;
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
     * 检测项目
     */
	@TableField("detect_produce")
	private String detectProduce;
    /**
     * 批号
     */
	@TableField("batch_number")
	private String batchNumber;
    /**
     * 任务来源/项目名称
     */
	@TableField("produce_source_name")
	private String produceSourceName;
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

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getSamplingtype() {
		return samplingtype;
	}

	public void setSamplingtype(String samplingtype) {
		this.samplingtype = samplingtype;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public String getFoodClassification() {
		return foodClassification;
	}

	public void setFoodClassification(String foodClassification) {
		this.foodClassification = foodClassification;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getSamplingProduce() {
		return samplingProduce;
	}

	public void setSamplingProduce(String samplingProduce) {
		this.samplingProduce = samplingProduce;
	}

	public Date getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
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

	public String getDetectProduce() {
		return detectProduce;
	}

	public void setDetectProduce(String detectProduce) {
		this.detectProduce = detectProduce;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getProduceSourceName() {
		return produceSourceName;
	}

	public void setProduceSourceName(String produceSourceName) {
		this.produceSourceName = produceSourceName;
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
		return "EquipmentFoodArticle{" +
			"enterpriseName=" + enterpriseName +
			", enterpriseAddress=" + enterpriseAddress +
			", samplingName=" + samplingName +
			", province=" + province +
			", foodName=" + foodName +
			", specifications=" + specifications +
			", samplingtype=" + samplingtype +
			", foodType=" + foodType +
			", produceDate=" + produceDate +
			", foodClassification=" + foodClassification +
			", classification=" + classification +
			", announcement=" + announcement +
			", samplingProduce=" + samplingProduce +
			", announcementDate=" + announcementDate +
			", trademark=" + trademark +
			", samplingResult=" + samplingResult +
			", detectProduce=" + detectProduce +
			", batchNumber=" + batchNumber +
			", produceSourceName=" + produceSourceName +
			", title=" + title +
			", Sampling=" + Sampling +
			", updateId=" + updateId +
			"}";
	}
}
