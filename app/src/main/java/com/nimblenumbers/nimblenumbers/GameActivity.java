package com.nimblenumbers.nimblenumbers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    private long questionTime;

    private double score;
    private int correctAnswers;
    private int incorrectAnswers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Should show the keyboard by default
        //((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);


        // THE MODE WILL BE SET BY THE PREVIOUS PAGE
        Intent intent = getIntent();
        mode = intent.getIntExtra("MODE", 0);

        //userLevel = 2;
        correctAnswers = 0;
        incorrectAnswers = 0;
        score = 0;

        startTimer();
        updateScore(score);
        setQuestion();

    }

    @Override
    protected void onResume() {
        super.onResume();

        /*
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        */

    }


    private void startTimer() {

        new CountDownTimer(15000, 1000) {

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

        TextView textView = (TextView) findViewById(R.id.textView_question);
        textView.setTextColor(Color.parseColor("#808080"));

        Random rnd = new Random();

        int number1 = rnd.nextInt(10);
        int number2 = rnd.nextInt(10);

        Log.d("DEBUG", "Number 1 is " + number1);
        Log.d("DEBUG", "Number 2 is " + number2);

        switch(mode) {
            case 5 : // Random
                // Change random to a number from 1-4
                break;
            case 1 : // Addition
                textView.setText(number1 + " + " + number2);
                currentAnswer = number1 + number2;
                break;
            case 2 : // Subtraction
                textView.setText(number1 + " - " + number2);
                currentAnswer = number1 - number2;

                break;
            case 3 : // Multplication
                textView.setText(number1 + " x " + number2);
                currentAnswer = number1 * number2;
                break;
            case 4: // Division
                textView.setText(number1 + " / " + number2);
                currentAnswer = number1 / number2;
                break;

        }

        questionTime = SystemClock.elapsedRealtime();

    }

    public void answerQuestion(View view) {

        Log.d("DEBUG", "000P Answer button pressed ");

        EditText editText = (EditText) findViewById(R.id.editText_answer);

        if (editText.getText().toString().equals("") || !android.text.TextUtils.isDigitsOnly(editText.getText().toString())) {
            Log.d("DEBUG", "000P No answer or invalid input");

            return;
        }

        int answer = Integer.parseInt(editText.getText().toString());

        // Set the question to red or green and wait
        final TextView textView = (TextView) findViewById(R.id.textView_question);

        if(answer == currentAnswer) {
            // Answer is correct

            Log.d("DEBUG", "000P Answer correct");
            correctAnswers++;
            score++;

            textView.setTextColor(Color.parseColor("#008000"));

            long end = SystemClock.elapsedRealtime();
            long delta = end - questionTime;
            double elapsedSeconds = delta / 1000.0;
            Log.d("DEBUG", "000P Time taken: " + elapsedSeconds);


            if (elapsedSeconds < 10) {
                score = score + ((10 - elapsedSeconds) * 3);
                updateScore(score);
            } else {
                score++;
                updateScore(score);
            }



        } else {
            // Answer is incorrect
            Log.d("DEBUG", "000P Answer wrong");
            incorrectAnswers++;
            textView.setTextColor(Color.parseColor("#FF0000"));
        }

        editText.setText("");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // wait

                setQuestion();
            }
        }, 400);

    }

    public void updateScore(double score) {

        Log.d("DEBUG", "IS SCORE NULL? : " + score);

        TextView textView = (TextView) findViewById(R.id.textView_score);
        textView.setText("Score: " + Math.round(score));

    }

    public void endGame() {

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("SCORE", (int) score);
        intent.putExtra("CORRECT", correctAnswers);
        intent.putExtra("INCORRECT", incorrectAnswers);

        startActivity(intent);

        Log.d("DEBUG", "000P Attempting to open new activity");

    }





}
