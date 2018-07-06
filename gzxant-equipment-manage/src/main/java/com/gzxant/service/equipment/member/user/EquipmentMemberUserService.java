package com.gzxant.service.equipment.member.user;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.entity.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.equipment.member.user.EquipmentMemberUser;
import com.gzxant.dao.equipment.member.user.EquipmentMemberUserDao;
import com.gzxant.service.equipment.member.user.IEquipmentMemberUserService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 会员用户表 服务实现类
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-23
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentMemberUserService extends BaseService<EquipmentMemberUserDao, EquipmentMemberUser> implements IEquipmentMemberUserService {
    /**
     * 检测登录名是否重复
     *
     * @param loginName
     * @param id
     * @return
     */
    @Override
    public Boolean checkLoginName(String loginName, Long id) {
        EquipmentMemberUser equipmentMemberUser = selectOne(Condition.create().eq("login_name", loginName));
        return equipmentMemberUser == null || !id.equals(0L) && equipmentMemberUser.getId().equals(id);
    }
	
}
