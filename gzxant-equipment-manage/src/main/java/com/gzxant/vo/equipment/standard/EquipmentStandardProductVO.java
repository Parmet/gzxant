package com.gzxant.vo.equipment.standard;

import java.io.Serializable;

/**
 * <p>
 * 标准表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public class EquipmentStandardProductVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String type;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
