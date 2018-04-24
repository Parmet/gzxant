package com.gzxant.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.gzxant.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文章内容
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-19
 */
@TableName("fs_information")
public class FsInformation extends BaseEntity<FsInformation> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 创建人id
     */
	@TableField("create_id")
	private Long createId;
    /**
     * 最近修改人id
     */
	@TableField("update_id")
	private Long updateId;
    /**
     * 修改时间
     */
	@TableField("create_date")
	private Date createDate;
    /**
     * 创建时间
     */
	@TableField("update_date")
	private Date updateDate;
    /**
     * 删除标记Y：正常；N：删除；A：审核
     */
	@TableField("del_flag")
	private String delFlag;
    /**
     * 标题
     */
	private String title;
    /**
     * 内容
     */
	private String content;
    /**
     * 类型
     */
	private String type;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 作者
     */
	private String author;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "FsInformation{" +
			", id=" + id +
			", createId=" + createId +
			", updateId=" + updateId +
			", createDate=" + createDate +
			", updateDate=" + updateDate +
			", delFlag=" + delFlag +
			", title=" + title +
			", content=" + content +
			", type=" + type +
			", status=" + status +
			", author=" + author +
			"}";
	}
}
