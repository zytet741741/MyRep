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

public class EditShangJiaActivity extends AppCompatActivity {
    User user;
    ImageView img_edit_shangJiahead_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shang_jia);
        initEditShangJiaInfo();
        Button btn_edit_shangJiaInfoT = (Button) findViewById(R.id.btn_edit_shangJiaInfoT);
        Button btn_edit_shangJiaInfoChangeF = (Button) findViewById(R.id.btn_edit_shangJiaInfoChangeF);
        //点击编辑页面中的取消按钮，并返回到FindShangJiaInfoActivity
        btn_edit_shangJiaInfoChangeF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String useraccount = intent.getStringExtra("useraccount").toString();
                Log.d("GoodInfoChangeActivity","-----------------商品名称："+useraccount);
                intent = new Intent(EditShangJiaActivity.this,FindShangJiaInfoActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        ////点击编辑页面中的确认修改按钮，并返回到FindShangJiaInfoActivity
        btn_edit_shangJiaInfoT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                img_edit_shangJiahead_image = (ImageView) findViewById(R.id.img_edit_shangJiahead_image);
                //获取控件id
                TextView TxtV_edit_shangJiaAccount = (TextView) findViewById(R.id.TxtV_edit_shangJiaAccount);
                EditText edit_shangJiaName = (EditText) findViewById(R.id.edit_shangJiaName);
                EditText edit_shangJiaPsw = (EditText) findViewById(R.id.edit_shangJiaPsw);
                EditText edit_shangJiaSX = (EditText) findViewById(R.id.edit_shangJiaSX);
                EditText edit_shangJiaPhone = (EditText) findViewById(R.id.edit_shangJiaPhone);
                EditText edit_shangJiaAddr = (EditText) findViewById(R.id.edit_shangJiaAddr);
                //获取控件里的内容
                String account = TxtV_edit_shangJiaAccount.getText().toString();
                String username = edit_shangJiaName.getText().toString();
                String password = edit_shangJiaPsw.getText().toString();
                String sex = edit_shangJiaSX.getText().toString();
                String phone = edit_shangJiaPhone.getText().toString();
                String address = edit_shangJiaAddr.getText().toString();
                //与Web端交互
                String address1 ="http://10.0.2.2:8080/qimo/user/updateShangJiaInfoJSON.do";
                RequestBody requestBody = new FormBody.Builder().add("account",account).add("username",username).add("password",password).add("sex",sex).add("phone",phone)
                        .add("address",address)
                        .build();
                OkHttpUtil.postOksendRequestWithOkHttp(address1,requestBody, new okhttp3.Callback(){


                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast.makeText(EditShangJiaActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                       String account = user.getAccount();
                        Log.d("获得的数据是","跳转时商家账号："+ user.getAccount());
                        Gson gson = new Gson();
                        String responseData = response.body().string();
                        Log.d("获得的数据是",responseData);
                        if(responseData.equals("success")){
                            Looper.prepare();
                            Toast.makeText(EditShangJiaActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EditShangJiaActivity.this,FindShangJiaInfoActivity.class);
                            intent.putExtra("useraccount",account);
                            Log.d("跳转","+++++++++");
                            startActivity(intent);
                            Looper.loop();
                        }

                    }
                });
            }
        });

    }



    private void  initEditShangJiaInfo(){
        //获取传来得数据
        Intent intent = getIntent();
        String useraccount = intent.getStringExtra("useraccount").toString();
        Log.d("EditShangJiaActivity","-------------------------------"+useraccount);
        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/user/shangJiaInfoJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("account",useraccount).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){


            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(EditShangJiaActivity.this, "查询失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                user = gson.fromJson(responseData,User.class);
                Log.d("获得的数据是",responseData);
                //把查询到的信息显示出来
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img_edit_shangJiahead_image = (ImageView) findViewById(R.id.img_edit_shangJiahead_image);
                        TextView TxtV_edit_shangJiaAccount = (TextView) findViewById(R.id.TxtV_edit_shangJiaAccount);
                        EditText edit_shangJiaName = (EditText) findViewById(R.id.edit_shangJiaName);
                        EditText edit_shangJiaPsw = (EditText) findViewById(R.id.edit_shangJiaPsw);
                        EditText edit_shangJiaSX = (EditText) findViewById(R.id.edit_shangJiaSX);
                        EditText edit_shangJiaPhone = (EditText) findViewById(R.id.edit_shangJiaPhone);
                        EditText edit_shangJiaAddr = (EditText) findViewById(R.id.edit_shangJiaAddr);
                        Glide.with(EditShangJiaActivity.this)
                                .load("http://10.0.2.2:8080/qimo/"+user.getHead_image())
                                .into(img_edit_shangJiahead_image);
                        TxtV_edit_shangJiaAccount.setText(user.getAccount());
                        edit_shangJiaName.setText(user.getUsername());
                        edit_shangJiaPsw.setText(user.getPassword());
                        edit_shangJiaSX.setText(user.getSex());
                        edit_shangJiaPhone.setText(user.getPhone());
                        edit_shangJiaAddr.setText(user.getAddress());

                    }
                });

            }
        });
    }
}
