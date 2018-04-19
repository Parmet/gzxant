package com.gzant.controller;


import com.gzant.entity.ShopBrand;
import com.gzant.service.IShopBrandService;
import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.util.ReturnDTOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 商城-品牌表 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-04-19
 */
@Controller
@RequestMapping("/shop/Brand")
public class ShopBrandController extends BaseController {
    @Autowired
    private IShopBrandService shopBrandService;


    @ApiOperation(value = "进入博客列表界面", notes = "进入博客列表界面")
    @GetMapping(value = "")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("url", request.getContextPath() + "/blog/content/");
        return "blog/list";
    }

    @ApiOperation(value = "获取列表列表数据", notes = "获取列表列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<ShopBrand> list(@RequestBody DataTable dt, ServletRequest request) {
        return shopBrandService.pageSearch(dt);
    }

    @ApiOperation(value = "进入博客编辑界面", notes = "进入博客编辑界面")
    @GetMapping(value = "/detail/{action}")
    public String create(@PathVariable("action") String action, Model model, HttpServletRequest request) {
        model.addAttribute("action", action);
        model.addAttribute("url", request.getContextPath() + "/blog/content/");
        return "blog/detail";
    }


    @ApiOperation(value = "添加博客", notes = "添加博客")
    @PostMapping(value = "/create")
    @ResponseBody
    public ReturnDTO create(ShopBrand shopBrand) {
        shopBrandService.insert(shopBrand);
        return ReturnDTOUtil.success();
    }

    @SLog("批量删除博客")
    @ApiOperation(value = "批量删除博客", notes = "批量删除博客")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
        boolean success = shopBrandService.deleteBatchIds(ids);
        if (success) {
            return ReturnDTOUtil.success();
        }
        return ReturnDTOUtil.fail();

    }



}
