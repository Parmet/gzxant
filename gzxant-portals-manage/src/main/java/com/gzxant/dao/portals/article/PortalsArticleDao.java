package com.gzxant.dao.portals.article;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.portals.article.PortalsArticle;
/**
 * <p>
  * 官网文章内容 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-05-09
 */
public interface PortalsArticleDao extends CrudDao<PortalsArticle> {

    PortalsArticle selectAllArticle();
}