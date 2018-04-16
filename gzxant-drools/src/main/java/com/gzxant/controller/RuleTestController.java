package com.gzxant.controller;

import javax.annotation.Resource;

import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzxant.fact.User;

/**
 * Created by chen on 2017/12/21.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */

@RestController
public class RuleTestController {
    @Resource
    private KieSession kieSession;

    @GetMapping("/address")
    public void test(){
        User user = new User();
        user.setUserId(1L);
        user.setUserName("admin");

        kieSession.insert(user);

        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");



    }
}
