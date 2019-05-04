package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.tree.AuthorityMenuTree;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:登录成功后 首页业务
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/1
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/home")
public class IndexController extends AbstractController {

    /**
     * 登录成功后进入菜单首页.可以做数据统计等等操作.
     * @return
     */
    @LogAnnotation(module = "系统模块" ,method = LogEnum.ATHOR ,logDesc = "获取验证码")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public RespJsonData index(){
        System.out.println("111111111111111");
        //TODO:菜单列表 用于后台数据左侧菜单栏展示:公共
        List<AuthorityMenuTree> authorityMenuTreeList = null;
        //TODO:右侧数据统计,例如交易统计.入驻量统计,根据角色进行匹配
        return  null;
    }
}
