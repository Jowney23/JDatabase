package com.jowney.database.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/5/13/13:59
 * Description:
 */
@Entity
public class User {
    @Id
    private int Id;
    private String UserName;
    private String PassWord;
    private String RealName;
    private String Mobile;
    @Generated(hash = 1553943604)
    public User(int Id, String UserName, String PassWord, String RealName,
            String Mobile) {
        this.Id = Id;
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.RealName = RealName;
        this.Mobile = Mobile;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public int getId() {
        return this.Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getUserName() {
        return this.UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getPassWord() {
        return this.PassWord;
    }
    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
    public String getRealName() {
        return this.RealName;
    }
    public void setRealName(String RealName) {
        this.RealName = RealName;
    }
    public String getMobile() {
        return this.Mobile;
    }
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }
}
