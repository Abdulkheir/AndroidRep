/*package com.example.zanzibar;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


    //CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

    public class CustomAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<ClipData.Item> data;//modify here

        public CustomAdapter(Context mContext, ArrayList<ClipData.Item> data) {
            this.mContext = mContext;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();// # of items in your arraylist
        }
        @Override
        public Object getItem(int position) {
            return data.get(position);// get the actual item
        }
        @Override
        public long getItemId(int id) {
            return id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(R.layout.item_layout, parent,false);//modify here
                viewHolder = new ViewHolder();
                //modify this block of code
                viewHolder.name = (TextView) convertView.findViewById(R.id.edit_regname);
                viewHolder.tvemail = (TextView) convertView.findViewById(R.id.tvemail);
                viewHolder.tvamount = (TextView) convertView.findViewById(R.id.tvamount);
                viewHolder.imageView=(ImageView) convertView.findViewById(R.id.imageView);
                //Up to here
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //MODIFY THIS BLOCK OF CODE
            ClipData.Item person = data.get(position);//modify here
            viewHolder.tvnames.setText(person.getNames());//modify here
            viewHolder.tvemail.setText(person.getEmail());//modify here
            viewHolder.tvamount.setText("Ksh"+person.getAmount());//modify here
            viewHolder.imageView.setImageResource(person.getImage());
            return convertView;

        }
        static class ViewHolder {
            TextView tvnames;
            TextView tvemail;
            TextView tvamount;//These don't have to be same names as the Id's
            //MODIFY THIS BLOCK OF CODE
            //TextView textViewTitle;
            ImageView imageView;
        }

    }
}*/
