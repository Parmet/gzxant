package com.gzxant.entity.equipment.standard.tech;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 标准技术要求表
 * </p>
 *
 * @author ycxiao
 * @since 2018-06-20
 */
@TableName("equipment_standard_tech")
public class EquipmentStandardTech extends DataEntity<EquipmentStandardTech> {

	private static final long serialVersionUID = 1L;

	private String name;
	@TableField("standard_id")
	private Long standardId;
	private String project;
	private String require;
	private String function;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStandardId() {
		return standardId;
	}

	public void setStandardId(Long standardId) {
		this.standardId = standardId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EquipmentStandardTech{" + "name=" + name + ", standardId=" + standardId + ", project=" + project
				+ ", require=" + require + ", function=" + function + "}";
	}
}
