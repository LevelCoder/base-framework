package com.aibiancheng.service.impl;

import com.aibiancheng.entity.MenuEntity;
import com.aibiancheng.exception.CustomException;
import com.aibiancheng.extension.MenuExtension;
import com.aibiancheng.mapper.AuthResourceMapper;
import com.aibiancheng.mapper.ElementMapper;
import com.aibiancheng.mapper.MenuMapper;
import com.aibiancheng.model.bo.menu.AddMenuBO;
import com.aibiancheng.model.bo.menu.EditMenuBO;
import com.aibiancheng.model.bo.menu.FindMenuBo;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.MenuService;
import com.aibiancheng.utils.BaseAuthConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:菜单业务实现层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    /** 引入日志 */
    private static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private ElementMapper elementMapper;

    @Autowired
    private AuthResourceMapper authResourceMapper;

    @Override
    public RespJson addMenu(AddMenuBO addMenuBO) {
        try{
            logger.info("start add menu ");
            logger.info("transfer parameters >> addMenuBO:{}", JSON.toJSON(addMenuBO));

            MenuEntity menuEntity = MenuExtension.addMenu(addMenuBO);
            menuMapper.saveByEntity(menuEntity);

            logger.info("end add menu ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }


    @Override
    public RespJson editMenu(EditMenuBO editMenuBO){
        try{
            logger.info("start edit menu ");
            logger.info("transfer parameters >> editMenuBO:{}", JSON.toJSON(editMenuBO));

            MenuEntity menuEntity = MenuExtension.editMenu(editMenuBO);
            menuMapper.updateSelective(menuEntity);
            logger.info("end edit menu ");
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }


    @Override
    public RespJson changeMenu(Long menuId, byte menuState){
        try{
            logger.info("start change menu ");
            logger.info("transfer parameters >> menuId:{},menuState:{}", menuId,menuState);

            if(menuState == 2){
              if(authResourceMapper.findAuthResourceByResource(menuId,"menu") > 0){
                  return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"资源已分配,不允许关闭");
              }
            }
            menuMapper.changeMenu(menuId,menuState);
            logger.info("end change menu ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJson deleteMenu(Long menuId){
        try{
            logger.info("start delete menu ");
            logger.info("transfer parameters >> menuId:{}", menuId);

            if(elementMapper.findElementListByMenuId(menuId).size() > 0 ){
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"存在子菜单,不允许删除");
            }

            if(authResourceMapper.findAuthResourceByResource(menuId,"menu") > 0){
                return new RespJson(BaseAuthConstant.responseCode.FAIL_CODE,"资源已分配,不允许删除");
            }

            menuMapper.deleteById(menuId);

            logger.info("end delete menu ");
            return new RespJson(BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonData viewMenuDetail(Long menuId) {
        try{
            logger.info("start view menu detail menu ");
            logger.info("transfer parameters >> menuId:{}", menuId);

            MenuEntity menuEntity = menuMapper.findMenuDetailById(menuId);

            logger.info("end view menu detail menu ");
            return new RespJsonData(menuEntity,BaseAuthConstant.responseCode.SUCCESS_CODE,BaseAuthConstant.responseMessage.SUCCESS_MESSAGE);
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }

    @Override
    public RespJsonPageData viewMenuList(FindMenuBo findMenuBo) {
        try{
            logger.info("start view menu list menu ");
            logger.info("transfer parameters >> findMenuBo:{}", JSON.toJSON(findMenuBo));

            logger.info("end view menu list menu ");
            return null;
        }catch (Exception e){
            throw new CustomException(BaseAuthConstant.responseMessage.FAIL_MESSAGE);
        }
    }
}
