package com.gzxant.entity.shop.sku;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * sku
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@TableName("shop_sku")
public class ShopSku extends DataEntity<ShopSku> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
	private String name;
    /**
     * 属性id
     */
	@TableField("property_id")
	private Long propertyId;
    /**
     * 顺序
     */
	private Integer sort;
    /**
     * 更新者
     */
	@TableField("update_id")
	private Long updateId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
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
		return "ShopSku{" +
			"name=" + name +
			", propertyId=" + propertyId +
			", sort=" + sort +
			", updateId=" + updateId +
			"}";
	}
}
