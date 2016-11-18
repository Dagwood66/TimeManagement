package cn.lizihao.timemanagement.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * by 2016-11-09 11:58
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {

    public Activity mActivity;
    public List<T> mDates;

    public MyBaseAdapter(Activity activity, List<T> dates) {
        mActivity = activity;
        mDates = dates;
    }

    @Override
    public int getCount() {
        return mDates == null ? 0 : mDates.size();
    }

    @Override
    public Object getItem(int position) {
        return mDates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
