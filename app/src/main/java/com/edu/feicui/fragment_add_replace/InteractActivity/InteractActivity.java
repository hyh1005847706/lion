package com.edu.feicui.fragment_add_replace.InteractActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.edu.feicui.fragment_add_replace.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class InteractActivity extends AppCompatActivity implements InteractFragment.NewsTitleChangeListener{
    private Button btnShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interact);
        btnShow = (Button) findViewById(R.id.btn_show);

        FragmentManager fm = getSupportFragmentManager();
        InteractFragment fragment = new InteractFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl_container,fragment);
        ft.commit();
    }

    @Override
    public void changeTitle(String title) {
        btnShow.setText(title);
    }
}
