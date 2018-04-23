package com.gzxant.service.impl;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.ShopCategoryDao;
import com.gzxant.entity.ShopCategory;
import com.gzxant.service.IShopCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商城-分类表 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ShopCategoryService extends BaseService<ShopCategoryDao, ShopCategory> implements IShopCategoryService {
	
}
