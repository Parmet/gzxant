package com.gzxant.controller.shop.goods.stock;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.shop.goods.stock.ShopGoodsStock;
import com.gzxant.service.shop.goods.stock.IShopGoodsStockService;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商城-订单商品表 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-02
 */
@Controller
@RequestMapping("/goods/stock")
public class ShopGoodsStockController extends BaseController {
	@Autowired
	private IShopGoodsStockService shopGoodsStockService;

	@ApiOperation(value = "进入商城-订单商品表列表界面", notes = "进入商城-订单商品表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/goods/stock/list";
	}

	@ApiOperation(value = "进入商城-订单商品表编辑界面", notes = "进入商城-订单商品表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/shop/goods/stock/detail";
	}

	@ApiOperation(value = "获取商城-订单商品表列表数据", notes = "获取商城-订单商品表列表数据:使用约定的DataTable")
	@RequestMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopGoodsStock> list(@RequestBody DataTable<ShopGoodsStock> dt) {
		return shopGoodsStockService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城-订单商品表", notes = "添加商城-订单商品表")
	@RequestMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(ShopGoodsStock param) {
		shopGoodsStockService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城-订单商品表", notes = "编辑商城-订单商品表")
	@RequestMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopGoodsStock param) {
		shopGoodsStockService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除商城-订单商品表")
	@ApiOperation(value = "批量删除商城-订单商品表", notes = "批量删除商城-订单商品表")
	@RequestMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = shopGoodsStockService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
