package com.gzxant.service.portals.about.me;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.portals.about.me.PortalsAboutMe;
import com.gzxant.dao.portals.about.me.PortalsAboutMeDao;
import com.gzxant.service.portals.about.me.IPortalsAboutMeService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 关于我们 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PortalsAboutMeService extends BaseService<PortalsAboutMeDao, PortalsAboutMe> implements IPortalsAboutMeService {
	
}
