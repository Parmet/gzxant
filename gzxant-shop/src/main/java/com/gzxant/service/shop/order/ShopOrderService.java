package com.gzxant.service.shop.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.order.ShopOrder;
import com.gzxant.dao.shop.order.ShopOrderDao;
import com.gzxant.service.shop.order.IShopOrderService;
import com.gzxant.vo.shop.order.ShopOrderVo;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城-订单表 服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopOrderService extends BaseService<ShopOrderDao, ShopOrder> implements IShopOrderService {

	@Override
	public void insert(ShopOrderVo param) {
		
	}
	
}
