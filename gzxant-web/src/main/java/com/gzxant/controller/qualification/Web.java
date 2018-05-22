package com.gzxant.controller.qualification;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.article.Article;
import com.gzxant.entity.qualification.Qualification;
import com.gzxant.service.article.IArticleService;
import com.gzxant.service.qualification.IQualificationService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/code")
public class Web {

    @Autowired
    private IQualificationService qualificationService;

    @Autowired
    private IArticleService articleService;


//用户填写认证信息并保存
    @ApiOperation(value = "进入资格认证列表界面", notes = "进入资格认证列表界面")
    @GetMapping(value = "")
    public String list(Model model) {

        model.addAttribute("action","insert");
        return "/qualification/save_code";
    }

    @ApiOperation(value = "添加资格认证", notes = "添加资格认证")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(Qualification param) {
        //非空判断  姓名,身份证号,邮箱,电话不能空
        if (param == null
                || StringUtils.isBlank(param.getName())
                || StringUtils.isBlank(param.getCard())
                || StringUtils.isBlank(param.getEmail())
                || StringUtils.isBlank(param.getPhone())) {
            return ReturnDTOUtil.paramError();
        }
        qualificationService.insert(param);
        return ReturnDTOUtil.success();
    }


    //富文本编辑
    @ApiOperation(value = "进入word", notes = "进入word")
    @GetMapping(value = "/word")
    public String select(Model model) {

        model.addAttribute("action","insert");
        return "/qualification/word";
    }

    @ApiOperation(value = "保存文章", notes = "保存文章")
    @PostMapping(value = "/insert_word")
    @ResponseBody
    public ReturnDTO insertWord(Article param) {
        //非空判断  文章名称,文章内容不为空
        if (param == null
                || StringUtils.isBlank(param.getName())
                || StringUtils.isBlank(param.getArticleContent())) {
            return ReturnDTOUtil.paramError();
        }
        articleService.insert(param);
        return ReturnDTOUtil.success();
    }



//查询授权编码
    @ApiOperation(value = "进入查询列表界面", notes = "进入查询列表界面")
    @GetMapping(value = "/select")
    public String worde(Model model) {

        model.addAttribute("action","save");
        return "/qualification/code";
    }

    @ApiOperation(value = "授权编码查询", notes = "授权编码查询")
    @PostMapping(value = "/select/save")
    @ResponseBody
    public String save(String param) {
        //非空判断  授权编码不能为空
        if (param == null
                || StringUtils.isBlank(param)) {
            return "没有该授权编码";
        }
        qualificationService.selectByCode(param);
        return param;
    }

}
