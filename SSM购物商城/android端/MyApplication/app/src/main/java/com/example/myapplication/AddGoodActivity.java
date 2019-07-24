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
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddGoodActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_good);
        Button btn_AddgoodYes = (Button) findViewById(R.id.btn_AddgoodYes);
       // Button btn_AddgoodNo = (Button) findViewById(R.id.btn_AddgoodNo);

        ImageView all_goodInfo_addg = (ImageView) findViewById(R.id.all_goodInfo_addg);
        ImageView shangjia_info_addg = (ImageView) findViewById(R.id.shangjia_info_addg);
        //点击商品列表按钮
        all_goodInfo_addg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去商品列表界面","-------------------------------"+useraccount);
                Intent intent = new Intent(AddGoodActivity.this,FindAllGoodActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        //点击个人信息按钮
        shangjia_info_addg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = getIntent();
                String useraccount = intent1.getStringExtra("useraccount").toString();
                Log.d("去个人信息界面","-------------------------------"+useraccount);
                Intent intent = new Intent(AddGoodActivity.this,FindShangJiaInfoActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });



        btn_AddgoodYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Edi_AddgoodImage = (EditText) findViewById(R.id.Edi_AddgoodImage);
                EditText Edi_AddgoodTypeId = (EditText) findViewById(R.id.Edi_AddgoodTypeId);
                EditText Edi_AddgoodName = (EditText) findViewById(R.id.Edi_AddgoodName);
                EditText Edi_AddgoodContent = (EditText) findViewById(R.id.Edi_AddgoodContent);
                EditText Edi_AddgoodPrice = (EditText) findViewById(R.id.Edi_AddgoodPrice);
                String good_image = Edi_AddgoodImage.getText().toString();
                String good_type_id = Edi_AddgoodTypeId.getText().toString();
                String good_name = Edi_AddgoodName.getText().toString();
                String good_content = Edi_AddgoodContent.getText().toString();
                String good_price = Edi_AddgoodPrice.getText().toString();
                Log.d("AddGoodYes获得的数据是","商品图片："+good_image);
                Log.d("AddGoodYes获得的数据是","商品类型id："+good_type_id);
                Log.d("AddGoodYes获得的数据是","商品名字："+good_name);
                Log.d("AddGoodYes获得的数据是","商品简介："+good_content);
                Log.d("AddGoodYes获得的数据是","商品价格good_price："+good_price);

                //与Web端交互
                String address ="http://10.0.2.2:8080/qimo/goods/addGoodJSON.do";
                RequestBody requestBody = new FormBody.Builder().add("good_type_id",good_type_id).add("good_name",good_name).add("good_content",good_content).add("good_price",good_price).add("good_image",good_image)
                        .build();
                OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(AddGoodActivity.this, "增加失败", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                       // String good_name = good.getGood_name();
                       // Log.d("获得的数据是","跳转时商品名字："+good.getGood_name());
                        Intent intent1 = getIntent();
                        String useraccount = intent1.getStringExtra("useraccount").toString();
                        Log.d("去个人信息界面","-------------------------------"+useraccount);
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(AddGoodActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddGoodActivity.this,FindAllGoodActivity.class);
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
    }
}
