package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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

public class UnEvaluatedActivity extends AppCompatActivity {

    private List<Good> orderList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_pay);
        jump();
        initUnPay();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.Unpay_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        UnPayAdapter adapter = new UnPayAdapter(orderList);
        recyclerView.setAdapter(adapter);
        //接受到上一个数据传送过来得值

    }

    private void jump() {
        TextView TextView_allSale = (TextView)findViewById(R.id.TextView_allSale);
        TextView TextView_UnPay = (TextView)findViewById(R.id.TextView_UnPay);
        TextView TextView_UnShip = (TextView)findViewById(R.id.TextView_UnShip);
        TextView TextView_UnReceived = (TextView)findViewById(R.id.TextView_UnReceived);
        TextView TextView_UnEvaluated = (TextView)findViewById(R.id.TextView_UnEvaluated);

        ImageView ImageView_all_shop = (ImageView)findViewById(R.id.all_shop);
        ImageView ImageView_all_good = (ImageView)findViewById(R.id.all_good);
        ImageView ImageView_all_myself = (ImageView)findViewById(R.id.all_myself);


        //去全部订单界面
        TextView_allSale.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("UnPayActivity","-------------------------------"+useraccount);

                Intent intent = new Intent(UnEvaluatedActivity.this,AllSaleActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //去待付款界面
        TextView_UnPay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("UnPayActivity","-------------------------------"+useraccount);

                Intent intent = new Intent(UnEvaluatedActivity.this,UnPayActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //去待收货界面
        TextView_UnReceived.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("UnPayActivity","-------------------------------"+useraccount);

                Intent intent = new Intent(UnEvaluatedActivity.this,UnReceivedActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //去待发货界面
        TextView_UnEvaluated.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("UnPayActivity","-------------------------------"+useraccount);

                Intent intent = new Intent(UnEvaluatedActivity.this,UnShipActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //去个人信息界面
        ImageView_all_myself.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去个人信息界面","-------------------------------"+useraccount);

                Intent intent = new Intent(UnEvaluatedActivity.this,MyselfActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //去购物车界面
        ImageView_all_shop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去个人信息界面","-------------------------------"+useraccount);

                Intent intent = new Intent(UnEvaluatedActivity.this,ShopCarActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //去商品界面
        ImageView_all_good.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去个人信息界面","-------------------------------"+useraccount);

                Intent intent = new Intent(UnEvaluatedActivity.this,GoodListActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });



    }

    private void initUnPay() {

        //获取传来得数据
        Intent intent = getIntent();
        String useraccount = intent.getStringExtra("useraccount").toString();
        Log.d("UnPayActivity","-------------------------------"+useraccount);

        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/goods/EvaluatedJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("user_account",useraccount).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(UnEvaluatedActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                List<Good> two_orderList =gson.fromJson(responseData,new TypeToken<List<Good>>(){}.getType());
                for(Good order:two_orderList){
                    orderList.add(order);
                    Log.d("UnPayActivity","name is"+order.getGood_name());
                    Log.d("UnPayActivity","image is"+order.getGood_image());
                    Log.d("UnPayActivity","Order_type_id is"+order.getOrderType().getOrder_status_name());
                    Log.d("UnPayActivity","Order_type_id is"+order.getOrder().getOrder_type_id());

                }
            }
        });
    }


}
