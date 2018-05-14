package com.gzxant.service.portals.company.information;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.portals.company.information.PortalsCompanyInformation;
import com.gzxant.dao.portals.company.information.PortalsCompanyInformationDao;
import com.gzxant.service.portals.company.information.IPortalsCompanyInformationService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 公司信息 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PortalsCompanyInformationService extends BaseService<PortalsCompanyInformationDao, PortalsCompanyInformation> implements IPortalsCompanyInformationService {
	
}
