package com.gzxant.entity.portals.article;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 官网文章内容
 * </p>
 *
 * @author zt
 * @since 2018-05-09
 */
@TableName("portals_article")
public class PortalsArticle extends DataEntity<PortalsArticle> {

    private static final long serialVersionUID = 1L;

    /**
     * 最近修改人id
     */
	@TableField("update_id")
	private Long updateId;
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
     * 标签
     */
	private String tags;
    /**
     * 分类
     */
	private String categories;
    /**
     * 开启评论
     */
	@TableField("allow_comment")
	private Integer allowComment;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 关联栏目id
     */
	private String columnId;


	@TableField(exist = false)
	private String columnName;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	/**

	 * 作者
	 */
	private String author;


	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public Integer getAllowComment() {
		return allowComment;
	}

	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
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
		return "PortalsArticle{" +
			"updateId=" + updateId +
			", title=" + title +
			", content=" + content +
			", type=" + type +
			", tags=" + tags +
			", categories=" + categories +
			", allowComment=" + allowComment +
			", status=" + status +
			", author=" + author +
			", columnId=" + columnId +
			", columnName=" + columnName +
			"}";
	}
}
