package com.example.zhku.classaddresslist;

import android.bluetooth.le.AdvertisingSetParameters;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class tongxunlu extends AppCompatActivity {

    private SearchView search;
    private ListView list_view;
    private Spinner zhuanye;
    private Spinner banji;
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
        banji = findViewById(R.id.banji);

    }
}
