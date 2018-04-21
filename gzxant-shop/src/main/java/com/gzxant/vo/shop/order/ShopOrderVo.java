package com.gzxant.vo.shop.order;

import java.util.List;

import com.gzxant.vo.shop.order.goods.ShopOrderGoodsVo;

/**
 * 商城订单vo
 * 
 * @author xiayc
 * @since 2018-04-21
 */
public class ShopOrderVo {
	private List<ShopOrderGoodsVo> goods;

	public List<ShopOrderGoodsVo> getGoods() {
		return goods;
	}

	public void setGoods(List<ShopOrderGoodsVo> goods) {
		this.goods = goods;
	}
	
}
