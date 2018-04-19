package com.gzant.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商城-品牌表
 * </p>
 *
 * @author zt
 * @since 2018-04-19
 */
@TableName("shop_brand")
public class ShopBrand extends DataEntity<ShopBrand> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 名称
     */
	private String name;
	private String logo;
	@TableField("create_id")
	private Long createId;
	@TableField("update_id")
	private Long updateId;
	@TableField("create_date")
	private Date createDate;
	@TableField("update_date")
	private Date updateDate;
    /**
     * 删除标记Y：正常；N：删除；A：审核
     */
	@TableField("del_flag")
	private String delFlag;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ShopBrand{" +
			", id=" + id +
			", name=" + name +
			", logo=" + logo +
			", createId=" + createId +
			", updateId=" + updateId +
			", createDate=" + createDate +
			", updateDate=" + updateDate +
			", delFlag=" + delFlag +
			"}";
	}
}
