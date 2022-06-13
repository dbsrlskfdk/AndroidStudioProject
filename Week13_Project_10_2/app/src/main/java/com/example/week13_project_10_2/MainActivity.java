package com.example.week13_project_10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제일 귀여운 동물 투표");

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++) {
            voteCount[i] = 0;
        }

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3,
                             R.id.iv4, R.id.iv5, R.id.iv6,
                             R.id.iv7, R.id.iv8, R.id.iv9};
        final String imgName[] = {"세마리의 고양이나선", "기지개를 키는 호랑이", "비닐에 갇힌 바둑이",
                "자다 깬 마음이", "놀란눈의 미남이", "멍때리는 뭉치와마음이", "잘생긴 마음이", "잘생긴 미남이", "잘생긴 바둑이"};

        for (int i = 0; i < imageId.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + " : 총 " + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ReslutActivity.class);
                intent.putExtra("VoteCount", voteCount); // 이 Activity에서 voteCount 배열을 -> 넘겨줄 액티비티에 VoteCount 라는 이름으로 넘김 / voteCount 가 정수형 배열이라, 넘겨받을 액티비티에서는 getIntArrayExtra() 메소드로 받으면 됨.
                intent.putExtra("ImageName", imgName); // 이 Activity에서 imgName 배열을 -> 넘겨줄 액티비티에 ImageName 라는 이름으로 넘김 / imgName 가 문자열 배열이라, 넘겨받을 액티비티에서는 getStringArrayExtra() 메소드로 받으면 됨.
                startActivity(intent);
            }
        });
    }
}