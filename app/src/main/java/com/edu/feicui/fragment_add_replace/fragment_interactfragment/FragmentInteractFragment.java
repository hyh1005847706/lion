package com.edu.feicui.fragment_add_replace.fragment_interactfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.edu.feicui.fragment_add_replace.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2016/11/26.
 */
public class FragmentInteractFragment extends AppCompatActivity implements MenuFragment.ChangeWomanListener {
    private Button btnShow;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_interact_frag);
        btnShow = (Button) findViewById(R.id.btn_show);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        btnShow.setText("EventBus" + messageEvent.getName());
    }

    @Override
    public void display(String name, String path) {
        //显示标题
        btnShow.setText(name);
        //通过查找fragment，找到contentFragment，调用displayImage方法
        FragmentManager fm = getSupportFragmentManager();
        ContentFragment fragment = (ContentFragment) fm.findFragmentById(R.id.fragment_content);
        fragment.setDisplayImage(path);
    }
}
