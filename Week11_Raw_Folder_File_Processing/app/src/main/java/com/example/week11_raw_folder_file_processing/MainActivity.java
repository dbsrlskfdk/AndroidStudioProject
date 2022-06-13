package com.example.week11_raw_folder_file_processing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        //Raw Folder 파일 처리
        Button btnRead;
        final EditText edtRaw;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtRaw = (EditText) findViewById(R.id.edtRaw);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputS = getResources().openRawResource(R.raw.raw_test);
                    byte[] txt = new byte[inputS.available()];
                    inputS.read(txt);
                    edtRaw.setText(new String(txt));
                    inputS.close();
                }catch (IOException e){}
            }
        });
        */

        /*
        // SD카드에서 파일 읽기
        Button btnRead;
        final EditText edtSD;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream inFs = new FileInputStream("/sdcard/sd_test.txt");
                    byte[] txt = new byte[inFs.available()];
                    inFs.read(txt);
                    edtSD.setText(new String(txt));
                    inFs.close();
                }catch(IOException e){}
            }
        });
        */

        /*
        // SD 카드에 폴더 및 파일 생성
        // 생성이나 삭제 후 sdcard 폴더 syncronize 해야 보인다.
        Button btnMkdir, btnRmdir;
        btnMkdir = (Button) findViewById(R.id.btnMkdir);
        btnRmdir = (Button) findViewById(R.id.btnRmDir);
        final String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDpath + "/mydir");

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.mkdir();
            }
        });

        btnRmdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });
        */

        // 특정 폴더의 하위 폴더 및 파일 목록 출력
        Button btnFilelist;
        final EditText edtFilelist;
        btnFilelist = (Button) findViewById(R.id.btnFilelist);
        edtFilelist = (EditText) findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();
                File[] sysFiles = (new File(sysDir).listFiles());

                String strFname;
                for(int i=0; i<sysFiles.length; i++){
                    if (sysFiles[i].isDirectory() == true) {
                        strFname = "<폴더> " + sysFiles[i].toString();
                    }else{
                        strFname = "<파일> " + sysFiles[i].toString();
                    }

                    edtFilelist.setText(edtFilelist.getText() + "\n" + strFname);
                }
            }
        });
    }
}