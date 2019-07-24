package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
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
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 805138185 on 2019/6/17.
 */

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.ViewHolder> {
    private List<Good> mGoodList;
    private Context context;
    private String useraccount;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView goodImage;
        TextView goodName;
        TextView goodPrice;
        Button goodInfoButton;
        Button delGoodButton;

        public ViewHolder(View view) {
            super(view);
            goodImage = (ImageView)view.findViewById(R.id.img_goodImage);
            goodName = (TextView)view.findViewById(R.id.TxtV_goodName);
            goodPrice = (TextView) view.findViewById(R.id.TxtV_goodPrice);
            goodInfoButton = (Button)view.findViewById(R.id.btn_goodInfo);
            delGoodButton = (Button) view.findViewById(R.id.btn_delGood);
        }
    }

    public GoodAdapter(List<Good> goodList){
        mGoodList = goodList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context==null){
            context = parent.getContext();
        }
        Log.d("FindGoodInfoActivity","context is=================="+context);
        View view = LayoutInflater.from(context).inflate(R.layout.good_item,parent,false);
        Log.d("FindGoodInfoActivity","context is++++++++++++++++++++++"+context);

        final ViewHolder holder = new ViewHolder(view);

        //点击删除按钮
        holder.delGoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int position = holder.getAdapterPosition();
                Good good = mGoodList.get(position);
                //Toast.makeText(v.getContext(),"已删除",Toast.LENGTH_SHORT).show();
                String good_name = good.getGood_name();
                String useraccount = good.getUseraccount();
                Log.d("FindGoodInfoActivity","进入删除**********************商品名称："+good_name);
                Log.d("FindGoodInfoActivity","进入删除*********************账号："+useraccount);
                String address ="http://10.0.2.2:8080/qimo/goods/delGoodJSON.do";
                RequestBody requestBody = new FormBody.Builder().add("good_name",good_name).build();
                OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(v.getContext(),"删除失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        int position = holder.getAdapterPosition();
                        Good good = mGoodList.get(position);
                        Log.d("FindGoodInfoActivity","进入*********************账号2222："+good.getUseraccount());
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(v.getContext(),"删除成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context,FindAllGoodActivity.class);
                           // intent.putExtra("useraccount",useraccount);
                            intent.putExtra("useraccount",good.getUseraccount());
                            context.startActivity(intent);
                            Looper.loop();
                        }

                    }
                });

            }
        });
        //点击详情按钮
        holder.goodInfoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Good good = mGoodList.get(position);
                //获取按钮id
                int i = good.getId().intValue();
                String  goodId =good.getId().toString();
                String good_name = good.getGood_name();
                Log.d("FindGoodInfoActivity","-------------------------------"+good_name);
                Log.d("FindGoodInfoActivity","-----------good.getUseraccount()--------------------"+good.getUseraccount());
                Intent intent = new Intent(context,FindGoodInfoActivity.class);
                intent.putExtra("good_name",good_name);
                intent.putExtra("useraccount",good.getUseraccount());
                Toast.makeText(v.getContext(),"进入详情页成功",Toast.LENGTH_SHORT).show();
                context.startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Good good = mGoodList.get(position);
        holder.goodName.setText(good.getGood_name());
        holder.goodPrice.setText(good.getGood_price());
        Glide.with(context).load("http://10.0.2.2:8080/qimo"+good.getGood_image()).placeholder(R.mipmap.ic_launcher).override(200,200).error(R.mipmap.ic_launcher).into(holder.goodImage);

        Log.d("FindGoodInfoActivity","url is**************"+good.getGood_image());
    }

    @Override
    public int getItemCount() {

        return mGoodList.size();
    }


}
