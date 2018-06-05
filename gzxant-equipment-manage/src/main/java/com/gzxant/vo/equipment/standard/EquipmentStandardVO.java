package com.gzxant.vo.equipment.standard;

import java.io.Serializable;
import java.util.List;

import com.gzxant.entity.equipment.standard.EquipmentStandard;

/**
 * <p>
 * 标准表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public class EquipmentStandardVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<EquipmentStandard> info;
    private List<EquipmentStandardItemVO> item;

	public List<EquipmentStandard> getInfo() {
		return info;
	}

	public void setInfo(List<EquipmentStandard> info) {
		this.info = info;
	}

	public List<EquipmentStandardItemVO> getItem() {
		return item;
	}

	public void setItem(List<EquipmentStandardItemVO> item) {
		this.item = item;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}  
}
