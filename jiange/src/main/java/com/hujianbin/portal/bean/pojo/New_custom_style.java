package com.hujianbin.portal.bean.pojo;

/**
 * Created by hujb4 on 2016/5/19.
 */
public class New_custom_style {
    private TerminalStyle TerminalStyle;

    private String Language;

    private String Number;

    private String ProgressBar;

    private String logoPosition;

    private String logoURL;

    public void setTerminalStyle(TerminalStyle TerminalStyle){
        this.TerminalStyle = TerminalStyle;
    }
    public TerminalStyle getTerminalStyle(){
        return this.TerminalStyle;
    }
    public void setLanguage(String Language){
        this.Language = Language;
    }
    public String getLanguage(){
        return this.Language;
    }
    public void setNumber(String Number){
        this.Number = Number;
    }
    public String getNumber(){
        return this.Number;
    }
    public void setProgressBar(String ProgressBar){
        this.ProgressBar = ProgressBar;
    }
    public String getProgressBar(){
        return this.ProgressBar;
    }
    public void setLogoPosition(String logoPosition){
        this.logoPosition = logoPosition;
    }
    public String getLogoPosition(){
        return this.logoPosition;
    }
    public void setLogoURL(String logoURL){
        this.logoURL = logoURL;
    }
    public String getLogoURL(){
        return this.logoURL;
    }

}
