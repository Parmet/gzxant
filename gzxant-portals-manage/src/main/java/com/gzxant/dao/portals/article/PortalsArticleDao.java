package com.gzxant.dao.portals.article;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.portals.article.PortalsArticle;

import java.util.List;

/**
 * <p>
  * 官网文章内容 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-05-09
 */
public interface PortalsArticleDao extends CrudDao<PortalsArticle> {


    List<PortalsArticle> selectAllArticle();

}