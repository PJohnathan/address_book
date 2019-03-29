package com.example.zhku.classaddresslist;

import android.bluetooth.le.AdvertisingSetParameters;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.RelativeDateTimeFormatter;
import android.location.Address;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import org.litepal.crud.DataSupport;
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
    private StudentAdapter adapter;

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
            //点击检索有进行的操作
            @Override
            public void onClick(View v) {

                //列表为空时直接添加数据
                if (studentList.isEmpty()) {

                    //选择物联网工程161班的情况
                    if (position1.equals("物联网工程161班")) {
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程161班").order("name").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p9, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    } else if (position1.equals("物联网工程162班")) {//选则物联网工程162班的情况
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程162班").order("name").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p1, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        StudentAdapter adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    }else if (position1.equals("物联网工程163班")){
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程163班").order("name").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p3, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        StudentAdapter adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    }else if (position1.equals("物联网工程164班")){
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程164班").order("name").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p4, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        StudentAdapter adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    }

                } else{
                    if (position1.equals("物联网工程161班")) {
                        studentList.removeAll(studentList);
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程161班").order("name desc").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p9, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    }else if (position1.equals("物联网工程162班")){
                        studentList.removeAll(studentList);
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程162班").order("name desc").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p1, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        StudentAdapter adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    }else if (position1.equals("物联网工程163班")){
                        studentList.removeAll(studentList);
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程163班").order("name desc").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p3, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        StudentAdapter adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    }else if (position1.equals("物联网工程164班")){
                        studentList.removeAll(studentList);
                        List<Student> students = DataSupport.where("zhuanye = ?", "物联网工程164班").order("name desc").find(Student.class);
                        for (Student student : students) {
                            Student student1 = new Student(R.drawable.p4, student.getName(),student.getTelephone(),student.getAddress(),student.getZhuanye());
                            studentList.add(student1);
                        }
                        adapter = new StudentAdapter(tongxunlu.this, R.layout.student_item, studentList);
                        list_view.setAdapter(adapter);
                    }
                }
                Toast.makeText(tongxunlu.this, position1, Toast.LENGTH_LONG).show();
            }
        });

        //list_view.setTextFilterEnabled(true);//设置listview启用过滤
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
                   //list_view.setFilterText(newText);//使用用户输入的内容对listview的列表进行过滤，出现黑框
                    adapter.getFilter().filter(newText);
                }
                return true;
            }
        });

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentList.get(position);
                //点击进行页面跳转,并且传数据
                Intent intent = new Intent(tongxunlu.this,Detail.class);
                intent.putExtra(Detail.STUDENT_NAME,student.getName());
                intent.putExtra(Detail.STUDENT_IMAGE_ID,student.getImageId());
                intent.putExtra(Detail.STUDENT_TEL,student.getTelephone());
                intent.putExtra(Detail.STUDENT_ADDR,student.getAddress());
                intent.putExtra(Detail.STUDENT_CLA,student.getZhuanye());
                startActivity(intent);
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
