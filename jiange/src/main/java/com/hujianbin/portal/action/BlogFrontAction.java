package com.hujianbin.portal.action;

import com.hujianbin.common.spring.BaseAction;
import com.hujianbin.portal.constant.BlogReturnConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hujb4 on 2017/2/27.
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogFrontAction extends BaseAction {

    @RequestMapping(value = "/list")
    public String listBlog() {
        return BlogReturnConstant.BLOG_LIST;
    }

    @RequestMapping(value = "/iframe")
    public String iframe(){
        return "iframe";
    }
}
