package com.gzxant.controller.fs.standard;

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
import com.gzxant.service.fs.standard.IFsStandardService;
import com.gzxant.entity.fs.standard.FsStandard;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 食品标准表 前端控制器
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-28
 */
@Controller
@RequestMapping("/fs/standard")
public class FsStandardController extends BaseController {
	@Autowired
	private IFsStandardService fsStandardService;

	@ApiOperation(value = "进入食品标准表列表界面", notes = "进入食品标准表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/fs/standard/list";
	}

	@ApiOperation(value = "进入食品标准表编辑界面", notes = "进入食品标准表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/fs/standard/detail";
	}

	@ApiOperation(value = "获取食品标准表列表数据", notes = "获取食品标准表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<FsStandard> list(@RequestBody DataTable<FsStandard> dt) {
		return fsStandardService.pageSearch(dt);
	}

	@ApiOperation(value = "添加食品标准表", notes = "添加食品标准表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(FsStandard param) {
		fsStandardService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑食品标准表", notes = "编辑食品标准表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(FsStandard param) {
		fsStandardService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除食品标准表")
	@ApiOperation(value = "批量删除食品标准表", notes = "批量删除食品标准表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = fsStandardService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
