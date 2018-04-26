package com.gzxant.entity.shop.sku;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.TreeEntity;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * sku
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@TableName("shop_sku")
public class ShopSku extends TreeEntity<ShopSku> implements Comparable<ShopSku> {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
	private String name;
    /**
     * 属性id
     */
	@TableField("property_id")
	private Long propertyId;
    /**
     * 顺序
     */
	private Integer sort;
    /**
     * 更新者
     */
	@TableField("update_id")
	private Long updateId;


	/**
	 * char(1) NULL是否展示
	 */
	@TableField(value ="show_flag")
	private String showFlag;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ShopSku{" +
			"name=" + name +
			", propertyId=" + propertyId +
			", sort=" + sort +
			", updateId=" + updateId +
			"}";
	}


	@Override
	public int compareTo(ShopSku o) {
		return this.getSort().compareTo(o.getSort());
	}



	@TableField(exist=false)
	public List<ShopSku> children= new ArrayList();

	public List<ShopSku> getChildren() {
		return children;
	}
    public void setChildren(List<ShopSku> children) {
        this.children = children;
    }


	@Length(min = 0, max = 1, message = "标识长度必须介于 1 和 1 之间")
	public String getShowFlag() {
		return showFlag;
	}
    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }
}
