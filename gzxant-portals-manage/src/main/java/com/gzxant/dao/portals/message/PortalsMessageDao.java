package com.gzxant.dao.portals.message;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.portals.message.PortalsMessage;

/**
 * <p>
  * 联系我们 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
public interface PortalsMessageDao extends CrudDao<PortalsMessage> {

    PortalsMessage selectAllMessage();
}