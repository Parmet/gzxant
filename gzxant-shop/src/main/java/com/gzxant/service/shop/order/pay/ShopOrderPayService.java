package com.gzxant.service.shop.order.pay;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.order.pay.ShopOrderPay;
import com.gzxant.dao.shop.order.pay.ShopOrderPayDao;
import com.gzxant.service.shop.order.pay.IShopOrderPayService;
import com.gzxant.vo.shop.order.ShopOrderVo;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城-订单支付表 服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopOrderPayService extends BaseService<ShopOrderPayDao, ShopOrderPay> implements IShopOrderPayService {

	@Override
	public void insert(ShopOrderVo param) {
		
	}
	
}
