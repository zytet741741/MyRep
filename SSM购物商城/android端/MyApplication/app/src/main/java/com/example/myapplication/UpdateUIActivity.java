package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by admin on 2019/6/24.
 */

public class UpdateUIActivity extends AppCompatActivity {
    private String username;
    private String user_account ;
    private String password;
    private String sex;
    private String phone;
    private String address_two;
    private EditText et_user_name;
    private TextView tv_user_account;
    private EditText et_password;
    private EditText et_sex;
    private EditText et_phone;
    private EditText et_address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateui);

        //测试
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        tv_user_account = (TextView)findViewById(R.id.tv_user_account);
        et_password = (EditText)findViewById(R.id.et_password);
        et_sex = (EditText)findViewById(R.id.et_sex);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_address = (EditText)findViewById(R.id.et_address);



        Intent intent1 = getIntent();
        user_account = intent1.getStringExtra("user_account").toString();
        username = intent1.getStringExtra("user_name").toString();
        password = intent1.getStringExtra("password").toString();
        sex = intent1.getStringExtra("user_sex").toString();
        phone = intent1.getStringExtra("user_phone").toString();
        address_two = intent1.getStringExtra("user_address").toString();


        Log.d("UpdataUIActivity",user_account);
        tv_user_account.setText(user_account);
        et_user_name.setText(username);
        et_password .setText(password);
        et_sex.setText(sex);
        et_phone.setText(phone);
        et_address.setText(address_two);


        Button sure = (Button) findViewById(R.id.update_ui_sure);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_user_name.getText().toString();
                Log.d("UpdataUIActivity",username);
                password = et_password.getText().toString();
                Log.d("UpdataUIActivity",password);
                sex = et_sex.getText().toString();
                Log.d("UpdataUIActivity",sex);
                phone = et_phone.getText().toString();
                Log.d("UpdataUIActivity",phone);
                address_two = et_address.getText().toString();
                Log.d("UpdataUIActivity",address_two);
                initUserInfo2();
                Intent intent = new Intent(UpdateUIActivity.this,UserInfoActivity.class);
                intent.putExtra("user_account",user_account);
                startActivity(intent);
            }
        });

        Intent intent2 = getIntent();
        final String useraccount = intent2.getStringExtra("user_account");

        //正下方3个ImageView
        ImageView all_good = (ImageView)findViewById(R.id.updateui_all_good);
        ImageView all_myself = (ImageView)findViewById(R.id.updateui_all_myself);
        ImageView all_shop = (ImageView)findViewById(R.id.updateui_all_shop);



        all_good.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateUIActivity.this,GoodListActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_myself.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateUIActivity.this,MyselfActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_shop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateUIActivity.this,ShopCarActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });
    }

    private void initUserInfo2() {


//        //获取传来得数据
//        Intent intent = getIntent();
//        String user_account = intent.getStringExtra("user_account").toString();
//        Log.d("UserInfoActivity","-------------------------------"+user_account);

        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/user/updateUserInfoJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("account",user_account)
                .add("username",username)
                .add("password",password)
                .add("sex",sex)
                .add("phone",phone)
                .add("address",address_two)
               .build();

        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(UpdateUIActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);

//                final User userInfo2 =gson.fromJson(responseData,User.class);
//                Log.d("UnPayActivity","name is"+userInfo2.getAccount());
//                Log.d("UnPayActivity","image is"+userInfo2.getUsername());

            }
        });
    }
}
