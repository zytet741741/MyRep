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
import com.example.myapplication.Good;
import com.example.myapplication.Shop;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by admin on 2019/6/22.
 */

public class ShopCarAdapter extends RecyclerView.Adapter<ShopCarAdapter.ViewHolder> {
    private List<Shop> mShopList;
    public Context context;
    private String useraccount;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView shop_Name;
        TextView shop_price;
        ImageView shop_Image;
        Button shop_car_delete;
        Button add_in_order;
        public ViewHolder(View view) {
            super(view);
            shop_Image = (ImageView)view.findViewById(R.id.shop_car_image);
            shop_Name = (TextView)view.findViewById(R.id.shop_car_name);
            shop_price = (TextView)view.findViewById(R.id.shop_car_price);

            shop_car_delete = (Button)view.findViewById(R.id.shop_car_delete);
            add_in_order = (Button)view.findViewById(R.id.addinorder_button);
        }
    }

    public ShopCarAdapter(List<Shop> shopList){
        mShopList = shopList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        if(context==null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopcar_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        holder.shop_car_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int position = holder.getAdapterPosition();
                Shop shop = mShopList.get(position);
                String good_name = shop.getGood_name();
                Log.d("ShopCarActivity","删除***********购物车商品："+good_name);
                String address = "http://10.0.2.2:8080/qimo/goods/delCarGoodJSON.do";
                final RequestBody requestBody = new FormBody.Builder().add("good_name",good_name).build();
                OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(v.getContext(), "失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是：",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(v.getContext(),"删除成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(parent.getContext(),ShopCarActivity.class);
                            intent.putExtra("useraccount",useraccount);
                            parent.getContext().startActivity(intent);
                            Looper.loop();
                        }
                    }
                });
            }
        });

        holder.add_in_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int position = holder.getAdapterPosition();
                Shop shop = mShopList.get(position);
                String good_name = shop.getGood_name();
                String good_price = shop.getGood_price();
                String good_image = shop.getGood_image();
                String user_account = shop.getUser_account();
                String number = shop.getNumber().toString();
                String good_total_price = shop.getGood_price();
                String order_type_id = "2";
                Log.d("ShopCarActivity","添加购物车商品到订单--------------"+good_name);
                String address = "http://10.0.2.2:8080/qimo/goods/addInOrderJSON.do";
                final RequestBody requestBody = new FormBody.Builder()
                        .add("good_name",good_name).add("good_price",good_price)
                        .add("good_image",good_image).add("user_account",user_account)
                        .add("number",number).add("good_total_price",good_total_price)
                        .add("order_type_id",order_type_id)
                        .build();
                OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(v.getContext(), "失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是：",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(v.getContext(),"付款成功",Toast.LENGTH_SHORT).show();
                            Log.d("asdassasdad",useraccount);
                            Intent intent = new Intent(parent.getContext(),GoodListActivity.class);
                            intent.putExtra("useraccount",useraccount);
                            parent.getContext().startActivity(intent);
                            Looper.loop();

                        }
                    }
                });
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Shop shop = mShopList.get(position);
        holder.shop_Name.setText(shop.getGood_name());
        holder.shop_price.setText(shop.getGood_price());
        useraccount = shop.getUser_account();
        Glide.with(context).load("http://10.0.2.2:8080/qimo"+shop.getGood_image()).placeholder(R.mipmap.ic_launcher).override(200,200).error(R.mipmap.ic_launcher).into(holder.shop_Image);
    }

    @Override
    public int getItemCount() {
        return mShopList.size();
    }
}
