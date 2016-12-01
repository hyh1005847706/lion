package com.edu.feicui.fragment_add_replace;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/11/26.
 */
public class VolleyUtils {
    private Context context;
    private static RequestQueue requestQueue;

    public VolleyUtils(Context context){
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void sendImageRequest(String path, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener){

    }

    public void sendStringRequest(String path, Response.Listener<String> listener, Response.ErrorListener errorListener){
        Request request = new StringRequest(path, listener, errorListener);
        requestQueue.add(request);
    }

    public void sendImageLoader(String path,ImageView imageView){
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView,R.drawable.bb,R.drawable.aa);

    }
}
