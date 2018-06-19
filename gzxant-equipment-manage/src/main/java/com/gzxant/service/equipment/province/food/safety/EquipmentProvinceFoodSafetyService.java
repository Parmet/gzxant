package com.gzxant.service.equipment.province.food.safety;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.province.food.safety.EquipmentProvinceFoodSafety;
import com.gzxant.dao.equipment.province.food.safety.EquipmentProvinceFoodSafetyDao;
import com.gzxant.service.equipment.province.food.safety.IEquipmentProvinceFoodSafetyService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 省食品安全监督抽检 服务实现类
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentProvinceFoodSafetyService extends BaseService<EquipmentProvinceFoodSafetyDao, EquipmentProvinceFoodSafety> implements IEquipmentProvinceFoodSafetyService {
	
}
