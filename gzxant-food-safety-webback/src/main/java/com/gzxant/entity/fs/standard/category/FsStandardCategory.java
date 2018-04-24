package com.gzxant.entity.fs.standard.category;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
@TableName("standard_category")
public class FsStandardCategory extends DataEntity<FsStandardCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
	private String name;
	@TableField("update_id")
	private Long updateId;
    /**
     * 父级
     */
	private Long parent;
    /**
     * 排序规则
     */
	private Integer sort;
    /**
     * 分类排序
     */
	private String path;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "StandardCategory{" +
			"name=" + name +
			", updateId=" + updateId +
			", parent=" + parent +
			", sort=" + sort +
			", path=" + path +
			"}";
	}
}
