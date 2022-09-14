package com.example.tasbeeh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cnt;
    TextView words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt = (TextView) findViewById(R.id.cnt);
        words = (TextView) findViewById(R.id.words);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int n1 = prefs.getInt("n", 0);
        cnt.setText(String.valueOf(n1));
    }

    @SuppressLint("SetTextI18n")
    public void add(View view) {
        String[] word = {"subhanallah", "alhamdulillah", "allahu akbar", "La ilaha illallohu vahdahu la sharika lah, lahul mulku va lahul hamd. Va huva 'ala kulli shayin qodir"};
        int n = Integer.parseInt(cnt.getText().toString());
        n = n + 1;

        if (n % 100 == 0){
            words.setText(word[3]);
        }
        else if (n % 100 < 34){
            words.setText(word[0]);
        }
        else if (n % 100 > 33 && n % 100 < 67){
            words.setText(word[1]);
        }
        else if (n % 100 > 66){
            words.setText(word[2]);
        }

        cnt.setText(String.valueOf(n));
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("n", n);
        editor.apply();
    }

    public void clear(View view) {
        int m = 0;
        cnt.setText(String.valueOf(m));
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("n", m);
        editor.apply();
    }
}