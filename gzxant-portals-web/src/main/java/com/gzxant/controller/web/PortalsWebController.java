package com.gzxant.controller.web;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.portals.about.me.PortalsAboutMe;
import com.gzxant.entity.portals.article.PortalsArticle;
import com.gzxant.entity.portals.column.PortalsColumn;
import com.gzxant.entity.portals.company.information.PortalsCompanyInformation;
import com.gzxant.entity.portals.customer.PortalsCustomer;
import com.gzxant.entity.portals.message.PortalsMessage;
import com.gzxant.service.portals.about.me.PortalsAboutMeService;
import com.gzxant.service.portals.article.PortalsArticleService;
import com.gzxant.service.portals.column.PortalsColumnService;
import com.gzxant.service.portals.company.information.PortalsCompanyInformationService;
import com.gzxant.service.portals.customer.PortalsCustomerService;
import com.gzxant.service.portals.message.PortalsMessageService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/portals")
public class PortalsWebController {

    /**
     * 公司信息展示
     */
     @Autowired
     private PortalsCompanyInformationService portalsCompanyInformationService;


    /**
     * 公司信息栏目
     */
     @Autowired
     private PortalsColumnService portalsColumnService;

    /**
     * 公司文章
     */
    @Autowired
    private PortalsArticleService portalsArticleService;


    /**
     * 公司联系方式
     */
    @Autowired
    private PortalsMessageService portalsMessageService;

    /**
     * 关于我们的信息
     */
    @Autowired
    private PortalsAboutMeService portalsAboutMeService;
    /**
     * 关于我们的客户信息
     */
    @Autowired
    private PortalsCustomerService portalsCustomerService;




    @ApiOperation(value = "进入公司官网展示公司信息", notes = "进入公司官网展示公司信息")
    @GetMapping(value = "/{code}" )
    public String list(Model model, @PathVariable String code) {
        //判断公司唯一编码不能为空
        if (code == null || StringUtils.isBlank(code)){
            return "404";
        }
        //根据公司唯一标识查询是那一家公司
        PortalsCompanyInformation pcif = new PortalsCompanyInformation();
        pcif.setCode(code);
        //查询公司所有的信息
        PortalsCompanyInformation portalsCompanyInformation = portalsCompanyInformationService.selectById(code);





        //查询栏目
        List<PortalsColumn> portalsColumn = portalsColumnService.selectAllColumns();

        //查询文章
        List<PortalsArticle> portalsArticle = portalsArticleService.selectAllArticle();


        //公司的联系方式
        PortalsMessage portalsMessage =  portalsMessageService.selectAllMessage();

        //关于我们的信息
        PortalsAboutMe portalsAboutMe = portalsAboutMeService.selectAllAboutMe();


        //公司客户信息
        List<PortalsCustomer> portalsCustomer = portalsCustomerService.selectAllCustomer();


        //公司信息
        model.addAttribute("portalsCompanyInformation",portalsCompanyInformation);
       //公司栏目
        model.addAttribute("portalsColumn",portalsColumn);
        //公司文章
        model.addAttribute("portalsArticle",portalsArticle);
        //公司的联系方式
        model.addAttribute("portalsMessage",portalsMessage);
        //关于我们的信息
        model.addAttribute("portalsAboutMe",portalsAboutMe);
        //关于我们的客户信息
        model.addAttribute("portalsCustomer",portalsCustomer);
        return "/portals/index";
    }



    @ApiOperation(value = "添加客户管理", notes = "添加客户管理")
    @PostMapping(value = "/save")
    @ResponseBody
    public ReturnDTO create(PortalsCustomer param) {
        //客户名字 客户logo
        if (param == null
                || StringUtils.isBlank(param.getCustomerName())
                || StringUtils.isBlank(param.getCustomerLogo())) {
            return ReturnDTOUtil.paramError();
        }
        portalsCustomerService.insert(param);
        return ReturnDTOUtil.success();
    }



}
