package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by admin on 2019/6/19.
 */

public class GoodListAdapter extends RecyclerView.Adapter<GoodListAdapter.ViewHolder> {
    private List<Good> mGoodList;
    private Context context;
    private String useraccount;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView goodlistName;
        ImageView goodlistImage;
        Button goodInfo ;
        public ViewHolder(View view) {
            super(view);
            goodlistName = (TextView)view.findViewById(R.id.goodlist_name);
            goodlistImage = (ImageView)view.findViewById(R.id.goodlist_image);
            goodInfo=(Button) view.findViewById(R.id.show_goodinfo_bt);
        }
    }

    public GoodListAdapter(List<Good> goodList){
        mGoodList = goodList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context==null){
            context = parent.getContext();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.goodlist_item,parent,false);
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.goodlist_item,parent,false);
//        ViewHolder holder = new ViewHolder(view);



        //点击事件
        final GoodListAdapter.ViewHolder holder = new GoodListAdapter.ViewHolder(view);
        holder.goodInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                int position =holder.getAdapterPosition();
                Good good = mGoodList.get(position);
                Intent intent = new Intent(context,GoodInfoActivity.class);
                intent.putExtra("good_name",good.getGood_name());
                intent.putExtra("useraccount",good.getUseraccount());
                context.startActivity(intent);

                /*Toast.makeText(v.getContext(),good.getGood_name(), Toast.LENGTH_SHORT).show();*/
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Good good = mGoodList.get(position);
        holder.goodlistName.setText(good.getGood_name());
        Glide.with(context).load("http://10.0.2.2:8080/qimo"+good.getGood_image()).placeholder(R.mipmap.ic_launcher).override(200,200).error(R.mipmap.ic_launcher).into(holder.goodlistImage);
    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }
}
