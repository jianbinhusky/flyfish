package com.hujianbin.portal.bean.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by hujb4 on 2016/5/20.
 */
@Document
@Data
public class Option {
    private Date updated;

    private String cid;

    private String title;

    private boolean is_open;

    @Id
    private String id;

    private Custom_attr custom_attr;

    private String question_id;
}
