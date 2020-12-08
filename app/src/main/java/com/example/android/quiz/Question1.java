package com.example.android.quiz;

import android.content.Intent;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Question1 extends AppCompatActivity {
private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;
    private TextView mTextField;
    private CountDownTimer myCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        addListenerOnButton();

    }
    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        btnDisplay = (Button) findViewById(R.id.submit);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId =radioGroup.getCheckedRadioButtonId();
                myCount.cancel();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==R.id.rb3)
                {
                    Intent intent = new Intent(Question1.this, Question2.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent(Question1.this, Loser.class);
                    startActivity(intent);
                    finish();
                }
            }

        });

        myCount=new CountDownTimer(16000, 1000) {

            public void onTick(long millisUntilFinished) {

            mTextField = (TextView) findViewById(R.id.tv);
                mTextField.setText("Time left:"+millisUntilFinished / 1000);

            }

            public void onFinish() {

                 Intent intent = new Intent(Question1.this, Timesup.class);
                    startActivity(intent);
                    finish();
            }
        }.start();

    }}
