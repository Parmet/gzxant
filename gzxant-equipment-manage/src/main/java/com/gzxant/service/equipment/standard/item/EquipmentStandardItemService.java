package com.gzxant.service.equipment.standard.item;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;
import com.gzxant.dao.equipment.standard.item.EquipmentStandardItemDao;
import com.gzxant.service.equipment.standard.item.IEquipmentStandardItemService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 标准项表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentStandardItemService extends BaseService<EquipmentStandardItemDao, EquipmentStandardItem> implements IEquipmentStandardItemService {
	
}
