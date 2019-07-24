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

import com.example.myapplication.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by admin on 2019/6/24.
 */

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        initUserInfo();

        Intent intent1 = getIntent();
        final String useraccount = intent1.getStringExtra("user_account");

        //正下方3个ImageView
        ImageView all_good = (ImageView)findViewById(R.id.userinfo_all_good);
        ImageView all_myself = (ImageView)findViewById(R.id.userinfo_all_myself);
        ImageView all_shop = (ImageView)findViewById(R.id.userinfo_all_shop);



        all_good.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this,GoodListActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_myself.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this,MyselfActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

        all_shop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this,ShopCarActivity.class);
                intent.putExtra("useraccount",useraccount);
                startActivity(intent);
            }
        });

    }

    private void initUserInfo() {

        //获取传来得数据
        Intent intent = getIntent();
        String user_account = intent.getStringExtra("user_account").toString();
        Log.d("UserInfoActivity","-------------------------------"+user_account);

        //与WEB端交互
        String address ="http://10.0.2.2:8080/qimo/user/userInfoJSON.do";
        RequestBody requestBody = new FormBody.Builder().add("account",user_account).build();
        OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(UserInfoActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String responseData = response.body().string();
                Log.d("获得的数据是",responseData);
                final User user = gson.fromJson(responseData,User.class);
                Log.d("UserInfoActivity","name is"+user.getAccount());
                TextView name = (TextView) findViewById(R.id.user_name);
                TextView account = (TextView) findViewById(R.id.user_account);
                TextView pwd = (TextView) findViewById(R.id.password);
                TextView sex = (TextView) findViewById(R.id.sex);
                TextView phone = (TextView) findViewById(R.id.phone);
                TextView address = (TextView) findViewById(R.id.address);
                name.setText(user.getUsername());
                account.setText(user.getAccount());
                pwd.setText(user.getPassword());
                sex.setText(user.getSex());
                phone.setText(user.getPhone());
                address.setText(user.getAddress());

                Button update = (Button) findViewById(R.id.update_ui);
                final String user_name = user.getUsername();
                final String user_account = user.getAccount();
                final String password = user.getPassword();
                final String user_sex = user.getSex();
                final String user_phone = user.getPhone();
                final String user_address = user.getAddress();


                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(UserInfoActivity.this,UpdateUIActivity.class);
                        intent.putExtra("user_name",user_name);
                        intent.putExtra("user_account",user_account);
                        intent.putExtra("password",password);
                        intent.putExtra("user_sex",user_sex);
                        intent.putExtra("user_phone",user_phone);
                        intent.putExtra("user_address",user_address);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
