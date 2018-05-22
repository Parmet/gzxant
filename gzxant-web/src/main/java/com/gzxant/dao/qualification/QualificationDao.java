package com.gzxant.dao.qualification;

import com.gzxant.base.dao.BaseDao;
import com.gzxant.entity.qualification.Qualification;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 资格认证 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-05-18
 */
public interface QualificationDao extends BaseDao<Qualification> {

    Qualification selectByCode(@Param("code") String code);

    Qualification selectByPhone(@Param("phone")String phone);
}