package com.gzxant.service.equipment.healthcare.food;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.healthcare.food.EquipmentHealthcareFood;
import com.gzxant.dao.equipment.healthcare.food.EquipmentHealthcareFoodDao;
import com.gzxant.service.equipment.healthcare.food.IEquipmentHealthcareFoodService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 国家保健食品安全监督抽检 服务实现类
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-20
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentHealthcareFoodService extends BaseService<EquipmentHealthcareFoodDao, EquipmentHealthcareFood> implements IEquipmentHealthcareFoodService {
	
}
