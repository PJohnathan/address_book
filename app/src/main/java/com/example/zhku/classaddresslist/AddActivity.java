package com.example.zhku.classaddresslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

public class AddActivity extends AppCompatActivity {

    //声明添加页面里面的编辑框
    private EditText add_name;
    private EditText add_address;
    private EditText add_tel;
    private EditText add_class;
    private Button add;
    private Button cancle;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_students);

        //对添加页面里面的内容初始化
        add_name = findViewById(R.id.add_name);
        add_address = findViewById(R.id.add_address);
        add_class = findViewById(R.id.add_class);
        add_tel = findViewById(R.id.add_telephone);
        add = findViewById(R.id.add_change);
        cancle = findViewById(R.id.add_cancle);

        //final String name = add_name.getText().toString();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String addName = add_name.getText().toString();
                String addClass = add_class.getText().toString();
                String addTel = add_tel.getText().toString();
                String addAddress = add_address.getText().toString();

                Connector.getDatabase();//点击后会创建数据库
                //获取添加的数据到数据库
                Student student = new Student();
                student.setName(addName);
                student.setZhuanye(addClass);
                student.setTelephone(addTel);
                student.setAddress(addAddress);
                student.save();
                Toast.makeText(AddActivity.this,"添加成功",Toast.LENGTH_SHORT).show();

                //清空数据
                add_name.setText("");
                add_class.setText("");
                add_tel.setText("");
                add_address.setText("");
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this,tongxunlu.class);
                startActivity(intent);
            }
        });

    }
}
