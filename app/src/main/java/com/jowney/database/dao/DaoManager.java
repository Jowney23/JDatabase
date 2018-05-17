package com.jowney.database.dao;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.jowney.database.bean.Student;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;
import java.io.IOException;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/5/13/20:18
 * Description:
 */

public class DaoManager {
    private static final String DB_NAME = "jDatabase.db";//数据库名称
    private static DaoManager mDaoManager;
    private DaoManager.MySQLiteOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private Context context;
    private boolean encrypt = false;//数据库加密，默认不加密
    private String password =null;
    public DaoManager(Context context) {
        this.context = context;
    }

    /**
     * 使用单例模式获得操作数据库的对象
     *
     * @return
     */
    public static DaoManager getInstance(Context context) {
        if (mDaoManager == null) {
            synchronized (DaoManager.class) {
                if (mDaoManager == null) {
                    mDaoManager = new DaoManager(context);
                }
            }
        }
        return mDaoManager;
    }

    /**
     * 获取DaoSession
     *
     * @return
     */
    public synchronized DaoSession getDaoSession() {
        if (null == mDaoSession) {
            mDaoSession = getDaoMaster().newSession();
        }
        return mDaoSession;
    }

    /**
     * 设置debug模式开启或关闭，默认关闭
     *
     * @param flag
     */
    public  void setDebug(boolean flag) {
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }

    /**
     *将标志位设为true
     */
    public void encryptDatabase(String password) {
        this.encrypt = true;
        this.password = password;
    }

    /**
     * 关闭数据库
     */
    public synchronized void closeDataBase() {
        closeHelper();
        closeDaoSession();
    }

    /**
     * 判断数据库是否存在，如果不存在则创建
     *
     * @return
     */
    private DaoMaster getDaoMaster() {
        if (null == mDaoMaster) {
            // mHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
            mHelper = new DaoManager.MySQLiteOpenHelper(new DaoManager.GreenDaoContext(context), DB_NAME, null);
            if (encrypt){
                mDaoMaster = new DaoMaster(mHelper.getEncryptedWritableDb(password));
            }else {
                mDaoMaster = new DaoMaster(mHelper.getWritableDb());
            }
        }
        return mDaoMaster;
    }

    private void closeDaoSession() {
        if (null != mDaoSession) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    private void closeHelper() {
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
    }

    public static class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
        public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

                @Override
                public void onCreateAllTables(Database db, boolean ifNotExists) {
                    DaoMaster.createAllTables(db, ifNotExists);
                }

                @Override
                public void onDropAllTables(Database db, boolean ifExists) {
                    DaoMaster.dropAllTables(db, ifExists);
                }
            }, StudentDao.class);
        }
    }
    public static class GreenDaoContext  extends ContextWrapper {

        private String currentUserId = "greendao";//一般用来针对一个用户一个数据库，以免数据混乱问题
        private Context mContext;

        public GreenDaoContext(Context context) {
            super(context);
            this.mContext = context;
        }

        /**
         * 获得数据库路径，如果不存在，则创建对象
         *
         * @param dbName
         */
        @Override
        public File getDatabasePath(String dbName) {
            String dbDir = Environment.getExternalStorageDirectory().getPath();
            if (TextUtils.isEmpty(dbDir)){
                Log.e("SD卡管理：", "SD卡不存在，请加载SD卡");
                return null;
            }
            File baseFile = new File(dbDir);
            // 目录不存在则自动创建目录
            if (!baseFile.exists()){
                baseFile.mkdirs();
            }
            StringBuffer buffer = new StringBuffer();
            buffer.append(baseFile.getPath());
            buffer.append(File.separator);
            buffer.append(currentUserId);
            dbDir = buffer.toString();// 数据库所在目录
            buffer.append(File.separator);
//        buffer.append(dbName+"_"+currentUserId);//也可以采用此种方式，将用户id与表名联系到一块命名
            buffer.append(dbName);
            String dbPath = buffer.toString();// 数据库路径
            // 判断目录是否存在，不存在则创建该目录
            File dirFile = new File(dbDir);
            if (!dirFile.exists()){
                dirFile.mkdirs();
            }
            // 数据库文件是否创建成功
            boolean isFileCreateSuccess = false;
            // 判断文件是否存在，不存在则创建该文件
            File dbFile = new File(dbPath);
            if (!dbFile.exists()) {
                try {
                    isFileCreateSuccess = dbFile.createNewFile();// 创建文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else
                isFileCreateSuccess = true;
            // 返回数据库文件对象
            if (isFileCreateSuccess)
                return dbFile;
            else
                return super.getDatabasePath(dbName);
        }

        /**
         * 重载这个方法，是用来打开SD卡上的数据库的，android 2.3及以下会调用这个方法。
         *
         * @param name
         * @param mode
         * @param factory
         */
        @Override
        public SQLiteDatabase openOrCreateDatabase(String name, int mode,SQLiteDatabase.CursorFactory factory) {
            SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
            return result;
        }

        /**
         * Android 4.0会调用此方法获取数据库。
         *
         * @param name
         * @param mode
         * @param factory
         * @param errorHandler
         * @see android.content.ContextWrapper#openOrCreateDatabase(java.lang.String, int,
         * android.database.sqlite.SQLiteDatabase.CursorFactory,
         * android.database.DatabaseErrorHandler)
         */
        @Override
        public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory,DatabaseErrorHandler errorHandler) {
            SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);

            return result;
        }

    }

}
