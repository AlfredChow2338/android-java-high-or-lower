package com.example.alfredchow.higher_lower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int rand_int;

    public void generateRandInt() {
        Random rand = new Random();
        rand_int = rand.nextInt(100) + 1;
    }

    public void guessFun(View view){
        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);
        String guessNumStr = numberEditText.getText().toString();
        int guessNum = Integer.parseInt(guessNumStr);

        String message;

        if(guessNum > rand_int) {
            message = "Lower!";
        } else if (guessNum < rand_int) {
            message = "Higher!";
        } else {
            message = "You got it! Try again!";
            generateRandInt();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandInt();
    }
}
