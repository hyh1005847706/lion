package com.edu.feicui.fragment_add_replace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/25.
 */
public class VolleyActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnLogin2;

    private RequestQueue requestQueue;
    private RequestQueue requestQueue2;
    private static final String url = "http://10.0.1.16:8080/GourmetOrderServer/loginServlet";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        etPassword = (EditText) findViewById(R.id.et_password);
        etUsername = (EditText) findViewById(R.id.et_username);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin2 = (Button) findViewById(R.id.btn_login2);

        requestQueue = Volley.newRequestQueue(this);
        requestQueue2 = Volley.newRequestQueue(this);

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username2 = etUsername.getText().toString();
                final String password2 = etPassword.getText().toString();
                String path = "http://10.0.0.86:8080/users/user";

                if(!CommonUtils.isConnect(VolleyActivity.this)){
                    Toast.makeText(VolleyActivity.this,"当前网络出现异常",Toast.LENGTH_SHORT).show();
                    return;
                }

                StringRequest request2 = new StringRequest(Request.Method.POST,path,listener,errorListener){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("method", "login");
                        params.put("username", username2);
                        params.put("password", password2);
                        return params;
                    }
                };

                requestQueue2.add(request2);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String path = url + "?category=user&name=" + username + "&paw=" + password;
                //2.创建一个请求
                StringRequest request = new StringRequest(path,
                        new Response.Listener<String>() {//当请求成功是，回调此接口
                            @Override
                            public void onResponse(String s) {
                                try {
                                    JSONObject jsonObject = new JSONObject(s);
                                    String resultCode = jsonObject.getString("rt");
                                    String resultMessage = jsonObject.getString("rtmsg");
                                    if ("200".equals(resultCode)) {
                                        Toast.makeText(VolleyActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(VolleyActivity.this, resultMessage, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Toast.makeText(VolleyActivity.this, "访问数据出现异常，请重试", Toast.LENGTH_SHORT).show();
                            }
                        });

                //3.此时只需要讲该请求添加至请求队列中即可
                requestQueue.add(request);
                }
        });

    }

    private Response.Listener<String> listener = new Response.Listener<String>() {
        @Override
        public void onResponse(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);
                boolean isOK = jsonObject.getBoolean("isok");
                if(isOK){
                    Toast.makeText(VolleyActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(VolleyActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Toast.makeText(VolleyActivity.this, "访问数据出现异常，请重试", Toast.LENGTH_SHORT).show();
        }
    };
}
