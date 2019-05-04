package com.aibiancheng.controller;

import com.aibiancheng.aop.log.LogAnnotation;
import com.aibiancheng.aop.log.LogEnum;
import com.aibiancheng.model.bo.log.FindLogRecordBO;
import com.aibiancheng.model.resp.RespJson;
import com.aibiancheng.model.resp.RespJsonData;
import com.aibiancheng.model.resp.RespJsonPageData;
import com.aibiancheng.service.LogRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:日志记录
 * 作者:LevelCoder
 * 邮箱:LevelCoder@126.com
 * 版本:V1.0.0
 * 时间:2018/7/2
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/server/log")
public class LogRecordController extends AbstractController {

    @Autowired
    private LogRecordService logRecordService;


    /**
     * 查看日志列表
     * @param findLogRecordBO
     * @return
     */
    @LogAnnotation(module = "日志管理" ,method = LogEnum.SELECT ,logDesc = "查看日志列表")
    @RequiresPermissions("sys:log:list")
    @RequestMapping(value = "/viewLogRecordList",method = RequestMethod.GET)
    public RespJsonPageData viewLogRecordList(FindLogRecordBO findLogRecordBO){
        return logRecordService.viewLogRecordList(findLogRecordBO);
    }

    /**
     * 查看日志详情
     * @param id
     * @return
     */
    @LogAnnotation(module = "日志管理" ,method = LogEnum.SELECT ,logDesc = "查看日志详情")
    @RequiresPermissions("sys:log:detail")
    @RequestMapping(value = "/viewLogRecordDetail",method = RequestMethod.GET)
    public RespJsonData viewLogRecordDetail(Long id)  {
        return logRecordService.viewLogRecordDetail(id);
    }


    /**
     * 删除日志
     * @param logId
     * @return
     * @throws Exception
     */
    @LogAnnotation(module = "日志管理" ,method = LogEnum.DEL ,logDesc = "删除日志")
    @RequiresPermissions("sys:log:delete")
    @RequestMapping(value = "/deleteLogRecord",method = RequestMethod.POST)
    public RespJson deleteLogRecord(@RequestBody Long logId)  {
        return logRecordService.deleteLogRecord(logId);
    }
}
