package com.example.internalmarkscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dummyactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummyactivity);

        StudentDetails stud = (StudentDetails) getIntent().getSerializableExtra("obj");
        System.out.println(stud.lab[0].preLab[0]);
        System.out.println(stud.lab[0].preLab[1]);
        System.out.println(stud.lab[1].report[1]);
    }
}