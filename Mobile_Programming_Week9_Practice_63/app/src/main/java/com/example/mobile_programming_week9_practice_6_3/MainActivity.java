package com.example.mobile_programming_week9_practice_6_3;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecDog = tabHost.newTabSpec("DOG").setIndicator("강아지");
        tabSpecDog.setContent(R.id.tabDog);
        tabHost.addTab(tabSpecDog);

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("CAT").setIndicator("고양이");
        tabSpecCat.setContent(R.id.tabCat);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecGiraffe = tabHost.newTabSpec("GIRAFFE").setIndicator("기린");
        tabSpecGiraffe.setContent(R.id.tabGiraffe);
        tabHost.addTab(tabSpecGiraffe);

        TabHost.TabSpec tabSpecHorse = tabHost.newTabSpec("HORSE").setIndicator("말");
        tabSpecHorse.setContent(R.id.tabHorse);
        tabHost.addTab(tabSpecHorse);

        tabHost.setCurrentTab(0);
    }
}