package com.gzxant.service.equipment.shop.product;

import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;

import java.util.List;
import java.util.Map;

import com.gzxant.base.service.IBaseService;

/**
 * <p>
 * 产品表 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public interface IEquipmentShopProductService extends IBaseService<EquipmentShopProduct> {

	List<EquipmentShopProduct> selectExistsProduct(List<EquipmentShopProduct> products);

	List<Long> getIds(List<EquipmentShopProduct> existsProductexistsProduct);

	List<EquipmentShopProduct> insert(Map<String, List<EquipmentShopProduct>> itemMap);
	
}
