package com.gzxant.controller.shop.brand;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.shop.brand.ShopBrand;
import com.gzxant.service.shop.brand.IShopBrandService;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
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
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/brand")
public class ShopBrandController extends BaseController {
	@Autowired
	private IShopBrandService shopBrandService;


	@ApiOperation(value = "进入商城-品牌表列表界面", notes = "进入商城-品牌表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/brand/list";
	}


	@ApiOperation(value = "进入商城-品牌表详情界面", notes = "进入商城-品牌表详情界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/shop/brand/list";
		}

		ShopBrand brand = null;
		if (StringUtils.isNumeric(id)) {
			brand = shopBrandService.selectById(id);
		}

		model.addAttribute("brand", brand);
		model.addAttribute("action", action);

		return "/shop/brand/detail";
	}

	@ApiOperation(value = "获取商城-品牌表列表数据", notes = "获取商城-品牌表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopBrand> list(@RequestBody DataTable<ShopBrand> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return shopBrandService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城-品牌表", notes = "添加商城-品牌表")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(ShopBrand param) {
		//非空判断
		if (param == null
				|| StringUtils.isBlank(param.getLogo())
				|| StringUtils.isBlank(param.getName())) {
			return ReturnDTOUtil.paramError();
		}
		shopBrandService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城-品牌表", notes = "编辑商城-品牌表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopBrand param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		shopBrandService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除商城-品牌表")
	@ApiOperation(value = "批量删除商城-品牌表", notes = "批量删除商城-品牌表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = shopBrandService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
