package com.gzxant.entity.equipment.standard.item.product;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 检验项产品关联表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-31
 */
@TableName("equipment_standard_item_product")
public class EquipmentStandardItemProduct extends DataEntity<EquipmentStandardItemProduct> {

	private static final long serialVersionUID = 1L;

	@TableField("item_id")
	private Long itemId;
	/**
	 * fs_product 表 id
	 */
	@TableField("product_id")
	private Long productId;
	private Integer sort;

	@TableField(exist = false)
	private String itemName;

	@TableField(exist = false)
	private String productName;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EquipmentStandardItemProduct{" + "itemId=" + itemId + ", productId=" + productId + ", sort=" + sort
				+ "}";
	}
}
