package com.gzxant.service.equipment.standard;

import java.util.Map;

import com.gzxant.base.service.IBaseService;
import com.gzxant.bo.equipment.standard.EquipmentStandardBO;
import com.gzxant.entity.equipment.standard.EquipmentStandard;

/**
 * <p>
 * 标准表 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public interface IEquipmentStandardService extends IBaseService<EquipmentStandard> {

	Map<String, Object> parse(String txtPath);

	EquipmentStandardBO getDataById(String id);

	void deleteItemsById(Long id);
	
}
