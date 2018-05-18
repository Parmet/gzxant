package com.gzxant.service.portals.customer;

import com.gzxant.entity.portals.customer.PortalsCustomer;
import com.gzxant.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 * 客户管理 服务类
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
public interface IPortalsCustomerService extends IBaseService<PortalsCustomer> {

    List<PortalsCustomer> selectAllCustomer();
	
}
