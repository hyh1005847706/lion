package com.edu.feicui.fragment_add_replace.InteractActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.edu.feicui.fragment_add_replace.R;

/**
 * Created by Administrator on 2016/11/26.
 */
public class InteractFragment extends Fragment {
    private Button btnNews;
    private Button btnTels;

    public interface NewsTitleChangeListener{
        public void changeTitle(String title);
    }

    private NewsTitleChangeListener newsTitleChangeListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        newsTitleChangeListener = (NewsTitleChangeListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interact,container,false);
        btnNews = (Button) view.findViewById(R.id.btn_news);
        btnTels = (Button) view.findViewById(R.id.btn_tel);
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsTitleChangeListener.changeTitle("新闻");
            }
        });

        btnTels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsTitleChangeListener.changeTitle("科技");
            }
        });
        return view;
    }


}
