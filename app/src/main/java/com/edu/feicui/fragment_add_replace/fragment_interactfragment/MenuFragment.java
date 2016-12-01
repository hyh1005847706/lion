package com.edu.feicui.fragment_add_replace.fragment_interactfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.edu.feicui.fragment_add_replace.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016/11/26.
 */
public class MenuFragment extends Fragment {
    private Button btnFirstWoman;
    private Button btnSecondWoman;
    private Button btnThirdWoman;
    private Button btnFouthWoman;

    public interface  ChangeWomanListener {
        public void display(String name, String path);
    }

    private ChangeWomanListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (ChangeWomanListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        btnFirstWoman = (Button) view.findViewById(R.id.btn_first_woman);
        btnSecondWoman = (Button) view.findViewById(R.id.btn_second_woman);
        btnThirdWoman = (Button) view.findViewById(R.id.btn_third_woman);
        btnFouthWoman = (Button) view.findViewById(R.id.btn_forth_woman);

        btnFirstWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageEvent event = new MessageEvent("貂蝉","http://p1.so.qhmsg.com/sdr/512_768_/t0145202376a6fe3b96.jpg");
                EventBus.getDefault().post(event);
//                listener.display("貂蝉","http://p1.so.qhmsg.com/sdr/512_768_/t0145202376a6fe3b96.jpg");
            }
        });
        btnSecondWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageEvent event = new MessageEvent("王昭君","http://p3.so.qhmsg.com/sdr/460_768_/t01b5f730b2134e1a83.jpg");
                EventBus.getDefault().post(event);
//                listener.display("王昭君","http://p3.so.qhmsg.com/sdr/460_768_/t01b5f730b2134e1a83.jpg");
            }
        });
        btnThirdWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageEvent event = new MessageEvent("西施","http://p4.so.qhmsg.com/sdr/519_768_/t01a29556262adb756e.jpg");
                EventBus.getDefault().post(event);
//                listener.display("西施","http://p4.so.qhmsg.com/sdr/519_768_/t01a29556262adb756e.jpg");
            }
        });
        btnFouthWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageEvent event = new MessageEvent("杨玉环","http://p2.so.qhmsg.com/sdr/512_768_/t01f6487e626f7082bc.jpg");
                EventBus.getDefault().post(event);
//                listener.display("杨玉环","http://p2.so.qhmsg.com/sdr/512_768_/t01f6487e626f7082bc.jpg");
            }
        });

        return view;
    }


}
