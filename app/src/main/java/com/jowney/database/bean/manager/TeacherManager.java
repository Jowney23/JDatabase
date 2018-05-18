package com.jowney.database.bean.manager;

import com.jowney.database.bean.Teacher;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by Jowney on 2018/5/18.
 */

public class TeacherManager extends BaseBeanManager<Teacher,Long> {
    public TeacherManager(AbstractDao dao) {
        super(dao);
    }
}
