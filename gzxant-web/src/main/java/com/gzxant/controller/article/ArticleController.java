package com.gzxant.controller.article;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.article.Article;
import com.gzxant.service.article.IArticleService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-22
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
	@Autowired
	private IArticleService articleService;

	@ApiOperation(value = "进入文章列表界面", notes = "进入文章列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/article/list";
	}

	@ApiOperation(value = "进入文章编辑界面", notes = "进入文章编辑界面")
	@GetMapping(value = { "/{action}/{id}", "/{action}" })
	public String detail(@PathVariable(name = "action") String action,
			@PathVariable(name = "id", required = false) String id, Model model) {
		if (!action.equals("add") && !action.equals("edit") && !action.equals("view")) {
			return "404";
		}
		Article article = null;
		if (StringUtils.isNumeric(id)) {
			article = articleService.selectById(id);
		}

		model.addAttribute("action", action);
		model.addAttribute("article", article);
		return "/article/" + action;
	}

	@ApiOperation(value = "文章发布", notes = "文章发布")
	@PostMapping(value = "/push/{state}/{id}")
	@ResponseBody
	public ReturnDTO push(@PathVariable(name = "state") String state,
			@PathVariable(name = "id") String id, Model model) {
		if (StringUtils.isBlank(state)
			|| (!state.equals("Y") && !state.equals("N"))
			|| StringUtils.isBlank(id)) {
			return ReturnDTOUtil.paramError();
		}
		
		Article article = articleService.selectById(id);
		if (article == null || article.getId() == null) {
			return ReturnDTOUtil.custom(405, "非法请求");
		}
		
		article.setState(state);
		article.setPushTime(new Date());
		articleService.updateById(article);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "获取文章列表数据", notes = "获取文章列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<Article> list(@RequestBody DataTable<Article> dt) {
		if (dt == null || dt.getPageNumber() < 0 || dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return articleService.pageSearch(dt);
	}

	@ApiOperation(value = "添加文章", notes = "添加文章")
	@PostMapping(value = "/add")
	@ResponseBody
	public ReturnDTO create(Article param) {
		// 非空判断 文章名称,文章内容不为空
		if (param == null || StringUtils.isBlank(param.getName()) || StringUtils.isBlank(param.getArticleContent())) {
			return ReturnDTOUtil.paramError();
		}

		articleService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑文章", notes = "编辑文章")
	@PostMapping(value = "/edit/{id}")
	@ResponseBody
	public ReturnDTO update(Article param) {
		// 非空判断
		if (param == null || param.getId() == null) {
			return ReturnDTOUtil.paramError();
		}

		articleService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除文章")
	@ApiOperation(value = "批量删除文章", notes = "批量删除文章")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}

		List<Article> datas = articleService.selectBatchIds(ids);
		for (Article article : datas) {
			article.setDelFlag("N");
			article.setState("N");
		}

		boolean success = articleService.updateAllColumnBatchById(datas);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
