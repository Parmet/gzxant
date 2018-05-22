package com.gzxant.service.equipment.shop.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.dao.equipment.shop.product.EquipmentShopProductDao;
import com.gzxant.service.equipment.shop.product.IEquipmentShopProductService;
import com.gzxant.base.service.impl.BaseService;

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
	
}
