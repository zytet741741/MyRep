package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 805138185 on 2019/6/8.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private Context mContext;
    private List<Test> mTestList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView testImage;
        TextView testName;
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            testImage=(ImageView)view.findViewById(R.id.test_image);
            testName = (TextView)view.findViewById(R.id.test_name);
        }
    }

    public TestAdapter(List<Test> testList){
        mTestList = testList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.test_item,parent,false);

        //点击事件
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int positoin = holder.getAdapterPosition();
                Test test = mTestList.get(positoin);
                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra(DetailActivity.TEST_NAME,test.getName());
                intent.putExtra(DetailActivity.TEST_IMAGE_ID,test.getId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Test test = mTestList.get(position);
        holder.testName.setText(test.getName());
        Glide.with(mContext).load(test.getId()).into(holder.testImage);
    }

    @Override
    public int getItemCount() {
        return mTestList.size();
    }

}
