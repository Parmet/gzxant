package com.gzxant.service.equipment.standard.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.equipment.standard.item.EquipmentStandardItemDao;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
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
	
	/**
	 * @param items 数据库的检验项
	 * @param productDatas 数据库的产品数据
	 * @param itemMap 页面传递的检验项结构数据
	 */
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	@Override
	public void saveItemProducts(List<EquipmentStandardItem> itemDatas, 
			List<EquipmentShopProduct> productDatas, 
			Map<String, List<EquipmentShopProduct>> itemMap) {
		// 保存关联
		List<EquipmentStandardItemProduct> itemProducts = new ArrayList<>();
		
		// product 名称和实体的对应map
		Map<String, EquipmentShopProduct> productDataMap = new HashMap<>();
		for (EquipmentShopProduct product : productDatas) {
			productDataMap.put(product.getName(), product);
		}
		
		for (EquipmentStandardItem item : itemDatas) {
			if (itemMap.containsKey(item.getName())) {
				for (EquipmentShopProduct product : itemMap.get(item.getName())) {
					EquipmentStandardItemProduct itemProduct = new EquipmentStandardItemProduct();
					EquipmentShopProduct productData = productDataMap.get(product.getName());
					itemProduct.setItemId(item.getId());
					itemProduct.setProductId(productData.getId());
					itemProduct.setRemark(product.getRemark());
					itemProducts.add(itemProduct);
				}
			}
		}
		
		if (!itemProducts.isEmpty()) {
			itemProductService.insertBatch(itemProducts);
		}
	}
}
