package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.element.AddElementBO;
import com.aibiancheng.model.bo.element.EditElementBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.ElementService;
import com.aibiancheng.utils.BaseAuthConstant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:元素/按钮控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/element")
public class ElementController extends AbstractController {

    @Autowired
    private ElementService elementService;

    @LogAnnotation(module = "元素管理" ,method = LogEnum.ADD ,logDesc = "新增元素")
    @RequiresPermissions("sys:element:add")
    @RequestMapping(value = "/addElement",method = RequestMethod.POST)
    public RespJson addElement(@RequestBody AddElementBO addElementBO)  {
        return elementService.addElement(addElementBO);
    }

    @LogAnnotation(module = "元素管理" ,method = LogEnum.ADD ,logDesc = "修改元素")
    @RequiresPermissions("sys:element:edit")
    @RequestMapping(value = "/editElement",method = RequestMethod.POST)
    public RespJson editElement(@RequestBody EditElementBO editElementBO)  {
       return elementService.editElement(editElementBO);
    }

    @LogAnnotation(module = "元素管理" ,method = LogEnum.ADD ,logDesc = "删除元素")
    @RequiresPermissions("sys:element:delete")
    @RequestMapping(value = "/deleteElement",method = RequestMethod.POST)
    public RespJson deleteElement(@RequestBody Long elementId)  {
      return elementService.deleteElement(elementId);
    }


    @LogAnnotation(module = "元素管理" ,method = LogEnum.ADD ,logDesc = "查看元素详情")
    @RequiresPermissions("sys:element:detail")
    @RequestMapping(value = "/viewElementDetail",method = RequestMethod.GET)
    public RespJsonData viewElementDetail(Long elementId)  {
       return elementService.viewElementDetail(elementId);
    }


    @LogAnnotation(module = "元素管理" ,method = LogEnum.ADD ,logDesc = "查看元素列表")
    @RequiresPermissions("sys:element:list")
    @RequestMapping(value = "/viewElementList",method = RequestMethod.GET)
    public RespJsonPageData viewElementList(){
        try{

            return null;
        }catch (Exception e){
            return new RespJsonPageData(null,0,BaseAuthConstant.responseCode.FAIL_CODE,BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}
