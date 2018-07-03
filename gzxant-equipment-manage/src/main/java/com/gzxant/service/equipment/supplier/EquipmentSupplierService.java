package com.gzxant.service.equipment.supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.supplier.EquipmentSupplier;
import com.gzxant.dao.equipment.supplier.EquipmentSupplierDao;
import com.gzxant.service.equipment.supplier.IEquipmentSupplierService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 供应商 服务实现类
 * </p>
 *
 * @author mojinsheng
 * @since 2018-07-01
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentSupplierService extends BaseService<EquipmentSupplierDao, EquipmentSupplier> implements IEquipmentSupplierService {
	
}
