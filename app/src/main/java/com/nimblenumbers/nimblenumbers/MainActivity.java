package com.nimblenumbers.nimblenumbers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void startGame(View view) {

        Log.d("DEBUG", "000P Button pressed ");

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }
}
