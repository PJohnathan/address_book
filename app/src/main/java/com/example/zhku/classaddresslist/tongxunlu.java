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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class tongxunlu extends AppCompatActivity {

    private SearchView search;
    private ListView list_view;
    private Spinner zhuanye;
    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongxunlu);
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
                builder.setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //单击修改后进行的操作
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
