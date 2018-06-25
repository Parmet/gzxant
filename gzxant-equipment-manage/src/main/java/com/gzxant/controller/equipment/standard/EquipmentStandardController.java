package com.gzxant.controller.equipment.standard;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.bo.equipment.standard.EquipmentStandardBO;
import com.gzxant.bo.equipment.standard.EquipmentStandardItemBO;
import com.gzxant.dto.equipment.standard.EquipmentStandardDTO;
import com.gzxant.dto.equipment.standard.EquipmentStandardItemDTO;
import com.gzxant.dto.equipment.standard.EquipmentStandardProductDTO;
import com.gzxant.dto.equipment.standard.EquipmentStandardTechDTO;
import com.gzxant.dto.equipment.standard.EquipmentStandardTechSubDTO;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.entity.equipment.standard.category.EquipmentStandardCategory;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;
import com.gzxant.entity.equipment.standard.tech.EquipmentStandardTech;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.equipment.shop.product.IEquipmentShopProductService;
import com.gzxant.service.equipment.standard.IEquipmentStandardService;
import com.gzxant.service.equipment.standard.category.IEquipmentStandardCategoryService;
import com.gzxant.service.equipment.standard.item.IEquipmentStandardItemService;
import com.gzxant.service.equipment.standard.tech.IEquipmentStandardTechService;
import com.gzxant.util.FileUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.data.JsonUtil;
import com.gzxant.util.image.ocr.baidu.ImageUtils;
import com.gzxant.util.pdf.PDFUtil;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 标准表 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Controller
@RequestMapping("/back/standard")
public class EquipmentStandardController extends BaseController {
	@Autowired
	private IEquipmentStandardService standardService;
	@Autowired
	private IEquipmentStandardCategoryService categoryService;
	@Autowired
	private IEquipmentStandardTechService techService;
	@Autowired
	private IEquipmentStandardItemService itemService;
	@Autowired
	private IEquipmentShopProductService productService;
	@Autowired
	private ISysDictService dictService;

	@ApiOperation(value = "进入标准表列表界面", notes = "进入标准表列表界面")
	@GetMapping(value = "")
	public String toList(Model model) {
		model.addAttribute("categoryTrees", JSON.toJSONString(categoryService.getDictTree()));
		model.addAttribute("types", dictService.getSub("STANDARD_TYPE"));
		return "/equipment/standard/list";
	}

	@ApiOperation(value = "进入标准表编辑界面", notes = "进入标准表编辑界面")
	@GetMapping(value = "/jupdate/{id}")
	public String toUpdate(@PathVariable("id") String id, Model model) {
		if (StringUtils.isBlank(id)) {
			return "redirect:/back/standard/";
		}

		EquipmentStandardBO standardBo = standardService.getDataById(id);
		if (standardBo == null) {
			return "redirect:/back/standard/";
		}

		EquipmentStandard standard = standardBo.getStandard();
		EquipmentStandardDTO standardDto = parseStandard(standard);
		List<EquipmentStandardTechDTO> techDtos = parseTechs(standardBo.getTechs());
		List<EquipmentStandardItemDTO> itemDtos = parseItems(standardBo.getItems());
		standardDto.setItems(itemDtos);
		standardDto.setTechs(techDtos);

		List<String> txts = FileUtils.readFileTxt(new File(standard.getTxtUrl()));
		model.addAttribute("types", dictService.getSub("STANDARD_TYPE"));
		model.addAttribute("standard", standardDto);
		model.addAttribute("txts", txts);
		return "/equipment/standard/update";
	}

	@ApiOperation(value = "进入标准表编辑界面", notes = "进入标准表编辑界面")
	@GetMapping(value = "/detail/{id}")
	public String detail(@PathVariable("id") String id, Model model) {
		EquipmentStandardBO standardBo = standardService.getDataById(id);
		if (standardBo == null) {
			return "redirect:/back/standard/";
		}

		EquipmentStandard standard = standardBo.getStandard();
		EquipmentStandardDTO standardDto = parseStandard(standard);
		List<EquipmentStandardTechDTO> techDtos = parseTechs(standardBo.getTechs());
		List<EquipmentStandardItemDTO> itemDtos = parseItems(standardBo.getItems());
		standardDto.setItems(itemDtos);
		standardDto.setTechs(techDtos);
		model.addAttribute("standard", standardDto);
		return "/equipment/standard/detail";
	}

