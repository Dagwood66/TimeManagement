package cn.lizihao.timemanagement.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.lizihao.timemanagement.bean.client.TimeDetailsTable;
import cn.lizihao.timemanagement.utils.TimeUtils;
import cn.lizihao.timemanagement.utils.UIUtils;


/**
 * 数据库操作类
 */
public class DBUtils {
    private static final String TAG = DBUtils.class.getName();
    private static DBUtils dbUtils = new DBUtils();
    private SQLiteDatabase mWritableDatabase;

    private DBUtils() {
        DBHelper dbHelper = new DBHelper(UIUtils.getContext(), "db", null, 1);
        mWritableDatabase = dbHelper.getWritableDatabase();
    }


    public static DBUtils getInstance() {
        return dbUtils;
    }


    public void getCategory(List<String> category) {
        category.clear();
        Cursor cursor = mWritableDatabase.rawQuery("select * from CategoryTable", new String[]{});
        while (cursor.moveToNext()) {
            category.add(getString(cursor, "category"));
        }
        cursor.close();
    }

    public void insert(long startTime, long endTime, String category, String title, String details) {
        mWritableDatabase.execSQL("insert into TimeDetailsTable(startTime,endTime,category,title,details) values(?,?,?,?,?)", new Object[]{
                startTime, endTime, category, title, details
        });
    }

    public void insertCategory(String category) {
        mWritableDatabase.execSQL("insert into CategoryTable(category) values(?)", new Object[]{category});
    }

    private int getInt(Cursor cursor, String name) {
        return cursor.getInt(cursor.getColumnIndex(name));
    }

    private String getString(Cursor cursor, String name) {
        return cursor.getString(cursor.getColumnIndex(name));
    }

    private long getLong(Cursor cursor, String name) {
        String string = cursor.getString(cursor.getColumnIndex(name));
        return Long.parseLong(string);
    }


    private boolean getBoolean(Cursor cursor, String name) {
        String string = cursor.getString(cursor.getColumnIndex(name));
        return Integer.parseInt(string) == 1;
    }

    private double getDouble(Cursor cursor, String name) {
        String string = cursor.getString(cursor.getColumnIndex(name));
        return Double.parseDouble(string);
    }

    public String getStartTime() {
        String startTime;
        Cursor cursor = mWritableDatabase.rawQuery("select * from TimeDetailsTable order by _id DESC", new String[]{});
        List<TimeDetailsTable> timeDetailsTables = getTimeDetailsTable(cursor);
        if (timeDetailsTables.size() > 0) {
            TimeDetailsTable timeDetailsTable = timeDetailsTables.get(0);
            startTime = TimeUtils.getTimeFormat(Long.parseLong(timeDetailsTable.getEndTime()), TimeUtils.FORMAT1);
        } else {
            startTime = TimeUtils.getTimeFormat(System.currentTimeMillis(), TimeUtils.FORMAT1);
        }
        return startTime;
    }

    public List<TimeDetailsTable> getTimeDetailsTableAll() {
        Cursor cursor = mWritableDatabase.rawQuery("select * from TimeDetailsTable", new String[]{});
        return getTimeDetailsTable(cursor);
    }


    private List<TimeDetailsTable> getTimeDetailsTable(Cursor cursor) {
        return getTimeDetailsTable(cursor, null);
    }

    private List<TimeDetailsTable> getTimeDetailsTable(Cursor cursor, List<TimeDetailsTable> timeDetailsTables) {
        if (timeDetailsTables == null) {
            timeDetailsTables = new ArrayList<>();
        }
        if (cursor != null) {
            timeDetailsTables.clear();
            while (cursor.moveToNext()) {
                TimeDetailsTable timeDetailsTable = new TimeDetailsTable();
                timeDetailsTable.setId(getInt(cursor, "_id"));
                timeDetailsTable.setCategory(getString(cursor, "category"));
                timeDetailsTable.setDetails(getString(cursor, "details"));
                timeDetailsTable.setEndTime(getString(cursor, "endTime"));
                timeDetailsTable.setStartTime(getString(cursor, "startTime"));
                timeDetailsTable.setTitle(getString(cursor, "title"));
                timeDetailsTables.add(timeDetailsTable);
            }
            cursor.close();
        }
        return timeDetailsTables;

    }

}
