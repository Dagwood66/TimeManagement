package cn.lizihao.timemanagement.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.lizihao.timemanagement.R;
import cn.lizihao.timemanagement.adapter.CategoryAdapter;
import cn.lizihao.timemanagement.db.DBUtils;
import cn.lizihao.timemanagement.utils.LogUtils;
import cn.lizihao.timemanagement.utils.StringUtils;
import cn.lizihao.timemanagement.utils.TimeUtils;

/**
 * by 2016-11-28 17:36
 */
public class TimeCollectFragment extends Fragment {
    private static final String TAG = TimeCollectFragment.class.getName();
    @BindView(R.id.main_tv_start_time)
    TextView mMainTvStartTime;
    @BindView(R.id.main_sn_category)
    Spinner mMainSnCategory;
    @BindView(R.id.main_et_append_category)
    EditText mMainEtAppendCategory;
    @BindView(R.id.main_btn_append_category)
    Button mMainBtnAppendCategory;
    @BindView(R.id.main_acet_title)
    AutoCompleteTextView mMainAcetTitle;
    @BindView(R.id.main_et_details)
    EditText mMainEtDetails;
    @BindView(R.id.main_btn_commit)
    Button mMainBtnCommit;
    private Activity mActivity;
    private DBUtils mDBUtils = DBUtils.getInstance();
    private ArrayList<String> mCategory = new ArrayList<>();
    private String mSelectCategory = "";
    private CategoryAdapter mCategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_time_collect, container, false);
        ButterKnife.bind(this, view);
        LogUtils.i(TAG, "TimeCollectActivity-->onCreate-->" + LogUtils.getLineNumber(),
                "", "");
        mMainTvStartTime.setText(mDBUtils.getStartTime());
        //TODO 标题候选
//        mMainAcetTitle.setAdapter();
        initCategory();
        return view;
    }

    private void initCategory() {
        mDBUtils.getCategory(mCategory);
        LogUtils.i(TAG, "TimeCollectFragment-->initCategory-->" + LogUtils.getLineNumber(),
                "", mActivity + "");
        mCategoryAdapter = new CategoryAdapter(mActivity, mCategory);
        mMainSnCategory.setAdapter(mCategoryAdapter);
        mMainSnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectCategory = mCategory.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick({R.id.main_btn_append_category, R.id.main_btn_commit})
    public void onClick(View view) {
        LogUtils.i(TAG, "TimeCollectActivity-->onClick-->" + LogUtils.getLineNumber(),
                "", "");
        switch (view.getId()) {
            case R.id.main_btn_append_category:
                String category = mMainEtAppendCategory.getText().toString();
                if (!StringUtils.isNull(category)) {
                    mDBUtils.insertCategory(mMainEtAppendCategory.getText().toString());
                    mMainEtAppendCategory.setText("");
                    mDBUtils.getCategory(mCategory);
                    mCategoryAdapter.notifyDataSetChanged();
                    mMainSnCategory.setSelection(mCategory.size());
                }
                break;
            case R.id.main_btn_commit:
                String title = mMainAcetTitle.getText().toString();
                String details = mMainEtDetails.getText().toString();
                if (!StringUtils.isNull(title)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        mDBUtils.insert(
                                TimeUtils.parse(TimeUtils.FORMAT1, mMainTvStartTime.getText().toString()),
                                currentTimeMillis,
                                mSelectCategory,
                                title,
                                details
                        );
                        LogUtils.i(TAG, "TimeCollectActivity-->onClick-->" + LogUtils.getLineNumber(),
                                "全部记录", mDBUtils.getTimeDetailsTableAll());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    mMainAcetTitle.setText("");
                    mMainEtDetails.setText("");
                    mMainTvStartTime.setText(mDBUtils.getStartTime());
                }
                break;
        }
    }
}
