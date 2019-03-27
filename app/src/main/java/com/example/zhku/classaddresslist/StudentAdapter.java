package com.example.zhku.classaddresslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    private int resourceId;
    public StudentAdapter(Context context, int textViewResourceId, List<Student> objects) {
        super(context, textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Student student = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.student_image = view.findViewById(R.id.student_image);
            viewHolder.student_name = view.findViewById(R.id.student_name);
            view.setTag(viewHolder);//将viewholder存储在View中
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取viewholder
        }

        viewHolder.student_image.setImageResource(student.getImageId());
        viewHolder.student_name.setText(student.getName());
        return view;
    }

    class ViewHolder{
        ImageView student_image;
        TextView student_name;
    }
}
