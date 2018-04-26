package com.gzxant.controller.shop.sku;

import com.alibaba.fastjson.JSON;
import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.shop.sku.ShopSku;
import com.gzxant.enums.SysMenuType;
import com.gzxant.service.shop.sku.IShopSkuService;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * sku 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/sku")
public class ShopSkuController extends BaseController {
	@Autowired
	private IShopSkuService shopSkuService;

	/**
	 * 获取sku详情
	 *
	 * @param id 菜单ID
	 */
	@GetMapping(value = "select/{id}")
	@ResponseBody
	public Map selectById(@PathVariable Long id){
		Map map = new HashMap();
		map.put("menu", shopSkuService.selectById(id));
		return map;
	}


	@RequiresPermissions("shop:sku:list")
	@GetMapping(value = "")
	public String list1(Model model){
		model.addAttribute("menuTree", JSON.toJSONString(shopSkuService.getMenuTree()));
		model.addAttribute("menuTypes", SysMenuType.values());
		return "/shop/sku/list";
	}






	//================================
	@ApiOperation(value = "进入sku列表界面", notes = "进入sku列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/sku/list";
	}

	@ApiOperation(value = "进入sku编辑界面", notes = "进入sku编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/shop/sku/detail";
	}

	@ApiOperation(value = "获取sku列表数据", notes = "获取sku列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopSku> list(@RequestBody DataTable<ShopSku> dt) {
		return shopSkuService.pageSearch(dt);
	}

	@ApiOperation(value = "添加sku", notes = "添加sku")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(ShopSku param) {
		shopSkuService.insert(param);
		return ReturnDTOUtil.success();
	}


	@ApiOperation(value = "编辑sku", notes = "编辑sku")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopSku param) {
		shopSkuService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除sku")
	@ApiOperation(value = "批量删除sku", notes = "批量删除sku")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = shopSkuService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
