package com.jowney.database.bean.manager;

import com.jowney.database.bean.Student;

import org.greenrobot.greendao.AbstractDao;


/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/5/13/21:27
 * Description:
 */

public class StudentManager extends BaseBeanManager<Student, Long> {
    public StudentManager(AbstractDao dao) {
        super(dao);
    }
}
