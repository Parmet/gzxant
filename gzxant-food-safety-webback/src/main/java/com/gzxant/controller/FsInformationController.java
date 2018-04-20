package com.gzxant.controller;


import com.gzxant.dao.FsInformationDao;
import com.gzxant.entity.FsInformation;
import com.gzxant.service.IFsInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.gzxant.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 文章内容 前端控制器
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-19
 */
@Controller
@RequestMapping("/fsInformation")
public class FsInformationController extends BaseController {

    @Autowired
    private IFsInformationService iFsInformationService;

    /**
     * 用户插入数据
     */
    @GetMapping("/testControllerinsert")
    @ResponseBody
    public void insertSysFsInfromation(){
        try{
            FsInformation sysFsInformation=new FsInformation();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(sdf.format(new Date()));
            sysFsInformation.setCreateDate(date);
            sysFsInformation.setUpdateDate(date);
            sysFsInformation.setAuthor("莫进生");
            sysFsInformation.setContent("食品检测");
            sysFsInformation.setDelFlag("Y");
            sysFsInformation.setTitle("标题文字");
            sysFsInformation.setStatus(1);
            iFsInformationService.insert(sysFsInformation);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
