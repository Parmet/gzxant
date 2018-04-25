package com.gzxant.dao.fs.standard.category;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.fs.standard.category.FsStandardCategory;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
public interface FsStandardCategoryDao extends CrudDao<FsStandardCategory> {

   void selectSubCategory(FsStandardCategory standardCategory);
}