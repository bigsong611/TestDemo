package com.bigsong.testdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigsong.testdemo.R;
import com.bigsong.testdemo.bean.NewBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class NewsListViewAdapter extends BaseAdapter {

    private List<NewBean> newBeans;
    private LayoutInflater inflater;

    public NewsListViewAdapter( Context context,List<NewBean> newBeans) {
        this.inflater = LayoutInflater.from(context);
        this.newBeans = newBeans;
    }

    @Override
    public int getCount() {
        return newBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return newBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item_news,null);
            holder = new ViewHolder();
            holder.itemImg = (ImageView) convertView.findViewById(R.id.itemimg);
            holder.itemName = (TextView) convertView.findViewById(R.id.itemname);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemImg.setImageResource(R.mipmap.ic_launcher);
        holder.itemName.setText(newBeans.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        ImageView itemImg;
        TextView itemName;
    }
}
