package com.gzxant.controller;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.ShopBrand;
import com.gzxant.service.IShopBrandService;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商城-品牌表 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-04-20
 */
@Controller
@RequestMapping("/shop/brand")
public class ShopBrandController extends BaseController {
	@Autowired
	private IShopBrandService shopBrandService;

	@ApiOperation(value = "进入商城-品牌表列表界面", notes = "进入商城-品牌表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/brand/list";
	}

	@ApiOperation(value = "进入商城-品牌表编辑界面", notes = "进入商城-品牌表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/shop/brand/detail";
	}

	@ApiOperation(value = "获取商城-品牌表列表数据", notes = "获取商城-品牌表列表数据:使用约定的DataTable")
	@RequestMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopBrand> list(@RequestBody DataTable<ShopBrand> dt) {

		return shopBrandService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城-品牌表", notes = "添加商城-品牌表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(ShopBrand param) {
		if (param == null){
			ReturnDTOUtil.fail();
		}
		shopBrandService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城-品牌表", notes = "编辑商城-品牌表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopBrand param) {
		if (param == null){
			ReturnDTOUtil.fail();
		}
		shopBrandService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除商城-品牌表")
	@ApiOperation(value = "批量删除商城-品牌表", notes = "批量删除商城-品牌表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = shopBrandService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
