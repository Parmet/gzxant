package com.gzxant.service.fs.standard.category;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.fs.standard.category.FsStandardCategoryDao;
import com.gzxant.entity.fs.standard.category.FsStandardCategory;
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
public class FsStandardCategoryService extends BaseService<FsStandardCategoryDao, FsStandardCategory> implements IFsStandardCategoryService {
    /**
     * 分类查询
     * @param standardCategory
     */
    @Override
    public void getByPage(FsStandardCategory standardCategory) {
        selectById(standardCategory);
    }

    /**
     * 分组查询 name
     * @param standardCategory
     */
    @Override
    public void getSubCategory(FsStandardCategory standardCategory) {
        baseMapper.selectSubCategory(standardCategory);
    }

    /**
     *
     * 修改分类
     * @param standardCategory
     */
    @Override
    public int update(FsStandardCategory standardCategory) {
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
