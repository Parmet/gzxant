package com.gzxant.controller.equipment.standard.item;

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
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;
import com.gzxant.service.equipment.standard.item.IEquipmentStandardItemService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 标准项表 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Controller
@RequestMapping("/back/standard/item")
public class EquipmentStandardItemController extends BaseController {
	@Autowired
	private IEquipmentStandardItemService equipmentStandardItemService;

	@ApiOperation(value = "进入标准项表列表界面", notes = "进入标准项表列表界面")
	@GetMapping(value = "")
	public String toList(Model model) {
		return "/equipment/standard/item/list";
	}

	@ApiOperation(value = "进入标准项表编辑界面", notes = "进入标准项表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String toDetail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/equipment/standard/item/detail";
	}

	@ApiOperation(value = "获取标准项表列表数据", notes = "获取标准项表列表数据:使用约定的DataTable")
	@GetMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentStandardItem> list(@RequestBody DataTable<EquipmentStandardItem> dt) {
		return equipmentStandardItemService.pageSearch(dt);
	}

	@ApiOperation(value = "添加标准项表", notes = "添加标准项表")
	@PostMapping(value = "/")
	@ResponseBody
	public ReturnDTO create(EquipmentStandardItem param) {
		equipmentStandardItemService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑标准项表", notes = "编辑标准项表")
	@PutMapping(value = "/")
	@ResponseBody
	public ReturnDTO update(EquipmentStandardItem param) {
		equipmentStandardItemService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除标准项表")
	@ApiOperation(value = "批量删除标准项表", notes = "批量删除标准项表")
	@DeleteMapping(value = "/")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentStandardItemService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
