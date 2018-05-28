package com.gzxant.controller.portals.article;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.portals.article.PortalsArticle;
import com.gzxant.service.portals.article.IPortalsArticleService;
import com.gzxant.service.portals.column.IPortalsColumnService;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 官网文章内容 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-09
 */
@Controller
@RequestMapping("/article")
public class PortalsArticleController extends BaseController {
	@Autowired
	private IPortalsArticleService portalsArticleService;

	//栏目
	@Autowired
    private IPortalsColumnService portalsColumnService;

	@ApiOperation(value = "进入官网文章内容列表界面", notes = "进入官网文章内容列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/portals/article/list";
	}

	@ApiOperation(value = "进入官网文章内容详情界面", notes = "进入官网文章内容详情界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");

			return "/portals/article/list";
		}

		PortalsArticle portalsArticle = null;
		if (StringUtils.isNumeric(id)) {
			portalsArticle = portalsArticleService.selectById(id);
		}


		model.addAttribute("portalsArticles", portalsArticle);
		//查询栏目
		model.addAttribute("portalsColumn", portalsColumnService.selectAllColumns());
		model.addAttribute("action", action);
		return "/portals/article/detail";
	}

	@ApiOperation(value = "获取官网文章内容列表数据", notes = "获取官网文章内容列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<PortalsArticle> list(@RequestBody DataTable<PortalsArticle> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return portalsArticleService.pageSearch(dt);
	}

	@ApiOperation(value = "添加官网文章内容", notes = "添加官网文章内容")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(PortalsArticle param) {
		//非空判断  标题和内容不能为空
		if (param == null
				|| StringUtils.isBlank(param.getTitle())
				|| StringUtils.isBlank(param.getContent())) {
			return ReturnDTOUtil.paramError();
		}
		portalsArticleService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑官网文章内容", notes = "编辑官网文章内容")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(PortalsArticle param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		portalsArticleService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除官网文章内容")
	@ApiOperation(value = "批量删除官网文章内容", notes = "批量删除官网文章内容")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = portalsArticleService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
