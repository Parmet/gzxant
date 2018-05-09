package com.gzxant.service.shop.goods.stock;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.goods.stock.ShopGoodsStock;
import com.gzxant.dao.shop.goods.stock.ShopGoodsStockDao;
import com.gzxant.service.shop.goods.stock.IShopGoodsStockService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城-订单商品表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-02
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopGoodsStockService extends BaseService<ShopGoodsStockDao, ShopGoodsStock> implements IShopGoodsStockService {
	
}
