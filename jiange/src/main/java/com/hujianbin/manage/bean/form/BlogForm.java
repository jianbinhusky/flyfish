package com.hujianbin.manage.bean.form;

import lombok.Data;

/**
 * Created by hujb4 on 2016/12/8.
 */
@Data
public class BlogForm {
    /** 标题 **/
    private String title;
    /** 摘要 **/
    private String summary;
    /** 标签 **/
    private String tag;
    /** 图片地址 **/
    private String img;
    /** 内容 **/
    private String content;
    /** 分类ID **/
    private String categoryId;
}
