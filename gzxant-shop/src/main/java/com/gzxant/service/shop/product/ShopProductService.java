package com.gzxant.service.shop.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.product.ShopProduct;
import com.gzxant.dao.shop.product.ShopProductDao;
import com.gzxant.service.shop.product.IShopProductService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城-产品表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-27
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopProductService extends BaseService<ShopProductDao, ShopProduct> implements IShopProductService {
	
}
