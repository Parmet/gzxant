package com.gzxant.controller.equipment.standard;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.entity.equipment.standard.category.EquipmentStandardCategory;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;
import com.gzxant.entity.equipment.standard.item.product.EquipmentStandardItemProduct;
import com.gzxant.service.equipment.shop.product.IEquipmentShopProductService;
import com.gzxant.service.equipment.standard.IEquipmentStandardService;
import com.gzxant.service.equipment.standard.category.IEquipmentStandardCategoryService;
import com.gzxant.service.equipment.standard.item.IEquipmentStandardItemService;
import com.gzxant.service.equipment.standard.item.product.IEquipmentStandardItemProductService;
import com.gzxant.util.FileUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.data.JsonUtil;
import com.gzxant.util.pdf.PDFUtil;
import com.gzxant.vo.equipment.standard.EquipmentStandardVO;

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
	private IEquipmentStandardItemService itemService;
	@Autowired
	private IEquipmentStandardItemProductService itemProductService;
	@Autowired
	private IEquipmentShopProductService productService;
	
	@ApiOperation(value = "进入标准表列表界面", notes = "进入标准表列表界面")
	@GetMapping(value = "")
	public String toList(Model model) {
		model.addAttribute("categoryTrees", JSON.toJSONString(categoryService.getDictTree()));
		return "/equipment/standard/list";
	}

	@ApiOperation(value = "进入标准表编辑界面", notes = "进入标准表编辑界面")
	@GetMapping(value = "/detail/{id}")
	public String detail(@PathVariable("id") String id, Model model) {
		EquipmentStandard standard = standardService.selectById(id);
		if (standard == null || standard.getId() == null) {
			return "404";
		}
		
		if (StringUtils.isNotBlank(standard.getPdfUrl())) {
			standard.setPdfUrl(standard.getPdfUrl().replace(File.separator, "|"));
		}
		
		EntityWrapper<EquipmentStandardItem> itemEw = new EntityWrapper<>();
		itemEw.setEntity(new EquipmentStandardItem());
		itemEw.where("stand_id={0}", id);
		List<EquipmentStandardItem> items = itemService.selectList(itemEw);
		Map<String, String> itemProductMap = new HashMap<>();
		for (EquipmentStandardItem item : items) {
			EntityWrapper<EquipmentStandardItemProduct> itemProductEw = new EntityWrapper<>();
			itemProductEw.setEntity(new EquipmentStandardItemProduct());
			itemProductEw.where("item_id={0}", item.getId());
			List<EquipmentStandardItemProduct> itemProducts = itemProductService.selectList(itemProductEw);
			
			List<Long> productIds = new ArrayList<>();
			for (EquipmentStandardItemProduct itemProduct : itemProducts) {
				productIds.add(itemProduct.getProductId());
			}
			
			List<EquipmentShopProduct> products = productService.selectBatchIds(productIds);
			String productNames = "";
			String eProductNames = "";
			String mProductNames = "";
			for (EquipmentShopProduct product : products) {
				if (product.getType().equals("E")) {
					eProductNames = eProductNames + product.getName() + ",";
				} else if (product.getType().equals("M")) {
					mProductNames = mProductNames + product.getName() + ",";
				}
			}
			
			if (StringUtils.isNotBlank(mProductNames)) {
				mProductNames = mProductNames.substring(0, mProductNames.length() - 1);
			}
			
			if (StringUtils.isNotBlank(eProductNames)) {
				eProductNames.substring(0, eProductNames.length() - 1);
			}
			
			productNames = mProductNames + "|" + eProductNames;
			
			itemProductMap.put(item.getName(), productNames);
		}
		
		model.addAttribute("standard", standard);
		model.addAttribute("items", itemProductMap);
		return "/equipment/standard/detail";
	}
	
	@ApiOperation(value = "进入标准表导入界面", notes = "进入标准表导入界面")
	@GetMapping(value = "/import")
	public String toImport(Model model) {
		return "/equipment/standard/import";
	}
	
	@ApiOperation(value = "下载标准", notes = "下载标准")
	@GetMapping(value = "/download")
	public void download(HttpServletResponse response, String pdfUrl, String name) {
		if (StringUtils.isBlank(pdfUrl)) {
			return ;
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
		if (standard == null
			|| StringUtils.isBlank(standard.getPdfUrl()) 
			|| !standard.getPdfUrl().endsWith(".pdf")) {
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
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(String data) {
		if (StringUtils.isBlank(data)) {
			return ReturnDTOUtil.fail();
		}
		
		Map map = JsonUtil.stringToCollect(data);
		// 解析标准信息
		EquipmentStandard standard = parseStandard(map);
		
		// 解析分类并保存数据
		EquipmentStandardCategory category = parseCategory(standard);
		
		// 保存标准信息
		String name = standard.getFirstCategory();
		if (StringUtils.isNotBlank(standard.getSecondCategory())) {
			name = name + " " + standard.getSecondCategory(); 
		} 
		
		name = name + " " + standard.getName();
		standard.setName(name);
		standard.setCategoryId(category.getId());
		standard.setCategoryPath(category.getPath());
		standardService.insert(standard);
		
		// 解析检验项，以及检验项的耗材、设备
		Map<String, List<EquipmentShopProduct>> itemMap = parseItems(map);
		List<EquipmentStandardItem> items = itemService.insert(standard, itemMap);
		List<EquipmentShopProduct> products = productService.insert(itemMap);
		itemService.saveItemProducts(items, products, itemMap);
		
		return ReturnDTOUtil.success();
	}

	private Map<String, List<EquipmentShopProduct>> parseItems(Map map) {
		Map<String, List<EquipmentShopProduct>> itemMap = new HashMap<>();
		JSONArray items = (JSONArray) map.get("item");
		for (Iterator iterator = items.iterator(); iterator.hasNext();) {
			JSONObject item = (JSONObject) iterator.next();
			List<EquipmentShopProduct> products = new ArrayList<>();
			
			JSONArray subs = (JSONArray) item.get("sub");
			for (Iterator iterator2 = subs.iterator(); iterator2.hasNext();) {
				JSONObject sub = (JSONObject) iterator2.next();
				EquipmentShopProduct product = new EquipmentShopProduct();
				product.setBrandsId(0L);
				product.setCategoryId(0L);
				product.setName(sub.getString("name").trim());
				product.setType(sub.getString("type").trim());
				products.add(product);
			}
			
			itemMap.put(item.getString("name").trim(), products);
		}
		
		return itemMap;
	}

	private EquipmentStandardCategory parseCategory(EquipmentStandard standard) {
		EquipmentStandardCategory category = new EquipmentStandardCategory();
		category.setParentId(0L);
		category.setName(standard.getFirstCategory());
		category = categoryService.insertSingle(category);
		if (StringUtils.isNoneBlank(standard.getSecondCategory())) {
			EquipmentStandardCategory secondCategory = new EquipmentStandardCategory();
			secondCategory.setParentId(category.getId());
			secondCategory.setName(standard.getSecondCategory());
			category = categoryService.insertSingle(secondCategory);
		}
		
		return category;
	}

	private EquipmentStandard parseStandard(Map map) {
		JSONObject info = (JSONObject) map.get("info");
		EquipmentStandard standard = new EquipmentStandard();
		standard.setName(info.getString("name").trim());
		standard.setFirstCategory(info.getString("firstCategory").trim());
		standard.setSecondCategory(info.getString("secondCategory").trim());
		standard.setNumber(info.getString("number").trim());
		standard.setOldStand(info.getString("oldStand").trim());
		standard.setPdfUrl(info.getString("pdfUrl").trim());
		standard.setTxtUrl(info.getString("txtUrl").trim());
		standard.setPublishDate(info.getString("publishDate").trim());
		standard.setUploadDate(info.getString("uploadDate").trim());
		standard.setImplementDate(info.getString("implementDate").trim());
		return standard;
	}

	@ApiOperation(value = "编辑标准表", notes = "编辑标准表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentStandardVO param) {
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
}
