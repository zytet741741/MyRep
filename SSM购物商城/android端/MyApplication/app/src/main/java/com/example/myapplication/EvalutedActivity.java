package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.R.attr.action;
import static android.R.attr.order;

public class EvalutedActivity extends AppCompatActivity {
    Good good = new Good();
    private String evalutedName = null;
    private String url = null;
    private String orderId;
    private ImageView evaluted_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluted);
        evaluted_image = (ImageView)findViewById(R.id.evaluted_image);
        final TextView evaluted_name = (TextView)findViewById(R.id.evaluted_name);
        final EditText evaluted_content = (EditText)findViewById(R.id.evaluted_content);
        Button evalutedButton = (Button)findViewById(R.id.evaluted_button);


        //获取数据
        Intent intent1 = getIntent();
        final String useraccount = intent1.getStringExtra("useraccount");
        final String orderId = intent1.getStringExtra("orderId");

        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/goods/ToEvaluatedJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("user_account",useraccount).add("orderId",orderId).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(EvalutedActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                List<Good> two_orderList =gson.fromJson(responseData,new TypeToken<List<Good>>(){}.getType());
                for(int i = 0;i<two_orderList.size();i++){
                    evalutedName = two_orderList.get(i).getOrder().getGood_name();
                    url = two_orderList.get(i).getOrder().getGood_image();
                    Log.d("路径",url);
                }
                evaluted_name.setText(evalutedName);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(EvalutedActivity.this).load("http://10.0.2.2:8080/qimo"+url).placeholder(R.mipmap.ic_launcher).override(200,200).error(R.mipmap.ic_launcher).into(evaluted_image);
                    }
                });

//                Glide.with(activity).load("http://10.0.2.2:8080/qimo"+url).placeholder(R.mipmap.ic_launcher).override(200,200).error(R.mipmap.ic_launcher).into(evaluted_image);
            }
        });

        //按钮点击事件
        evalutedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test",orderId);
                final String evalutedContent = evaluted_content.getText().toString();

                //点击实现与web端交互
                String address ="http://10.0.2.2:8080/qimo/goods/AddEvaluated.do";
                RequestBody requestBody = new FormBody.Builder().add("evaluated",evalutedContent).add("orderId",orderId).build();
                OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(EvalutedActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(EvalutedActivity.this, "评价成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EvalutedActivity.this,AllSaleActivity.class);
                            intent.putExtra("useraccount",useraccount);
                            startActivity(intent);
                            Looper.loop();
                        }
                    }
                });


            }
        });


    }


}
