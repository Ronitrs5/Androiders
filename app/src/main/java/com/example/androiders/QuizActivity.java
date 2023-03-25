package com.example.androiders;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiders.model.QuestionAnswer;

import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalqst, questionTextView;
    Button a,b,c,d;
    Button submit;

    int score=0;
    int totalQuestion= QuestionAnswer.question.length;
    int currentQuestion=0;
    int currentqstdisplay=1;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        totalqst = findViewById(R.id.totalqstxt);
        questionTextView = findViewById(R.id.question);
        a = findViewById(R.id.ans_A);
        b = findViewById(R.id.ans_B);
        c = findViewById(R.id.ans_C);
        d = findViewById(R.id.ans_D);
        submit = findViewById(R.id.submit);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        submit.setOnClickListener(this);

        totalqst.setText("Questions: "+ currentqstdisplay+ "/"+totalQuestion);

        loadNewQuestion();
    }



    private void loadNewQuestion() {

        if (currentQuestion==totalQuestion){
            finishQuiz();
            return;
        }



        questionTextView.setText(QuestionAnswer.question[currentQuestion]);
        a.setText(QuestionAnswer.choices[currentQuestion][0]);
        b.setText(QuestionAnswer.choices[currentQuestion][1]);
        c.setText(QuestionAnswer.choices[currentQuestion][2]);
        d.setText(QuestionAnswer.choices[currentQuestion][3]);
    }

    private void finishQuiz() {

        String passStatus="";
        int percent= (score*100)/totalQuestion;
        int incorrect= totalQuestion-score;

        if (percent>=80){

            new AlertDialog.Builder(this)
                    .setTitle("WELL DONE! Training Complete!")
                    .setMessage("Accuracy: "+percent+"%"+"\nCorrect Answers: "+score+"\nIncorrect Answers: "+incorrect)
                    .setNegativeButton("Restart", (dialogInterface, i) -> restartQuiz())
                    .setPositiveButton("Proceed", ((dialogInterface, i) -> proceed()))
                    .setCancelable(false)
                    .show();

        }else{
            new AlertDialog.Builder(this)
                    .setTitle("NOT UP TO THE MARK")
                    .setMessage("Accuracy: "+percent+"%"+"\nCorrect Answers: "+score+"\nIncorrect Answers: "+incorrect)
                    .setNegativeButton("Study again", ((dialogInterface, i) -> study()))
                    .setCancelable(false)
                    .show();
        }

    }

    private void proceed() {
        LayoutInflater inflater= getLayoutInflater();
        View layout= inflater.inflate(R.layout.custon_toast, (ViewGroup) findViewById(R.id.toast_root));
        layout.setBackgroundColor(Color.GREEN);
        TextView textView= layout.findViewById(R.id.customToast);
        textView.setText("TRAIN COMPLETE!!!");
        textView.setTextColor(Color.BLACK);
        Toast toast= new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
        startActivity(new Intent(QuizActivity.this,_0MainActivity.class ));
        finishAffinity();
    }

    private void study() {

        startActivity(new Intent(QuizActivity.this, _0MainActivity.class));
        finishAffinity();
    }

    private void restartQuiz() {
        score=0;
        currentQuestion=0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        a.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.WHITE);
        c.setBackgroundColor(Color.WHITE);
        d.setBackgroundColor(Color.WHITE);

        a.setTextColor(Color.BLACK);
        b.setTextColor(Color.BLACK);
        c.setTextColor(Color.BLACK);
        d.setTextColor(Color.BLACK);

        Button clickedButton= (Button) view;
        totalqst.setText("Questions: "+ currentqstdisplay+"/"+totalQuestion);
        if (clickedButton.getId()==R.id.submit){

            if (selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestion])){
                score++;
            }

            currentQuestion++;
            currentqstdisplay++;
            loadNewQuestion();
            totalqst.setText("Questions: "+ currentqstdisplay+"/"+totalQuestion);




        }else{
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLACK);
            clickedButton.setTextColor(Color.WHITE);
        }

    }
}