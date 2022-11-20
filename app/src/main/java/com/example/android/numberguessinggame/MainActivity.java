package com.example.android.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //    Random rand = new Random();
//    int random_int = rand.nextInt(100);
//    int i=0;
    int random;
    int cnt = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        random = rand.nextInt(100);
    }


    public void submit(View v) {
        EditText edit_text = findViewById(R.id.inupt_text_view);
        String str = edit_text.getText().toString();

        int num = Integer.parseInt(str);
        TextView infoText = findViewById(R.id.info_text_view);
        if (num == random) {
            cnt = 7;
            Toast.makeText(this, "Game has restarted!", Toast.LENGTH_SHORT).show();
            Random rand = new Random();
            random = rand.nextInt(100);
            edit_text.setText("");
            infoText.setText("You won! Game has restarted.");
            edit_text.setHint("Enter a number between 1 and 100");

        } else if (num > random) {
            cnt--;
            Toast.makeText(this, cnt + " attempt left.", Toast.LENGTH_SHORT).show();
            infoText.setText("Some lower number please.You have " + cnt + " attempt left.");
            edit_text.setText("");
            edit_text.setHint("Enter lower than " + num);

        } else {

            cnt--;
            Toast.makeText(this, cnt + " attempt left.", Toast.LENGTH_SHORT).show();
            infoText.setText("Some higher number please.You have " + cnt + " attempt left.");
//            submit(v);
            edit_text.setText("");
            edit_text.setHint("Enter higher than " + num);

        }

        if (cnt < 1) {
            Toast.makeText(this, "Game has restarted!", Toast.LENGTH_SHORT).show();
            infoText.setText("You lost! Game has restarted");
//            reset();
            cnt = 7;
            Random rand = new Random();
            random = rand.nextInt(100);
            edit_text.setText("");
            edit_text.setHint("Enter a number between 1 and 100");

        }
    }


}