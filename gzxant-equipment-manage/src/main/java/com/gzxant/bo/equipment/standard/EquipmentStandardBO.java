package com.gzxant.bo.equipment.standard;

import java.util.List;

import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.entity.equipment.standard.tech.EquipmentStandardTech;

/**
 * <p>
 * 标准表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public class EquipmentStandardBO {
	private EquipmentStandard standard;
	private List<EquipmentStandardTech> techs;
	private List<EquipmentStandardItemBO> items;

	public EquipmentStandard getStandard() {
		return standard;
	}

	public void setStandard(EquipmentStandard standard) {
		this.standard = standard;
	}

	public List<EquipmentStandardTech> getTechs() {
		return techs;
	}

	public void setTechs(List<EquipmentStandardTech> techs) {
		this.techs = techs;
	}

	public List<EquipmentStandardItemBO> getItems() {
		return items;
	}

	public void setItems(List<EquipmentStandardItemBO> items) {
		this.items = items;
	}
}
