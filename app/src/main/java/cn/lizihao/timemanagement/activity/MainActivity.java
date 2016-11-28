package cn.lizihao.timemanagement.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.lizihao.timemanagement.R;
import cn.lizihao.timemanagement.adapter.ViewPagerAdapter;
import cn.lizihao.timemanagement.fragment.TimeCollectFragment;
import cn.lizihao.timemanagement.fragment.ToDoListFragment;

/**
 * by 2016-11-21 18:47
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.main_vp)
    ViewPager mMainVp;
    @BindView(R.id.main_btn_time_details)
    Button mMainBtnTimeDetails;
    @BindView(R.id.main_btn_todo_list)
    Button mMainBtnTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TimeCollectFragment());
        fragments.add(new ToDoListFragment());
        mMainVp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        mMainVp.setCurrentItem(0);
        mMainVp.addOnPageChangeListener(new MainOnPageChangeListener());
    }

    @OnClick({R.id.main_btn_time_details, R.id.main_btn_todo_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_time_details:
                mMainVp.setCurrentItem(0);
                break;
            case R.id.main_btn_todo_list:
                mMainVp.setCurrentItem(1);
                break;
        }
    }

    class MainOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //TODO 选项卡优化
            mMainBtnTimeDetails.setTextColor(Color.parseColor("#000000"));
            mMainBtnTodoList.setTextColor(Color.parseColor("#000000"));
            switch (position) {
                case 0:
                    mMainBtnTimeDetails.setTextColor(Color.parseColor("#00FF7F"));
                    break;
                case 1:
                    mMainBtnTodoList.setTextColor(Color.parseColor("#00FF7F"));
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
