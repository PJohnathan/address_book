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
import android.widget.Button;
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
    private ArrayAdapter adapter1;
    private String position1;
    private Button jiansuo;
    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongxunlu);

        list_view = findViewById(R.id.list_view);
        zhuanye = findViewById(R.id.zhuanye);
        adapter1 = ArrayAdapter.createFromResource(this, R.array.zhuanye, android.R.layout.simple_spinner_item);//将内容与arrayadapter连接起来，获取数组里面的数据
        zhuanye.setOnItemSelectedListener(new SpinnerXMLSelectedListener());
        jiansuo = findViewById(R.id.jiansuo);
        jiansuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击检索有进行的操作
                Toast.makeText(tongxunlu.this,position1,Toast.LENGTH_LONG).show();
            }
        });

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
                Intent intent = new Intent(tongxunlu.this,AddActivity.class);
                startActivity(intent);
                break;

                default:
        }
        return true;
    }

    class SpinnerXMLSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            position1 = adapter1.getItem(position).toString();//将获取的专业班级传入position1
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
