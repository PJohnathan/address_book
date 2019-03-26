package com.example.zhku.classaddresslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutput;

public class MainActivity extends AppCompatActivity {
    private EditText zhanghao;
    private EditText mima;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zhanghao = findViewById(R.id.zhanghao);
        mima = findViewById(R.id.mima);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = zhanghao.getText().toString().trim();
                String s2 = mima.getText().toString().trim();
                if (TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                    Toast.makeText(MainActivity.this,"请输入账号或者密码",Toast.LENGTH_SHORT).show();
                }else if (s1.equals("admin")&s2.equals("123456")){
                    Intent intent = new Intent(MainActivity.this,tongxunlu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
