package com.gzxant.service.shop.order.goods;

import com.gzxant.entity.shop.order.goods.ShopOrderGoods;
import com.gzxant.vo.shop.order.ShopOrderVo;
import com.gzxant.base.service.IBaseService;

/**
 * <p>
 * 商城-订单商品表 服务类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
public interface IShopOrderGoodsService extends IBaseService<ShopOrderGoods> {

	void insert(ShopOrderVo param);
	
}
