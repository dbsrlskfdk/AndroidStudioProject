package com.example.week11_context_menu_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout baselayout;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        baselayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        baselayout.setOrientation(LinearLayout.VERTICAL);

        button1 = new Button(this);
        button2 = new Button(this);

        button1.setText("배경색변경");
        button2.setText("버튼 변경");

        registerForContextMenu(button1);
        registerForContextMenu(button2);

        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btnParams.gravity = Gravity.CENTER_HORIZONTAL;

        baselayout.addView(button1, btnParams);
        baselayout.addView(button2, btnParams);
        setContentView(baselayout, params);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if (v == button1) {
            menu.setHeaderTitle("배경색 변경");
            menu.add(0, 1, 0, "배경색(빨강)");
            menu.add(0, 2, 0, "배경색(초록)");
            menu.add(0, 3, 0, "배경색(파랑)");
      }
        if (v == button2) {
            menu.add(0, 4, 0, "버튼 45도 회전");
            menu.add(0, 5, 0, "버튼 2배 확대");
        }


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                baselayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baselayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baselayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button2.setRotation(button2.getRotation()+45);
                return true;
            case 5:
                button2.setScaleX(2);
                button2.setScaleY(2);
                return true;
        }
        return false;
    }
}