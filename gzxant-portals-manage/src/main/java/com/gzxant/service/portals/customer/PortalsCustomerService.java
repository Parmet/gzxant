package com.gzxant.service.portals.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.portals.customer.PortalsCustomer;
import com.gzxant.dao.portals.customer.PortalsCustomerDao;
import com.gzxant.service.portals.customer.IPortalsCustomerService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 客户管理 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PortalsCustomerService extends BaseService<PortalsCustomerDao, PortalsCustomer> implements IPortalsCustomerService {
	
}
