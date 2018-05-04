package com.gzxant.controller.shop.category;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.vo.PCAjaxVO;
import com.gzxant.entity.shop.category.ShopCategory;
import com.gzxant.service.shop.category.IShopCategoryService;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 商城-分类表 前端控制器
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/category")
public class ShopCategoryController extends BaseController {
	@Autowired
	private IShopCategoryService shopCategoryService;

	@ApiOperation(value = "进入商城-分类表列表界面", notes = "进入商城-分类表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		model.addAttribute("categoryTrees", JSON.toJSON(shopCategoryService.getDictTree()).toString());
		return "/shop/category/list";
	}

	/**
	 * 保存数据
	 *
	 * @return
	 */
	@ApiOperation(value = "添加更新商城-分类表", notes = "添加更新商城-分类表")
	@PostMapping(value = "/insert")
	public String insert(ShopCategory category, RedirectAttributes redirectAttributes) {
		if (category == null || StringUtils.isBlank(category.getName())
			|| category.getParentId() == null || category.getParentId().intValue() < 0) {
			redirectAttributes.addFlashAttribute("message", "参数错误");
			return "redirect:/category";
		}
		
		boolean success = shopCategoryService.insertOrUpdate(category);
		if (success) {
			redirectAttributes.addFlashAttribute("message", "更新或添加数据字典成功");
		} else {
			redirectAttributes.addFlashAttribute("message", "更新或添加数据字典失败");
		}
		
		return "redirect:/category";
	}

	/**
	 * 获取资源
	 *
	 * @param id 资源ID
	 */
	@GetMapping(value = "select/{id}")
	@ResponseBody
	public Map<String, Object> selectById(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categorys", shopCategoryService.selectById(id));
		return map;
	}

	/**
	 * 删除节点已经子节点
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "delete/{id}")
	@ResponseBody
	public PCAjaxVO delete(@PathVariable("id") Long id) {
		return shopCategoryService.delete(id);
	}
}
