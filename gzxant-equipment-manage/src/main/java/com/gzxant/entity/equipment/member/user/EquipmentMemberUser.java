package com.gzxant.entity.equipment.member.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 会员用户表
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-23
 */
@TableName("equipment_member_user")
public class EquipmentMemberUser extends DataEntity<EquipmentMemberUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 修改者id
     */
	@TableField("update_id")
	private Long updateId;
    /**
     * 登录用户名
     */
	@TableField("login_name")
	private String loginName;
    /**
     * 登录密码
     */
	private String password;
    /**
     * 姓名
     */
	private String name;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 电话
     */
	private String phone;
    /**
     * 手机
     */
	private String mobile;
    /**
     * 用户头像
     */
	private String photo;
    /**
     * 是否可登录：可以:Y 否:N
     */
	@TableField("login_flag")
	private String loginFlag;


	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EquipmentMemberUser{" +
			"updateId=" + updateId +
			", loginName=" + loginName +
			", password=" + password +
			", name=" + name +
			", email=" + email +
			", phone=" + phone +
			", mobile=" + mobile +
			", photo=" + photo +
			", loginFlag=" + loginFlag +
			"}";
	}
}
