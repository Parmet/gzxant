package com.gzxant.service.impl;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.SlifeLogDao;
import com.gzxant.entity.SlifeLog;
import com.gzxant.service.ISlifeLogService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chen
 * @date 2017/9/19
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: slife 日志 service
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SlifeLogService extends BaseService<SlifeLogDao, SlifeLog> implements ISlifeLogService {


}
