package com.gzxant.service.equipment.standard.tech;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.standard.tech.EquipmentStandardTech;
import com.gzxant.dao.equipment.standard.tech.EquipmentStandardTechDao;
import com.gzxant.service.equipment.standard.tech.IEquipmentStandardTechService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 标准技术要求表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-06-20
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentStandardTechService extends BaseService<EquipmentStandardTechDao, EquipmentStandardTech>
		implements IEquipmentStandardTechService {

}
