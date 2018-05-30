package com.gzxant.vo.equipment.standard;

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
public class EquipmentStandardItemVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private List<EquipmentStandardProductVO> sub;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EquipmentStandardProductVO> getSub() {
		return sub;
	}
	public void setSub(List<EquipmentStandardProductVO> sub) {
		this.sub = sub;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
