package com.example.myapplication;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.util.List;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//public class testIndexActivity extends AppCompatActivity implements View.OnClickListener {
//    TextView responseText;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Button sendRequest = (Button) findViewById(R.id.send_request);
//        responseText = (TextView) findViewById(R.id.response_text);
////        sendRequest.setOnClickListener(this);
//    }
//}

//    @Override
//    public void onClick(View v) {
//        if(v.getId()==R.id.send_request){
//            sendRequestWithOkHttp();
//        }
//    }

//    private void sendRequestWithOkHttp() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    OkHttpClient client  = new OkHttpClient();
//                    Request request = new Request.Builder().url("http://10.0.2.2:8080/SSM/index.jsp").build();
//                    Response response = client.newCall(request).execute();
//                    String responseData = response.body().string();
////                    showResponse(responseData);
//                    pareseJSONWithGSON(responseData);
//                }catch (Exception e ){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//    }

//    private void pareseJSONWithGSON(String responseData) {
//        Gson gson = new Gson();
//        List<Goods> goodsList = gson.fromJson(responseData,new TypeToken<List<Goods>>(){}.getType());
//        for (Goods goods:goodsList){
//            Log.d("testIndexActivity","id is"+goods.getId());
//            Log.d("testIndexActivity","name is"+goods.getTypeid());
//            Log.d("testIndexActivity","name is"+goods.getGood_name());
//            Log.d("testIndexActivity","name is"+goods.getContent());
//            Log.d("testIndexActivity","name is"+goods.getPrice());
//            Log.d("testIndexActivity","name is"+goods.getCreate_date());
//            Log.d("testIndexActivity","name is"+goods.getImgurl());
//
//        }
//    }
//
//    private void showResponse(final String response) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                responseText.setText(response);
//            }
//        });
//
//    }
//}
