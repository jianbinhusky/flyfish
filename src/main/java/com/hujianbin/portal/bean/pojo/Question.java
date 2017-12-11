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
public class Question {

    private boolean has_open_option;

    @Id
    private String id;

    private List<String> jumpconstraint_id_list;

    private List<String> option_id_list;

    private String cid;

    private String questionpage_id;

    private String title;

    private Date updated;

    private List<String> matrixrow_list;

    private List<String> matrixrow_id_list;

    private List<Option> option_list;

    private Object question_type;

    private String project_id;

    private Custom_attr custom_attr;

}
