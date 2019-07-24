package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FindShangJiaInfoActivity extends AppCompatActivity {
    User user;
    ImageView img_shangJiahead_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_shangjia_info);
        initFindGoodInfo();


        Button zhuxiao_userinfo = (Button) findViewById(R.id.zhuxiao_userinfo);
        ImageView all_goodInfo_sjif = (ImageView) findViewById(R.id.all_goodInfo_sjif);
        ImageView Add_good_sjif = (ImageView) findViewById(R.id.Add_good_sjif);
        //点击注销按钮
        zhuxiao_userinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindShangJiaInfoActivity.this,loginActicity.class);
                startActivity(intent);
            }
        });

        //点击图标跳转到所有商品页面
        all_goodInfo_sjif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
                intent = new Intent(FindShangJiaInfoActivity.this,FindAllGoodActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //点击图标跳转到添加商品页面
        Add_good_sjif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
                intent = new Intent(FindShangJiaInfoActivity.this,AddGoodActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //点击编辑商品信息页面的按钮
        Button btn_shangJiaInfoChange = (Button) findViewById(R.id.btn_shangJiaInfoChange);
        btn_shangJiaInfoChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取传来得数据
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
               // String useraccount =  "shangjia";
                Log.d("FindGoodInfoActivity","-----------------商家账号："+useraccount);
                Toast.makeText(FindShangJiaInfoActivity.this, "进入修改", Toast.LENGTH_SHORT).show();
                Log.d("FindGoodInfoActivity","--------------GoodInfo修改-----------------");
                intent = new Intent(FindShangJiaInfoActivity.this,EditShangJiaActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);

            }
        });





    }

    //通过商家账号（account）查询商商家个人信息并在FindShangJiaInfoActivity显示
    private void initFindGoodInfo(){

        //获取传来账号
        Intent intent = getIntent();
        String useraccount = intent.getStringExtra("useraccount").toString();
         // String useraccount = "shangjia";
        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/user/shangJiaInfoJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("account",useraccount).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(FindShangJiaInfoActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                user = gson.fromJson(responseData,User.class);
                Log.d("获得的数据是",responseData);
                Log.d("获得的数据是","商家头像："+user.getHead_image());
                Log.d("获得的数据是","商家账号："+user.getAccount());
                Log.d("获得的数据是","商家用户名："+user.getUsername());
                Log.d("获得的数据是","商家密码："+user.getPassword());
                Log.d("获得的数据是","商家性别："+user.getSex());
                Log.d("获得的数据是","商家电话："+user.getPhone());
                Log.d("获得的数据是","商家地址："+user.getAddress());
            //把查询到的信息显示出来
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img_shangJiahead_image = (ImageView) findViewById(R.id.img_shangJiahead_image);
                        TextView TxtV_shangJiaAccount = (TextView) findViewById(R.id.TxtV_shangJiaAccount);
                        TextView TxtV_shangJiaName = (TextView) findViewById(R.id.TxtV_shangJiaName);
                        TextView TxtV_shangJiaPsw = (TextView) findViewById(R.id.TxtV_shangJiaPsw);
                        TextView TxtV_shangJiaSX = (TextView) findViewById(R.id.TxtV_shangJiaSX);
                        TextView TxtV_shangJiaPhone = (TextView) findViewById(R.id.TxtV_shangJiaPhone);
                        TextView TxtV_shangJiaAddr = (TextView) findViewById(R.id.TxtV_shangJiaAddr);
                        Glide.with(FindShangJiaInfoActivity.this)
                                .load("http://10.0.2.2:8080/qimo/"+user.getHead_image())
                                .into(img_shangJiahead_image);
                        TxtV_shangJiaAccount.setText(user.getAccount());
                        TxtV_shangJiaName.setText(user.getUsername());
                        TxtV_shangJiaPsw.setText(user.getPassword());
                        TxtV_shangJiaSX.setText(user.getSex());
                        TxtV_shangJiaPhone.setText(user.getPhone());
                        TxtV_shangJiaAddr.setText(user.getAddress());

                    }
                });


            }
        });

    }

}
