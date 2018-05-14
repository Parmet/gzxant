package com.gzxant.service.portals.column;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.portals.column.PortalsColumn;
import com.gzxant.dao.portals.column.PortalsColumnDao;
import com.gzxant.service.portals.column.IPortalsColumnService;
import com.gzxant.base.service.impl.BaseService;

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
	
}
