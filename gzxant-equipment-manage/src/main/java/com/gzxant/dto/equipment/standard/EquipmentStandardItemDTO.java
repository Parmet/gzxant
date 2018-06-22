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
public class EquipmentStandardItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private List<EquipmentStandardProductDTO> materials;
	private List<EquipmentStandardProductDTO> equipments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EquipmentStandardProductDTO> getMaterials() {
		return materials;
	}

	public void setMaterials(List<EquipmentStandardProductDTO> materials) {
		this.materials = materials;
	}

	public List<EquipmentStandardProductDTO> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<EquipmentStandardProductDTO> equipments) {
		this.equipments = equipments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
