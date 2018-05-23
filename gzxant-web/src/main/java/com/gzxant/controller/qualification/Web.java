package com.gzxant.controller.qualification;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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

import java.util.Date;

@Controller
@RequestMapping("")
public class Web {

    @Autowired
    private IQualificationService qualificationService;

    @Autowired
    private IArticleService articleService;



//用户填写认证信息并保存
    @ApiOperation(value = "进入资格认证列表界面", notes = "进入资格认证列表界面")
    @GetMapping(value = "/code")
    public String submitCode(Model model) {
        model.addAttribute("action","insert");
        return "/qualification/web/code/submit";
    }

    @ApiOperation(value = "添加资格认证", notes = "添加资格认证")
    @PostMapping(value = "/code/insert")
    @ResponseBody
    public ReturnDTO createCode(Qualification param) {
        // 1. 非空判断  姓名,身份证号,邮箱,电话不能空
        if (param == null
            || StringUtils.isBlank(param.getName())
            || StringUtils.isBlank(param.getCard())
            || StringUtils.isBlank(param.getEmail())
            || StringUtils.isBlank(param.getPhone())) {
            return ReturnDTOUtil.paramError();
        }
//        Qualification qualification = qualificationService.selectByPhone(param.getPhone());
        // 2. 判断是否重复申请
        // 默认为空，已通过，不通过
        // 存在除了状态为不通过的数据时，返回已提交申请提示
        EntityWrapper<Qualification> ew = new EntityWrapper<Qualification>();
        ew.setEntity(new Qualification());
        ew.where("phone={0}", param.getPhone())
        .andNew("state='Y'")
        .or("state is null");
        int count = qualificationService.selectCount(ew);
        if(count > 0){
            return ReturnDTOUtil.custom(201, "该手机号已提交认证申请，请勿重复提交！");
        }
        
        // 3. 保存数据
        param.setCreateId(0L);
        param.setUpdateId(0L);
        param.setCreateDate(new Date());
        param.setUpdateDate(new Date());
        param.setDelFlag("Y");
        qualificationService.insert(param);
        
        // 4. 返回保存成功
        return ReturnDTOUtil.success();
    }


    //富文本编辑
    @ApiOperation(value = "进入word", notes = "进入word")
    @GetMapping(value = {"/word/{action}/{id}", "/{action}"})
    public String wordDetail(@PathVariable(name = "action") String action,
                         @PathVariable(name = "id", required = false) String id, Model model) {
        Article article = null;
            article = articleService.selectById(2L);
        model.addAttribute("article", article);
        model.addAttribute("action","insert");
        return "/qualification/web/word";
    }


//查询授权编码
    @ApiOperation(value = "进入查询列表界面", notes = "进入查询列表界面")
    @GetMapping(value = "/code/select")
    public String queryCode(Model model) {
        model.addAttribute("action","detail");
        return "/qualification/web/code/query";
    }

    @ApiOperation(value = "详情页", notes = "详情页")
    @GetMapping(value = "/code/detail/{code}")
    public String codeDetail(@PathVariable(name = "code") String code, Model model) {
        if (code == null || StringUtils.isBlank(code)) {
            model.addAttribute("msg", "授权编号有误");
            return "/qualification/web/code/query";
        }
        
        EntityWrapper<Qualification> ew = new EntityWrapper<Qualification>();
        ew.setEntity(new Qualification());
        ew.where("code={0}", code)
        .andNew("state='Y'");
        Qualification qualification = qualificationService.selectOne(ew);
        model.addAttribute("qualification",qualification);
        return "/qualification/web/code/submit-detail";
    }

}
