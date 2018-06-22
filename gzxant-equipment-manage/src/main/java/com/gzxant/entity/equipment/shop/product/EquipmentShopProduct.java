package com.gzxant.entity.equipment.shop.product;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 产品表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@TableName("equipment_shop_product")
public class EquipmentShopProduct extends DataEntity<EquipmentShopProduct> implements Cloneable {

	private static final long serialVersionUID = 1L;

	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 分类id
	 */
	@TableField("category_id")
	private Long categoryId;
	/**
	 * 分类id
	 */
	@TableField("brands_id")
	private Long brandsId;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 商品类型(M:材料， E:设备)
	 */
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBrandsId() {
		return brandsId;
	}

	public void setBrandsId(Long brandsId) {
		this.brandsId = brandsId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EquipmentShopProduct{" + "name=" + name + ", categoryId=" + categoryId + ", brandsId=" + brandsId
				+ ", sort=" + sort + ", type=" + type + ", updateId=" + updateId + "}";
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
