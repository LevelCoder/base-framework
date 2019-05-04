package com.aibiancheng.controller;

import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:验证控制器
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/1
 */
@RestController
@RequestMapping(value = "/validata")
public class ValidataController extends AbstractController {

    @Autowired
    private UserService userService;

    /**
     * 验证邮箱是否存在
     * @return
     */
    @RequestMapping(value = "/validataUserEmail",method = RequestMethod.POST)
    public RespJson validataUserEmail(@RequestBody String userEmail) {
        return userService.validataUserEmail(userEmail);
    }

    /**
     * 验证手机号是否重复
     * @return
     */
    @RequestMapping(value = "/validataUserPhone",method = RequestMethod.POST)
    public RespJson validataUserPhone(@RequestBody String userPhone)  {
        return userService.validataUserPhone(userPhone);
    }

    /**
     * 验证用户名是否重复
     * @return
     */
    @RequestMapping(value = "/validataUserName",method = RequestMethod.POST)
    public RespJson validataUserName(@RequestBody String userName){
        return userService.validataUserName(userName);
    }

    /**
     * 验证角色名是否存在
     * @return
     */
    @RequestMapping(value = "/validataRoleName" ,method = RequestMethod.POST)
    public RespJson validataRoleName(@RequestBody String roleName){
        return null;
    }

    /**
     * 验证元素名称是否存在
     * @return
     */
    @RequestMapping(value = "/validataElementName",method = RequestMethod.POST)
    public RespJson validataElementName(@RequestBody String elementName){
        return null;
    }

    /**
     * 验证菜单名称是否存在
     * @return
     */
    @RequestMapping(value = "/validataMenuName",method = RequestMethod.POST)
    public RespJson validataMenuName(@RequestBody String menuName){
        return null;
    }


    /**
     * 验证组织名称
     * @param organizationName
     * @return
     */
    @RequestMapping(value = "/validataOrganizationName",method = RequestMethod.POST)
    public RespJson validataOrganizationName(@RequestBody String organizationName){
        return null;
    }


}
