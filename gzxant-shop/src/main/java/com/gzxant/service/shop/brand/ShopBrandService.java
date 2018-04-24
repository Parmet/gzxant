package com.gzxant.service.shop.brand;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.brand.ShopBrand;
import com.gzxant.dao.shop.brand.ShopBrandDao;
import com.gzxant.service.shop.brand.IShopBrandService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城-品牌表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopBrandService extends BaseService<ShopBrandDao, ShopBrand> implements IShopBrandService {
	
}
