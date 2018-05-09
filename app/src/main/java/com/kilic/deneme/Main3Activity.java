package com.kilic.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tv5= findViewById(R.id.textView5);

        Intent i = getIntent();
        String isim= i.getStringExtra("isim");
        int skor= i.getIntExtra("skor", 0);
        tv5.setText("congratulations " + isim + "\n" +  "your score s " + skor  +  "\n" + " the lower the better");
    }
}
