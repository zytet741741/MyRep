package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class GoodInfoChangeActivity extends AppCompatActivity {
    ImageView img_goodInfoImageChange;
    Good good;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_info_change);
        initGoodInfoChange();
        Button btn_goodInfoChangeYes = (Button) findViewById(R.id.btn_goodInfoChangeYes);
        Button btn_goodInfoChangeNo = (Button) findViewById(R.id.btn_goodInfoChangeNo);
        //点击编辑页面中的取消按钮，并返回到FindGoodInfoActivity
        btn_goodInfoChangeNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String good_name = intent.getStringExtra("good_name").toString();
                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("GoodInfoChangeActivity","-----------------商品名称："+good_name);
                Log.d("GoodInfoChangeActivity","-----------------用户账号："+useraccount);
                intent = new Intent(GoodInfoChangeActivity.this,FindGoodInfoActivity.class);
                intent.putExtra("good_name",good_name);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });
        //点击编辑页面中的确认修改按钮
        btn_goodInfoChangeYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();


                Log.d("GoodInfoChangeActivity","-----------------用户账号11："+useraccount);
                Log.d("GoodInfoChangeActivity","--------------GoodInfo修改-----------------");

                img_goodInfoImageChange = (ImageView) findViewById(R.id.img_goodInfoImageChange);
                TextView TxtV_goodInfoIdChang= (TextView) findViewById(R.id.TxtV_goodInfoIdChang);
                TextView EdiT_goodInfoName = (TextView) findViewById(R.id.EdiT_goodInfoName);
                EditText EdiT_goodInfoContent = (EditText) findViewById(R.id.EdiT_goodInfoContent);
                EditText EdiT_goodInfoPrice = (EditText) findViewById(R.id.EdiT_goodInfoPrice);

                String good_content = EdiT_goodInfoContent.getText().toString();
                String good_price = EdiT_goodInfoPrice.getText().toString();
                String good_name = EdiT_goodInfoName.getText().toString();

                Log.d("InfoChangeYes获得的数据是","商品图片："+good.getGood_image());
                Log.d("InfoChangeYes获得的数据是","商品id："+good.getId());
                Log.d("InfoChangeYes获得的数据是","商品名字："+good_name);
                Log.d("InfoChangeYes获得的数据是","商品简介："+good_content);
                Log.d("InfoChangeYes获得的数据是","商品价格good_price："+good_price);
                String address ="http://10.0.2.2:8080/qimo/goods/updateGoodsInfoJSON.do";
                RequestBody requestBody = new FormBody.Builder().add("good_content",good_content).add("good_price",good_price).add("good_name",good_name)
                      .build();
               OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(GoodInfoChangeActivity.this, "修改失败", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Intent intent = getIntent();
                        String useraccount = intent.getStringExtra("useraccount").toString();
                        String good_name = good.getGood_name();
                        Log.d("获得的数据是","跳转时商品名字："+good.getGood_name());
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(GoodInfoChangeActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                            intent = new Intent(GoodInfoChangeActivity.this,FindGoodInfoActivity.class);
                            intent.putExtra("good_name",good_name);
                            intent.putExtra("useraccount",useraccount);
                            Log.d("GoodInfoChangeActivity","-----------------用户账号222："+useraccount);
                            Log.d("跳转","+++++++++到FindAllGoodActivity");
                            startActivity(intent);
                            Looper.loop();
                        }

                    }
                });
            }
        });

    }

    private void initGoodInfoChange(){
        //获取传来得数据
        Intent intent = getIntent();
        String good_name = intent.getStringExtra("good_name").toString();
        Log.d("FindGoodInfoActivity","-------------------------------"+good_name);
        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/goods/findGoodInfoJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("good_name",good_name).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(GoodInfoChangeActivity.this, "失败", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                good = gson.fromJson(responseData,Good.class);
                Log.d("获得的数据是",responseData);
                img_goodInfoImageChange = (ImageView) findViewById(R.id.img_goodInfoImageChange);
                TextView TxtV_goodInfoIdChang= (TextView) findViewById(R.id.TxtV_goodInfoIdChang);
                TextView EdiT_goodInfoName = (TextView) findViewById(R.id.EdiT_goodInfoName);
                EditText EdiT_goodInfoContent = (EditText) findViewById(R.id.EdiT_goodInfoContent);
                EditText EdiT_goodInfoPrice = (EditText) findViewById(R.id.EdiT_goodInfoPrice);
                Log.d("获得的数据是","商品图片："+good.getGood_image());
                Log.d("获得的数据是","商品id："+good.getId());
                Log.d("获得的数据是","商品名字："+good.getGood_name());
                Log.d("获得的数据是","商品简介："+good.getGood_content());
                Log.d("获得的数据是","商品价格："+good.getGood_price());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(GoodInfoChangeActivity.this)
                                .load("http://10.0.2.2:8080/qimo/"+good.getGood_image())
                                .into(img_goodInfoImageChange);
                    }
                });
              //  TxtV_goodInfoIdChang.setText(good.getId().toString());
                EdiT_goodInfoName.setText(good.getGood_name());
                EdiT_goodInfoContent.setText(good.getGood_content());
                EdiT_goodInfoPrice.setText(good.getGood_price().toString());


            }
        });

    }

}
