package com.gzxant.entity.portals.message;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 联系我们
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
@TableName("portals_message")
public class PortalsMessage extends DataEntity<PortalsMessage> {

    private static final long serialVersionUID = 1L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
     * 姓名
     */
	private String name;
    /**
     * 电话
     */
	private String phone;
    /**
     * 邮箱
     */
	private String email;
    /**
     * qq
     */
	private String qq;
    /**
     * 留言内容
     */
	private String messageContent;

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PortalsMessage{" +
			"name=" + name +
			", phone=" + phone +
			", email=" + email +
			", messageContent=" + messageContent +
			", qq=" + qq +
			"}";
	}
}
