package com.common.utils;

import com.common.web.page.PageDomain;
import com.common.web.page.TableSupport;
import com.github.pagehelper.PageHelper;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/9 15:26
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class PageUtils extends PageHelper {

    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {   //从 request 里面获取到 分页对象
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();//第几页
        Integer pageSize = pageDomain.getPageSize();//每页几个数据
        //检查字符，防止注入绕过
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        //分页参数的合理化
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
