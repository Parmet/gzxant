package com.gzxant.entity.equipment.standard.item;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 标准项表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@TableName("equipment_standard_item")
public class EquipmentStandardItem extends DataEntity<EquipmentStandardItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类名称
     */
	private String name;
    /**
     * 关联标准分类id
     */
	@TableField("stand_id")
	private Long standId;
    /**
     * 排序
     */
	private Integer sort;
	@TableField("update_id")
	private Long updateId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStandId() {
		return standId;
	}

	public void setStandId(Long standId) {
		this.standId = standId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EquipmentStandardItem{" +
			"name=" + name +
			", standId=" + standId +
			", sort=" + sort +
			", updateId=" + updateId +
			"}";
	}
}
