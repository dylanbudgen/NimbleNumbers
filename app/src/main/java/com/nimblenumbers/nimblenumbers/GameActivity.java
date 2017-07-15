package com.nimblenumbers.nimblenumbers;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static android.R.id.message;

public class GameActivity extends AppCompatActivity {

    public static final String SCORE = "com.nimblenumbers.nimblenumbers.SCORE";
    public static final String CORRECT = "com.nimblenumbers.nimblenumbers.CORRECT";
    public static final String INCORRECT = "com.nimblenumbers.nimblenumbers.INCORRECT";



    private int userLevel;
    private int mode;

    private int currentAnswer;

    private int score;
    private int correctAnswers;
    private int incorrectAnswers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Should show the keyboard by default
        //((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);


        // THE MODE WILL BE SET BY THE PREVIOUS PAGE
        userLevel = 2;
        mode = 1;
        correctAnswers = 0;
        incorrectAnswers = 0;
        score = 0;

        startTimer();
        setQuestion();

    }




    private void startTimer() {

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {

                TextView textView = (TextView) findViewById(R.id.textView_time);
                textView.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                TextView textView = (TextView) findViewById(R.id.textView_time);

                endGame();

            }
        }.start();

    }

    private void setQuestion() {

        Random rnd = new Random();

        int number1 = rnd.nextInt(10);
        int number2 = rnd.nextInt(10);

        Log.d("DEBUG", "Number 1 is " + number1);
        Log.d("DEBUG", "Number 2 is " + number2);

        TextView textView = (TextView) findViewById(R.id.textView_question);


        switch(mode) {
            case 1 :
                textView.setText(number1 + " + " + number2);
                currentAnswer = number1 + number2;
                break;
        }


    }

    public void answerQuestion(View view) {

        Log.d("DEBUG", "000P Answer button pressed ");

        EditText editText = (EditText) findViewById(R.id.editText_answer);

        if (editText.getText().toString() == null) {
            Log.d("DEBUG", "000P No answer");
            return;
        }

        int answer = Integer.parseInt(editText.getText().toString());

        if(answer == currentAnswer) {
            Log.d("DEBUG", "000P Answer correct");
            correctAnswers++;
            score++;

        } else {
            Log.d("DEBUG", "000P Answer wrong");
            incorrectAnswers++;
        }

        editText.setText("");
        setQuestion();


    }

    public void endGame() {

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("SCORE", score * userLevel);
        intent.putExtra("CORRECT", correctAnswers);
        intent.putExtra("INCORRECT", incorrectAnswers);

        startActivity(intent);

        Log.d("DEBUG", "000P Attempting to open new activity");

    }





}