	private List<EquipmentStandardTechDTO> parseTechs(List<EquipmentStandardTech> techs) {
		List<EquipmentStandardTechDTO> techDtos = new ArrayList<>();
		if (techs == null || techs.isEmpty()) {
			return techDtos;
		}

		Map<String, List<EquipmentStandardTechSubDTO>> map = new HashMap<>();
		for (EquipmentStandardTech tech : techs) {
			List<EquipmentStandardTechSubDTO> subs = null;
			if (map.containsKey(tech.getName())) {
				subs = map.get(tech.getName());
			} else {
				subs = new ArrayList<>();
			}

			EquipmentStandardTechSubDTO sub = new EquipmentStandardTechSubDTO();
			sub.setProject(tech.getProject());
			sub.setRequire(tech.getRequire());
			sub.setFunction(tech.getFunction());
			subs.add(sub);
			map.put(tech.getName(), subs);
		}

		for (String techName : map.keySet()) {
			EquipmentStandardTechDTO techDto = new EquipmentStandardTechDTO();
			techDto.setName(techName);
			techDto.setSubs(map.get(techName));
			techDtos.add(techDto);
		}

		return techDtos;
	}

	@ApiOperation(value = "进入标准表导入界面", notes = "进入标准表导入界面")
	@GetMapping(value = "/import")
	public String toImport(Model model) {
		model.addAttribute("types", dictService.getSub("STANDARD_TYPE"));
		return "/equipment/standard/import";
	}

	@ApiOperation(value = "下载标准", notes = "下载标准")
	@GetMapping(value = "/download")
	public void download(HttpServletResponse response, String pdfUrl, String name) {
		if (StringUtils.isBlank(pdfUrl)) {
			return;
		}

		if (pdfUrl.contains("|")) {
			pdfUrl = pdfUrl.replace("|", File.separator);
		}

		FileUtils.downLoadFile(response, pdfUrl, name, false);
	}

	@ApiOperation(value = "导入标准", notes = "导入标准")
	@PostMapping(value = "/import")
	@ResponseBody
	public ReturnDTO importPDF(EquipmentStandard standard, Model model) {
		if (standard == null || StringUtils.isBlank(standard.getPdfUrl()) || !standard.getPdfUrl().endsWith(".pdf")) {
			return ReturnDTOUtil.fail();
		}

		logger.debug("PDF转换开始");
		long start = System.currentTimeMillis();

		Map<String, Object> map = new HashMap<>();

		// pdf 转 txt
		String pdfPath = standard.getPdfUrl();
		String txtPath = PDFUtil.pdf2Txt(pdfPath);

		// 读取txt的内容，返回页面
		List<String> txts = FileUtils.readFileTxt(new File(txtPath));
		logger.debug("pdf 转 txt 完成");

		// pdf转图片
		List<String> imgs = PDFUtil.pdf2Img(pdfPath);
		logger.debug("pdf 转 图片 完成");

		long end = System.currentTimeMillis();

		logger.debug("转换完成，共用时：" + (end - start));
		map.put("txtPath", txtPath);
		map.put("txts", txts);
		map.put("imgs", imgs);
		return ReturnDTOUtil.success(map);
	}

	@ApiOperation(value = "获取标准表列表数据", notes = "获取标准表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentStandard> list(@RequestBody DataTable<EquipmentStandard> dt) {
		return standardService.pageSearch(dt);
	}
	
	@ApiOperation(value = "添加标准表", notes = "添加标准表")
	@PostMapping(value = "/")
	@ResponseBody
	public ReturnDTO save(String data) {
		EquipmentStandardDTO standardData = parseData(data);
		if (standardData == null) {
			return ReturnDTOUtil.fail();
		}

		// 解析标准信息
		EquipmentStandard standard = parseStandard(standardData);

		// 解析分类并保存数据
		EquipmentStandardCategory category = parseCategory(standardData);

		// 保存标准信息
		standard.setCategoryId(category.getId());
		standard.setCategoryPath(category.getPath());
		standardService.insert(standard);
		return ReturnDTOUtil.success(standard.getId());
	}

