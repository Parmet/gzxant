package com.gzxant.controller.shop.sku;

import com.alibaba.fastjson.JSON;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.shop.sku.ShopSku;
import com.gzxant.enums.SysMenuType;
import com.gzxant.service.shop.sku.IShopSkuService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.ReturnDTOUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
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

	/**
	 * 进入系统菜单管理首页
	 */
	@RequiresPermissions("shop:sku:list")
	@GetMapping(value = "")
	public String list1(Model model){
		model.addAttribute("menuTree", JSON.toJSONString(shopSkuService.getMenuTree()));
		model.addAttribute("menuTypes", SysMenuType.values());
		return "/shop/sku/list";
	}

	/**
	 * 查询系统用户 侧边栏菜单      ,   , 	  ,
	 */
	@GetMapping(value = "/usersidemenu")
	@ResponseBody
	public ReturnDTO selectUserSideMenu() {

		return ReturnDTOUtil.success(shopSkuService.CaseMenu(GzxantSysUser.id()));
	}


	/**
	 * 保存资源信息
	 *
	 * @param shopSku
	 * @param redirectAttributes
	 *
	 * @return
	 */
	@PostMapping(value="insert")
	public String save(@Valid ShopSku shopSku, RedirectAttributes redirectAttributes){
		if (ObjectUtils.isEmpty(shopSku.getId())) {
			shopSkuService.add(shopSku);
		}else {
			shopSkuService.update(shopSku);
		}

		redirectAttributes.addFlashAttribute("message","保存菜单成功");
		return "redirect:/sys/menu";
	}


	/**
	 * 设置为不可用
	 * @param id
	 * @return
	 */
	@PostMapping(value="disable/{id}")
	@ResponseBody
	public ReturnDTO disable(@PathVariable("id") Long id){
		shopSkuService.disableMenu(id);
		return ReturnDTOUtil.success();
	}

	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="delete/{id}")
	@ResponseBody
	public ReturnDTO delete(@PathVariable("id") Long id){
		shopSkuService.deleteMenu(id);
		return ReturnDTOUtil.success();
	}

}
