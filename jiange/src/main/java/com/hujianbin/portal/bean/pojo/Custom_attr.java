package com.hujianbin.portal.bean.pojo;

/**
 * Created by hujb4 on 2016/5/19.
 */
public class Custom_attr {
    private String survey_share_pic_url;

    private String panelsite;

    private String theme;

    private String scrollbar;

    private New_custom_style new_custom_style;

    private String screenout_desc;

    public void setSurvey_share_pic_url(String survey_share_pic_url){
        this.survey_share_pic_url = survey_share_pic_url;
    }
    public String getSurvey_share_pic_url(){
        return this.survey_share_pic_url;
    }
    public void setPanelsite(String panelsite){
        this.panelsite = panelsite;
    }
    public String getPanelsite(){
        return this.panelsite;
    }
    public void setTheme(String theme){
        this.theme = theme;
    }
    public String getTheme(){
        return this.theme;
    }
    public void setScrollbar(String scrollbar){
        this.scrollbar = scrollbar;
    }
    public String getScrollbar(){
        return this.scrollbar;
    }
    public void setNew_custom_style(New_custom_style new_custom_style){
        this.new_custom_style = new_custom_style;
    }
    public New_custom_style getNew_custom_style(){
        return this.new_custom_style;
    }
    public void setScreenout_desc(String screenout_desc){
        this.screenout_desc = screenout_desc;
    }
    public String getScreenout_desc(){
        return this.screenout_desc;
    }

}
