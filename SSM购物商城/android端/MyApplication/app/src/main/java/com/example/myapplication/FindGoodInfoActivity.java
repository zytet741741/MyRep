package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
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

public class FindGoodInfoActivity extends AppCompatActivity {
    ImageView goodInfo_img;
    Good good;
    private String useraccount;

//    private FindGoodInfoActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_good_info);
        initFindGoodInfo();
        ImageView Add_good_gdif = (ImageView) findViewById(R.id.Add_good_gdif);
        ImageView all_goodInfo_gdif = (ImageView) findViewById(R.id.all_goodInfo_gdif);
        ImageView shangjia_info_gdif = (ImageView) findViewById(R.id.shangjia_info_gdif);
        Button btn_delGoodInfo = (Button) findViewById(R.id.btn_delGoodInfo);
        Intent intent = getIntent();
        useraccount = intent.getStringExtra("useraccount").toString();
        //点击图标跳转到所有商品页面
        all_goodInfo_gdif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
                Log.d("去所有商品界面","-------------------------------"+useraccount);
                intent = new Intent(FindGoodInfoActivity.this,FindAllGoodActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //点击图标跳转到添加商品页面
        Add_good_gdif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
                Log.d("去添加商品界面","-------------------------------"+useraccount);
                intent = new Intent(FindGoodInfoActivity.this,AddGoodActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //点击个人信息按钮
        shangjia_info_gdif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去个人信息界面","-------------------------------"+useraccount);
                Intent intent = new Intent(FindGoodInfoActivity.this,FindShangJiaInfoActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });


        //点击删除商品信息页面的按钮
        btn_delGoodInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
                Log.d("去------界面","-------------------------------"+useraccount);
                String good_name = intent.getStringExtra("good_name").toString();
                Toast.makeText(FindGoodInfoActivity.this, "已删除", Toast.LENGTH_SHORT).show();
                Log.d("FindGoodInfoActivity","--------------GoodInfo删除-----------------");
                String address ="http://10.0.2.2:8080/qimo/goods/delGoodJSON.do";
                RequestBody requestBody = new FormBody.Builder().add("good_name",good_name).build();
                OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback() {


                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(FindGoodInfoActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Intent intent = getIntent();
                        String useraccount = intent.getStringExtra("useraccount").toString();
                        Log.d("去------界面","-------------------------------"+useraccount);
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(FindGoodInfoActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                            intent = new Intent(FindGoodInfoActivity.this,FindAllGoodActivity.class);
                            //intent.putExtra("good_name",good_name);
                            intent.putExtra("useraccount",useraccount);
                            Log.d("跳转","+++++++++到FindAllGoodActivity");
                            startActivity(intent);
                            Looper.loop();
                        }

                    }
                });


            }
        });



       //点击编辑商品信息页面的按钮
        Button btn_goodInfoChange = (Button) findViewById(R.id.btn_goodInfoChange);
        btn_goodInfoChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取传来得数据
                Intent intent = getIntent();
                String good_name = intent.getStringExtra("good_name").toString();
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("FindGoodInfoActivity","-----------------商品名称："+good_name);
                Log.d("FindGoodInfoActivity","-----------------商品名称："+useraccount);
                Toast.makeText(FindGoodInfoActivity.this, "进入修改", Toast.LENGTH_SHORT).show();
                Log.d("FindGoodInfoActivity","--------------GoodInfo修改-----------------");
                intent = new Intent(FindGoodInfoActivity.this,GoodInfoChangeActivity.class);
                intent.putExtra("good_name",good_name);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);

            }
        });



    }
//通过商品名称查询商品并在FindGoodInfoActivity显示
    private void initFindGoodInfo() {
        //获取传来得数据
        Intent intent = getIntent();
        String good_name = intent.getStringExtra("good_name").toString();
        Log.d("FindGoodInfoActivity","-------------------------------"+good_name);
        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/goods/findGoodInfoJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("good_name",good_name).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(FindGoodInfoActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               // Context context = FindGoodInfoActivity.this;
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                final Good good = gson.fromJson(responseData,Good.class);
                Log.d("获得的数据是",responseData);
                Log.d("获得的数据是","商品图片："+good.getGood_image());
                Log.d("获得的数据是","商品id："+good.getId());
                Log.d("获得的数据是","商品名字："+good.getGood_name());
                Log.d("获得的数据是","商品简介："+good.getGood_content());
                Log.d("获得的数据是","商品价格："+good.getGood_price());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        goodInfo_img = (ImageView) findViewById(R.id.img_goodInfoImage);
                        TextView goodInfo_id = (TextView) findViewById(R.id.TxtV_goodInfoId);
                        TextView goodInfo_name = (TextView) findViewById(R.id.TxtV_goodInfoName);
                        TextView goodInfo_content = (TextView) findViewById(R.id.TxtV_goodInfoContent);
                        TextView goodInfo_price = (TextView) findViewById(R.id.TxtV_goodInfoPrice);

                        Glide.with(FindGoodInfoActivity.this)
                                .load("http://10.0.2.2:8080/qimo/"+good.getGood_image())
                                .into(goodInfo_img);
                        goodInfo_id.setText(good.getId().toString());
                        goodInfo_name.setText(good.getGood_name());
                        goodInfo_content.setText(good.getGood_content());
                        goodInfo_price.setText(good.getGood_price());
                    }
                });





            }
        });



    }
}
