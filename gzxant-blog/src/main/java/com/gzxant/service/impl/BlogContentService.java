package com.gzxant.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.BlogContentDao;
import com.gzxant.entity.BlogContent;
import com.gzxant.service.IBlogContentService;

/**
 *
 * @author chen
 * @date 2017/11/20
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BlogContentService extends BaseService<BlogContentDao, BlogContent> implements IBlogContentService {
}
