package com.example.zhku.classaddresslist;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;

public class Detail extends AppCompatActivity {
    public static final String STUDENT_NAME = "student_name";
    public static final String STUDENT_IMAGE_ID= "student_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String studentName = intent.getStringExtra(STUDENT_NAME);
        int studentImage = intent.getIntExtra(STUDENT_IMAGE_ID,0);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        //初始化一些控件
        ImageView studentImageView = findViewById(R.id.student_image_view);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                //删除操作
                break;
            case R.id.change:
                //修改操作
                break;
                default:
        }
        return true;
    }
}
