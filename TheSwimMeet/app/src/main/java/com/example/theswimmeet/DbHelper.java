package com.example.theswimmeet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final String DATABASE_NAME="database.db";
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_SWIMMER="_swimmer";
    private static final  String KEY_ID="id";
    private static final  String KEY_EVENT="event";
    private static final  String KEY_BEST="best";
    private static final  String KEY_GOAL="goal";

    public DbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String Query_Table=" CREATE TABLE " +TABLE_SWIMMER+ "("
                +KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +KEY_EVENT+ " TEXT, " +KEY_BEST+ " TEXT, " +KEY_GOAL+ " TEXT);";
        db.execSQL(Query_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_SWIMMER);
        onCreate(db);

    }

    public long insertStudent(String event, String best, String goal) {
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_EVENT,event);
        values.put(KEY_BEST,best);
        values.put(KEY_GOAL,goal);
        return db.insert(TABLE_SWIMMER,null,values);
    }

    public String getData() {
        db=this.getReadableDatabase();
        String[] columns=new String[] {KEY_ID,KEY_EVENT,KEY_BEST,KEY_GOAL};
        Cursor cursor=db.query(TABLE_SWIMMER,columns,null,null,null,null,null);

        int iId= cursor.getColumnIndex(KEY_ID);
        int iName= cursor.getColumnIndex(KEY_EVENT);
        int iEmail= cursor.getColumnIndex(KEY_BEST);
        int iMobile= cursor.getColumnIndex(KEY_GOAL);
        String result="";

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            result=result+
                    "Id: "+cursor.getString(iId)+ "\n"+
                    "Event: " +cursor.getString(iName)+"\n"+
                    "Best Time: " +cursor.getString(iEmail)+ "\n"+
                    "Goal Time: "+cursor.getString(iMobile)+ "\n\n";
        }
        db.close();
        return result;
    }

    public void deleteStudent(long l) {
        db=this.getWritableDatabase();
        db.delete(TABLE_SWIMMER,KEY_ID+"="+l,null);
    }

    public void updateStudent(long l, String event, String best, String goal) {
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_EVENT,event);
        values.put(KEY_BEST,best);
        values.put(KEY_GOAL,goal);
        db.update(TABLE_SWIMMER,values,KEY_ID+"="+l,null);
        db.close();
    }

    public String getName(long l1) {
        db=this.getReadableDatabase();
        String[] columns=new String[]{KEY_ID,KEY_EVENT,KEY_BEST,KEY_GOAL};
        Cursor cursor=db.query(TABLE_SWIMMER,columns,KEY_ID+"="+l1,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
            String name=cursor.getString(1);
            return name;
        }
        return null;
    }

    public String getEmail(long l1) {
        db=this.getReadableDatabase();
        String[] columns=new String[]{KEY_ID,KEY_EVENT,KEY_BEST,KEY_GOAL};
        Cursor cursor=db.query(TABLE_SWIMMER,columns,KEY_ID+"="+l1,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
            String name=cursor.getString(2);
            return name;
        }
        return null;
    }

    public String getMobile(long l1) {
        db=this.getReadableDatabase();
        String[] columns=new String[]{KEY_ID,KEY_EVENT,KEY_BEST,KEY_GOAL};
        Cursor cursor=db.query(TABLE_SWIMMER,columns,KEY_ID+"="+l1,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
            String name=cursor.getString(3);
            return name;
        }
        return null;
    }
}


