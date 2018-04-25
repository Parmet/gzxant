package com.gzxant.service.shop.sku;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.sku.ShopSku;
import com.gzxant.dao.shop.sku.ShopSkuDao;
import com.gzxant.service.shop.sku.IShopSkuService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * sku 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopSkuService extends BaseService<ShopSkuDao, ShopSku> implements IShopSkuService {
	
}
