package com.gzxant.service.shop.order.pay;

import com.gzxant.entity.shop.order.pay.ShopOrderPay;
import com.gzxant.vo.shop.order.ShopOrderVo;
import com.gzxant.base.service.IBaseService;

/**
 * <p>
 * 商城-订单支付表 服务类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
public interface IShopOrderPayService extends IBaseService<ShopOrderPay> {

	void insert(ShopOrderVo param);
	
}
