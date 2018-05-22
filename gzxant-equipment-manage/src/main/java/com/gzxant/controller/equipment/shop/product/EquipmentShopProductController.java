package com.gzxant.controller.equipment.shop.product;

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
import com.gzxant.service.equipment.shop.product.IEquipmentShopProductService;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 产品表 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Controller
@RequestMapping("/back/shop/product")
public class EquipmentShopProductController extends BaseController {
	@Autowired
	private IEquipmentShopProductService equipmentShopProductService;

	@ApiOperation(value = "进入产品表列表界面", notes = "进入产品表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/equipment/shop/product/list";
	}

	@ApiOperation(value = "进入产品表编辑界面", notes = "进入产品表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/equipment/shop/product/detail";
	}

	@ApiOperation(value = "获取产品表列表数据", notes = "获取产品表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentShopProduct> list(@RequestBody DataTable<EquipmentShopProduct> dt) {
		return equipmentShopProductService.pageSearch(dt);
	}

	@ApiOperation(value = "添加产品表", notes = "添加产品表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(EquipmentShopProduct param) {
		equipmentShopProductService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑产品表", notes = "编辑产品表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentShopProduct param) {
		equipmentShopProductService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除产品表")
	@ApiOperation(value = "批量删除产品表", notes = "批量删除产品表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentShopProductService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
