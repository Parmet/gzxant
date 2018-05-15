package com.gzxant.service.portals.about.me;

import com.gzxant.entity.portals.about.me.PortalsAboutMe;
import com.gzxant.base.service.IBaseService;

/**
 * <p>
 * 关于我们 服务类
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
public interface IPortalsAboutMeService extends IBaseService<PortalsAboutMe> {
    PortalsAboutMe selectAllAboutMe();
}
