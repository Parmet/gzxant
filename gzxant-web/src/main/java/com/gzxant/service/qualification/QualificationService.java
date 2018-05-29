package com.gzxant.service.qualification;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.qualification.QualificationDao;
import com.gzxant.entity.qualification.Qualification;
import com.gzxant.util.StringUtils;

/**
 * <p>
 * 资格认证 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-18
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class QualificationService extends BaseService<QualificationDao, Qualification> implements IQualificationService {

    @Override
    public Qualification selectByCode(String param) {
        Qualification qualification = baseMapper.selectByCode(param);
        return qualification;
    }

    @Override
    public Qualification selectByPhone(String phone) {
        return baseMapper.selectByPhone(phone);
    }

	@Override
	public String checkCode(String code) {
		if (StringUtils.isBlank(code)) {
			return "请填写编号";
		}
		
		// 编号格式不正确
		// 长度为9的字符串
		// 要以GZZJ开头
		// GZZJ后面必须是数字
		// 数字要从在[37681, 87680]的区间中
		if (code.length() != 9 
			|| !code.startsWith("GZZJ")
			|| !StringUtils.isNumeric(code.substring(4))
			|| Integer.parseInt(code.substring(4)) < 37681
			|| Integer.parseInt(code.substring(4)) > 87680) {
			return "编号格式不正确";
		}
		
		// 编号不能重复
		EntityWrapper<Qualification> ew = new EntityWrapper<>();
		ew.setEntity(new Qualification());
		ew.where("state='Y'")
			.and("code={0}", code);
		int count = baseMapper.selectCount(ew);
		if (count > 0) {
			return "该编号：" + code + "已存在";
		}
		
		return "";
	}

}
