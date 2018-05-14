package com.gzxant.entity.portals.column;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 栏目管理
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@TableName("portals_column")
public class PortalsColumn extends DataEntity<PortalsColumn> {

    private static final long serialVersionUID = 1L;

    /**
     * 栏目名称
     */
	@TableField("column_name")
	private String columnName;
    /**
     * 栏目路径,具体的栏目位置
     */
	@TableField("column_path")
	private String columnPath;
    /**
     * 排序
     */
	private String sorting;
	@TableField("update_id")
	private Long updateId;


	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnPath() {
		return columnPath;
	}

	public void setColumnPath(String columnPath) {
		this.columnPath = columnPath;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PortalsColumn{" +
			"columnName=" + columnName +
			", columnPath=" + columnPath +
			", sorting=" + sorting +
			", updateId=" + updateId +
			"}";
	}
}
