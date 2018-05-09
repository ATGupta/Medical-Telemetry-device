package com.example.robonaut4.rih_prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);
        new HomePage(linearLayout,this);

        setContentView(linearLayout);
    }
}