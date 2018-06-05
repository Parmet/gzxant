package com.gzxant.service.equipment.standard.category;

import com.gzxant.entity.equipment.standard.category.EquipmentStandardCategory;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.base.vo.PCAjaxVO;

/**
 * <p>
 * 标准分类表 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public interface IEquipmentStandardCategoryService extends IBaseService<EquipmentStandardCategory> {
	List<JsTree> getDictTree();

	PCAjaxVO delete(Long id);

	EquipmentStandardCategory insertSingle(EquipmentStandardCategory category);
}