	@ApiOperation(value = "添加标准表", notes = "添加标准表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(String data) {
		EquipmentStandardDTO standardData = parseData(data);
		if (standardData == null) {
			return ReturnDTOUtil.fail();
		}

		// 解析标准信息
		EquipmentStandard standard = parseStandard(standardData);

		// 解析分类并保存数据
		EquipmentStandardCategory category = parseCategory(standardData);

		// 保存标准信息
		standard.setCategoryId(category.getId());
		standard.setCategoryPath(category.getPath());
		standardService.insert(standard);

		// 解析技术要求
		List<EquipmentStandardTech> techs = parseTechs(standard, standardData);
		if (!techs.isEmpty()) {
			techService.insertBatch(techs);
		}

		// 解析检验项，以及检验项的耗材、设备
		Map<String, List<EquipmentShopProduct>> itemMap = parseItems(standardData);
		List<EquipmentStandardItem> items = getItems(standard, itemMap);
		if (items.isEmpty()) {
			return ReturnDTOUtil.success();
		}
		itemService.insertBatch(items);

		// 所有产品
		List<EquipmentShopProduct> products = new ArrayList<>();
		for (List<EquipmentShopProduct> list : itemMap.values()) {
			products.addAll(list);
		}

		if (products.isEmpty()) {
			return ReturnDTOUtil.success();
		}
		products = productService.insert(products);
		itemService.saveItemProducts(items, products, itemMap);

		// 增加关联信息的备注后清空产品的备注
		for (EquipmentShopProduct product : products) {
			product.setRemark("");
		}

		productService.updateBatchById(products);
		return ReturnDTOUtil.success();
	}

	private List<EquipmentStandardTech> parseTechs(EquipmentStandard standard, EquipmentStandardDTO standardData) {
		if (standardData.getTechs() == null || standardData.getTechs().isEmpty()) {
			return (new ArrayList<>());
		}

		List<EquipmentStandardTech> techs = new ArrayList<>();
		for (EquipmentStandardTechDTO techData : standardData.getTechs()) {
			for (EquipmentStandardTechSubDTO subData : techData.getSubs()) {
				EquipmentStandardTech tech = new EquipmentStandardTech();
				tech.setName(techData.getName().trim());
				tech.setStandardId(standard.getId());
				tech.setProject(subData.getProject().trim());
				tech.setRequire(subData.getRequire().trim());
				tech.setFunction(subData.getFunction().trim());
				techs.add(tech);
			}
		}

		return techs;
	}

	private EquipmentStandardDTO parseData(String data) {
		EquipmentStandardDTO dto = JsonUtil.toBean(data, EquipmentStandardDTO.class);
		return dto;
	}

	@ApiOperation(value = "更新标准文字", notes = "更新标准文字")
	@PutMapping(value = "/update/txt")
	@ResponseBody
	public ReturnDTO updateTxt(@RequestParam("txtUrl") String txtUrl, @RequestParam("imgsPath") String imgsPath,
			@RequestParam("pageSize") String pageSize) {
		if (StringUtils.isBlank(txtUrl) || StringUtils.isBlank(imgsPath) || StringUtils.isBlank(pageSize)) {
			return ReturnDTOUtil.fail();
		}

		int size = Integer.parseInt(pageSize);

		// 按页数循环读取图片，调用OCR接口转换文字
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(ImageUtils.image2Str(imgsPath + i + ".jpg"));
		}

		// 重新写进该标准的文字文件
		PDFUtil.writeContent2Txt(sb.toString(), txtUrl);

