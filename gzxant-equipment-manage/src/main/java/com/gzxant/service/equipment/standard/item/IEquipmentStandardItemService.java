package com.gzxant.service.equipment.standard.item;

import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;

import java.util.List;
import java.util.Map;

import com.gzxant.base.service.IBaseService;

/**
 * <p>
 * 标准项表 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public interface IEquipmentStandardItemService extends IBaseService<EquipmentStandardItem> {

	List<EquipmentStandardItem> insert(EquipmentStandard standard, Map<String, List<EquipmentShopProduct>> itemMap);

	void saveItemProducts(List<EquipmentStandardItem> items, List<EquipmentShopProduct> products,
			Map<String, List<EquipmentShopProduct>> itemMap);
	
}
