package com.example.week12_practice_8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    TextView tvNum;
    myPictureView myPicture;
    int curNum = 1;
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        tvNum = (TextView) findViewById(R.id.tvNum);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        //image 불러들이기
        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        imageFname = imageFiles[curNum].toString(); // curNum 이 1부터 시작인데, Pictures 폴더안에 원래 있던 ".thumnail" 이거 제외 하기위해서
        myPicture.imagePath = imageFname;

        tvNum.setTextSize(20);
        tvNum.setText((curNum)+"/"+ (imageFiles.length-1));

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum <= 1){
                    //Toast.makeText(getApplicationContext(), "첫번째 그림입니다", Toast.LENGTH_SHORT).show();
                    curNum = imageFiles.length-1;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    tvNum.setText((curNum)+"/"+ (imageFiles.length-1));
                }else{
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    tvNum.setText((curNum)+"/"+ (imageFiles.length-1));
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum >= imageFiles.length-1){
                    //Toast.makeText(getApplicationContext(), "마지막 그림입니다", Toast.LENGTH_SHORT).show();
                    curNum = 1;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    tvNum.setText((curNum)+"/"+ (imageFiles.length-1));
                }else{
                    curNum++;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    tvNum.setText((curNum)+"/"+ (imageFiles.length-1));
                }
            }
        });
    }
}