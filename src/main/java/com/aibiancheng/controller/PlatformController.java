package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.platform.AddPlatformBO;
import com.aibiancheng.model.bo.platform.EditPlatformBO;
import com.aibiancheng.model.bo.platform.FindPlatformBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.PlatformService;
import com.aibiancheng.utils.BaseAuthConstant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:平台管理控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/platform")
public class PlatformController extends AbstractController{

    @Autowired
    private PlatformService platformService;


    @LogAnnotation(module = "平台管理" ,method = LogEnum.ADD ,logDesc = "新增平台信息")
    @RequiresPermissions("sys:platform:add")
    @RequestMapping(value = "/addPlatform" ,method = RequestMethod.POST)
    public RespJson addPlatform(@RequestBody AddPlatformBO addPlatformBO){
        return platformService.addPlatform(addPlatformBO);
    }


    /**
     * 修改平台信息
     * @return
     */
    @LogAnnotation(module = "平台管理" ,method = LogEnum.UPDATE ,logDesc = "修改平台信息")
    @RequiresPermissions("sys:platform:edit")
    @RequestMapping(value = "/editPlatform" ,method = RequestMethod.POST)
    public RespJson editPlatform(@RequestBody EditPlatformBO editPlatformBO){
        return platformService.editPlatform(editPlatformBO);
    }


    /**
     *
     * @return
     */
    @LogAnnotation(module = "平台管理" ,method = LogEnum.DEL ,logDesc = "删除平台信息")
    @RequiresPermissions("sys:platform:delete")
    @RequestMapping(value = "/deletePlatform" ,method = RequestMethod.POST)
    public RespJson deletePlatform(@RequestBody Long platformId){
        return platformService.deletePlatform(platformId);
    }


    /**
     * 查看平台详情
     * @return
     */
    @LogAnnotation(module = "平台管理" ,method = LogEnum.SELECT ,logDesc = "查看平台详情")
    @RequiresPermissions("sys:platform:detail")
    @RequestMapping(value = "/viewPlatformDetail" ,method = RequestMethod.GET)
    public RespJsonData viewPlatformDetail(Long platformId){
        return platformService.viewPlatformDetail(platformId);
    }

    /**
     * 查看平台列表
     * @return
     */
    @LogAnnotation(module = "平台管理" ,method = LogEnum.SELECT ,logDesc = "查看平台列表")
    @RequiresPermissions("sys:platform:list")
    @RequestMapping(value = "/viewPlatformList" ,method = RequestMethod.GET)
    public RespJsonPageData viewPlatformList(FindPlatformBO findPlatformBO){
        return platformService.viewPlatformList(findPlatformBO);
    }


    /**
     * 启用平台
     * @return
     */
    @LogAnnotation(module = "平台管理" ,method = LogEnum.UPDATE ,logDesc = "启用平台")
    @RequiresPermissions("sys:platform:open")
    @RequestMapping(value = "/openPlatform" ,method = RequestMethod.GET)
    public RespJson openPlatform(){
        return null;
    }


    /**
     * 禁用平台
     * @return
     */
    @LogAnnotation(module = "平台管理" ,method = LogEnum.UPDATE ,logDesc = "禁用平台")
    @RequiresPermissions("sys:platform:close")
    @RequestMapping(value = "/closePlatform" ,method = RequestMethod.GET)
    public RespJson closePlatform(){
        return null;
    }
}
