package com.jowney.database.bean.manager;

import com.jowney.database.MyApp;
import com.jowney.database.dao.DaoManager;

/**
 * Created by Jowney on 2018/5/14.
 */

public class ManagerFactory {
    /**
     * 每一个BeanManager都管理着数据库中的一个表，我将这些管理者在ManagerFactory中进行统一管理
     */
    StudentManager studentManager;

    TeacherManager teacherManager;

    private static ManagerFactory mInstance = null;

        /**
         * 获取DaoFactory的实例
         *
         * @return
         */
        public static ManagerFactory getInstance() {
            if (mInstance == null) {
                synchronized (ManagerFactory.class) {
                    if (mInstance == null) {
                        mInstance = new ManagerFactory();
                    }
                }
            }
            return mInstance;
        }

    public synchronized StudentManager getStudentManager() {
            if (studentManager == null){
              studentManager = new StudentManager(DaoManager.getInstance(MyApp.getContext()).getDaoSession().getStudentDao());
            }
        return studentManager;
    }

    public synchronized TeacherManager getTeacherManager(){
            if (teacherManager == null){
                teacherManager = new TeacherManager(DaoManager.getInstance(MyApp.getContext()).getDaoSession().getTeacherDao());
            }
            return teacherManager;
    }
}
