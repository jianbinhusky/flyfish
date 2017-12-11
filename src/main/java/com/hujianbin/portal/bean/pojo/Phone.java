package com.hujianbin.portal.bean.pojo;

import java.util.List;

/**
 * Created by hujb4 on 2016/5/19.
 */
public class Phone {
    private String TopBgColor;

    private String BgColor;

    private String theme;

    private String R_TopBgColor;

    private List<Font> font ;

    private String OtherColor;

    private String R_OtherColor;

    public void setTopBgColor(String TopBgColor){
        this.TopBgColor = TopBgColor;
    }
    public String getTopBgColor(){
        return this.TopBgColor;
    }
    public void setBgColor(String BgColor){
        this.BgColor = BgColor;
    }
    public String getBgColor(){
        return this.BgColor;
    }
    public void setTheme(String theme){
        this.theme = theme;
    }
    public String getTheme(){
        return this.theme;
    }
    public void setR_TopBgColor(String R_TopBgColor){
        this.R_TopBgColor = R_TopBgColor;
    }
    public String getR_TopBgColor(){
        return this.R_TopBgColor;
    }
    public void setFont(List<Font> font){
        this.font = font;
    }
    public List<Font> getFont(){
        return this.font;
    }
    public void setOtherColor(String OtherColor){
        this.OtherColor = OtherColor;
    }
    public String getOtherColor(){
        return this.OtherColor;
    }
    public void setR_OtherColor(String R_OtherColor){
        this.R_OtherColor = R_OtherColor;
    }
    public String getR_OtherColor(){
        return this.R_OtherColor;
    }

}
