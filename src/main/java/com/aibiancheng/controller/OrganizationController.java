package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.organization.AddOrganizationBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.service.OrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:组织架构控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/organization")
public class OrganizationController extends AbstractController{

    @Autowired
    private OrganizationService organizationService;


    @LogAnnotation(module = "组织管理" ,method = LogEnum.ADD ,logDesc = "新增组织")
    @RequiresPermissions("sys:organization:add")
    @RequestMapping(value = "/addOrganization" ,method = RequestMethod.POST)
    public RespJson addOrganization(@RequestBody AddOrganizationBO addOrganizationBO){
        return organizationService.addOrganization(addOrganizationBO);
    }


    @LogAnnotation(module = "组织管理" ,method = LogEnum.UPDATE ,logDesc = "修改组织")
    @RequiresPermissions("sys:organization:edit")
    @RequestMapping(value = "/editOrganization" ,method = RequestMethod.POST)
    public RespJson editOrganization(){

    }

    @LogAnnotation(module = "组织管理" ,method = LogEnum.DEL ,logDesc = "删除组织")
    @RequiresPermissions("sys:organization:delete")
    @RequestMapping(value = "/editOrganization" ,method = RequestMethod.POST)
    public RespJson deleteOrganization(){

    }

    @LogAnnotation(module = "组织管理" ,method = LogEnum.SELECT ,logDesc = "查看组织列表")
    @RequiresPermissions("sys:organization:list")
    @RequestMapping(value = "/viewOrganizationList" ,method = RequestMethod.GET)
    public RespJson viewOrganizationList(){

    }

    @LogAnnotation(module = "组织管理" ,method = LogEnum.SELECT ,logDesc = "查看组织详情")
    @RequiresPermissions("sys:organization:detail")
    @RequestMapping(value = "/viewOrganizationDetail" ,method = RequestMethod.GET)
    public RespJson viewOrganizationDetail(){

    }
}
