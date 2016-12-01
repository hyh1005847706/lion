package com.edu.feicui.fragment_add_replace;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
public class ImageAdapter extends BaseAdapter{
    private List<User> list;
    private Context context;
    private LayoutInflater inflater;
    private VolleyUtils volleyUtils;

    public ImageAdapter(Context context,List<User> list){
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        volleyUtils = new VolleyUtils(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.grid_view_item,null);
            holder = new ViewHolder();
            holder.ivImage = (ImageView) view.findViewById(R.id.imageView);
            holder.tvName = (TextView) view.findViewById(R.id.textView);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        User user = list.get(i);
        holder.tvName.setText(user.getName());
        final  ImageView imageView = holder.ivImage;
        volleyUtils.sendImageRequest(user.getImg(), new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }
        );
        return null;
    }

    class ViewHolder{
        ImageView ivImage;
        TextView tvName;
    }
}
