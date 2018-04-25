package com.gzxant.controller.fs.standard.category;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.fs.standard.category.FsStandardCategory;
import com.gzxant.service.fs.standard.category.IFsStandardCategoryService;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商城-分类表 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/fs/standard")
public class FsStandardCategoryController extends BaseController {
	@Autowired
	private IFsStandardCategoryService fsStandardCategoryService;

	@ApiOperation(value = "进入食品药品-检测表列表界面", notes = "进入食品药品-检测表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/fs/standard/list";
	}

	@ApiOperation(value = "进入食品药品-检测表编辑界面", notes = "进入食品药品-检测表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/fs/standard/detail";
	}

	@ApiOperation(value = "获取食品药品-检测表列表数据", notes = "获取食品药品-检测表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<FsStandardCategory> list(@RequestBody DataTable<FsStandardCategory> dt) {
		return fsStandardCategoryService.pageSearch(dt);
	}

	@ApiOperation(value = "添加食品药品-检测表", notes = "添加商城-检测表")
	@RequestMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(FsStandardCategory param) {
		param.setId(1L);
		param.setName("添加测试");
		if (param == null){
			ReturnDTOUtil.fail();
		}
		fsStandardCategoryService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑食品药品-检测表", notes = "编辑食品药品-检测表")
	@RequestMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(FsStandardCategory param) {
		param.setId(1L);
		param.setName("修改测试");
		if (param == null){
			ReturnDTOUtil.fail();
		}
		fsStandardCategoryService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除食品药品-检测表")
	@ApiOperation(value = "批量删除食品药品-检测表", notes = "批量删除食品药品-检测表")
	@RequestMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		ids.add(1L);
		boolean success = fsStandardCategoryService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
