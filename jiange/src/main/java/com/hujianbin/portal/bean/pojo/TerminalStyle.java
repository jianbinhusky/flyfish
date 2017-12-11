package com.hujianbin.portal.bean.pojo;

/**
 * Created by hujb4 on 2016/5/19.
 */
public class TerminalStyle {
    private PC PC;

    private Phone Phone;

    public void setPC(PC PC){
        this.PC = PC;
    }
    public PC getPC(){
        return this.PC;
    }
    public void setPhone(Phone Phone){
        this.Phone = Phone;
    }
    public Phone getPhone(){
        return this.Phone;
    }

}