		// 返回文字列表给页面
		List<String> txts = FileUtils.readFileTxt(new File(txtUrl));
		return ReturnDTOUtil.success(txts);
	}

	@SuppressWarnings("unchecked")
	@ApiOperation(value = "编辑标准表", notes = "编辑标准表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(String data) {
		EquipmentStandardDTO standardData = parseData(data);
		if (standardData == null || StringUtils.isBlank(standardData.getId())) {
			return ReturnDTOUtil.fail();
		}

		// 解析标准信息 保存标准信息
		EquipmentStandard standard = parseStandard(standardData);
		if (standard == null) {
			return ReturnDTOUtil.fail();
		}
		EquipmentStandardCategory category = parseCategory(standardData);
		standard.setCategoryId(category.getId());
		standard.setCategoryPath(category.getPath());
		standardService.updateAllColumnById(standard);

		// 删除检验项、以及检验项与商品的关联
		standardService.deleteItemsById(standard.getId());
		// 删除技术要求
		techService.delete(Condition.create().eq("standard_id", standard.getId()));

		// 解析技术要求
		List<EquipmentStandardTech> techs = parseTechs(standard, standardData);
		if (!techs.isEmpty()) {
			techService.insertBatch(techs);
		}

		// 解析检验项，以及检验项的耗材、设备
		Map<String, List<EquipmentShopProduct>> itemMap = parseItems(standardData);
		List<EquipmentStandardItem> items = getItems(standard, itemMap);
		if (items.isEmpty()) {
			return ReturnDTOUtil.success();
		}

		itemService.insertBatch(items);

		// 所有产品
		List<EquipmentShopProduct> products = new ArrayList<>();
		for (List<EquipmentShopProduct> list : itemMap.values()) {
			products.addAll(list);
		}

		if (products.isEmpty()) {
			return ReturnDTOUtil.success();
		}

		products = productService.insert(products);
		itemService.saveItemProducts(items, products, itemMap);

		// 增加关联信息的备注后清空产品的备注
		for (EquipmentShopProduct product : products) {
			product.setRemark("");
		}

		productService.updateBatchById(products);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除标准表")
	@ApiOperation(value = "批量删除标准表", notes = "批量删除标准表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		List<EquipmentStandard> standards = standardService.selectBatchIds(ids);
		for (EquipmentStandard standard : standards) {
			standard.setDelFlag("N");
		}

		boolean success = standardService.updateBatchById(standards);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}

	@ApiOperation(value = "校验标准是否存在", notes = "校验标准是否存在")
	@GetMapping(value = "/check")
	@ResponseBody
	public ReturnDTO check(String number) {
		if (StringUtils.isBlank(number)) {
			return ReturnDTOUtil.paramError();
		}

		EntityWrapper<EquipmentStandard> ew = new EntityWrapper<>();
		ew.setEntity(new EquipmentStandard());
		ew.where("number={0}", number);
		if (standardService.selectCount(ew) > 0) {
			return ReturnDTOUtil.custom(201, "该标准已存在，请核实！");
		}

		return ReturnDTOUtil.success();
	}

	private List<EquipmentStandardItem> getItems(EquipmentStandard standard,
			Map<String, List<EquipmentShopProduct>> itemMap) {
		List<EquipmentStandardItem> items = new ArrayList<>();
		for (String name : itemMap.keySet()) {
			EquipmentStandardItem item = new EquipmentStandardItem();
			item.setName(name);
			item.setStandardId(standard.getId());
			items.add(item);
		}

		return items;
	}

	private Map<String, List<EquipmentShopProduct>> parseItems(EquipmentStandardDTO standardData) {
		Map<String, List<EquipmentShopProduct>> itemMap = new HashMap<>();
		for (EquipmentStandardItemDTO item : standardData.getItems()) {
			List<EquipmentShopProduct> products = new ArrayList<>();
			for (EquipmentStandardProductDTO sub : item.getMaterials()) {
				EquipmentShopProduct product = new EquipmentShopProduct();
				product.setBrandsId(0L);
				product.setCategoryId(0L);
				product.setName(sub.getName().trim());
				product.setType(sub.getType().trim());
				product.setRemark(sub.getRemark().trim());
				products.add(product);
			}

			for (EquipmentStandardProductDTO sub : item.getEquipments()) {
				EquipmentShopProduct product = new EquipmentShopProduct();
				product.setBrandsId(0L);
				product.setCategoryId(0L);
				product.setName(sub.getName().trim());
				product.setType(sub.getType().trim());
				product.setRemark(sub.getRemark().trim());
				products.add(product);
			}

			itemMap.put(item.getName().trim(), products);
		}

		return itemMap;
	}

	private EquipmentStandardCategory parseCategory(EquipmentStandardDTO standardData) {
		EquipmentStandardCategory category = new EquipmentStandardCategory();
		category.setParentId(0L);
		category.setName(standardData.getCategory());
		category = categoryService.insertSingle(category);
		if (StringUtils.isNoneBlank(standardData.getType())) {
			EquipmentStandardCategory secondCategory = new EquipmentStandardCategory();
			secondCategory.setParentId(category.getId());
			secondCategory.setName(standardData.getType());
			category = categoryService.insertSingle(secondCategory);
		}

		return category;
	}

	private EquipmentStandard parseStandard(EquipmentStandardDTO standardData) {
		EquipmentStandard standard = new EquipmentStandard();
		if (StringUtils.isNotBlank(standardData.getId())) {
			standard = standardService.selectById(standardData.getId());
			if (standard == null || standard.getId() == null) {
				return null;
			}
		}
		standard.setEnglishName(standardData.getEnglishName().trim());
		standard.setReplaceStandard(standardData.getReplaceStandard().trim());
		standard.setImportStandard(standardData.getImportStandard().trim());
		standard.setName(standardData.getName().trim());
		standard.setNumber(standardData.getNumber().trim());
		standard.setCategoryName(standardData.getCategory().trim());
		standard.setTypeName(standardData.getType().trim());
		standard.setPdfUrl(standardData.getPdfUrl().trim());
		standard.setTxtUrl(standardData.getTxtUrl().trim());
		standard.setPageSize(standardData.getPageSize().trim());
		standard.setImgsPath(standardData.getImgsPath().trim());
		standard.setPublishDate(standardData.getPublishDate());
		standard.setUploadDate(standardData.getUploadDate());
		standard.setImplementDate(standardData.getImplementDate());
		return standard;
	}

	private EquipmentStandardDTO parseStandard(EquipmentStandard standardData) {
		EquipmentStandardDTO standard = new EquipmentStandardDTO();
		standard.setId(standardData.getId().toString());
		standard.setName(standardData.getName());
		standard.setEnglishName(standardData.getEnglishName());
		standard.setCategory(standardData.getCategoryName());
		standard.setType(standardData.getTypeName());
		standard.setNumber(standardData.getNumber());
		standard.setReplaceStandard(standardData.getReplaceStandard());
		standard.setImportStandard(standardData.getImportStandard());
		standard.setPdfUrl(standardData.getPdfUrl());
		standard.setTxtUrl(standardData.getTxtUrl());
		standard.setImgsPath(standardData.getImgsPath());
		standard.setPageSize(standardData.getPageSize());
		standard.setPublishDate(standardData.getPublishDate());
		standard.setUploadDate(standardData.getUploadDate());
		standard.setImplementDate(standardData.getImplementDate());
		return standard;
	}

	private List<EquipmentStandardItemDTO> parseItems(List<EquipmentStandardItemBO> itemBos) {
		List<EquipmentStandardItemDTO> itemDtos = new ArrayList<>();
		for (EquipmentStandardItemBO itemBo : itemBos) {
			EquipmentStandardItem item = itemBo.getItem();
			EquipmentStandardItemDTO itemDto = new EquipmentStandardItemDTO();
			itemDto.setName(item.getName());
			List<EquipmentStandardProductDTO> materials = new ArrayList<>();
			List<EquipmentStandardProductDTO> equipments = new ArrayList<>();
			for (EquipmentShopProduct sub : itemBo.getProducts()) {
				EquipmentStandardProductDTO subDto = new EquipmentStandardProductDTO();
				subDto.setName(sub.getName());
				subDto.setType(sub.getType());
				subDto.setRemark(sub.getRemark());
				if (sub.getType().equals("M")) {
					materials.add(subDto);
				} else if (sub.getType().equals("E")) {
					equipments.add(subDto);
				}
			}

			itemDto.setMaterials(materials);
			itemDto.setEquipments(equipments);
			itemDtos.add(itemDto);
		}

		return itemDtos;
	}
}
