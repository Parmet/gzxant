package com.gzxant.entity.article;

import com.baomidou.mybatisplus.annotations.TableField;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

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
