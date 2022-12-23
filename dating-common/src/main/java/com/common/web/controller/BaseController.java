package com.common.web.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.common.utils.PageUtils;
import com.common.web.domain.AjaxResult;


/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/9 15:13
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class BaseController {


    protected void starterPage(){
        PageUtils.startPage();
    }

    protected void clearPage(){
        PageUtils.clearPage();
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }
}
