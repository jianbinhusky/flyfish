package com.hujianbin.portal.bean.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by hujb4 on 2016/5/19.
 */
@Document
@Data
public class Project {
    private int status;

    private boolean is_shared;

    private Date updated;

    private int page_count;

    private int is_struct_change;

    private String short_id;

    private Date created;

    private List<String> questionpage_id_list ;

    private String title;

    private int share_status;

    private String project_func_id;

    private int official_status;

    private List<Page> questionpage_list ;

    private String creator_id;

    private int version;

    private boolean first_create_for_member;

    private boolean is_hdgc;

    private int question_count;

    @Id
    private String id;

    private String end_desc;

    private Custom_attr custom_attr;

    private String begin_desc;

}
