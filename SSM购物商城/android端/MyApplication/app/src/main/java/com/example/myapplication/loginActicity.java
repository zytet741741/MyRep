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
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class loginActicity extends AppCompatActivity {
    User user = new User();
    JSONObject userObject = null;
    private RadioButton userRb;
    private RadioButton businessRd;
    private String typeId ;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameEdit = (EditText)findViewById(R.id.username);
        final EditText passwordEdit = (EditText)findViewById(R.id.password);
        final Button login = (Button)findViewById(R.id.login);
        final Button toRegister = (Button)findViewById(R.id.to_register);
        userRb = (RadioButton)findViewById(R.id.rd_user);
        businessRd = (RadioButton)findViewById(R.id.rd_business);


        //登录按钮触发事件
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(userRb.isChecked()){
                    typeId = "1";
                    address ="http://10.0.2.2:8080/qimo/user/loginJson.do";
                }
                if (businessRd.isChecked()){
                    typeId = "2";
                    address ="http://10.0.2.2:8080/qimo/user/ShangJialoginJSON.do";
                }

//              RequestBody requestBody = new FormBody.Builder().add("account",username).add("password",password).add("user_type_id",typeId).build();
                RequestBody requestBody = new FormBody.Builder().add("account",username).add("password",password).build();
                //提交账号密码并且验证
                OkHttpUtil.postOksendRequestWithOkHttp(address,requestBody, new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(loginActicity.this, "失败", Toast.LENGTH_SHORT).show();
                        Looper.prepare();
                    }
                    //成功提交请求
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String username = usernameEdit.getText().toString();
                        String password = passwordEdit.getText().toString();
                        String responseData = response.body().string();

                        Log.d("获得的数据是",responseData);
                        try {
                            userObject = new JSONObject(responseData);
                            user.setAccount((String) userObject.get("account"));
                            user.setPassword((String) userObject.get("password"));
                            user.setUser_type_id((int)userObject.get("user_type_id"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.d("111",user.getAccount()+"  "+user.getPassword());
                            if (user.getAccount().equals(username)){
                                if(user.getPassword().equals(password)){
                                    if (!user.getUser_type_id().toString().equals(typeId)){
                                        Looper.prepare();
                                        Toast.makeText(loginActicity.this, "请选择正确的登录类型！", Toast.LENGTH_SHORT).show();
                                        Looper.loop();
                                    } else{
                                        //添加逻辑代码
                                        Log.d("测试typeID和user.typeID", typeId + "-------------------" + user.getUser_type_id());
                                        if(user.getUser_type_id().toString().equals(typeId)&&typeId.equals("1")) {
                                            Intent intent = new Intent(loginActicity.this, GoodListActivity.class);
                                            intent.putExtra("useraccount", username);
                                            startActivity(intent);
                                        }
                                        if (user.getUser_type_id().toString().equals(typeId)&&typeId.equals("2")){
                                            Intent intent = new Intent(loginActicity.this, FindShangJiaInfoActivity.class);
                                            intent.putExtra("useraccount", username);
                                            startActivity(intent);
                                        }
                                    }
                              }else {
                                 Looper.prepare();
                                 Toast.makeText(loginActicity.this, "密码错误", Toast.LENGTH_SHORT).show();
                                 Looper.loop();
                              }
                          }else{
                             Looper.prepare();
                             Toast.makeText(loginActicity.this, "账号错误", Toast.LENGTH_SHORT).show();
                             Looper.loop();
                           }

                    }
                });
            }
        });

        //去注册界面
        toRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActicity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });




    }
}
