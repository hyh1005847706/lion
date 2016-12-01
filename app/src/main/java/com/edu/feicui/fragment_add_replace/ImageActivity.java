package com.edu.feicui.fragment_add_replace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
public class ImageActivity extends AppCompatActivity {
    private VolleyUtils volleyUtils;
    private GridView gridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    private void sendRequest(){
        volleyUtils.sendStringRequest("http://10.0.0.86:8080/users/user?method=getAll",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Gson gson = new Gson();
                        List<User> list = gson.fromJson(s, new TypeToken<List<User>>(){}.getType());
                        ImageAdapter adapter = new ImageAdapter(ImageActivity.this,list);
                        gridView.setAdapter(adapter);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(ImageActivity.this, "网络异常，访问失败", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
