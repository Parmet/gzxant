package com.gzxant.entity.shop.attribute;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.TreeEntity;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * attribute
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@TableName("shop_attribute")
public class ShopAttribute extends TreeEntity<ShopAttribute> implements Comparable<ShopAttribute> {

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
	 * 属性类型
	 */
	private String type;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * char(1) NULL是否展示
	 */
	@TableField(value ="show_flag")
	private String showFlag;



	@Override
	protected Serializable pkVal() {
		return this.id;
	}





	@Override
	public int compareTo(ShopAttribute o) {
		return this.getSort().compareTo(o.getSort());
	}

	@TableField(exist=false)
	public List<ShopAttribute> children= new ArrayList();

	public List<ShopAttribute> getChildren() {
		return children;
	}
    public void setChildren(List<ShopAttribute> children) {
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
