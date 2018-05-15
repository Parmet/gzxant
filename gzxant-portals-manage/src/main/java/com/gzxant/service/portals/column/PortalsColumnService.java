package com.gzxant.service.portals.column;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.portals.column.PortalsColumnDao;
import com.gzxant.entity.portals.column.PortalsColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 栏目管理 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PortalsColumnService extends BaseService<PortalsColumnDao, PortalsColumn> implements IPortalsColumnService {

    @Autowired
    private PortalsColumnDao portalsColumnDao;

    @Override
    public PortalsColumn selectAllColumns() {
        return portalsColumnDao.selectAllColumns();
    }
}
