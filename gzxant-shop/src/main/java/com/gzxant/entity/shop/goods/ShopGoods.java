package com.gzxant.entity.shop.goods;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 商城商品表
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-20
 */
@TableName("shop_goods")
public class ShopGoods extends DataEntity<ShopGoods> {

    private static final long serialVersionUID = 1L;

	@TableField("seller_id")
	private Long sellerId;
    /**
     * 产品分类id
     */
	@TableField("product_id")
	private Long productId;
	@TableField("stock_id")
	private Long stockId;
	private String name;
	private String content;
	@TableField("update_id")
	private Long updateId;


	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "ShopGoods{" +
			"sellerId=" + sellerId +
			", productId=" + productId +
			", stockId=" + stockId +
			", name=" + name +
			", content=" + content +
			", updateId=" + updateId +
			"}";
	}
}
