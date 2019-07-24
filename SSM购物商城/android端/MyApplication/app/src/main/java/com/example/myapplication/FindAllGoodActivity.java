package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FindAllGoodActivity extends AppCompatActivity {

    private List<Good> goodList = new ArrayList<>();
    private String useraccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_all_good);
        initFindAllGood();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.AllGoods_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        GoodAdapter adapter = new GoodAdapter(goodList);
        recyclerView.setAdapter(adapter);
        //接受到上一个数据传送过来得值


        ImageView findallgood_allgood = (ImageView) findViewById(R.id.findallgood_allgood);
        ImageView findallgood_addg = (ImageView) findViewById(R.id.findallgood_addg);
        ImageView findallgood_usifo = (ImageView) findViewById(R.id.findallgood_usifo);
        //点击图标跳转到添加商品页面
        findallgood_addg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
                Log.d("去添加商品界面","-------------------------------"+useraccount);
                intent = new Intent(FindAllGoodActivity.this,AddGoodActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });
        //点击图标跳转到个人信息页面
        findallgood_usifo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去个人信息界面","-------------------------------"+useraccount);
                Intent intent = new Intent(FindAllGoodActivity.this,FindShangJiaInfoActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //点击商品列表按钮
        findallgood_allgood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去商品列表界面","-------------------------------"+useraccount);
                Intent intent = new Intent(FindAllGoodActivity.this,FindAllGoodActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

    }

    private void initFindAllGood() {
        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/goods/findGoodJSON.do";
        OkHttpUtil.sendOksendRequestWithOkHttp(address, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(FindAllGoodActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("useraccount","-------------------------------"+useraccount);
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                List<Good> all_goodList =gson.fromJson(responseData,new TypeToken<List<Good>>(){}.getType());
                for(Good good:all_goodList){
                    good.setUseraccount(useraccount);
                    goodList.add(good);
                    Log.d("FindAllGoodActivity","name is"+good.getGood_name());
                    Log.d("FindAllGoodActivity","image is"+good.getGood_image());
                    Log.d("FindAllGoodActivity","get Good_content is"+good.getGood_content());
                    Log.d("FindAllGoodActivity","get Good_price is"+good.getGood_price());

                }

            }

        });
    }
}
