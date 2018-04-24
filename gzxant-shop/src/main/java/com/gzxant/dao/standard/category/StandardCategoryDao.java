package com.gzxant.dao.standard.category;

import com.gzxant.entity.standard.category.StandardCategory;
import com.gzxant.base.dao.CrudDao;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
public interface StandardCategoryDao extends CrudDao<StandardCategory> {

   void selectSubCategory(StandardCategory standardCategory);
}