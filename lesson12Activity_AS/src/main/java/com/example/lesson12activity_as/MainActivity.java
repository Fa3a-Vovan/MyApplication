package com.example.lesson12activity_as;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    TextView textView;
    EditText editText;
    Button button, button2;
    int k = 0;
int k1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity onCreate");

        Log.d(TAG, "Main k="+k);
        Intent intent = getIntent();
        k=intent.getIntExtra("k", k);
        Log.d(TAG, "Main: k="+k);

        textView = findViewById(R.id.text);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView.setText("Main"+k);


    }

    @Override
    protected void onStart() {
        Log.d(TAG, "MainActivity onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "MainActivity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "MainActivity onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "MainActivity onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "MainActivity onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "MainActivity Destroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("k1", k1);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        k1 = savedInstanceState.getInt("k1");
        textView.setText("Главн "+k1); k1++;
    }

    @Override
    public void onClick(View v) {
        k++;
        Intent intent = null;
        textView.setText(editText.getText()+""+k);
        switch (v.getId()) {
            case R.id.button: intent = new Intent(this, OneActivity.class); break;
            case R.id.button2: intent = new Intent(this, TwoActivity.class); break;
        }
        intent.putExtra("k", k);
        startActivity(intent);
    }
}