package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.menu.AddMenuBO;
import com.aibiancheng.model.bo.menu.EditMenuBO;
import com.aibiancheng.model.bo.menu.FindMenuBo;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.MenuService;
import com.aibiancheng.utils.BaseAuthConstant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:菜单管理控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/menu")
public class MenuController extends AbstractController{


    @Autowired
    private MenuService menuService;

    /**
     * 新增菜单
     * @return
     */
    @LogAnnotation(module = "菜单管理" ,method = LogEnum.ADD ,logDesc = "新增菜单")
    @RequiresPermissions("sys:menu:add")
    @RequestMapping(value = "/addMenu",method = RequestMethod.POST)
    public RespJson addMenu(@RequestBody AddMenuBO addMenuBO)  {
        return menuService.addMenu(addMenuBO);
    }


    /**
     * 修改菜单
     * @return
     */
    @LogAnnotation(module = "菜单管理" ,method = LogEnum.UPDATE ,logDesc = "修改菜单")
    @RequiresPermissions("sys:menu:edit")
    @RequestMapping(value = "/editMenu",method = RequestMethod.POST)
    public RespJson editMenu(@RequestBody EditMenuBO editMenuBO)  {
        return menuService.editMenu(editMenuBO);
    }


    /**
     * 删除菜单
     * @return
     */
    @LogAnnotation(module = "菜单管理" ,method = LogEnum.DEL ,logDesc = "删除菜单")
    @RequiresPermissions("sys:menu:delete")
    @RequestMapping(value = "/deleteMenu",method = RequestMethod.POST)
    public RespJson deleteMenu(@RequestBody Long menuId)  {
        return menuService.deleteMenu(menuId);
    }


    @LogAnnotation(module = "菜单管理" ,method = LogEnum.SELECT ,logDesc = "查看菜单详情")
    @RequiresPermissions("sys:menu:detail")
    @RequestMapping(value = "/viewMenuDetail",method = RequestMethod.GET)
    public RespJsonData viewMenuDetail( Long menuId)  {
        return menuService.viewMenuDetail(menuId);
    }


    /**
     * 查看菜单列表
     * @return
     */
    @LogAnnotation(module = "菜单管理" ,method = LogEnum.SELECT ,logDesc = "查看菜单列表")
    @RequiresPermissions("sys:menu:list")
    @RequestMapping(value = "/viewMenuList",method = RequestMethod.GET)
    public RespJsonPageData viewMenuList( FindMenuBo findMenuBo)  {
        return menuService.viewMenuList(findMenuBo);
    }


    /**
     * 启用菜单
     * @param menuId
     * @return
     */
    @LogAnnotation(module = "菜单管理" ,method = LogEnum.UPDATE ,logDesc = "启用菜单")
    @RequiresPermissions("sys:menu:open")
    @RequestMapping(value = "/changeOpenMenu",method = RequestMethod.POST)
    public RespJson changeOpenMenu(@RequestBody Long menuId)  {
        return menuService.changeMenu(menuId,(byte)1);
    }

    /**
     * 禁用菜单
     * @param menuId
     * @return
     */
    @LogAnnotation(module = "菜单管理" ,method = LogEnum.UPDATE ,logDesc = "禁用菜单")
    @RequiresPermissions("sys:menu:close")
    @RequestMapping(value = "/changeCloseMenu",method = RequestMethod.POST)
    public RespJson changeCloseMenu(@RequestBody Long menuId)  {
        return menuService.changeMenu(menuId,(byte)2);
    }
}
