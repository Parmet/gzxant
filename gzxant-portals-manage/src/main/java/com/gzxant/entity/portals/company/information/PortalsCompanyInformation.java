package com.gzxant.entity.portals.company.information;

import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;

/**
 * <p>
 * 公司信息
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
@TableName("portals_company_information")
public class PortalsCompanyInformation extends DataEntity<PortalsCompanyInformation> {

    private static final long serialVersionUID = 1L;

    /**
     * 公司logo
     */
	private String logo;
    /**
     * 首页轮播图片
     */
	private String shuffling;
    /**
     * 公司名称
     */
	private String name;
    /**
     * 公司地理位置
     */
	private String address;
    /**
     * 公司地座右铭
     */
	private String portalsMotto;
    /**
     * 公司地理座右铭内容
     */
	private String mottoContent;

	/**
	 * 公司唯一标识
	 * @return
	 */
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getShuffling() {
		return shuffling;
	}

	public void setShuffling(String shuffling) {
		this.shuffling = shuffling;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPortalsMotto() {
		return portalsMotto;
	}

	public void setPortalsMotto(String portalsMotto) {
		this.portalsMotto = portalsMotto;
	}

	public String getMottoContent() {
		return mottoContent;
	}

	public void setMottoContent(String mottoContent) {
		this.mottoContent = mottoContent;
	}


	@Override
	public String toString() {
		return "PortalsCompanyInformation{" +
				"logo='" + logo + '\'' +
				", shuffling='" + shuffling + '\'' +
				", address='" + address + '\'' +
				", portalsMotto='" + portalsMotto + '\'' +
				", mottoContent='" + mottoContent + '\'' +
				", code='" + code + '\'' +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
