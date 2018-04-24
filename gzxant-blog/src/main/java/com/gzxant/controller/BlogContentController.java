package com.gzxant.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

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
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.BlogContent;
import com.gzxant.service.IBlogContentService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * @author chen
 * @date 2017/11/20
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Controller


public class BlogContentController extends BaseController {

    @Autowired
    private IBlogContentService blogContentService;


    @ApiOperation(value = "进入博客列表界面", notes = "进入博客列表界面")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath() + "/fs/content/");
        return "fs/list";
    }

    @ApiOperation(value = "获取列表列表数据", notes = "获取列表列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<BlogContent> list(@RequestBody DataTable dt, ServletRequest request) {
        return blogContentService.pageSearch(dt);
    }

    @ApiOperation(value = "进入博客编辑界面", notes = "进入博客编辑界面")
    @GetMapping(value = "/detail/{action}")
    public String create(@PathVariable("action") String action, Model model, HttpServletRequest request) {
        model.addAttribute("action", action);
        model.addAttribute("url", request.getContextPath() + "/fs/content/");
        return "fs/detail";
    }


    @ApiOperation(value = "添加博客", notes = "添加博客")
    @PostMapping(value = "/create")
    @ResponseBody
    public ReturnDTO create(BlogContent blogContent) {
        blogContentService.insert(blogContent);
        return ReturnDTOUtil.success();
    }

    @SLog("批量删除博客")
    @ApiOperation(value = "批量删除博客", notes = "批量删除博客")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        boolean success = blogContentService.deleteBatchIds(ids);
        if (success) {
            return ReturnDTOUtil.success();
        }
        return ReturnDTOUtil.fail();

    }

}
