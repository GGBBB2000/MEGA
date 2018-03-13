package com.example.mega;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button startButton10 = findViewById(R.id.startButton10);
        Button startButton20 = findViewById(R.id.startButton20);
        Button startButton30 = findViewById(R.id.startButton30);
        Button startButton40 = findViewById(R.id.startButton40);
        Button startButton50 = findViewById(R.id.startButton50);
        startButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, QuestionActivity.class);
                intent.putExtra("value", 10);
                startActivity(intent);
            }
        });
        startButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, QuestionActivity.class);
                intent.putExtra("value", 20);
                startActivity(intent);
            }
        });
        startButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, QuestionActivity.class);
                intent.putExtra("value", 30);
                startActivity(intent);
            }
        });
        startButton40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, QuestionActivity.class);
                intent.putExtra("value", 40);
                startActivity(intent);
            }
        });
        startButton50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, QuestionActivity.class);
                intent.putExtra("value", 50);
                startActivity(intent);
            }
        });
    }
}
