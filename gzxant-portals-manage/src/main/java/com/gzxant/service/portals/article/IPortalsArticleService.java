package com.gzxant.service.portals.article;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.portals.article.PortalsArticle;

import java.util.List;

/**
 * <p>
 * 官网文章内容 服务类
 * </p>
 *
 * @author zt
 * @since 2018-05-09
 */
public interface IPortalsArticleService extends IBaseService<PortalsArticle> {

    List<PortalsArticle> selectAllArticle();

}
