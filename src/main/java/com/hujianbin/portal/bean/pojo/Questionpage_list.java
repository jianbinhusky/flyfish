package com.hujianbin.portal.bean.pojo;

import java.util.List;

/**
 * Created by hujb4 on 2016/5/19.
 */
public class Questionpage_list {
    private Updated updated;

    private _id _id;

    private List<Question_id_list> question_id_list ;

    private List<Question_list> question_list ;

    private String project_id;

    private Custom_attr custom_attr;

    public void setUpdated(Updated updated){
        this.updated = updated;
    }
    public Updated getUpdated(){
        return this.updated;
    }
    public void set_id(_id _id){
        this._id = _id;
    }
    public _id get_id(){
        return this._id;
    }
    public void setQuestion_id_list(List<Question_id_list> question_id_list){
        this.question_id_list = question_id_list;
    }
    public List<Question_id_list> getQuestion_id_list(){
        return this.question_id_list;
    }
    public void setQuestion_list(List<Question_list> question_list){
        this.question_list = question_list;
    }
    public List<Question_list> getQuestion_list(){
        return this.question_list;
    }
    public void setProject_id(String project_id){
        this.project_id = project_id;
    }
    public String getProject_id(){
        return this.project_id;
    }
    public void setCustom_attr(Custom_attr custom_attr){
        this.custom_attr = custom_attr;
    }
    public Custom_attr getCustom_attr(){
        return this.custom_attr;
    }

}
