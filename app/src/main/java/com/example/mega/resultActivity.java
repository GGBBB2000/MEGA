package com.example.mega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = findViewById(R.id.resultText);
        Intent intent = getIntent();
        float rate = intent.getFloatExtra("value",0);
        result.setText("今回の正答率は" + (int)(rate * 100) + "%でした");
    }
}
