package com.gzxant.service.equipment.standard.category;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.base.vo.PCAjaxVO;
import com.gzxant.dao.equipment.standard.category.EquipmentStandardCategoryDao;
import com.gzxant.entity.equipment.standard.category.EquipmentStandardCategory;

/**
 * <p>
 * 标准分类表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentStandardCategoryService extends BaseService<EquipmentStandardCategoryDao, EquipmentStandardCategory> implements IEquipmentStandardCategoryService {
	@Override
	public List<JsTree> getDictTree() {
		logger.info("查找字段树");
        List<EquipmentStandardCategory> categorys = this.baseMapper.selectList(Condition.create().orderBy("sort", true));
        List<JsTree> jts = Lists.newArrayList();
        for (EquipmentStandardCategory category : categorys) {
            JsTree jt = new JsTree();
            jt.setId(category.getId().toString());
            jt.setParent(category.getParentId().compareTo(0L) > 0 ? category.getParentId().toString() : "#");
            jt.setText(category.getName());
            if (StringUtils.isBlank(category.getIcon())) {
                jt.setIcon("glyphicon glyphicon-tint");
            } else {
            	jt.setIcon(category.getIcon());
            }
            
            jts.add(jt);
        }
        
        return jts;
	}

	@Override
	public PCAjaxVO delete(Long id) {
		PCAjaxVO status = new PCAjaxVO(true);
        //是否为类，以及类下是否有引用
		EquipmentStandardCategory category = selectById(id);

        if (category != null) {
            //删除
            delete(Condition.create().like("path", category.getPath(), SqlLike.RIGHT));
        } else {
            status.setSuccess(false);
            status.setMessage("该数据不存在");
        }
        
        status.setMessage("删除成功");
        return status;
	}
}
