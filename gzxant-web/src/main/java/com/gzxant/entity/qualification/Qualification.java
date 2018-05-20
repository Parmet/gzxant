package com.gzxant.entity.qualification;

import com.baomidou.mybatisplus.annotations.TableField;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 资格认证
 * </p>
 *
 * @author zt
 * @since 2018-05-18
 */
public class Qualification extends DataEntity<Qualification> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
	private String title;
    /**
     * 认证说明
     */
	private String instructions;
    /**
     * 姓名
     */
	private String name;
    /**
     * 电话
     */
	private String phone;
    /**
     * 企业
     */
	private String enterprise;
    /**
     * 身份证
     */
	private String card;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 目前经营的品牌和代理
     */
	@TableField("brand_agent")
	private String brandAgent;
    /**
     * 身份
     */
	private String provinces;
    /**
     * 授权编码
     */
	private String code;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
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

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrandAgent() {
		return brandAgent;
	}

	public void setBrandAgent(String brandAgent) {
		this.brandAgent = brandAgent;
	}

	public String getProvinces() {
		return provinces;
	}

	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Qualification{" +
			"title=" + title +
			", instructions=" + instructions +
			", name=" + name +
			", phone=" + phone +
			", enterprise=" + enterprise +
			", card=" + card +
			", email=" + email +
			", brandAgent=" + brandAgent +
			", provinces=" + provinces +
			", code=" + code +
			"}";
	}
}
