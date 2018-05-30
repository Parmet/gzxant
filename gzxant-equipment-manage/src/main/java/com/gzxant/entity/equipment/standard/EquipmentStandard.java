package com.gzxant.entity.equipment.standard;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 标准表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@TableName("equipment_standard")
public class EquipmentStandard extends DataEntity<EquipmentStandard> {

    private static final long serialVersionUID = 1L;

    /**
     * 标准名称
     */
	private String name;
    /**
     * 关联分类父级id
     */
	@TableField("category_id")
	private Long categoryId;
    /**
     * 路径
     */
	@TableField("category_path")
	private String categoryPath;
    /**
     * 编码
     */
	private String number;
    /**
     * 旧标准
     */
	@TableField("old_stand")
	private String oldStand;
	/**
	 * pdf上传路径
	 */
	@TableField("pdf_url")
	private String pdfUrl;
	/**
	 * txt生成路径
	 */
	@TableField("txt_url")
	private String txtUrl;
    /**
     * 发布时间
     */
	@TableField("publish_date")
	private String publishDate;
    /**
     * 上传时间
     */
	@TableField("upload_date")
	private String uploadDate;
    /**
     * 实施时间
     */
	@TableField("implement_date")
	private String implementDate;
    /**
     * 发布状态Y：已发布；N：未发布
     */
	private String state;
	/**
	 * 第一分类
	 */
	@TableField(exist = false)
	private String firstCategory;
	/**
	 * 第二分类
	 */
	@TableField(exist = false)
	private String secondCategory;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOldStand() {
		return oldStand;
	}

	public void setOldStand(String oldStand) {
		this.oldStand = oldStand;
	}

	public String getPdfUrl() {
		return pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	public String getTxtUrl() {
		return txtUrl;
	}

	public void setTxtUrl(String txtUrl) {
		this.txtUrl = txtUrl;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getImplementDate() {
		return implementDate;
	}

	public void setImplementDate(String implementDate) {
		this.implementDate = implementDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFirstCategory() {
		return firstCategory;
	}

	public void setFirstCategory(String firstCategory) {
		this.firstCategory = firstCategory;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EquipmentStandard{" +
			"name=" + name +
			", categoryId=" + categoryId +
			", path=" + categoryPath +
			", number=" + number +
			", oldStand=" + oldStand +
			", publishDate=" + publishDate +
			", uploadDate=" + uploadDate +
			", implementDate=" + implementDate +
			", state=" + state +
			"}";
	}
}
