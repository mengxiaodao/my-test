package org.andy.shop.model;

import java.util.Date;

/**
 * Created by mengchuang on 2018/10/21
 **/
public class SysUser {
    private Long id;//用户id
    private String userName; // 用户名
    private String passWord; // 密码
    private String name;//真实姓名
    private Date createTime; // 创建时间
    private String is_deleted; // 用户电话

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }
}
