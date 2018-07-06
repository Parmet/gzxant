package com.gzxant.controller.equipment.standard.item.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.equipment.standard.item.product.EquipmentStandardItemProduct;
import com.gzxant.service.equipment.standard.item.product.IEquipmentStandardItemProductService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 检验项产品关联表 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-31
 */
@Controller
@RequestMapping("/equipment/standard/item/product")
public class EquipmentStandardItemProductController extends BaseController {
	@Autowired
	private IEquipmentStandardItemProductService equipmentStandardItemProductService;

	@ApiOperation(value = "进入检验项产品关联表列表界面", notes = "进入检验项产品关联表列表界面")
	@GetMapping(value = "")
	public String toList(Model model) {
		return "/equipment/standard/item/product/list";
	}

	@ApiOperation(value = "进入检验项产品关联表编辑界面", notes = "进入检验项产品关联表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String toDetail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/equipment/standard/item/product/detail";
	}

	@ApiOperation(value = "获取检验项产品关联表列表数据", notes = "获取检验项产品关联表列表数据:使用约定的DataTable")
	@GetMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentStandardItemProduct> list(@RequestBody DataTable<EquipmentStandardItemProduct> dt) {
		return equipmentStandardItemProductService.pageSearch(dt);
	}

	@ApiOperation(value = "添加检验项产品关联表", notes = "添加检验项产品关联表")
	@PostMapping(value = "/")
	@ResponseBody
	public ReturnDTO create(EquipmentStandardItemProduct param) {
		equipmentStandardItemProductService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑检验项产品关联表", notes = "编辑检验项产品关联表")
	@PutMapping(value = "/")
	@ResponseBody
	public ReturnDTO update(EquipmentStandardItemProduct param) {
		equipmentStandardItemProductService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除检验项产品关联表")
	@ApiOperation(value = "批量删除检验项产品关联表", notes = "批量删除检验项产品关联表")
	@DeleteMapping(value = "/")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentStandardItemProductService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
