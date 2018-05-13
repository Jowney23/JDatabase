package com.jowney.database.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jowney.database.bean.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Integer> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "Id", true, "ID");
        public final static Property UserName = new Property(1, String.class, "UserName", false, "USER_NAME");
        public final static Property PassWord = new Property(2, String.class, "PassWord", false, "PASS_WORD");
        public final static Property RealName = new Property(3, String.class, "RealName", false, "REAL_NAME");
        public final static Property Mobile = new Property(4, String.class, "Mobile", false, "MOBILE");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"ID\" INTEGER PRIMARY KEY NOT NULL ," + // 0: Id
                "\"USER_NAME\" TEXT," + // 1: UserName
                "\"PASS_WORD\" TEXT," + // 2: PassWord
                "\"REAL_NAME\" TEXT," + // 3: RealName
                "\"MOBILE\" TEXT);"); // 4: Mobile
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String UserName = entity.getUserName();
        if (UserName != null) {
            stmt.bindString(2, UserName);
        }
 
        String PassWord = entity.getPassWord();
        if (PassWord != null) {
            stmt.bindString(3, PassWord);
        }
 
        String RealName = entity.getRealName();
        if (RealName != null) {
            stmt.bindString(4, RealName);
        }
 
        String Mobile = entity.getMobile();
        if (Mobile != null) {
            stmt.bindString(5, Mobile);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String UserName = entity.getUserName();
        if (UserName != null) {
            stmt.bindString(2, UserName);
        }
 
        String PassWord = entity.getPassWord();
        if (PassWord != null) {
            stmt.bindString(3, PassWord);
        }
 
        String RealName = entity.getRealName();
        if (RealName != null) {
            stmt.bindString(4, RealName);
        }
 
        String Mobile = entity.getMobile();
        if (Mobile != null) {
            stmt.bindString(5, Mobile);
        }
    }

    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.getInt(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.getInt(offset + 0), // Id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // UserName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // PassWord
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // RealName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // Mobile
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setUserName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPassWord(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRealName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMobile(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Integer updateKeyAfterInsert(User entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public Integer getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}