package com.example.mobile_programming_week10_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목입니다");
                dlg.setMessage("이곳이 내용입니다");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "확인을 눌렀네요", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        final String[] versionArray = new String[]{"Q(10)", "R(11)", "S(12)"};
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                dlg2.setTitle("좋아하는 버전은?");
                dlg2.setIcon(R.mipmap.ic_launcher);
                dlg2.setItems(versionArray,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                button2.setText(versionArray[i]);
                            }
                        });
                dlg2.setPositiveButton("닫기", null);
                dlg2.show();
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder dlg3 = new AlertDialog.Builder(MainActivity.this);
                dlg3.setTitle("좋아하는 버전은?");
                dlg3.setIcon(R.mipmap.ic_launcher);
                dlg3.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button3.setText(versionArray[i]);
                    }
                });
                dlg3.setPositiveButton("닫기", null);
                dlg3.show();
            }
        });

        final boolean[] checkArray = new boolean[]{true, false, false};
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder dlg4 = new AlertDialog.Builder(MainActivity.this);
                dlg4.setTitle("좋아하는 버전은?");
                dlg4.setIcon(R.mipmap.ic_launcher);
                dlg4.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        button4.setText(versionArray[i]);
                    }

                });
                dlg4.setPositiveButton("닫기", null);
                dlg4.show();
            }
        });



    }
}