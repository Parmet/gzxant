package com.gzxant.service.portals.article;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.portals.article.PortalsArticleDao;
import com.gzxant.entity.portals.article.PortalsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 官网文章内容 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-09
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PortalsArticleService extends BaseService<PortalsArticleDao, PortalsArticle> implements IPortalsArticleService {

    @Autowired
    private PortalsArticleDao portalsArticleDao;

    @Override
    public PortalsArticle selectAllArticle() {
        //查询文章
        return portalsArticleDao.selectAllArticle();
    }
}
