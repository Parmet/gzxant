package com.gzxant.controller.standard.category;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.standard.category.StandardCategory;
import com.gzxant.service.standard.category.IStandardCategoryService;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 *  分类
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/standard/category")
public class StandardCategoryController extends BaseController {
	@Autowired
	private IStandardCategoryService standardCategoryService;

	@ApiOperation(value = "进入分类列表界面", notes = "进入列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/standard/category/list";
	}

	@ApiOperation(value = "进入分类编辑界面", notes = "进入分类编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/standard/category/detail";
	}

	@ApiOperation(value = "获取分类列表数据", notes = "获取分类列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<StandardCategory> list(@RequestBody DataTable<StandardCategory> dt) {
		return standardCategoryService.pageSearch(dt);
	}

	@ApiOperation(value = "添加分类", notes = "添加分类")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(StandardCategory param) {
		if (param == null){
			ReturnDTOUtil.fail();
		}else {
			standardCategoryService.insert(param);
		}
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑分类", notes = "编辑分类")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(StandardCategory param) {
		if (param == null){
			ReturnDTOUtil.fail();
		}else {
			standardCategoryService.updateById(param);
		}
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "查询分类", notes = "查询分类")
	@PostMapping(value = "/getByPage")
	@ResponseBody
	public ReturnDTO getByPage(StandardCategory param) {
		standardCategoryService.getByPage(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "查询分类", notes = "查询分类")
	@PostMapping(value = "/getSubCategory")
	@ResponseBody
	public ReturnDTO getSubCategory(StandardCategory param) {
		standardCategoryService.getSubCategory(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除分类")
	@ApiOperation(value = "批量删除分类", notes = "批量删除分类")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = standardCategoryService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}



}
