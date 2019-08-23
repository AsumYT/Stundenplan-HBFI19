package com.hbfi.stundenplan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ShortsActivity extends AppCompatActivity {

    private LinearLayout linear1;
    private LinearLayout linear3;
    private LinearLayout linear5;
    private LinearLayout linear7;
    private LinearLayout linear9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shorts);

        getSupportActionBar().setTitle("Stundenplan HBFI19");
        getSupportActionBar().setSubtitle("Lehrer Abkürzungen");

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear3 = (LinearLayout)findViewById(R.id.linear3);
        linear5 = (LinearLayout)findViewById(R.id.linear5);
        linear7 = (LinearLayout)findViewById(R.id.linear7);
        linear9 = (LinearLayout)findViewById(R.id.linear9);

        ((TextView)findViewById(R.id.textview1)).setText("ME");
        ((TextView)findViewById(R.id.textview2)).setText("Menzel");
        linear1.setBackgroundColor(Color.parseColor("#ffd3d3d3"));
        ((TextView)findViewById(R.id.textview3)).setText("DS");
        ((TextView)findViewById(R.id.textview4)).setText("de Sousa");
        ((TextView)findViewById(R.id.textview5)).setText("SB");
        ((TextView)findViewById(R.id.textview6)).setText("Seibert");
        linear3.setBackgroundColor(Color.parseColor("#ffd3d3d3"));
        ((TextView)findViewById(R.id.textview7)).setText("BI");
        ((TextView)findViewById(R.id.textview8)).setText("Biehl");
        ((TextView)findViewById(R.id.textview9)).setText("MK");
        ((TextView)findViewById(R.id.textview10)).setText("Mück");
        linear5.setBackgroundColor(Color.parseColor("#ffd3d3d3"));
        ((TextView)findViewById(R.id.textview11)).setText("CH");
        ((TextView)findViewById(R.id.textview12)).setText("Chalubinski");
        ((TextView)findViewById(R.id.textview13)).setText("FK");
        ((TextView)findViewById(R.id.textview14)).setText("Finkenrath");
        linear7.setBackgroundColor(Color.parseColor("#ffd3d3d3"));
        ((TextView)findViewById(R.id.textview15)).setText("AB");
        ((TextView)findViewById(R.id.textview16)).setText("Albus");
        ((TextView)findViewById(R.id.textview17)).setText("EALI");
        ((TextView)findViewById(R.id.textview18)).setText("Lines");
        linear9.setBackgroundColor(Color.parseColor("#fdd3d3d3"));
        ((TextView)findViewById(R.id.textview19)).setText("EAKS");
        ((TextView)findViewById(R.id.textview20)).setText("Kaiser");

    }
}
