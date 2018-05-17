package com.jowney.database.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/5/13/21:23
 * Description:
 */
@Entity
public class Student {
    @Id
    private String Id;
    private String name;
    private Integer age;
    private String department;
    private String gender;


    @Generated(hash = 954656573)
    public Student(String Id, String name, Integer age, String department, String gender) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.gender = gender;
    }


    @Generated(hash = 1556870573)
    public Student() {
    }

  
    @Override
    public String toString() {
        return "ID:" + Id + "   name:" + name +"   age:"+age + "   department:" + department + "   gender:" + gender;
    }
/*
    @Override
    public String toString() {
        return "ID:" + Id + "   name:" + name + "   department:" + department + "   gender:" + gender;
    }*/


    public String getId() {
        return this.Id;
    }


    public void setId(String Id) {
        this.Id = Id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return this.age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public String getDepartment() {
        return this.department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getGender() {
        return this.gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

}
