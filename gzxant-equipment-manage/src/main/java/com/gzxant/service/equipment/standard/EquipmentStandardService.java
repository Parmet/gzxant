package com.gzxant.service.equipment.standard;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.dao.equipment.standard.EquipmentStandardDao;
import com.gzxant.service.equipment.standard.IEquipmentStandardService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 标准表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentStandardService extends BaseService<EquipmentStandardDao, EquipmentStandard> implements IEquipmentStandardService {
	
}
