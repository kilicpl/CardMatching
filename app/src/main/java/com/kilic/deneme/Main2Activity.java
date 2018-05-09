package com.kilic.deneme;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.GridLayout;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv2;
    int sonKart = 0;
    int skor = 0;
    int hata = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        final String s = i.getStringExtra("isim");
        tv2 = findViewById(R.id.textView2);
        tv2.setText(s);


        kart[] kartlar = new kart[16];
        for (int j = 1; j <= 16; j++) {
            kartlar[j - 1] = new kart(this, j);
            kartlar[j - 1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k = (kart) v;
                    k.cevir();

                    if (sonKart > 0) {
                        final kart k2 = (kart) findViewById(sonKart);

                        if (k2.onPlanID == k.onPlanID && k2.getId() != k.getId()) {
                            k2.cevrilebilir = false;
                            k.cevrilebilir = false;
                            skor++;
                            hata++;

                            if (skor == 8) {
                                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                                i.putExtra("skor", hata);
                                i.putExtra("isim", s);

                                startActivity(i);
                            }
                        } else { //card are different
                            Handler h = new Handler();

                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.cevir();
                                    k2.cevir();
                                }
                            }, 500);
                            hata++;


                            sonKart = 0;
                        }


                    } else {
                        sonKart = k.getId();

                        Log.v("son kart", "sonkart is: " + sonKart);
                    }

                }
            });


        }


        for (int j = 0; j < 16; j++) {

            int rnumber = (int) (Math.random() * 16);
            kart tmp;
            tmp = kartlar[rnumber];
            kartlar[rnumber] = kartlar[j];
            kartlar[j] = tmp;


        }

        GridLayout gr = (GridLayout) findViewById(R.id.kartlar);

        for (int j = 0; j < 16; j++) {
            gr.addView(kartlar[j]);
        }


    }


}
