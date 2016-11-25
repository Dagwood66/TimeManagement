package cn.lizihao.timemanagement.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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

public class TimeCollectActivity extends AppCompatActivity {
    private static final String TAG = TimeCollectActivity.class.getName();
    @BindView(R.id.main_tv_start_time)
    TextView mMainTvStartTime;
    @BindView(R.id.main_sn_category)
    Spinner mMainSnCategory;
    @BindView(R.id.main_et_title)
    EditText mMainEtTitle;
    @BindView(R.id.main_et_details)
    EditText mMainEtDetails;
    @BindView(R.id.main_et_append_category)
    EditText mMainEtAppendCategory;
    private Activity mActivity = this;
    private DBUtils mDBUtils = DBUtils.getInstance();
    private ArrayList<String> mCategory = new ArrayList<>();
    private String mSelectCategory = "";
    private CategoryAdapter mCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_collect);
        ButterKnife.bind(this);
        LogUtils.i(TAG, "TimeCollectActivity-->onCreate-->" + LogUtils.getLineNumber(),
                "", "");
        mMainTvStartTime.setText(mDBUtils.getStartTime());
        //TODO 标题候选
        initCategory();
    }

    private void initCategory() {
        mDBUtils.getCategory(mCategory);
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
                String title = mMainEtTitle.getText().toString();
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
                    mMainEtTitle.setText("");
                    mMainEtDetails.setText("");
                    mMainTvStartTime.setText(mDBUtils.getStartTime());
                }
                break;
        }
    }
}
