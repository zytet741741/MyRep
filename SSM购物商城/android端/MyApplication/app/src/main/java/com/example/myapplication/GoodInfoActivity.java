package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.Good;
import com.example.myapplication.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by admin on 2019/6/22.
 */

public class GoodInfoActivity extends AppCompatActivity {
    private ImageView goodinfo_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodinfo);
        initGoodInfo();

        Intent intent1 = getIntent();
        final String useraccount2 = intent1.getStringExtra("useraccount");

        ImageView all_good = (ImageView)findViewById(R.id.goodinfo_all_good);
        ImageView all_myself = (ImageView)findViewById(R.id.goodinfo_all_myself);
        ImageView all_shop = (ImageView)findViewById(R.id.goodinfo_all_shop);
        goodinfo_image = (ImageView)findViewById(R.id.goodinfo_image);


        all_good.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodInfoActivity.this,GoodListActivity.class);
                intent.putExtra("useraccount",useraccount2);
                startActivity(intent);
            }
        });

        all_myself.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodInfoActivity.this,MyselfActivity.class);
                intent.putExtra("useraccount",useraccount2);
                startActivity(intent);
            }
        });

        all_shop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodInfoActivity.this,ShopCarActivity.class);
                intent.putExtra("useraccount",useraccount2);
                startActivity(intent);
            }
        });
    }

    public void initGoodInfo(){
        //获取传来得数据
        Intent intent = getIntent();
        String good_name = intent.getStringExtra("good_name").toString();
        final String useraccount = intent.getStringExtra("useraccount").toString();
        Log.d("GoodInfoActivity","-------------------------------"+good_name);
        Log.d("GoodInfoActivity",useraccount);

        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/goods/queryGoodInfoJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("good_name",good_name).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(GoodInfoActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                final Good goodList2 =gson.fromJson(responseData,Good.class);
                Log.d("name",goodList2.getGood_name());

                final TextView name = (TextView) findViewById(R.id.goodinfo_name);
                TextView content = (TextView) findViewById(R.id.goodinfo_content);
                TextView price = (TextView) findViewById(R.id.goodinfo_price);
                Button add_in_car = (Button) findViewById(R.id.addincar_bt);

                name.setText(goodList2.getGood_name());
                content.setText(goodList2.getGood_content());
                price.setText(goodList2.getGood_price());
                Log.d("basd",goodList2.getGood_image());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(GoodInfoActivity.this).load("http://10.0.2.2:8080/qimo"+goodList2.getGood_image()).placeholder(R.mipmap.ic_launcher).override(200,200).error(R.mipmap.ic_launcher).into(goodinfo_image);
                    }
                });

                add_in_car.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String good_name = goodList2.getGood_name();
                        String good_content = goodList2.getGood_content();
                        String good_price = goodList2.getGood_price();
                        String good_image = goodList2.getGood_image();
                        final String user_account = "yonghu";
                        Integer number = 1;
                        String  number2  = number.toString();
                        String address ="http://10.0.2.2:8080/qimo/goods/addInCarJSON.do";
                        RequestBody requestBody = new FormBody.Builder()
                                .add("good_name",good_name)
                                .add("good_content",good_content)
                                .add("good_price",good_price)
                                .add("good_image",good_image)
                                .add("user_account",user_account)
                                .add("number",number2)
                                .build();
                        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback() {

                            @Override
                            public void onFailure(Call call, IOException e) {
                                Toast.makeText(GoodInfoActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Gson gson = new Gson();
                                String responseData = response.body().string();
                                Log.d("获得的数据是", responseData);
                                Looper.prepare();
                                Toast.makeText(GoodInfoActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(GoodInfoActivity.this,ShopCarActivity.class);
                                intent.putExtra("useraccount",useraccount);
                                startActivity(intent);
                                Looper.loop();
                                Log.d("32132123123123",useraccount);

                            }
                        });
                    }
                });

            }
        });
    }
}
