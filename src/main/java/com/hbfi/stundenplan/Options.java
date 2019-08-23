package com.hbfi.stundenplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Options extends AppCompatActivity {

    private EditText edittext1;
    private TextView textview2;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        getSupportActionBar().setTitle("Stundenplan HBFI19");
        getSupportActionBar().setSubtitle("Optionen");

        edittext1 = (EditText)findViewById(R.id.edittext1);
        textview2 = (TextView)findViewById(R.id.textview2);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        final SharedPreferences spref2 = getSharedPreferences("Start", 0);
        edittext1.setText(spref2.getString("Message", ""));
        textview2.setText("Aktuell: " + spref2.getString("Message", ""));
        edittext1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                SharedPreferences.Editor editor = spref2.edit();
                editor.putString("Message", edittext1.getText().toString());
                editor.commit();
                textview2.setText("Aktuell: " + edittext1.getText().toString());
            }
        });
        String[] list = {"Gruppe A", "Gruppe B"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner1.setAdapter(adapter);
        if(spref2.getString("Gruppe", "").equals("A")) {
            spinner1.setSelection(0);
        } else if(spref2.getString("Gruppe", "").equals("B")) {
            spinner1.setSelection(1);
        }
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner1.getSelectedItemId() == 0) {
                    SharedPreferences.Editor editor = spref2.edit();
                    editor.putString("Gruppe", "A");
                    editor.commit();
                } if(spinner1.getSelectedItemId() == 1) {
                    SharedPreferences.Editor editor = spref2.edit();
                    editor.putString("Gruppe", "B");
                    editor.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Options.this, Stundenplan.class);
        startActivity(intent);
        finish();
    }
}
