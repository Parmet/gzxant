package com.gzxant.service.shop.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.shop.category.ShopCategory;
import com.gzxant.dao.shop.category.ShopCategoryDao;
import com.gzxant.service.shop.category.IShopCategoryService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 商城-分类表 服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-24
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopCategoryService extends BaseService<ShopCategoryDao, ShopCategory> implements IShopCategoryService {
	
}
