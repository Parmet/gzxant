package com.gzxant.entity.equipment.standard.category;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.TreeEntity;

/**
 * <p>
 * 标准分类表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@TableName("equipment_standard_category")
public class EquipmentStandardCategory extends TreeEntity<EquipmentStandardCategory> {

    private static final long serialVersionUID = 1L;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
