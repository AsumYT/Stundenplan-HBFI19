package com.hbfi.stundenplan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);

        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        fadeIn.setFillAfter(true);
        textview1 = (TextView)findViewById(R.id.textview1);
        textview1.startAnimation(fadeIn);

        final SharedPreferences spref2 = getSharedPreferences("Start", 0);
        if(spref2.getString("FirstStart", "").equals("finished")) {

        } else {
            final SharedPreferences.Editor editor = spref2.edit();
            editor.putString("Message", "Stundenplan HBFI19");
            new AlertDialog.Builder(this).setTitle("Gruppe auswählen").setMessage("Bitte wähle deine Gruppe aus. \n\nAchtung: Wenn du z.B. in Schwimmen: A und in Reli: B bist und dann Gruppe A auswählst, ist Reli für dich vertauscht, da du in Reli in der jeweils anderen Gruppe bist. Derzeit funktioniert es nur richtig, wenn du in allen Fächern in der gleichen Gruppe bist. Ein Feature welches das berücksichtigt folgt irgendwann :D").setPositiveButton("Gruppe A", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    editor.putString("FirstStart", "finished");
                    editor.putString("Gruppe", "A");
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, Stundenplan.class);
                    startActivity(intent);
                    finish();
                }
            }).setNegativeButton("Gruppe B", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    editor.putString("FirstStart", "finished");
                    editor.putString("Gruppe", "B");
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, Stundenplan.class);
                    startActivity(intent);
                    finish();
                }
            }).setCancelable(false).show();
        }
        textview1.setText(spref2.getString("Message", ""));

        VideoView videoview1 = (VideoView)findViewById(R.id.videoview1);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bg;
        Uri uri = Uri.parse(videoPath);
        videoview1.setVideoURI(uri);
        videoview1.start();

        getSupportActionBar().hide();
        new CountDownTimer(1000, 1000) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if(spref2.getString("FirstStart", "").equals("finished")) {
                    Intent intent = new Intent(MainActivity.this, Stundenplan.class);
                    startActivity(intent);
                    finish();
                } else {

                }
            }
        }.start();
    }
}
