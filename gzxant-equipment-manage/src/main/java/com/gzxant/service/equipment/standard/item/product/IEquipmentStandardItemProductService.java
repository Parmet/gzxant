package com.gzxant.service.equipment.standard.item.product;

import com.gzxant.entity.equipment.standard.item.product.EquipmentStandardItemProduct;

import java.util.List;

import com.gzxant.base.service.IBaseService;

/**
 * <p>
 * 检验项产品关联表 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-31
 */
public interface IEquipmentStandardItemProductService extends IBaseService<EquipmentStandardItemProduct> {

	List<EquipmentStandardItemProduct> selectByStandradId(String id);

}
