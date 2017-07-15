package com.nimblenumbers.nimblenumbers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean sound = sharedPref.getBoolean("sound", true);
        Button highscore = (Button) findViewById(R.id.button_highscore);
        if (sharedPref.getInt("highscore", 0) == 0) {
            highscore.setEnabled(false);
            setInitialPreferences(sharedPref);
        }
        else{
            highscore.setEnabled(true);

        }
    }

    private void setInitialPreferences(SharedPreferences sharedPref){
        int avgAcc = sharedPref.getInt("avgAcc", 0);
        int totalQuestions = sharedPref.getInt("totalQuestions", 0);
        double avgTime = sharedPref.getInt("avgTime", 0);
        int totalCorrect = sharedPref.getInt("totalCorrect", 0);
        int totalInorrect = sharedPref.getInt("totalInorrect", 0);
        int currentLevel = sharedPref.getInt("currentLevel", 0);

    }
/*
    public void setSound(View view, SharedPreferences sharedPref){
        if sharedPref.getBoolean("sound", true)
    }*/
    public void seeHighscore(View view){
        Log.d("DEBUG", "000P Highscore pressed ");
        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);
    }
    public void startGame(View view) {

        Log.d("DEBUG", "000P Button pressed ");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }
}
