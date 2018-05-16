package com.gzxant.dao.portals.column;

import com.gzxant.entity.portals.column.PortalsColumn;
import com.gzxant.base.dao.CrudDao;

import java.util.List;

/**
 * <p>
  * 栏目管理 Mapper 接口
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
public interface PortalsColumnDao extends CrudDao<PortalsColumn> {

    List<PortalsColumn> selectAllColumns();
}