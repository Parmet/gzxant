package com.gzxant.service.shop.order.goods;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.order.goods.ShopOrderGoods;
import com.gzxant.dao.shop.order.goods.ShopOrderGoodsDao;
import com.gzxant.service.shop.order.goods.IShopOrderGoodsService;
import com.gzxant.vo.shop.order.ShopOrderVo;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城-订单商品表 服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopOrderGoodsService extends BaseService<ShopOrderGoodsDao, ShopOrderGoods> implements IShopOrderGoodsService {

	@Override
	public void insert(ShopOrderVo param) {
		
	}
	
}
