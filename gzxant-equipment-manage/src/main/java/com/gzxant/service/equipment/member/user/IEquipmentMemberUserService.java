package com.gzxant.service.equipment.member.user;

import com.gzxant.entity.equipment.member.user.EquipmentMemberUser;
import com.gzxant.base.service.IBaseService;

/**
 * <p>
 * 会员用户表 服务类
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-23
 */
public interface IEquipmentMemberUserService extends IBaseService<EquipmentMemberUser> {
    /**
     * 检测登录名是否重复
     *
     * @param loginName
     * @param id
     * @return
     */
    Boolean checkLoginName(String loginName, Long id) ;
	
}
