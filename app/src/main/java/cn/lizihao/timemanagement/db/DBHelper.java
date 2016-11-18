package cn.lizihao.timemanagement.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String timeDetailsTable = "create table TimeDetailsTable(" +
                "_id integer primary key autoincrement," +
                "startTime Text," +
                "endTime Text," +
                "category Text," +
                "title Text," +
                "details Text" +
                ")";
        sqLiteDatabase.execSQL(timeDetailsTable);
        String CategoryTable = "create table CategoryTable(" +
                "_id integer primary key autoincrement," +
                "category Text" +
                ")";
        sqLiteDatabase.execSQL(CategoryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
