package com.gzxant.dto.equipment.standard;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 标准表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public class EquipmentStandardTechDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private List<EquipmentStandardTechSubDTO> subs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EquipmentStandardTechSubDTO> getSubs() {
		return subs;
	}

	public void setSubs(List<EquipmentStandardTechSubDTO> subs) {
		this.subs = subs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
