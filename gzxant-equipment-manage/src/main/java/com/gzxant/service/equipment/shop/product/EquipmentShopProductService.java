package com.gzxant.service.equipment.shop.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.equipment.shop.product.EquipmentShopProductDao;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentShopProductService extends BaseService<EquipmentShopProductDao, EquipmentShopProduct> implements IEquipmentShopProductService {

	@Override
	public List<EquipmentShopProduct> selectExistsProduct(List<EquipmentShopProduct> products) {
		List<String> mNames = new ArrayList<>();
		List<String> eNames = new ArrayList<>();
		for (EquipmentShopProduct product : products) {
			if (product.getType().equals("M")) {
				mNames.add(product.getName());
			} else if (product.getType().equals("E")) {
				eNames.add(product.getName());
			}
		}
		
		EntityWrapper<EquipmentShopProduct> ewMProduct = new EntityWrapper<>();
		ewMProduct.setEntity(new EquipmentShopProduct());
		ewMProduct.where("type='M'").in("name", mNames);
		List<EquipmentShopProduct> existMProducts = selectList(ewMProduct);
		if (existMProducts == null) {
			existMProducts = new ArrayList<>();
		}
		
		EntityWrapper<EquipmentShopProduct> ewEProduct = new EntityWrapper<>();
		ewEProduct.setEntity(new EquipmentShopProduct());
		ewEProduct.where("type='E'").in("name", eNames);
		List<EquipmentShopProduct> existEProducts = selectList(ewEProduct);
		if (existEProducts == null) {
			existEProducts = new ArrayList<>();
		}
		
		List<EquipmentShopProduct> existProducts = new ArrayList<>();
		existProducts.addAll(existEProducts);
		existProducts.addAll(existMProducts);
		return existProducts;
	}

	@Override
	public List<Long> getIds(List<EquipmentShopProduct> products) {
		List<Long> ids = new ArrayList<>();
		for (EquipmentShopProduct product : products) {
			ids.add(product.getId());
		}
		
		return ids;
	}

	@Override
	@Transactional(readOnly = false)
	public List<EquipmentShopProduct> insert(List<EquipmentShopProduct> products) {
		
		// 已存在的产品数据
		List<EquipmentShopProduct> existsProducts = new ArrayList<>();
		// 准备插入的产品数据
		List<EquipmentShopProduct> insertProducts = new ArrayList<>();
		
		
		// 查询已存在的数据，并保存名称到list
		existsProducts = selectExistsProduct(products);
		List<String> existsProductNames = new ArrayList<>();
		for (EquipmentShopProduct existsProduct : existsProducts) {
			existsProductNames.add(existsProduct.getName());
		}
		
		// 排除已存在的数据，保存到准备插入的产品数据中
		for (EquipmentShopProduct product : products) {
			if (!existsProductNames.contains(product.getName())) {
				insertProducts.add(product);
			}
		}
		
		if (insertProducts != null && !insertProducts.isEmpty()) {
			insertBatch(insertProducts);
		}
		
		products = new ArrayList<>();
		products.addAll(insertProducts);
		products.addAll(existsProducts);
		return products;
	}
	
}
