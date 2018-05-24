package com.gzxant.entity.article;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 文章
 * </p>
 *
 * @author zt
 * @since 2018-05-22
 */
public class Article extends DataEntity<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章内容
     */
	@TableField("article_content")
	private String articleContent;
    /**
     * 文章名称
     */
	private String name;
	
	private String state;
	
	@TableField("push_time")
	private Date pushTime;


	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getPushTime() {
		return pushTime;
	}

	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Article{" +
			"articleContent=" + articleContent +
			", name=" + name +
			"}";
	}
}
