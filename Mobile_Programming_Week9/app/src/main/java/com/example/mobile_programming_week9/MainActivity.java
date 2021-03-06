package com.example.mobile_programming_week9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // 기본적인 ViewFlipper Java Code
        Button btnPrev, btnNext;
        final ViewFlipper vFlipper;

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                vFlipper.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                vFlipper.showNext();
            }
        });
        */
        // 직접 풀어보기 6-2
        Button btnStart, btnStop;
        final ViewFlipper vFlipper;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                vFlipper.setFlipInterval(1000);
                vFlipper.startFlipping();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                vFlipper.stopFlipping();
            }
        });

    }
}