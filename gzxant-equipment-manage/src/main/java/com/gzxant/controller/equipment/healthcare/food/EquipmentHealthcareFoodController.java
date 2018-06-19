package com.gzxant.controller.equipment.healthcare.food;

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
import com.gzxant.service.equipment.healthcare.food.IEquipmentHealthcareFoodService;
import com.gzxant.entity.equipment.healthcare.food.EquipmentHealthcareFood;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 国家保健食品安全监督抽检 前端控制器
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-16
 */
@Controller
@RequestMapping("/healthcare_food")
public class EquipmentHealthcareFoodController extends BaseController {
	@Autowired
	private IEquipmentHealthcareFoodService equipmentHealthcareFoodService;

	@ApiOperation(value = "进入国家保健食品安全监督抽检列表界面", notes = "进入国家保健食品安全监督抽检列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/equipment/sampling/healthcare_food/list";
	}

	@ApiOperation(value = "进入国家保健食品安全监督抽检编辑界面", notes = "进入国家保健食品安全监督抽检编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/equipment/healthcare/food/detail";
	}

	@ApiOperation(value = "获取国家保健食品安全监督抽检列表数据", notes = "获取国家保健食品安全监督抽检列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentHealthcareFood> list(@RequestBody DataTable<EquipmentHealthcareFood> dt) {
		return equipmentHealthcareFoodService.pageSearch(dt);
	}

	@ApiOperation(value = "添加国家保健食品安全监督抽检", notes = "添加国家保健食品安全监督抽检")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(EquipmentHealthcareFood param) {
		equipmentHealthcareFoodService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑国家保健食品安全监督抽检", notes = "编辑国家保健食品安全监督抽检")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentHealthcareFood param) {
		equipmentHealthcareFoodService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除国家保健食品安全监督抽检")
	@ApiOperation(value = "批量删除国家保健食品安全监督抽检", notes = "批量删除国家保健食品安全监督抽检")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentHealthcareFoodService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
