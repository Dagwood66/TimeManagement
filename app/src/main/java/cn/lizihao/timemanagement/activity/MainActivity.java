package cn.lizihao.timemanagement.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.lizihao.timemanagement.R;

/**
 * by 2016-11-21 18:47
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_btn_time_details, R.id.main_btn_todo_list})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_time_details:
                startActivity(new Intent(this,TimeCollectActivity.class));
                break;
            case R.id.main_btn_todo_list:
                startActivity(new Intent(this,ToDoListActivity.class));
                break;
        }
    }
}
