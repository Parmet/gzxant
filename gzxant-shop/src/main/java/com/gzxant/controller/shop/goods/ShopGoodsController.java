package com.gzxant.controller.shop.goods;

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
import com.gzxant.service.shop.goods.IShopGoodsService;
import com.gzxant.entity.shop.goods.ShopGoods;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 商城商品表 前端控制器
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-20
 */
@Controller
@RequestMapping("/shop/goods")
public class ShopGoodsController extends BaseController {
	@Autowired
	private IShopGoodsService shopGoodsService;

	@ApiOperation(value = "进入商城商品表列表界面", notes = "进入商城商品表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/goods/list";
	}

	@ApiOperation(value = "进入商城商品表编辑界面", notes = "进入商城商品表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/shop/goods/detail";
	}

	@ApiOperation(value = "获取商城商品表列表数据", notes = "获取商城商品表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopGoods> list(@RequestBody DataTable<ShopGoods> dt) {
		return shopGoodsService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城商品表", notes = "添加商城商品表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(ShopGoods param) {
		shopGoodsService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城商品表", notes = "编辑商城商品表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopGoods param) {
		shopGoodsService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除商城商品表")
	@ApiOperation(value = "批量删除商城商品表", notes = "批量删除商城商品表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = shopGoodsService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
