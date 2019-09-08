package com.hbfi.stundenplan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Stundenplan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stundenplan);

        getWindow().setNavigationBarColor(Color.DKGRAY);
        getSupportActionBar().setTitle("Stundenplan HBFI19");

        Calendar calendar = Calendar.getInstance();
        int intweek = calendar.get(Calendar.WEEK_OF_YEAR);
        String week = String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));
        SharedPreferences spref2 = getSharedPreferences("Start", 0);
        if(intweek%2 == 0) {
            for(int i=12; i<32; i++) {
                ((TextView)findViewById(textviews[i])).setText(stdplan2[i]);
            }
            getSupportActionBar().setSubtitle("Woche " + intweek + ": Gerade");
            if(spref2.getString("Gruppe", "").equals("A")) {
                ((TextView)findViewById(R.id.textview13)).setText("Schwimmen \n\n SB \n\n Hallenbad");
                ((TextView)findViewById(R.id.textview14)).setText("Religion \n\n CH \n\n 211");
            } else if(spref2.getString("Gruppe", "").equals("B")) {
                ((TextView)findViewById(R.id.textview13)).setText("Frei");
                ((TextView)findViewById(R.id.textview14)).setText("Frei (Reli)");
            }
        } else {
            for(int i=12; i<32; i++) {
                ((TextView)findViewById(textviews[i])).setText(stdplan1[i]);
            }
            getSupportActionBar().setSubtitle("Woche " + intweek + ": Ungerade");
            if(spref2.getString("Gruppe", "").equals("A")) {
                ((TextView)findViewById(R.id.textview13)).setText("Frei");
                ((TextView)findViewById(R.id.textview14)).setText("Frei (Reli)");
            } else if(spref2.getString("Gruppe", "").equals("B")) {
                ((TextView)findViewById(R.id.textview13)).setText("Schwimmen \n\n SB \n\n Hallenbad");
                ((TextView)findViewById(R.id.textview14)).setText("Religion \n\n CH \n\n 211");
            }
        }

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if(day == Calendar.MONDAY) {
            ((TextView)findViewById(R.id.message_user)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textview12)).setTextColor(Color.BLUE);
            timeCheck(800, 930, 12);
            timeCheck(930, 945, 32);
            ((TextView)findViewById(R.id.textview17)).setTextColor(Color.BLUE);
            timeCheck(945, 1115, 17);
            timeCheck(1115, 1130, 33);
            ((TextView)findViewById(R.id.textview22)).setTextColor(Color.BLUE);
            timeCheck(1130, 1300, 22);
            timeCheck(1300, 1330, 34);
            ((TextView)findViewById(R.id.textview27)).setTextColor(Color.BLUE);
            timeCheck(1330, 1500, 27);
        } if(day == Calendar.TUESDAY) {
            ((TextView)findViewById(R.id.textview2)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textview13)).setTextColor(Color.BLUE);
            timeCheck(800, 930, 13);
            timeCheck(930, 945, 32);
            ((TextView)findViewById(R.id.textview18)).setTextColor(Color.BLUE);
            timeCheck(945, 1115, 18);
            timeCheck(1115, 1130, 33);
            ((TextView)findViewById(R.id.textview23)).setTextColor(Color.BLUE);
            timeCheck(1130, 1300, 23);
            timeCheck(1300, 1330, 34);
            ((TextView)findViewById(R.id.textview28)).setTextColor(Color.BLUE);
            timeCheck(1330, 1500, 28);
        } if(day == Calendar.WEDNESDAY) {
            ((TextView)findViewById(R.id.textview5)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textview14)).setTextColor(Color.BLUE);
            timeCheck(800, 930, 14);
            timeCheck(930, 945, 32);
            ((TextView)findViewById(R.id.textview19)).setTextColor(Color.BLUE);
            timeCheck(945, 1115, 19);
            timeCheck(1115, 1130, 33);
            ((TextView)findViewById(R.id.textview24)).setTextColor(Color.BLUE);
            timeCheck(1130, 1300, 24);
            timeCheck(1300, 1330, 34);
            ((TextView)findViewById(R.id.textview29)).setTextColor(Color.BLUE);
            timeCheck(1330, 1500, 29);
        } if(day == Calendar.THURSDAY) {
            ((TextView)findViewById(R.id.textview6)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textview15)).setTextColor(Color.BLUE);
            timeCheck(800, 930, 15);
            timeCheck(930, 945, 32);
            ((TextView)findViewById(R.id.textview20)).setTextColor(Color.BLUE);
            timeCheck(945, 1115, 20);
            timeCheck(1115, 1130, 33);
            ((TextView)findViewById(R.id.textview25)).setTextColor(Color.BLUE);
            timeCheck(1130, 1300, 25);
            timeCheck(1300, 1330, 34);
            ((TextView)findViewById(R.id.textview30)).setTextColor(Color.BLUE);
            timeCheck(1330, 1500, 30);
        } if(day == Calendar.FRIDAY) {
            ((TextView)findViewById(R.id.textview5)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textview16)).setTextColor(Color.BLUE);
            timeCheck(800, 930, 16);
            timeCheck(930, 945, 32);
            ((TextView)findViewById(R.id.textview21)).setTextColor(Color.BLUE);
            timeCheck(945, 1115, 21);
            timeCheck(1115, 1130, 33);
            ((TextView)findViewById(R.id.textview26)).setTextColor(Color.BLUE);
            timeCheck(1130, 1300, 26);
            timeCheck(1300, 1330, 34);
            ((TextView)findViewById(R.id.textview31)).setTextColor(Color.BLUE);
            timeCheck(1330, 1500, 31);
        }

        /*Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int from = 800;
        int to = 930;
        int t = c.get(Calendar.HOUR_OF_DAY) * 100 + c.get(Calendar.MINUTE);
        boolean isBetween = to > from && t >= from && t <= to || to < from && (t >= from || t <= to);


        if (isBetween == true) {
            Toast.makeText(getApplicationContext(), "Between", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Not between", Toast.LENGTH_SHORT).show();
        }*/

    } private int[] textviews = {
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11,
            12,
            R.id.textview12,
            R.id.textview13,
            R.id.textview14,
            R.id.textview15,
            R.id.textview16,
            R.id.textview17,
            R.id.textview18,
            R.id.textview19,
            R.id.textview20,
            R.id.textview21,
            R.id.textview22,
            R.id.textview23,
            R.id.textview24,
            R.id.textview25,
            R.id.textview26,
            R.id.textview27,
            R.id.textview28,
            R.id.textview29,
            R.id.textview30,
            R.id.textview31,
            R.id.textView4,
            R.id.textView5,
            R.id.textView6,

    }; private String[] stdplan1 = {
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            //1-2 Std.
            "Deutsch \n\n AB \n\n 211",
            "Frei",
            "Frei (Reli)",
            "Englisch \n\n EALI \n\n 211",
            "BUS \n\n DS \n\n E29",
            //3-4 Std.
            "DALTON",
            "DALTON",
            "BUF \n\n BI \n\n E29",
            "DALTON",
            "DALTON",
            //5-6 Std.
            "BUS \n\n MK \n\n ???",
            "Mathe \n\n FK \n\n 211",
            "BUF \n\n ME \n\n E29",
            "Mathe \n\n FK \n\n 211",
            "BUF \n\n EAKS \n\n E29",
            //7-8 Std.
            "MINT \n\n MK \n\n ???",
            "Frei",
            "BUF \n\n BI \n\n E29",
            "Frei",
            "Frei",

    }; private String[] stdplan2 = {
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            //1-2 Std.
            "Deutsch \n\n AB \n\n 211",
            "Schwimmen \n\n SB \n\n Hallenbad",
            "Religion \n\n CH \n\n 211",
            "Englisch \n\n EALI \n\n 211",
            "BUF \n\n DS \n\n E29",
            //3-4 Std.
            "DALTON",
            "DALTON",
            "BUF \n\n ME \n\n E29",
            "DALTON",
            "DALTON",
            //5-6 Std.
            "BUS \n\n MK \n\n ???",
            "Englisch \n\n EALI \n\n 211",
            "BUF \n\n ME \n\n E29",
            "Mathe \n\n FK \n\n 211",
            "BUF \n\n EAKS \n\n E29",
            //7-8 Std.
            "BUF \n\n BI \n\n E29",
            "Frei",
            "Sport \n\n SB \n\n Gymnastikhalle",
            "Frei",
            "Frei",
    }; private void timeCheck(int from, int to, int i) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int t = c.get(Calendar.HOUR_OF_DAY) * 100 + c.get(Calendar.MINUTE);
        boolean isBetween = to > from && t >= from && t <= to || to < from && (t >= from || t <= to);
        if(isBetween == true) {
            ((TextView)findViewById(textviews[i])).setBackgroundColor(Color.rgb(255, 158, 158));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stundenplan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1) {
            Intent intent = new Intent(Stundenplan.this, ShortsActivity.class);
            startActivity(intent);
        } if(id == R.id.item2) {
            Intent intent = new Intent(Stundenplan.this, Options.class);
            startActivity(intent);
            finish();
        } if(id == R.id.item3) {
            new AlertDialog.Builder(this).setTitle("Credits").setMessage("Ersteller: Jan \n\nVersion: 1.0.4").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
