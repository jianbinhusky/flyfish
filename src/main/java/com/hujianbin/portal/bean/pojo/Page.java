package com.hujianbin.portal.bean.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by hujb4 on 2016/5/20.
 */
@Document
@Data
public class Page {

    private Date updated;

    @Id
    private String id;

    private List<String> question_id_list;

    private List<Question> question_list;

    private String project_id;

    private Custom_attr custom_attr;
}
