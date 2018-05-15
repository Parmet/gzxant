package com.gzxant.dao.portals.company.information;

import com.gzxant.base.dao.BaseDao;
import com.gzxant.entity.portals.company.information.PortalsCompanyInformation;

/**
 * <p>
  * 公司信息 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
public interface PortalsCompanyInformationDao extends BaseDao<PortalsCompanyInformation> {

    PortalsCompanyInformation selectAllPortals();
}