package com.gzxant.controller;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.ShopCategory;
import com.gzxant.service.IShopCategoryService;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商城-分类表 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/shop/category")
public class ShopCategoryController extends BaseController {
	@Autowired
	private IShopCategoryService shopCategoryService;

	@ApiOperation(value = "进入商城-分类表列表界面", notes = "进入商城-分类表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/category/list";
	}

	@ApiOperation(value = "进入商城-分类表编辑界面", notes = "进入商城-分类表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/shop/category/detail";
	}

	@ApiOperation(value = "获取商城-分类表列表数据", notes = "获取商城-分类表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopCategory> list(@RequestBody DataTable<ShopCategory> dt) {
		return shopCategoryService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城-分类表", notes = "添加商城-分类表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(ShopCategory param) {
		if (param == null){
			ReturnDTOUtil.fail();
		}
		shopCategoryService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城-分类表", notes = "编辑商城-分类表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopCategory param) {
		if (param == null){
			ReturnDTOUtil.fail();
		}
		shopCategoryService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除商城-分类表")
	@ApiOperation(value = "批量删除商城-分类表", notes = "批量删除商城-分类表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		//ids.add(1L);//删除测试1136366818
		boolean success = shopCategoryService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
