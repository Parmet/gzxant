package com.gzxant.service.equipment.standard.item;

import java.util.List;
import java.util.Map;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;

/**
 * <p>
 * 标准项表 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public interface IEquipmentStandardItemService extends IBaseService<EquipmentStandardItem> {

	void saveItemProducts(List<EquipmentStandardItem> items, List<EquipmentShopProduct> products,
			Map<String, List<EquipmentShopProduct>> itemMap);

}
