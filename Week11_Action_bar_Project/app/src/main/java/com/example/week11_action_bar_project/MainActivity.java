package com.example.week11_action_bar_project;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar.Tab tabDog, tabCat, tabGiraffe, tabHorse;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.app.ActionBar bar= getSupportActionBar();
        bar.setNavigationMode(androidx.appcompat.app.ActionBar.NAVIGATION_MODE_TABS);


        tabDog = bar.newTab();
        tabDog.setText("강아지");
        tabDog.setIcon(R.drawable.dog);
        tabDog.setTabListener(this);
        bar.addTab(tabDog);

        tabGiraffe = bar.newTab();
        tabGiraffe.setText("기린");
        tabGiraffe.setIcon(R.drawable.giraffe);
        tabGiraffe.setTabListener(this);
        bar.addTab(tabGiraffe);

        tabCat = bar.newTab();
        tabCat.setText("고양이");
        tabCat.setIcon(R.drawable.cat);
        tabCat.setTabListener(this);
        bar.addTab(tabCat);

        tabHorse = bar.newTab();
        tabHorse.setText("말");
        tabHorse.setIcon(R.drawable.horse);
        tabHorse.setTabListener(this);
        bar.addTab(tabHorse);
    }

    public static class MyTabFragment extends androidx.fragment.app.Fragment{
        String tabName;
        ImageView imgView1;

        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View myView = inflater.inflate(R.layout.animal_layout, null);

            imgView1 = myView.findViewById(R.id.imgView1);

            if (tabName == "강아지") imgView1.setImageResource(R.drawable.dog);
            if (tabName == "고양이") imgView1.setImageResource(R.drawable.cat);
            if (tabName == "말") imgView1.setImageResource(R.drawable.horse);
            if (tabName == "기린") imgView1.setImageResource(R.drawable.giraffe);

            return myView;
        }
    }

    MyTabFragment myFrags[] = new MyTabFragment[4];

    @Override
    public void onTabSelected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()] == null) {
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        }
        else
            myTabFrag = myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }
}