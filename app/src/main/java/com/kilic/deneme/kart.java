package com.kilic.deneme;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

import static android.support.v7.widget.AppCompatDrawableManager.*;

@SuppressLint("AppCompatCustomView")
public class kart extends Button {
    public boolean Acikmi = false;
    public boolean cevrilebilir = true;
    public int resimID;
    public int arkaPlanID;
    public int onPlanID;
    Drawable arka;
    Drawable on;


    @SuppressLint("RestrictedApi")
    public kart(Context context, int id) {
        super(context);
        arkaPlanID = R.drawable.arka;
        setId(id);

        if (id % 8 == 0) onPlanID = R.drawable.c8;
        if (id % 8 == 1) onPlanID = R.drawable.c1;
        if (id % 8 == 2) onPlanID = R.drawable.c2;
        if (id % 8 == 3) onPlanID = R.drawable.c3;
        if (id % 8 == 4) onPlanID = R.drawable.c4;
        if (id % 8 == 5) onPlanID = R.drawable.c5;
        if (id % 8 == 6) onPlanID = R.drawable.c6;
        if (id % 8 == 7) onPlanID = R.drawable.c7;


        arka = AppCompatDrawableManager.get().getDrawable(context, arkaPlanID);
        on = AppCompatDrawableManager.get().getDrawable(context, onPlanID);
        setBackground(arka);

    }

    public void cevir() {
        if (cevrilebilir) {


            if (!Acikmi) {
                setBackground(on);
                Acikmi = true;
            } else {
                setBackground(arka);
                Acikmi = false;
            }

        }
    }


}
