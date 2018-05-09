package com.gzxant.service.shop.goods;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.goods.ShopGoods;
import com.gzxant.dao.shop.goods.ShopGoodsDao;
import com.gzxant.service.shop.goods.IShopGoodsService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城商品表 服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-05-02
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopGoodsService extends BaseService<ShopGoodsDao, ShopGoods> implements IShopGoodsService {
	
}
