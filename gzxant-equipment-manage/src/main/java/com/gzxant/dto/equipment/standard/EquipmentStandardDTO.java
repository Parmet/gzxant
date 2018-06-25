package com.gzxant.dto.equipment.standard;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 标准表
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
public class EquipmentStandardDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String englishName;
	private String number;
	private String category;
	private String type;
	private String replaceStandard;
	private String importStandard;
	private String pdfUrl;
	private String txtUrl;
	private String imgsPath;
	private String pageSize;
	private String publishDate;
	private String uploadDate;
	private String implementDate;
	
	private List<EquipmentStandardItemDTO> items;
	private List<EquipmentStandardTechDTO> techs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReplaceStandard() {
		return replaceStandard;
	}

	public void setReplaceStandard(String replaceStandard) {
		this.replaceStandard = replaceStandard;
	}

	public String getImportStandard() {
		return importStandard;
	}

	public void setImportStandard(String importStandard) {
		this.importStandard = importStandard;
	}

	public String getPdfUrl() {
		return pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	public String getTxtUrl() {
		return txtUrl;
	}

	public void setTxtUrl(String txtUrl) {
		this.txtUrl = txtUrl;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getImplementDate() {
		return implementDate;
	}

	public void setImplementDate(String implementDate) {
		this.implementDate = implementDate;
	}

	public List<EquipmentStandardItemDTO> getItems() {
		return items;
	}

	public void setItems(List<EquipmentStandardItemDTO> items) {
		this.items = items;
	}

	public String getImgsPath() {
		return imgsPath;
	}

	public void setImgsPath(String imgsPath) {
		this.imgsPath = imgsPath;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public List<EquipmentStandardTechDTO> getTechs() {
		return techs;
	}

	public void setTechs(List<EquipmentStandardTechDTO> techs) {
		this.techs = techs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
