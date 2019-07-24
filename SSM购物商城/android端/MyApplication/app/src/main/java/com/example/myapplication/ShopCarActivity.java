package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.Good;
import com.example.myapplication.Shop;
import com.example.myapplication.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by admin on 2019/6/22.
 */

public class ShopCarActivity extends AppCompatActivity {
    private List<Shop> shopList = new ArrayList<>();
    private String useraccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopcar);
        initShop();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ShopCar_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ShopCarAdapter adapter = new ShopCarAdapter(shopList);
        recyclerView.setAdapter(adapter);

        Intent intent1 = getIntent();
        final String useraccount = intent1.getStringExtra("useraccount");

        //正下方3个ImageView
        ImageView all_good = (ImageView)findViewById(R.id.all_good);
        ImageView all_myself = (ImageView)findViewById(R.id.all_myself);
        ImageView all_shop = (ImageView)findViewById(R.id.all_shop);



        all_good.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopCarActivity.this,GoodListActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_myself.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopCarActivity.this,MyselfActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_shop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopCarActivity.this,ShopCarActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });
    }


    public void initShop(){
        //获取传来得数据
        Intent intent = getIntent();
        useraccount = intent.getStringExtra("useraccount");
        Log.d("ShopCarActivity","-------------------------------"+useraccount);

        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/goods/shopCarJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("user_account",useraccount).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(ShopCarActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                /*parseJSONWithJSONObject(responseData);*/
                Log.d("获得的数据是",responseData);
                List<Shop> shopList2 =gson.fromJson(responseData,new TypeToken<List<Shop>>(){}.getType());
                for(Shop shop:shopList2){
                    shopList.add(shop);
                    Log.d("GoodInfoActivity","name is"+shop.getGood_name());
                    Log.d("GoodInfoActivity","image is"+shop.getGood_image());

                }



            }
        });
    }



}
