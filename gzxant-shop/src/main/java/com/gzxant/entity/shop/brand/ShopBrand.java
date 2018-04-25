package com.gzxant.entity.shop.brand;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 商城-品牌表
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@TableName("shop_brand")
public class ShopBrand extends DataEntity<ShopBrand> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
	private String name;
	private String logo;


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
