package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself);


        CircleImageView myself = (CircleImageView) findViewById(R.id.myself);
        TextView AllSale = (TextView) findViewById(R.id.all_sale);
        ImageView UnPay = (ImageView)findViewById(R.id.Unpay);
        ImageView UnShipped = (ImageView)findViewById(R.id.Unshipped);
        ImageView UnReceived = (ImageView)findViewById(R.id.Unreceived);
        ImageView UnEvaluated = (ImageView)findViewById(R.id.Unevaluated);
        ImageView myself_all_good = (ImageView)findViewById(R.id.myself_all_good);
        ImageView myself_all_myself = (ImageView)findViewById(R.id.myself_all_myself);
        ImageView myself_all_shop = (ImageView)findViewById(R.id.myself_all_shop);
        Button myself_zhuxiao = (Button)findViewById(R.id.myself_zhuxiao);


        //接受loginActivity的useraccount值
        Intent intent1 = getIntent();
        final String useraccount = intent1.getStringExtra("useraccount");
        Log.d("NavigationActivity",useraccount);


        //注销
        myself_zhuxiao.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MyselfActivity.this,loginActicity.class);
                startActivity(intent);
            }
        });

        //个人信息界面
        myself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyselfActivity.this,UserInfoActivity.class);
                intent.putExtra("user_account",useraccount);
                startActivity(intent);
            }
        });

        //我的订单点击事件
        AllSale.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //传username值传给下一个活动
                Intent intent = new Intent(MyselfActivity.this,AllSaleActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);

            }
        });


        //待付款点击事件
        UnPay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MyselfActivity.this, "待付款", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyselfActivity.this,UnPayActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);

            }
        });

        //待发货点击事件
        UnShipped.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MyselfActivity.this, "待发货", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyselfActivity.this,UnShipActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //待收货点击事件
        UnReceived.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MyselfActivity.this, "待收货", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyselfActivity.this,UnReceivedActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //待评价点击事件
        UnEvaluated.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MyselfActivity.this, "待评价", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyselfActivity.this,UnEvaluatedActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //个人界面
        myself_all_myself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyselfActivity.this,MyselfActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //商品界面
        myself_all_good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyselfActivity.this,GoodListActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //购物车界面
        myself_all_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyselfActivity.this,ShopCarActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });
    }
}
