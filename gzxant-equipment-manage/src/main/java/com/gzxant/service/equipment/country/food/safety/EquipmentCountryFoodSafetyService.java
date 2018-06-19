package com.gzxant.service.equipment.country.food.safety;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.country.food.safety.EquipmentCountryFoodSafety;
import com.gzxant.dao.equipment.country.food.safety.EquipmentCountryFoodSafetyDao;
import com.gzxant.service.equipment.country.food.safety.IEquipmentCountryFoodSafetyService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 国家食品安全监督抽检(合格) 服务实现类
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentCountryFoodSafetyService extends BaseService<EquipmentCountryFoodSafetyDao, EquipmentCountryFoodSafety> implements IEquipmentCountryFoodSafetyService {
	
}
