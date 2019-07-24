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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by admin on 2019/6/19.
 */

public class GoodListActivity extends AppCompatActivity {

    private List<Good> goodList = new ArrayList<>();
    private String useraccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodlist);
        initGoodList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.Good_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        GoodListAdapter adapter = new GoodListAdapter(goodList);
        recyclerView.setAdapter(adapter);

        Intent intent1 = getIntent();
        useraccount = intent1.getStringExtra("useraccount");

        //正下方3个ImageView
        ImageView all_good = (ImageView)findViewById(R.id.goodlist_all_good);
        ImageView all_myself = (ImageView)findViewById(R.id.goodlist_all_myself);
        ImageView all_shop = (ImageView)findViewById(R.id.goodlist_all_shop);



        all_good.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodListActivity.this,GoodListActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_myself.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodListActivity.this,MyselfActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_shop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodListActivity.this,ShopCarActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });



    }

    public void initGoodList() {

        //与web端交互
//        String address = "http://10.0.2.2:8080/qimo/goods/allGoodJSON.do";
        String address ="http://10.0.2.2:8080/qimo/goods/allGoodJSON.do";
        OkHttpUtil.postOksendRequestWithOkHttp2(address, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Looper.prepare();
                Toast.makeText(GoodListActivity.this, "失败", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                List<Good> two_goodList =gson.fromJson(responseData,new TypeToken<List<Good>>(){}.getType());
                for(Good good:two_goodList){
                    good.setUseraccount(useraccount);
                    goodList.add(good);

                    Log.d("GoodListActivity","name is"+good.getGood_name());
                    Log.d("GoodListActivity","image is"+good.getGood_image());
                    Log.d("cccccccccccc",good.getUseraccount());
                }

            }
        });
    }


}
