package com.nimblenumbers.nimblenumbers;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import static android.R.id.message;

public class GameActivity extends AppCompatActivity {



    int userLevel;



    int currentAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Should show the keyboard by default
        //((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        startTimer();
        //setQuestion();

    }






    private void startTimer() {

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {

                TextView textView = (TextView) findViewById(R.id.textView_time);
                textView.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                TextView textView = (TextView) findViewById(R.id.textView_time);
                textView.setText("done!");
            }
        }.start();

    }









    public void answerQuestion(View view) {

        Log.d("DEBUG", "000P Answer button pressed ");


    }





}
