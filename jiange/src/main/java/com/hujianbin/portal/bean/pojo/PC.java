package com.hujianbin.portal.bean.pojo;

import java.util.List;

/**
 * Created by hujb4 on 2016/5/19.
 */
public class PC {
    private String R_BgColor;

    private String BgImagePosition;

    private String backgroundRepeat;

    private String ImageURl;

    private String BgColor;

    private String WjBgColor;

    private String BgImageURl;

    private List<Font> font ;

    private String OtherColor;

    private String R_OtherColor;

    public void setR_BgColor(String R_BgColor){
        this.R_BgColor = R_BgColor;
    }
    public String getR_BgColor(){
        return this.R_BgColor;
    }
    public void setBgImagePosition(String BgImagePosition){
        this.BgImagePosition = BgImagePosition;
    }
    public String getBgImagePosition(){
        return this.BgImagePosition;
    }
    public void setBackgroundRepeat(String backgroundRepeat){
        this.backgroundRepeat = backgroundRepeat;
    }
    public String getBackgroundRepeat(){
        return this.backgroundRepeat;
    }
    public void setImageURl(String ImageURl){
        this.ImageURl = ImageURl;
    }
    public String getImageURl(){
        return this.ImageURl;
    }
    public void setBgColor(String BgColor){
        this.BgColor = BgColor;
    }
    public String getBgColor(){
        return this.BgColor;
    }
    public void setWjBgColor(String WjBgColor){
        this.WjBgColor = WjBgColor;
    }
    public String getWjBgColor(){
        return this.WjBgColor;
    }
    public void setBgImageURl(String BgImageURl){
        this.BgImageURl = BgImageURl;
    }
    public String getBgImageURl(){
        return this.BgImageURl;
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
