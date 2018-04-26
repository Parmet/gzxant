package com.gzxant.controller.shop.category;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.shop.category.ShopCategory;
import com.gzxant.service.shop.category.IShopCategoryService;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
 * @author xiaoyc
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/category")
public class ShopCategoryController extends BaseController {
	@Autowired
	private IShopCategoryService shopCategoryService;

	@ApiOperation(value = "进入商城-分类表列表界面", notes = "进入商城-分类表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/category/list";
	}

	@ApiOperation(value = "进入商城-分类表详情界面", notes = "进入商城-分类表详情界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action, 
			@PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/shop/category/list";
		}
		
		ShopCategory category = null;
		if (StringUtils.isNumeric(id)) {
			category = shopCategoryService.selectById(id);
		}
		
		model.addAttribute("category", category);
		model.addAttribute("action", action);
		return "/shop/category/detail";
	}

	@ApiOperation(value = "获取商城-分类表列表数据", notes = "获取商城-分类表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopCategory> list(@RequestBody DataTable<ShopCategory> dt) {
		if (dt == null 
			|| dt.getPageNumber() < 0 
			|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		
		return shopCategoryService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城-分类表", notes = "添加商城-分类表")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(ShopCategory param) {
		if (param == null
			|| param.getParentId() == null || param.getParentId().intValue() < 0
			|| StringUtils.isBlank(param.getName())) {
			return ReturnDTOUtil.paramError();
		}
		
		shopCategoryService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城-分类表", notes = "编辑商城-分类表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopCategory param) {
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		
		shopCategoryService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除商城-分类表")
	@ApiOperation(value = "批量删除商城-分类表", notes = "批量删除商城-分类表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		
		boolean success = shopCategoryService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		
		return ReturnDTOUtil.fail();
	}
}
