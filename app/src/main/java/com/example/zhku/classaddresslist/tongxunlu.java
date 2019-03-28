package com.example.zhku.classaddresslist;

import android.bluetooth.le.AdvertisingSetParameters;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class tongxunlu extends AppCompatActivity {

    private SearchView search;
    private ListView list_view;
    private Spinner zhuanye;
    private List<Student> studentList = new ArrayList<>();

    //声明对话框里面的编辑框
    private EditText add_name;
    private EditText add_address;
    private EditText add_tel;
    private EditText add_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongxunlu);

        //对对话框里面的内容初始化
        add_name = findViewById(R.id.add_name);
        add_address = findViewById(R.id.add_address);
        add_class = findViewById(R.id.add_class);
        add_tel = findViewById(R.id.add_telephone);

        list_view = findViewById(R.id.list_view);
        final StudentAdapter adapter = new StudentAdapter(this,R.layout.student_item,studentList);
        list_view.setAdapter(adapter);
        list_view.setTextFilterEnabled(true);//设置listview启用过滤
        search = findViewById(R.id.search);
        search.setSubmitButtonEnabled(true);//设置该searchview显示搜索按钮
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单击搜索按钮时激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            //用户输入字符时激发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    //list_view.clearTextFilter();//清除过滤
                    adapter.getFilter().filter("");
                }else {
                   // list_view.setFilterText(newText);//使用用户输入的内容对listview的列表进行过滤，出现黑框
                    adapter.getFilter().filter(newText);
                }
                return true;
            }
        });

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentList.get(position);
                //点击进行页面跳转
            }
        });

        zhuanye = findViewById(R.id.zhuanye);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.title,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                //跳入添加的界面
                AlertDialog.Builder builder = new AlertDialog.Builder(tongxunlu.this);
                LayoutInflater inflater = tongxunlu.this.getLayoutInflater();//获取layoutinflater对象
                View layout = inflater.inflate(R.layout.add_students,null);//创建布局
                builder.setIcon(R.drawable.student);
                builder.setTitle("添加学生信息");
                builder.setView(layout);//动态加载布局
                builder.setPositiveButton("添加", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //单击添加后进行的操作
                        Connector.getDatabase();//点击后会创建数据库
                        //获取添加的数据到数据库
                        Student student = new Student();
                        student.setName(add_name.getText().toString());
                        student.setZhuanye(add_class.getText().toString());
                        student.setTelephone(add_tel.getText().toString());
                        student.setAddress(add_address.getText().toString());
                        Toast.makeText(tongxunlu.this,"添加成功",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //单击取消后的操作
                        Toast.makeText(tongxunlu.this,"你取消了添加学生信息",Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();//显示对话框
                break;
                default:
        }
        return true;
    }

}
