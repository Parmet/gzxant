package com.gzxant.dao.portals.customer;

import com.gzxant.entity.portals.customer.PortalsCustomer;
import com.gzxant.base.dao.CrudDao;

import java.util.List;

/**
 * <p>
  * 客户管理 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
public interface PortalsCustomerDao extends CrudDao<PortalsCustomer> {

    List<PortalsCustomer> selectAllCustomer();
}