package com.gzxant.dto.equipment.standard;

import java.io.Serializable;

/**
 * <p>
 * 标准表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public class EquipmentStandardTechSubDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String project;
	private String require;
	private String function;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
