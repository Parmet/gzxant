package com.gzxant.entity.fs.standard;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 食品标准表
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-28
 */
@TableName("fs_standard")
public class FsStandard extends DataEntity<FsStandard> {

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
	private String path;
    /**
     * 编码
     */
	private String number;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 分类图标
     */
	private String icon;
    /**
     * 旧标准
     */
	@TableField("old_stand")
	private String oldStand;
	@TableField("update_id")
	private Long updateId;
    /**
     * 发布时间
     */
	@TableField("publish_date")
	private Date publishDate;
    /**
     * 上传时间
     */
	@TableField("upload_date")
	private Date uploadDate;
    /**
     * 实施时间
     */
	@TableField("implement_date")
	private Date implementDate;
    /**
     * 发布状态Y：已发布；N：未发布
     */
	private String state;


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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getOldStand() {
		return oldStand;
	}

	public void setOldStand(String oldStand) {
		this.oldStand = oldStand;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getImplementDate() {
		return implementDate;
	}

	public void setImplementDate(Date implementDate) {
		this.implementDate = implementDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "FsStandard{" +
			"name=" + name +
			", categoryId=" + categoryId +
			", path=" + path +
			", number=" + number +
			", sort=" + sort +
			", icon=" + icon +
			", oldStand=" + oldStand +
			", updateId=" + updateId +
			", publishDate=" + publishDate +
			", uploadDate=" + uploadDate +
			", implementDate=" + implementDate +
			", state=" + state +
			"}";
	}
}
