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

public class TheoryListAdapter extends ArrayAdapter<Theory>{
    private static final String TAG = "TheoryListAdapter";
    private Context theoryContext;
    private int theoryResource;



    public TheoryListAdapter(Context context, int resource, ArrayList<Theory> objects){
        super(context,resource,objects);
        theoryContext = context;
        theoryResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Theory theory = new Theory();
        theory = getItem(position);
        LayoutInflater layoutInflater = LayoutInflater.from(theoryContext);
        convertView = layoutInflater.inflate(theoryResource,parent,false);
        TextView courseName,courseCode, CA1,CA2,CA3,tut1,tut2,ap,aggCA,total;
        courseName = convertView.findViewById(R.id.courseName);
        courseCode = convertView.findViewById(R.id.courseCode);
        CA1 = convertView.findViewById(R.id.ca1);
        CA2 = convertView.findViewById(R.id.ca2);
        CA3 = convertView.findViewById(R.id.ca3);
        aggCA = convertView.findViewById(R.id.aggCa);
        tut1 = convertView.findViewById(R.id.tut1);
        tut2 = convertView.findViewById(R.id.tut2);
        ap = convertView.findViewById(R.id.ap);
        total = convertView.findViewById(R.id.total);

        courseName.setText(theory.name);
        courseCode.setText(theory.code);
        CA1.setText(String.format("%.2f",theory.CA[0]));
        CA2.setText(String.format("%.2f",theory.CA[1]));
        CA3.setText(String.format("%.2f",theory.CA[2]));
        aggCA.setText(String.format("%.2f",theory.aggCA));
        tut1.setText(String.format("%.2f",theory.tut[0]));
        tut2.setText(String.format("%.2f",theory.tut[1]));
        ap.setText(String.format("%.2f",theory.ap));
        total.setText(String.format("%.2f",theory.total));

        return convertView;
    }
}
