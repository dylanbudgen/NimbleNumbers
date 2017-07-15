package com.nimblenumbers.nimblenumbers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    //private static final String SCORE = "com.example.myfirstapp.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();

        int score = intent.getIntExtra("SCORE", 0);
        updateTextValue(R.id.textView_score_value, score);

        int correctAnswers = intent.getIntExtra("CORRECT", 0);
        updateTextValue(R.id.textView_correct_value, correctAnswers);

        int incorrectAnswers = intent.getIntExtra("INCORRECT", 0);
        updateTextValue(R.id.textView_incorrect_value, incorrectAnswers);

        if (correctAnswers == 0) {
            int accuracy = 0;
            updateTextValue(R.id.textView_accuracy_value, accuracy);
        } else {
            double accuracy = ((double) correctAnswers / ((double) correctAnswers + (double) incorrectAnswers)) * 100;
            Log.d("DEBUG", "000P Acc: " + accuracy);
            updateTextValue(R.id.textView_accuracy_value, (int) Math.round(accuracy));
        }


    }




    private void updateTextValue(int id, int value) {

        TextView textView = (TextView) findViewById(id);

        if(id == R.id.textView_accuracy_value) {
            textView.setText(Integer.toString(value) + "%");
        } else {
            textView.setText(Integer.toString(value));
        }


    }








}
