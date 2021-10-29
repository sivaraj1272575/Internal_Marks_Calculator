package com.example.internalmarkscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class lab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        StudentDetails stud = (StudentDetails) getIntent().getSerializableExtra("obj");
        TextView courseName = (TextView) findViewById(R.id.course);
        TextView courseCode = (TextView) findViewById(R.id.code);
        courseName.setText(stud.lab[stud.currentSubject].name);
        courseCode.setText(stud.lab[stud.currentSubject].code);
        Button next = (Button) findViewById(R.id.nextBtn3);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText pre1,pre2;
                EditText rep1,rep2;

                pre1 = (EditText) findViewById(R.id.pre1);
                pre2 = (EditText) findViewById(R.id.pre2);
                rep1 = (EditText) findViewById(R.id.rep1);
                rep2 = (EditText) findViewById(R.id.rep2);

                try {
                    stud.lab[stud.currentSubject].preLab[0] = Float.parseFloat(pre1.getText().toString());
                    stud.lab[stud.currentSubject].preLab[1] = Float.parseFloat(pre2.getText().toString());
                    stud.lab[stud.currentSubject].report[0] = Float.parseFloat(rep1.getText().toString());
                    stud.lab[stud.currentSubject].report[1] = Float.parseFloat(rep2.getText().toString());

                    if(stud.lab[stud.currentSubject].validateMarks()) {
                        if (stud.currentSubject < stud.maxLabs-1) {
                            stud.currentSubject += 1;
                            Intent intent = new Intent(getApplicationContext(), lab.class);
                            intent.putExtra("obj", stud);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(getApplicationContext(), displayMarks.class);
                            intent.putExtra("obj", stud);
                            startActivity(intent);
                        }
                    }
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(),"Marks beyond range",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                        toast.show();
                    }

                }
                catch (Exception E)
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Enter numbers only",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
            }
        });


    }
}