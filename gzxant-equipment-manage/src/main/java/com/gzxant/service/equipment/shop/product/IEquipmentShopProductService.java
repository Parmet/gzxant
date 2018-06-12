package com.gzxant.service.equipment.shop.product;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;

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

	List<EquipmentShopProduct> insert(List<EquipmentShopProduct> products);
	
}
