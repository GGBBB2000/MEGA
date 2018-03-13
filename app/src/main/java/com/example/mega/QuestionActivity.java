package com.example.mega;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class QuestionActivity extends AppCompatActivity {
    ArrayList<String> question = new ArrayList<String>();
    TextView questionView;
    TextView resultView;
    TextView answerView;
    Button buttonA, buttonB, buttonC, buttonD;
    int result = 0;
    Boolean clickFlag = true;
    int quizIndex = 0;
    int answerCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        questionView = findViewById(R.id.question);
        resultView = findViewById(R.id.result);
        answerView = findViewById(R.id.answer);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        getQuestion();
        quiz();
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizJudge("a");
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizJudge("b");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizJudge("c");
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizJudge("d");
            }
        });

    }



    public void getQuestion(){ // id/answer/question/choice1/choice2/choice3/choice4/Japanese
                               // 0  1      2        3       4       5       6       7
        try {
            InputStream is = this.getAssets().open("Question.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = br.readLine();
            while(str != null){
                question.add(str);
                str = br.readLine();
            }
            br.close();
            Collections.shuffle(question);
        }catch (Exception e){
            Log.e("", e.toString());
        }
    }



    public void quiz(){// id/answer/question/choice1/choice2/choice3/choice4/Japanese
                       // 0  1      2        3       4       5       6       7
        Button nextButton = findViewById(R.id.nextButton);
        Intent former = getIntent();
        Intent intent = new Intent(getApplication(), resultActivity.class);
        if(quizIndex < question.size() && answerCount < former.getIntExtra("value", question.size())) {
            questionView.setText(question.get(quizIndex).split("/", 0)[2]);
            buttonA.setText("(A)" + (question.get(quizIndex).split("/", 0))[3]);
            buttonB.setText("(B)" + (question.get(quizIndex).split("/", 0))[4]);
            buttonC.setText("(C)" + (question.get(quizIndex).split("/", 0))[5]);
            buttonD.setText("(D)" + (question.get(quizIndex).split("/", 0))[6]);
        }else{
            intent.putExtra("value", (float)result / (float)former.getIntExtra("value", 1));
            startActivity(intent);
            finish();
        }
        nextButton.setVisibility(View.INVISIBLE);
    }



    public void quizJudge(String alpha){
        if(alpha.equals((question.get(quizIndex).split("/", 0))[1]) && clickFlag){
            resultView.setText("正解です");
            answerView.setText(question.get(quizIndex).split("/", 0)[7]);
            clickFlag = false;
            result++;
        }else{
            resultView.setText("不正解です。正解は" + question.get(quizIndex).split("/", 0)[1]);
            answerView.setText(question.get(quizIndex).split("/", 0)[7]);
            clickFlag = false;
        }

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setVisibility(View.VISIBLE);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText("");
                answerView.setText("");
                clickFlag = true;
                quizIndex++;
                answerCount++;
                quiz();
            }
        });
    }
}
