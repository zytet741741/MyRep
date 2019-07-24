package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        TextView AllSale = (TextView) findViewById(R.id.all_sale);
        ImageView UnPay = (ImageView)findViewById(R.id.Unpay);
        ImageView UnShipped = (ImageView)findViewById(R.id.Unshipped);
        ImageView UnReceived = (ImageView)findViewById(R.id.Unreceived);
        ImageView UnEvaluated = (ImageView)findViewById(R.id.Unevaluated);
        //接受loginActivity的useraccount值
        Intent intent1 = getIntent();
        final String useraccount = intent1.getStringExtra("useraccount");
        Log.d("NavigationActivity",useraccount);

        //我的订单点击事件
        AllSale.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //传username值传给下一个活动
                Intent intent = new Intent(NavigationActivity.this,AllSaleActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);

            }
        });


        //待付款点击事件
        UnPay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "待付款", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NavigationActivity.this,UnPayActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);

            }
        });

        //待发货点击事件
        UnShipped.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "待发货", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NavigationActivity.this,UnShipActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //待收货点击事件
        UnReceived.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "待收货", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NavigationActivity.this,UnReceivedActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //待评价点击事件
        UnEvaluated.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "待评价", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NavigationActivity.this,UnEvaluatedActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });


    }
}
