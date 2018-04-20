package com.gzxant.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 商城-品牌表
 * </p>
 *
 * @author zt
 * @since 2018-04-20
 */
@TableName("shop_brand")
public class ShopBrand extends DataEntity<ShopBrand> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
	private String name;
	private String logo;
	@TableField("update_id")
	private Long updateId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "ShopBrand{" +
			"name=" + name +
			", logo=" + logo +
			", updateId=" + updateId +
			"}";
	}
}
