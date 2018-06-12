package com.gzxant.service.equipment.standard;

import java.util.List;
import java.util.Map;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;

/**
 * <p>
 * 标准表 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public interface IEquipmentStandardService extends IBaseService<EquipmentStandard> {

	Map<String, Object> parse(String txtPath);
	
	Map<EquipmentStandard, Map<EquipmentStandardItem, List<EquipmentShopProduct>>> getDataMapById(String id);

	void deleteItemsById(Long id);
}
