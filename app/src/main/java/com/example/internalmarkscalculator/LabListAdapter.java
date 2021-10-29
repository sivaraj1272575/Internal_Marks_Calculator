package com.example.internalmarkscalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LabListAdapter extends ArrayAdapter<Laboratory>{
    private static final String TAG = "LabListAdapter";
    private Context labContext;
    private int labResource;



    public LabListAdapter(Context context, int resource, ArrayList<Laboratory> objects){
        super(context,resource,objects);
        labContext = context;
        labResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Laboratory lab = new Laboratory();
        lab = getItem(position);
        LayoutInflater layoutInflater = LayoutInflater.from(labContext);
        convertView = layoutInflater.inflate(labResource,parent,false);
        TextView courseName,courseCode, pre1,pre2,rep1,rep2,total;
        courseName = convertView.findViewById(R.id.courseLab);
        courseCode = convertView.findViewById(R.id.courseLabCode);
        pre1 = convertView.findViewById(R.id.prelab1);
        pre2 = convertView.findViewById(R.id.prelab2);
        rep1 = convertView.findViewById(R.id.report1);
        rep2 = convertView.findViewById(R.id.report2);
        total = convertView.findViewById(R.id.totalLab);

        courseName.setText(lab.name);
        courseCode.setText(lab.code);
        pre1.setText(String.format("%.2f",lab.preLab[0]));
        pre2.setText(String.format("%.2f",lab.preLab[1]));
        rep1.setText(String.format("%.2f",lab.report[0]));
        rep2.setText(String.format("%.2f",lab.report[1]));
        total.setText(String.format("%.2f",lab.total));

        return convertView;
    }
}
