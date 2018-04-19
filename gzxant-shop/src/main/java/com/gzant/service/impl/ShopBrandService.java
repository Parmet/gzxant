package com.gzant.service.impl;

import com.gzant.dao.ShopBrandDao;
import com.gzant.entity.ShopBrand;
import com.gzant.service.IShopBrandService;
import com.gzxant.base.service.impl.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商城-品牌表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopBrandService extends BaseService<ShopBrandDao, ShopBrand> implements IShopBrandService {
	
}
