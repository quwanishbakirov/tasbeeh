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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt = (TextView) findViewById(R.id.cnt);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int n1 = prefs.getInt("n", 0);
        cnt.setText(String.valueOf(n1));
    }

    public void add(View view) {
        int n = Integer.parseInt(cnt.getText().toString());
        n = n + 1;
        cnt.setText(String.valueOf(n));
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("n", n);
        editor.apply();
    }

    public void clear(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = prefs.edit();
        int n2 = 0;
        cnt.setText(String.valueOf(n2));
        editor.putInt("n2", n2);
        editor.apply();

    }
}