package com.gzxant.controller.shop.attribute;

import com.alibaba.fastjson.JSON;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.shop.attribute.ShopAttribute;
import com.gzxant.enums.SysMenuType;
import com.gzxant.service.shop.attribute.IShopAttributeService;
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
 * attribute 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/attribute")
public class ShopAttributeController extends BaseController {
	@Autowired
	private IShopAttributeService shopSkuService;

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
	@RequiresPermissions("shop:attribute:list")
	@GetMapping(value = "")
	public String list1(Model model){
		model.addAttribute("menuTree", JSON.toJSONString(shopSkuService.getMenuTree()));
		model.addAttribute("menuTypes", SysMenuType.values());
		return "/shop/attribute/list";
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
	 * @param shopAttribute
	 * @param redirectAttributes
	 *
	 * @return
	 */
	@PostMapping(value="insert")
	public String save(@Valid ShopAttribute shopAttribute, RedirectAttributes redirectAttributes){
		if (ObjectUtils.isEmpty(shopAttribute.getId())) {
			shopSkuService.add(shopAttribute);
		}else {
			shopSkuService.update(shopAttribute);
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
