package com.example.internalmarkscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class displayMarks extends AppCompatActivity {

    ListView listView,listView1;
    TextView nameRoll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_marks);

        StudentDetails stud = (StudentDetails) getIntent().getSerializableExtra("obj");
        nameRoll = (TextView) findViewById(R.id.nameRoll);
        nameRoll.setText(stud.name+" - "+stud.rollNo);
        listView = (ListView) findViewById(R.id.theoryDisplay);
        ArrayList<Theory> theoryCourses = new ArrayList<Theory>();

        for(int i=0; i< stud.maxSubject; i++){
            stud.theory[i].calculateMarks();
            theoryCourses.add(stud.theory[i]);
        }

        TheoryListAdapter adapter = new TheoryListAdapter(this, R.layout.theory_marks,theoryCourses);
        listView.setAdapter(adapter);

        listView1 = (ListView) findViewById(R.id.labDisplay);
        ArrayList<Laboratory> LabCourses = new ArrayList<Laboratory>();

        for(int i=0; i<2; i++){
            stud.lab[i].calculateMarks();
            LabCourses.add(stud.lab[i]);
        }

        LabListAdapter adapter1 = new LabListAdapter(this, R.layout.lab_marks,LabCourses);
        listView1.setAdapter(adapter1);

        ListUtils.setDynamicHeight(listView,0);
        ListUtils.setDynamicHeight(listView1,1);
    }

    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView,int k) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            int n = 0,x = 75;
            if(k == 0) {
                n = mListAdapter.getCount() - 1;
                x = 150;
            }
            else {
                n = mListAdapter.getCount();
            }
            for (int i = 0; i < n; i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1))-x;
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
}