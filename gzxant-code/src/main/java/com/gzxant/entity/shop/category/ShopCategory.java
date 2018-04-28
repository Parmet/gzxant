package com.gzxant.entity.shop.category;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.TreeEntity;

/**
 * <p>
 * 商城-分类表
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-27
 */
@TableName("shop_category")
public class ShopCategory extends TreeEntity<ShopCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
	private String number;
    /**
     * 状态：Y 有效； N 无效
     */
	private String invalid;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getInvalid() {
		return invalid;
	}

	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		;
		return "ShopCategory{" +
			", number=" + number +
			", invalid=" + invalid +
			"}" + super.toString();
	}
}
