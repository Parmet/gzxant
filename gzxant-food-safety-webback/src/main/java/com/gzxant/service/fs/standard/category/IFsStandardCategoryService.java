package com.gzxant.service.fs.standard.category;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.fs.standard.category.FsStandardCategory;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
public interface IFsStandardCategoryService extends IBaseService<FsStandardCategory> {
    /**
     * 分类查询
     * @param standardCategory
     */
	 void getByPage(FsStandardCategory standardCategory);

    /**
     * 分组查询 name
     * @param standardCategory
     */
	 void getSubCategory(FsStandardCategory standardCategory);

    /**
     *
     * 修改分类
     * @param standardCategory
     */
     int update(FsStandardCategory standardCategory);

    /**
     *
     * 删除分类
     * @param id
     */
     int delete(Long id);
}
