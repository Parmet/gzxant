package com.gzxant.entity.shop.goods.stock;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 商城-订单商品表
 * </p>
 *
 * @author zt
 * @since 2018-05-02
 */
@TableName("shop_goods_stock")
public class ShopGoodsStock extends DataEntity<ShopGoodsStock> {

    private static final long serialVersionUID = 1L;

	@TableField("total_stock")
	private Integer totalStock;
	@TableField("able_stock")
	private Integer ableStock;
	@TableField("freeze_stock")
	private Integer freezeStock;
	@TableField("over_stock")
	private Integer overStock;
	private Integer version;


	public Integer getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Integer totalStock) {
		this.totalStock = totalStock;
	}

	public Integer getAbleStock() {
		return ableStock;
	}

	public void setAbleStock(Integer ableStock) {
		this.ableStock = ableStock;
	}

	public Integer getFreezeStock() {
		return freezeStock;
	}

	public void setFreezeStock(Integer freezeStock) {
		this.freezeStock = freezeStock;
	}

	public Integer getOverStock() {
		return overStock;
	}

	public void setOverStock(Integer overStock) {
		this.overStock = overStock;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ShopGoodsStock{" +
			"totalStock=" + totalStock +
			", ableStock=" + ableStock +
			", freezeStock=" + freezeStock +
			", overStock=" + overStock +
			", version=" + version +
			"}";
	}
}
