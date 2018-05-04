package com.gzxant.service.shop.category;

import com.gzxant.entity.shop.category.ShopCategory;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.base.vo.PCAjaxVO;

/**
 * <p>
 * 商城-分类表 服务类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-24
 */
public interface IShopCategoryService extends IBaseService<ShopCategory> {
	List<JsTree> getDictTree();

	PCAjaxVO delete(Long id);
	
}
