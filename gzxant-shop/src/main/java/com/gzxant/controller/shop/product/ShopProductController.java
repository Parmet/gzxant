package com.gzxant.controller.shop.product;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.shop.product.ShopProduct;
import com.gzxant.entity.shop.product.spu.ShopProductSpu;
import com.gzxant.service.shop.product.IShopProductService;
import com.gzxant.service.shop.product.spu.IShopProductSpuService;
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
 * 商城-产品表 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/product")
public class ShopProductController extends BaseController {
	@Autowired
	private IShopProductService shopProductService;

	//spu属性
	@Autowired
	private IShopProductSpuService shopProductSpuService;

	@ApiOperation(value = "进入商城-产品表列表界面", notes = "进入商城-产品表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/product/list";
	}


	@ApiOperation(value = "进入商城-产品表编辑界面", notes = "进入商城-产品表编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/shop/product/detail";
		}
		ShopProduct shopProduct = null;
		if (StringUtils.isNumeric(id)) {
			shopProduct = shopProductService.selectById(id);
		}
		model.addAttribute("shopProducts", shopProduct);
		model.addAttribute("action", action);
		return "/shop/product/detail";
	}

	@ApiOperation(value = "获取商城-产品表列表数据", notes = "获取商城-产品表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopProduct> list(@RequestBody DataTable<ShopProduct> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return shopProductService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城-产品表", notes = "添加商城-产品表")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(ShopProduct param) {
		//非空判断
		if (param == null
				|| StringUtils.isBlank(param.getName())) {
			return ReturnDTOUtil.paramError();
		}
		shopProductService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城-产品表", notes = "编辑商城-产品表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopProduct param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		shopProductService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除商城-产品表")
	@ApiOperation(value = "批量删除商城-产品表", notes = "批量删除商城-产品表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = shopProductService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
	//=========================
	@ApiOperation(value = "进入产品属性表列表界面", notes = "进入产品属性表列表界面")
	@GetMapping(value = "/spu")
	public String listSup(Model model) {
		return "/shop/product/spu/list";
	}



	@ApiOperation(value = "进入产品属性表编辑界面", notes = "进入产品属性表编辑界面")
	@GetMapping(value = {"/spu/{action}/{id}", "/spu/{action}"})
	public String detailSpu(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/shop/product/spu/list";
		}

		ShopProductSpu shopProductSpu = null;
		if (StringUtils.isNumeric(id)) {
			shopProductSpu = shopProductSpuService.selectById(id);
		}

		model.addAttribute("shopProductSpus", shopProductSpu);
		model.addAttribute("action", action);

		return "/shop/product/spu/detail";
	}



	@ApiOperation(value = "获取产品属性表列表数据", notes = "获取产品属性表列表数据:使用约定的DataTable")
	@PostMapping(value = "/spu/list")
	@ResponseBody
	public DataTable<ShopProductSpu> listSup(@RequestBody DataTable<ShopProductSpu> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return shopProductSpuService.pageSearch(dt);
	}

	@ApiOperation(value = "添加产品属性表", notes = "添加产品属性表")
	@PostMapping(value = "/spu/insert")
	@ResponseBody
	public ReturnDTO createSup(ShopProductSpu param) {
		//非空判断
		if (param == null
				//产品和spu不能为空
				|| StringUtils.isBlank(param.getProductId().toString())
				|| StringUtils.isBlank(param.getSpuId().toString())) {
			return ReturnDTOUtil.paramError();
		}
		shopProductSpuService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑产品属性表", notes = "编辑产品属性表")
	@PostMapping(value = "/spu/update")
	@ResponseBody
	public ReturnDTO updateSup(ShopProductSpu param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		shopProductSpuService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除产品属性表")
	@ApiOperation(value = "批量删除产品属性表", notes = "批量删除产品属性表")
	@PostMapping(value = "/spu/delete")
	@ResponseBody
	public ReturnDTO deleteSup(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = shopProductSpuService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}


}
