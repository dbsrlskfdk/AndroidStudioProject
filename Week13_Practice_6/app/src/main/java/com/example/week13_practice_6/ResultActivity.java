package com.example.week13_practice_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String[] imageName = intent.getStringArrayExtra("ImageName");
        int[] voteIndex = intent.getIntArrayExtra("voteIndex");
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        int[] imageFileId = intent.getIntArrayExtra("imageFileId");


        ImageView imgv[] = new ImageView[imageName.length];
        TextView tv[] = new TextView[imageFileId.length];

        Integer imgvID[] = {R.id.imgView1, R.id.imgView2, R.id.imgView3,
                R.id.imgView4, R.id.imgView5, R.id.imgView6,
                R.id.imgView7, R.id.imgView8, R.id.imgView9};
        Integer tvId[] = {R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9};
        for (int i = 0; i < voteIndex.length; i++) {
            imgv[i] = (ImageView) findViewById(imgvID[i]);
            tv[i] = (TextView) findViewById(tvId[i]);
        }
        for (int i = 0; i < voteIndex.length; i++) {
            imgv[i].setImageResource(imageFileId[voteIndex[i]]);
            tv[i].setText(imageName[voteIndex[i]] + " : 총 "+ voteCount[i] + "표");
        }


        final ViewFlipper vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.setFlipInterval(1000);
                vFlipper.startFlipping();
            }
        });

        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.stopFlipping();
            }
        });
    }
}
