package com.gzxant.service.portals.column;

import com.gzxant.entity.portals.column.PortalsColumn;
import com.gzxant.base.service.IBaseService;

import java.util.List;

/**
 * <p>
 * 栏目管理 服务类
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
public interface IPortalsColumnService extends IBaseService<PortalsColumn> {

    List<PortalsColumn> selectAllColumns();
}
