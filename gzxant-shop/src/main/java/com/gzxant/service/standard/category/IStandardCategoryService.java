package com.gzxant.service.standard.category;

import com.gzxant.entity.standard.category.StandardCategory;
import com.gzxant.base.service.IBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
public interface IStandardCategoryService extends IBaseService<StandardCategory> {
    /**
     * 分类查询
     * @param standardCategory
     */
	 void getByPage(StandardCategory standardCategory);

    /**
     * 分组查询 name
     * @param standardCategory
     */
	 void getSubCategory(StandardCategory standardCategory);

    /**
     *
     * 修改分类
     * @param standardCategory
     */
     int update(StandardCategory standardCategory);

    /**
     *
     * 删除分类
     * @param id
     */
     int delete(Long id);
}
