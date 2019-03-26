package com.example.zhku.classaddresslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class tongxunlu extends AppCompatActivity {

    private SearchView search;
    private ListView list_view;
    private final String[] mstrings={"sfsf","asdasda","adasd"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongxunlu);
        list_view = findViewById(R.id.list_view);
        list_view.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mstrings));
        list_view.setTextFilterEnabled(true);//设置listview启用过滤
        search = findViewById(R.id.search);
        search.setIconifiedByDefault(false);//设置该searchview默认是否自动缩小图标;
        search.setSubmitButtonEnabled(true);//设置该searchview显示搜索按钮
        search.setQueryHint("查找");//设置该searchview内默认显示的提示文本
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
                    list_view.clearTextFilter();//清除过滤
                }else {
                    list_view.setFilterText(newText);//使用用户输入的内容对listview的列表进行过滤
                }
                return true;
            }
        });
    }
}
