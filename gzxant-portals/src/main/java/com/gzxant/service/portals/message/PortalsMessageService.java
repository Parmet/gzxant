package com.gzxant.service.portals.message;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.portals.message.PortalsMessage;
import com.gzxant.dao.portals.message.PortalsMessageDao;
import com.gzxant.service.portals.message.IPortalsMessageService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 联系我们 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PortalsMessageService extends BaseService<PortalsMessageDao, PortalsMessage> implements IPortalsMessageService {
	
}
