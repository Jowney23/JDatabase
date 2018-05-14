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
    private Long Id;
    private String name;
    private int age;
    private String department;
    @Generated(hash = 68013477)
    public Student(Long Id, String name, int age, String department) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

}
