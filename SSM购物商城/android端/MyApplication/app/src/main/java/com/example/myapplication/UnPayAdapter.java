package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class UnPayAdapter extends RecyclerView.Adapter<UnPayAdapter.ViewHolder> {
    private List<Good> mOrderList;
    private Context context;



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView unpayName;
        ImageView unpayImage;
        Button unpayButton;

        public ViewHolder(View view) {
            super(view);
            unpayName = (TextView)view.findViewById(R.id.unpay_name);
            unpayImage = (ImageView)view.findViewById(R.id.unpay_image);
            unpayButton = (Button)view.findViewById(R.id.unpay_button);
        }
    }

    public UnPayAdapter(List<Good> orderList){
        mOrderList = orderList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context==null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.unpay_item,parent,false);

        Good g = mOrderList.get(0);
        Log.d("123", g.getOrder().getUser_account()+"------------------");

        //点击事件
        final ViewHolder holder = new ViewHolder(view);
        holder.unpayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                int position = holder.getAdapterPosition();
                Good order = mOrderList.get(position);
                //获取按钮id
                int i = order.getOrder().getOrder_type_id().intValue();
                String  orderId =order.getOrder().getId().toString();
                final String useraccount = order.getOrder().getUser_account();
                Log.d("AAAAAAAAAAAAAAAAA","-------------------------------"+useraccount);

               //点击付款事件
                if(i == 1){
                    String address ="http://10.0.2.2:8080/qimo/goods/ToPay.do";
                    RequestBody requestBody = new FormBody.Builder().add("orderId",orderId).build();
                    OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody,new okhttp3.Callback(){
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Looper.prepare();
                            Toast.makeText(v.getContext(),"失败", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            String responseData = response.body().string();
                            Log.d("获得的数据是",responseData);
                            if(responseData.equals("success")){

                                Intent intent = new Intent(context,UnShipActivity.class);
                                intent.putExtra("useraccount",useraccount);
                                context.startActivity(intent);
                                Looper.prepare();
                                Toast.makeText(v.getContext(),"付款成功",Toast.LENGTH_SHORT).show();
                                Looper.loop();
                            }
                        }
                    });
                }

                //点击确认收货事件
                if(i == 3){
//                    Toast.makeText(v.getContext(),orderId,Toast.LENGTH_SHORT).show();
                    String address ="http://10.0.2.2:8080/qimo/goods/ToReceived.do";
                    RequestBody requestBody = new FormBody.Builder().add("orderId",orderId).build();
                    OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody,new okhttp3.Callback(){
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Looper.prepare();
                            Toast.makeText(v.getContext(),"失败", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            String responseData = response.body().string();
                            Log.d("获得的数据是",responseData);
                            if(responseData.equals("success")){
                                Looper.prepare();
                                Toast.makeText(v.getContext(),"收货成功",Toast.LENGTH_SHORT).show();
                                Log.d("UnPayActivity1111111111","-------------------------------"+useraccount);
                                Intent intent = new Intent(context,UnEvaluatedActivity.class);
                                intent.putExtra("useraccount",useraccount);
                                context.startActivity(intent);
                                Looper.loop();
                            }
                        }
                    });
                }

                if(i == 4){
                    Log.d("BBBBBBBBBBBBBBBBBBB","-------------------------------"+useraccount);
                    Log.d("ccccccccccccccccc","---------------------------"+orderId);
                    Intent intent = new Intent(context,EvalutedActivity.class);
                    intent.putExtra("useraccount",useraccount);
                    intent.putExtra("orderId",orderId);
                    context.startActivity(intent);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Good order = mOrderList.get(position);
        holder.unpayName.setText(order.getGood_name());
        holder.unpayButton.setText(order.getOrderType().getOrder_status_name());
        Glide.with(context).load("http://10.0.2.2:8080/qimo"+order.getOrder().getGood_image()).placeholder(R.mipmap.ic_launcher).override(200,200).error(R.mipmap.ic_launcher).into(holder.unpayImage);

        Log.d("UnPayActivity","url is"+order.getOrder().getGood_image());
    }

    @Override
    public int getItemCount() {

        return mOrderList.size();
    }



    //获取当前Order实例

}
