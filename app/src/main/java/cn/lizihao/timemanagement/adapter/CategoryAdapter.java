package cn.lizihao.timemanagement.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.lizihao.timemanagement.R;

/**
 * by 2016-11-17 14:35
 */
public class CategoryAdapter extends MyBaseAdapter<String> {
    public CategoryAdapter(Activity activity, List<String> dates) {
        super(activity, dates);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mActivity).inflate(R.layout.item_category, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mItemCategoryTvShow.setText(mDates.get(position));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.item_category_tv_show)
        TextView mItemCategoryTvShow;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
