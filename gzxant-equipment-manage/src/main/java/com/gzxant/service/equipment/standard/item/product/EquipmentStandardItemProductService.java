package com.gzxant.service.equipment.standard.item.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.standard.item.product.EquipmentStandardItemProduct;
import com.gzxant.dao.equipment.standard.item.product.EquipmentStandardItemProductDao;
import com.gzxant.service.equipment.standard.item.product.IEquipmentStandardItemProductService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 检验项产品关联表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-31
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentStandardItemProductService extends BaseService<EquipmentStandardItemProductDao, EquipmentStandardItemProduct> implements IEquipmentStandardItemProductService {

	@Override
	public List<EquipmentStandardItemProduct> selectByStandradId(String id) {
		List<EquipmentStandardItemProduct> datas = this.baseMapper.selectByStandradId(id);
		if (datas == null) {
			datas = new ArrayList<>();
		}
		
		return datas;
	}
}
