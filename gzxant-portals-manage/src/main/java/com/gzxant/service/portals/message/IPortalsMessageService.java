package com.gzxant.service.portals.message;

import com.gzxant.entity.portals.message.PortalsMessage;
import com.gzxant.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 * 联系我们 服务类
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
public interface IPortalsMessageService extends IBaseService<PortalsMessage> {
    //查询公司联系信息
    PortalsMessage selectAllMessage();
}
