package com.aibiancheng.controller;

import com.aibiancheng.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:数据字典控制层
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/6/20
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/dictionary")
public class DictionaryController extends AbstractController{

    @Autowired
    private DictionaryService dictionaryService;


}
