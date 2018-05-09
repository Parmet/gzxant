package com.gzxant.entity.shop.brand;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 商城-品牌表
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@TableName("shop_brand")
public class ShopBrand extends DataEntity<ShopBrand> {

    private static final long serialVersionUID = 1L;

    //品牌中文名称
	private String chineseName;
	//品牌英文,名称
	private String englishName;
	//品牌logo
	private String logo;
	//对应该品牌的url网址
	private String url;
	//显示标识
	private String viewFlag;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(String viewFlag) {
		this.viewFlag = viewFlag;
	}

	@Override
	public String toString() {
		return "ShopBrand{" +
				"chinese_name='" + chineseName + '\'' +
				", english_name='" + englishName + '\'' +
				", logo='" + logo + '\'' +
				", url='" + url + '\'' +
				", remark='" + remark + '\'' +
				", viewFlag='" + viewFlag + '\'' +
				", id=" + id +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
