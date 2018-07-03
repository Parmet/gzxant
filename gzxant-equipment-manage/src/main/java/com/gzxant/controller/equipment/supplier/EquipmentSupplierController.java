package com.gzxant.controller.equipment.supplier;

import java.util.List;

import com.gzxant.entity.SysDict;
import com.gzxant.entity.equipment.country.food.safety.EquipmentCountryFoodSafety;
import com.gzxant.service.ISysDictService;
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
import com.gzxant.service.equipment.supplier.IEquipmentSupplierService;
import com.gzxant.entity.equipment.supplier.EquipmentSupplier;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 供应商 前端控制器
 * </p>
 *
 * @author mojinsheng
 * @since 2018-07-01
 */
@Controller
@RequestMapping("/supplier")
public class EquipmentSupplierController extends BaseController {
	@Autowired
	private IEquipmentSupplierService equipmentSupplierService;
	@Autowired
	private ISysDictService dictService;


	@ApiOperation(value = "进入供应商列表界面", notes = "进入供应商列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		model.addAttribute("mainIndustry",dictService.getDictTree("Main_Industry"));
		model.addAttribute("businessScope",  dictService.getDictTree("Business_Scope"));
		model.addAttribute("yearValues",dictService.getDictTree("YEAR_VALUES"));
		return "/equipment/supplier/list";
	}

	@ApiOperation(value = "进入供应商编辑界面", notes = "进入供应商编辑界面")
	@GetMapping(value = "/{action}/{id}")
	public String detail(@PathVariable("action") String action,@PathVariable("id") String id, Model model) {
		model.addAttribute("action", action);
		EquipmentSupplier equipmentSupplier = equipmentSupplierService.selectById(id);
		model.addAttribute("equipmentSupplier", equipmentSupplier);
        model.addAttribute("businessLocation", dictService.getDictTree("Business_Location"));
		model.addAttribute("supplierAddress", dictService.getDictTree("SUPPLIER_ADDRESS"));
		model.addAttribute("natureOfBusiness", dictService.getDictTree("nature_of_business"));
		model.addAttribute("companyPosition", dictService.getDictTree("company_position"));
		model.addAttribute("yearValues", dictService.getDictTree("YEAR_VALUES"));
		model.addAttribute("mainIndustry",dictService.getDictTree("Main_Industry"));
		model.addAttribute("enterpriseScale",dictService.getDictTree("business_scale"));
		model.addAttribute("businessScope", dictService.getDictTree("Business_Scope"));
		return "/equipment/supplier/detail";
	}

	@ApiOperation(value = "获取供应商列表数据", notes = "获取供应商列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentSupplier> list(@RequestBody DataTable<EquipmentSupplier> dt) {
		return equipmentSupplierService.pageSearch(dt);
	}

	@ApiOperation(value = "添加供应商", notes = "添加供应商")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(EquipmentSupplier param) {
		if (param == null) {
			return ReturnDTOUtil.paramError();
		}
		equipmentSupplierService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "进入国家食品安全监督抽检(合格)编辑界面", notes = "进入国家食品安全监督抽检(合格)编辑界面")
	@GetMapping(value = "/insert")
	public String importDate(Model model) {
		model.addAttribute("action", "insert");
		model.addAttribute("businessLocation", dictService.getDictTree("Business_Location"));
		model.addAttribute("supplierAddress", dictService.getDictTree("SUPPLIER_ADDRESS"));
		model.addAttribute("natureOfBusiness", dictService.getDictTree("nature_of_business"));
		model.addAttribute("companyPosition", dictService.getDictTree("company_position"));
		model.addAttribute("yearValues", dictService.getDictTree("YEAR_VALUES"));
		model.addAttribute("mainIndustry",dictService.getDictTree("Main_Industry"));
		model.addAttribute("enterpriseScale",dictService.getDictTree("business_scale"));
		model.addAttribute("businessScope", dictService.getDictTree("Business_Scope"));
		return "/equipment/supplier/insert";
	}
	@ApiOperation(value = "编辑供应商", notes = "编辑供应商")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentSupplier param) {
//        TODO: BUG Couldn't correctly update the info of province
//        	    I don't know what the reason, so I couldn't help
		if (param == null) {
			return ReturnDTOUtil.paramError();
		}
		equipmentSupplierService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除供应商")
	@ApiOperation(value = "批量删除供应商", notes = "批量删除供应商")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentSupplierService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
