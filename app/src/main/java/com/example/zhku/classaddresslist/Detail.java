package com.example.zhku.classaddresslist;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;

import org.litepal.crud.DataSupport;

public class Detail extends AppCompatActivity {

    private EditText tel_text;
    private EditText class_text;
    private EditText address_text;
    private ImageView studentImageView;

    public static final String STUDENT_NAME = "student_name";
    public static final String STUDENT_IMAGE_ID= "student_image_id";
    public static final String STUDENT_TEL = "student_tel";
    public static final String STUDENT_ADDR = "student_addr";
    public static final String STUDENT_CLA = "student_cla";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tel_text = findViewById(R.id.teltphone_text);
        class_text = findViewById(R.id.class_text);
        address_text = findViewById(R.id.address_text);

        Intent intent = getIntent();
        String studentName = intent.getStringExtra(STUDENT_NAME);
        int studentImage = intent.getIntExtra(STUDENT_IMAGE_ID,0);
        String studentTel = intent.getStringExtra(STUDENT_TEL);
        String studentAddr = intent.getStringExtra(STUDENT_ADDR);
        String studentCla = intent.getStringExtra(STUDENT_CLA);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //初始化一些控件
        studentImageView = findViewById(R.id.student_image_view);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(studentName);
        Glide.with(this).load(studentImage).into(studentImageView);
        StringBuilder telBuilder = new StringBuilder();
        telBuilder.append(studentTel);
        tel_text.setText(telBuilder);

        StringBuilder addrBuilder = new StringBuilder();
        addrBuilder.append(studentAddr);
        address_text.setText(addrBuilder);

        StringBuilder claBuilder = new StringBuilder();
        claBuilder.append(studentCla);
        class_text.setText(claBuilder);
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
                DataSupport.deleteAll(Student.class,"telephone = ?",tel_text.getText().toString());
                finish();
                break;
            case R.id.change:
                //修改更新操作
                Student student = new Student();
                student.setTelephone(tel_text.getText().toString());
                student.setAddress(address_text.getText().toString());
                student.setZhuanye(class_text.getText().toString());
                student.updateAll("name = ?","STUDENT_NAME");
                finish();
                break;
                default:
        }
        return true;
    }

}

