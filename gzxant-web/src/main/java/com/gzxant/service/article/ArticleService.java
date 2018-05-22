package com.gzxant.service.article;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.article.Article;
import com.gzxant.dao.article.ArticleDao;
import com.gzxant.service.article.IArticleService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-22
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ArticleService extends BaseService<ArticleDao, Article> implements IArticleService {
	
}
