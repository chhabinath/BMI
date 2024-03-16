package com.chhabinath.bmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edWeight;
        EditText edHeightFt;
        EditText edHeightIn;
        Button BMIButtonId;
        TextView result;
        LinearLayout llMain;

        edWeight = findViewById(R.id.edWeight);
        edHeightFt = findViewById(R.id.edHeightFt);
        edHeightIn = findViewById(R.id.edHeightIn);
        BMIButtonId = findViewById(R.id.BMIButtonId);
        result = findViewById(R.id.result);
        llMain = findViewById(R.id.llMain);

        BMIButtonId.setOnClickListener(view -> {
            int wt = Integer.parseInt(edWeight.getText().toString());
            int htFt = Integer.parseInt(edHeightFt.getText().toString());
            int htIn = Integer.parseInt(edHeightIn.getText().toString());

            int totalInches = htFt * 12 + htIn;

            double totalCm = totalInches * 2.53;

            double totalM = totalCm / 100;

            double bmi = wt / (totalM * totalM);

            if (bmi > 25) {
                result.setText("You are Over Weight");
                llMain.setBackgroundColor(getResources().getColor(R.color.red));
            } else if (bmi < 18) {
                result.setText("You are Under Weight");
                llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
            } else {
                result.setText("You are Healthy");
                llMain.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });


    }
}