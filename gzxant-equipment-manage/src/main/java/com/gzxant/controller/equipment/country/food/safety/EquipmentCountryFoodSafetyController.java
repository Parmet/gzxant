package com.gzxant.controller.equipment.country.food.safety;

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
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.equipment.country.food.safety.EquipmentCountryFoodSafety;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.equipment.country.food.safety.IEquipmentCountryFoodSafetyService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 国家食品安全监督抽检(合格) 前端控制器
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-16
 */
@Controller
@RequestMapping("/country_food_safety")
public class EquipmentCountryFoodSafetyController extends BaseController {
	@Autowired
	private IEquipmentCountryFoodSafetyService equipmentCountryFoodSafetyService;
	@Autowired
	private ISysDictService dictService;

	@ApiOperation(value = "进入国家食品安全监督抽检(合格)列表界面", notes = "进入国家食品安全监督抽检(合格)列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		model.addAttribute("foodType", dictService.getDictTree("FOOD_TYPE"));
		return "/equipment/sampling/country_food/list";
	}

	@ApiOperation(value = "进入国家食品安全监督抽检(合格)编辑界面", notes = "进入国家食品安全监督抽检(合格)编辑界面")
	@GetMapping(value = "/detail/{id}")
	public String detail(@PathVariable("id") String action, Model model) {
		EquipmentCountryFoodSafety equipmentCountryFoodSafety = equipmentCountryFoodSafetyService.selectById(Integer.parseInt(action));
		model.addAttribute("action", action);
		model.addAttribute("equipmentCountryFoodSafety", equipmentCountryFoodSafety);
		return "/equipment/sampling/country_food/detail";
	}
	@ApiOperation(value = "进入国家食品安全监督抽检(合格)编辑界面", notes = "进入国家食品安全监督抽检(合格)编辑界面")
	@GetMapping(value = "/{update}/{id}")
	public String update(@PathVariable("") String action,@PathVariable("id") String id, Model model) {
			EquipmentCountryFoodSafety equipmentCountryFoodSafety = equipmentCountryFoodSafetyService.selectById(Integer.parseInt(id));
			model.addAttribute("action", action);
			model.addAttribute("foodType", dictService.getDictTree("FOOD_TYPE"));
			model.addAttribute("equipmentCountryFoodSafety", equipmentCountryFoodSafety);
			return "/equipment/sampling/country_food/update";
	}
	@ApiOperation(value = "进入国家食品安全监督抽检(合格)编辑界面", notes = "进入国家食品安全监督抽检(合格)编辑界面")
	@GetMapping(value = "/insert")
	public String importDate(Model model) {
		model.addAttribute("action", "import");
		model.addAttribute("foodType", dictService.getDictTree("FOOD_TYPE"));
		return "/equipment/sampling/country_food/import";
	}

	@ApiOperation(value = "获取国家食品安全监督抽检(合格)列表数据", notes = "获取国家食品安全监督抽检(合格)列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentCountryFoodSafety> list(@RequestBody DataTable<EquipmentCountryFoodSafety> dt) {
		return equipmentCountryFoodSafetyService.pageSearch(dt);
	}

	@ApiOperation(value = "添加国家食品安全监督抽检(合格)", notes = "添加国家食品安全监督抽检(合格)")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(EquipmentCountryFoodSafety param) {
		equipmentCountryFoodSafetyService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑国家食品安全监督抽检(合格)", notes = "编辑国家食品安全监督抽检(合格)")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentCountryFoodSafety param,Model model) {
		logger.info("=============================================================");
		equipmentCountryFoodSafetyService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除国家食品安全监督抽检(合格)")
	@ApiOperation(value = "批量删除国家食品安全监督抽检(合格)", notes = "批量删除国家食品安全监督抽检(合格)")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentCountryFoodSafetyService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
