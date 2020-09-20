package com.example.gpa_celestinoa1_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    Button button1;
    EditText grade1, grade2, grade3, grade4, grade5;
    TextView calculation;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        grade1 = (EditText) findViewById(R.id.grade1);
        grade2 = (EditText) findViewById(R.id.grade2);
        grade3 = (EditText) findViewById(R.id.grade3);
        grade4 = (EditText) findViewById(R.id.grade4);
        grade5 = (EditText) findViewById(R.id.grade5);
        calculation = (TextView) findViewById(R.id.calculation);
        calculation.setBackgroundColor(Color.WHITE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gra1, gra2, gra3, gra4, gra5;
                if (count % 2 == 0) {
                    if (grade1.getText().toString().equals("") || grade2.getText().toString().equals("") || grade3.getText().toString().equals("") || grade4.getText().toString().equals("") || grade5.getText().toString().equals("")) {
                        calculation.setText("Cannot leave fields empty!");
                    } else {
                        gra1 = Integer.parseInt(grade1.getText().toString());
                        gra2 = Integer.parseInt(grade2.getText().toString());
                        gra3 = Integer.parseInt(grade3.getText().toString());
                        gra4 = Integer.parseInt(grade4.getText().toString());
                        gra5 = Integer.parseInt(grade5.getText().toString());
                        int avg = gra1 + gra2 + gra3 + gra4 + gra5;
                        avg = avg / 5;
                        if (avg < 60) {
                            calculation.setText(Integer.toString(avg));
                            calculation.setBackgroundColor(Color.RED);
                        } else if (avg > 60 && avg < 80) {
                            calculation.setText(Integer.toString(avg));
                            calculation.setBackgroundColor(Color.YELLOW);
                        } else if (avg >= 80 && avg <= 100) {
                            calculation.setText(Integer.toString(avg));
                            calculation.setBackgroundColor(Color.GREEN);
                        }
                        count++;
                        button1.setText("Clear");
                    }

                } else {
                    grade1.setText("");
                    grade2.setText("");
                    grade3.setText("");
                    grade4.setText("");
                    grade5.setText("");
                    calculation.setText("");
                    button1.setText("@string/compute_gpa");
                    calculation.setBackgroundColor(Color.WHITE);
                    count++;
                }
            }
        });
    }
}

