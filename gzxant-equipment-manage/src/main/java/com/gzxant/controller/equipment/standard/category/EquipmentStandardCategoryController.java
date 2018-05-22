package com.gzxant.controller.equipment.standard.category;

import java.util.List;

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

import com.gzxant.annotation.SLog;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.equipment.standard.category.IEquipmentStandardCategoryService;
import com.gzxant.entity.equipment.standard.category.EquipmentStandardCategory;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 标准分类表 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Controller
@RequestMapping("/back/standard/category")
public class EquipmentStandardCategoryController extends BaseController {
	@Autowired
	private IEquipmentStandardCategoryService equipmentStandardCategoryService;

	@ApiOperation(value = "进入标准分类表列表界面", notes = "进入标准分类表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/equipment/standard/category/list";
	}

	@ApiOperation(value = "进入标准分类表编辑界面", notes = "进入标准分类表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/equipment/standard/category/detail";
	}

	@ApiOperation(value = "获取标准分类表列表数据", notes = "获取标准分类表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentStandardCategory> list(@RequestBody DataTable<EquipmentStandardCategory> dt) {
		return equipmentStandardCategoryService.pageSearch(dt);
	}

	@ApiOperation(value = "添加标准分类表", notes = "添加标准分类表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(EquipmentStandardCategory param) {
		equipmentStandardCategoryService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑标准分类表", notes = "编辑标准分类表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentStandardCategory param) {
		equipmentStandardCategoryService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除标准分类表")
	@ApiOperation(value = "批量删除标准分类表", notes = "批量删除标准分类表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentStandardCategoryService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
