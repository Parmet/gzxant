package com.gzxant.service.fs.standard;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.fs.standard.FsStandard;
import com.gzxant.dao.fs.standard.FsStandardDao;
import com.gzxant.service.fs.standard.IFsStandardService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 食品标准表 服务实现类
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-28
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class FsStandardService extends BaseService<FsStandardDao, FsStandard> implements IFsStandardService {
	
}
