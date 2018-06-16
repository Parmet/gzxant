package com.gzxant.controller.equipment.food.article;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.equipment.standard.category.IEquipmentStandardCategoryService;
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
import com.gzxant.service.equipment.food.article.IEquipmentFoodArticleService;
import com.gzxant.entity.equipment.food.article.EquipmentFoodArticle;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 抽检食品文章表 前端控制器
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-13
 */
@Controller
@RequestMapping("/sampling")
public class EquipmentFoodArticleController extends BaseController {
	@Autowired
	private IEquipmentFoodArticleService equipmentFoodArticleService;
	@Autowired
	private ISysDictService dictService;

	@ApiOperation(value = "进入抽检食品文章表列表界面", notes = "进入抽检食品文章表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		//logger.info("======================================"+JSON.toJSONString(dictService.getDictTrees("SAMPLING_TYPE")));
		model.addAttribute("samplingTypes", dictService.getDictTree("SAMPLING_TYPE"));
		model.addAttribute("foodType", dictService.getDictTree("FOOD_TYPE"));
		return "/equipment/article/list";
	}

	@ApiOperation(value = "进入抽检食品文章表编辑界面", notes = "进入抽检食品文章表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/equipment/article/detail";
	}

	@ApiOperation(value = "获取抽检食品文章表列表数据", notes = "获取抽检食品文章表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentFoodArticle> list(@RequestBody DataTable<EquipmentFoodArticle> dt) {
		return equipmentFoodArticleService.pageSearch(dt);
	}

	@ApiOperation(value = "添加抽检食品文章表", notes = "添加抽检食品文章表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(EquipmentFoodArticle param) {
		equipmentFoodArticleService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑抽检食品文章表", notes = "编辑抽检食品文章表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentFoodArticle param) {
		equipmentFoodArticleService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除抽检食品文章表")
	@ApiOperation(value = "批量删除抽检食品文章表", notes = "批量删除抽检食品文章表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentFoodArticleService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
