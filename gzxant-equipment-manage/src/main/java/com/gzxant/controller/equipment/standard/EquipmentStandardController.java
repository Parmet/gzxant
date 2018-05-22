package com.gzxant.controller.equipment.standard;

import java.util.List;

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
import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.service.equipment.standard.IEquipmentStandardService;
import com.gzxant.service.equipment.standard.category.IEquipmentStandardCategoryService;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;
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
	
	@ApiOperation(value = "进入标准表列表界面", notes = "进入标准表列表界面")
	@GetMapping(value = "")
	public String toList(Model model) {
		model.addAttribute("categoryTrees", JSON.toJSONString(categoryService.getDictTree()));
		return "/equipment/standard/list";
	}

	@ApiOperation(value = "进入标准表编辑界面", notes = "进入标准表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/equipment/standard/detail";
	}
	
	@ApiOperation(value = "进入标准表导入界面", notes = "进入标准表导入界面")
	@GetMapping(value = "/import")
	public String toImport(Model model) {
		return "/equipment/standard/import";
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
		
		String path = standard.getPdfUrl();
		path = PathUtils.getRootPath() + path;
		String txtPath = PDFUtil.pdf2Txt(path);
		
		standard.setName("");
		standard.setTxtUrl(txtPath);
		standardService.insertOrUpdate(standard);
		
		return ReturnDTOUtil.success();
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
	public ReturnDTO create(EquipmentStandard param) {
		standardService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑标准表", notes = "编辑标准表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentStandard param) {
		standardService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除标准表")
	@ApiOperation(value = "批量删除标准表", notes = "批量删除标准表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = standardService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
