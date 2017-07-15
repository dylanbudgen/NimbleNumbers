package com.nimblenumbers.nimblenumbers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlayOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_options);
    }



    public void startAdditionGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("MODE", 1);
        startActivity(intent);
    }

    public void startSubtractionGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("MODE", 2);
        startActivity(intent);
    }

    public void startMultiplicationGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("MODE", 3);
        startActivity(intent);
    }

    public void startDivisionGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("MODE", 4);
        startActivity(intent);
    }

    public void startRandomGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("MODE", 5);
        startActivity(intent);
    }



}
