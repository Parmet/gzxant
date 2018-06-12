package com.gzxant.service.equipment.standard.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.equipment.standard.item.EquipmentStandardItemDao;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;
import com.gzxant.entity.equipment.standard.item.product.EquipmentStandardItemProduct;
import com.gzxant.service.equipment.standard.item.product.IEquipmentStandardItemProductService;

/**
 * <p>
 * 标准项表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentStandardItemService extends BaseService<EquipmentStandardItemDao, EquipmentStandardItem> implements IEquipmentStandardItemService {

	@Autowired
	private IEquipmentStandardItemProductService itemProductService;
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	@Override
	public void saveItemProducts(List<EquipmentStandardItem> items, List<EquipmentShopProduct> products,
			Map<String, List<EquipmentShopProduct>> itemMap) {
		// 保存关联
		List<EquipmentStandardItemProduct> itemProducts = new ArrayList<>();
		// item 和 product 名称的对应map
		Map<String, List<String>> itemProductNameMap = new HashMap<>();
		for (String itemName : itemMap.keySet()) {
			List<String> productNames = new ArrayList<>();
			for (EquipmentShopProduct product : itemMap.get(itemName)) {
				productNames.add(product.getName());
			}
			
			itemProductNameMap.put(itemName, productNames);
		}
		
		// product 名称和实体的对应map
		Map<String, EquipmentShopProduct> productMap = new HashMap<>();
		for (EquipmentShopProduct product : products) {
			productMap.put(product.getName(), product);
		}
		
		for (EquipmentStandardItem item : items) {
			if (itemProductNameMap.containsKey(item.getName())) {
				for (String productName : itemProductNameMap.get(item.getName())) {
					EquipmentStandardItemProduct itemProduct = new EquipmentStandardItemProduct();
					EquipmentShopProduct product = productMap.get(productName);
					itemProduct.setItemId(item.getId());
					itemProduct.setProductId(product.getId());
					itemProduct.setRemark(product.getRemark());
					itemProducts.add(itemProduct);
				}
			}
		}
		
		itemProductService.insertBatch(itemProducts);
	}
}
