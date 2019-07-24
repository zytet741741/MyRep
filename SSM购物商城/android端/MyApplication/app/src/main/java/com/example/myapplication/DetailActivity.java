package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String TEST_NAME = "test_name";
    public static final String TEST_IMAGE_ID = "test_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String testName = intent.getStringExtra(TEST_NAME);
        int testImageId = intent.getIntExtra(TEST_IMAGE_ID,0);
        Toolbar toolbar  = (Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView testImageView = (ImageView)findViewById(R.id.test_image_view);
        TextView testContentText = (TextView)findViewById(R.id.test_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(testName);
        Glide.with(this).load(testImageId).into(testImageView);
        String testContent = generateTestContent(testName);
        testContentText.setText(testContent);

    }

    private String generateTestContent(String testName) {
        StringBuilder testContent = new StringBuilder();
        for(int i = 0;i<500;i++){
            testContent.append(testName);
        }
        return testContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
