package com.gzxant.service.equipment.food.article;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.food.article.EquipmentFoodArticle;
import com.gzxant.dao.equipment.food.article.EquipmentFoodArticleDao;
import com.gzxant.service.equipment.food.article.IEquipmentFoodArticleService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 抽检食品文章表 服务实现类
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-15
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentFoodArticleService extends BaseService<EquipmentFoodArticleDao, EquipmentFoodArticle> implements IEquipmentFoodArticleService {
	
}
