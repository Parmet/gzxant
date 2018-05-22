package com.gzxant.service.qualification;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.qualification.Qualification;

/**
 * <p>
 * 资格认证 服务类
 * </p>
 *
 * @author zt
 * @since 2018-05-18
 */
public interface IQualificationService extends IBaseService<Qualification> {

    void qualification(Qualification param);

    Qualification selectByCode(String param);

    Qualification selectByPhone(String param);
}
