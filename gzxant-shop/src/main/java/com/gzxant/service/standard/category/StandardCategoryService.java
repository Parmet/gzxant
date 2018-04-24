package com.gzxant.service.standard.category;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.standard.category.StandardCategoryDao;
import com.gzxant.entity.standard.category.StandardCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StandardCategoryService extends BaseService<StandardCategoryDao, StandardCategory> implements IStandardCategoryService {
    /**
     * 分类查询
     * @param standardCategory
     */
    @Override
    public void getByPage(StandardCategory standardCategory) {
        selectById(standardCategory);
    }

    /**
     * 分组查询 name
     * @param standardCategory
     */
    @Override
    public void getSubCategory(StandardCategory standardCategory) {
        baseMapper.selectSubCategory(standardCategory);
    }

    /**
     *
     * 修改分类
     * @param standardCategory
     */
    @Override
    public int update(StandardCategory standardCategory) {
        baseMapper.updateById(standardCategory);
        return  1;
    }

    /**
     * 删除分类
     * @param id
     */
    @Override
    public int delete(Long id) {
        baseMapper.deleteById(id);
        return  1;

    }
}
