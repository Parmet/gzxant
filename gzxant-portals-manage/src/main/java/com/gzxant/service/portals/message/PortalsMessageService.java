package com.gzxant.service.portals.message;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.portals.message.PortalsMessageDao;
import com.gzxant.entity.portals.message.PortalsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private  PortalsMessageDao portalsMessageDao;

    @Override
    public PortalsMessage selectAllMessage() {
        return portalsMessageDao.selectAllMessage();
    }
}
