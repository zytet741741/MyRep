package com.example.myapplication;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
    private RadioButton maleRb;
    private RadioButton famaleRb;

    private String account;
    private String password;
    private String username;
    private String sex;
    private String phone;
    private String address;
    JSONObject responseObject = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText accountEdit = (EditText)findViewById(R.id.register_user_account);
        final EditText passwordEdit = (EditText)findViewById(R.id.register_user_password);
        final EditText usernameEdit = (EditText)findViewById(R.id.register_username);
        maleRb  =(RadioButton)findViewById(R.id.rd_male);
        famaleRb  =(RadioButton)findViewById(R.id.rd_famale);
        final EditText phoneEdit = (EditText)findViewById(R.id.register_phone);
        final EditText addressEdit = (EditText)findViewById(R.id.register_address);
        Button register = (Button)findViewById(R.id.register);
        Button register_zhuxiao = (Button)findViewById(R.id.register_zhuxiao);
//        final Button rg_sex =(Button)findViewById(R.id.rg_sex);
        //注册事件

        //返回登录
        register_zhuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,loginActicity.class);
                startActivity(intent);
            }
        });
      /*  //性别选择
        rg_sex.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(maleRb.isChecked()){
                    sex=maleRb.getText().toString();
                    Toast.makeText(RegisterActivity.this,sex,Toast.LENGTH_SHORT).show();
                }
                if(famaleRb.isChecked()){
                    sex=famaleRb.getText().toString();
                    Toast.makeText(RegisterActivity.this,sex,Toast.LENGTH_SHORT).show();
                }
            }
        });
        Toast.makeText(RegisterActivity.this,"11111"+sex,Toast.LENGTH_SHORT).show();*/

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                 account = accountEdit.getText().toString();
                 password = passwordEdit.getText().toString();
                 username = usernameEdit.getText().toString();
                 phone = phoneEdit.getText().toString();
                 address = addressEdit.getText().toString();
                if(maleRb.isChecked()){
                    sex=maleRb.getText().toString();
//                    Toast.makeText(RegisterActivity.this,sex,Toast.LENGTH_SHORT).show();
                }
                if(famaleRb.isChecked()){
                    sex=famaleRb.getText().toString();
//                    Toast.makeText(RegisterActivity.this,sex,Toast.LENGTH_SHORT).show();
                }
                //传向Web端
                String webAddress ="http://10.0.2.2:8080/qimo/user/addRegisterJSON.do";
                RequestBody requestBody = new FormBody.Builder().add("account",account)
                                                                 .add("password",password)
                                                                 .add("username",username)
                                                                 .add("sex",sex)
                                                                 .add("phone",phone)
                                                                 .add("address",address)
                                                                 .add("user_type_id","1").build();

                OkHttpUtil.postOksendRequestWithOkHttp(webAddress,requestBody, new okhttp3.Callback(){
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(RegisterActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        Log.d("获得的数据是",responseData);
                        if (responseData.equals("SUCCESS")){
                            Looper.prepare();
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, loginActicity.class);
                            startActivity(intent);
                            Looper.loop();
                        }
                    }
                });

            }
        });


    }


}
