package com.gzxant.entity.shop.category;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 商城-分类表
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@TableName("shop_category")
public class ShopCategory extends DataEntity<ShopCategory> {

    private static final long serialVersionUID = 1L;

	private String name;
	private Long parent;
	private String logo;
	@TableField("update_id")
	private Long updateId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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
		return "ShopCategory{" +
			"name=" + name +
			", parent=" + parent +
			", logo=" + logo +
			", updateId=" + updateId +
			"}";
	}
}
