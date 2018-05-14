package com.gzxant.entity.portals.about.me;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 关于我们
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@TableName("portals_about_me")
public class PortalsAboutMe extends DataEntity<PortalsAboutMe> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
	@TableField("about_me_title")
	private String aboutMeTitle;
    /**
     * 内容
     */
	@TableField("about_me_content")
	private String aboutMeContent;
    /**
     * 图片
     */
	@TableField("about_me_img")
	private String aboutMeImg;
	@TableField("update_id")
	private Long updateId;


	public String getAboutMeTitle() {
		return aboutMeTitle;
	}

	public void setAboutMeTitle(String aboutMeTitle) {
		this.aboutMeTitle = aboutMeTitle;
	}

	public String getAboutMeContent() {
		return aboutMeContent;
	}

	public void setAboutMeContent(String aboutMeContent) {
		this.aboutMeContent = aboutMeContent;
	}

	public String getAboutMeImg() {
		return aboutMeImg;
	}

	public void setAboutMeImg(String aboutMeImg) {
		this.aboutMeImg = aboutMeImg;
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
		return "PortalsAboutMe{" +
			"aboutMeTitle=" + aboutMeTitle +
			", aboutMeContent=" + aboutMeContent +
			", aboutMeImg=" + aboutMeImg +
			", updateId=" + updateId +
			"}";
	}
}
