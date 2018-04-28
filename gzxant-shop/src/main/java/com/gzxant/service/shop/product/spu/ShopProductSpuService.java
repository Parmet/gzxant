package com.gzxant.service.shop.product.spu;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.product.spu.ShopProductSpu;
import com.gzxant.dao.shop.product.spu.ShopProductSpuDao;
import com.gzxant.service.shop.product.spu.IShopProductSpuService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 产品属性表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-27
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopProductSpuService extends BaseService<ShopProductSpuDao, ShopProductSpu> implements IShopProductSpuService {
	
}
