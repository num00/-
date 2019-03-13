package com.bawei.day02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * @Author：魏恒炜
 * @E-mail：
 * @Date：2019/3/13 19:24
 * @Description：描述信息
 */
public class ListBean extends BaseAdapter {
    private ArrayList<Json01.data> list;
    private Context context;

    public ListBean(ArrayList<Json01.data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null){

            convertView = View.inflate(context,R.layout.show01,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.image01);
            viewHolder.textView  = convertView.findViewById(R.id.text01);
            convertView.setTag(viewHolder);
        }else {
             viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getClass_name());
        Glide.with(context).load(list.get(position).getBook_cover()).into(viewHolder.imageView);
        return convertView;
    }
   class ViewHolder{
        ImageView imageView;
        TextView textView;
   }
}
