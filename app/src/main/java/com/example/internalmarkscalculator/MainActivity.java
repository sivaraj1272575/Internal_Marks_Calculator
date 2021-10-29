package com.example.internalmarkscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText studentName;
    private EditText studentRollNo;
    private Button next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentName = (EditText) findViewById(R.id.studentName);
        studentRollNo = (EditText) findViewById(R.id.studentRollNo);
        next1 = (Button) findViewById(R.id.nextBtn1);


        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String name = studentName.getText().toString();
                String rollNo = studentRollNo.getText().toString();
                StudentDetails stud = new StudentDetails(name,rollNo);
                Intent intent = new Intent(getApplicationContext(),Subject1.class);
                intent.putExtra("obj",stud);
                startActivity(intent);
            }
        });

    }
}