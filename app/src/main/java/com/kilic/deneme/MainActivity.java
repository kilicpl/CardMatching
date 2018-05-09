package com.kilic.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

// App for guessing matching numbers card
    EditText editText;
    TextView textView;
    static int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText= (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //textView.setText(editText.getText().toString());
                editText.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("isim", editText.getText().toString());
                startActivity(intent);

                return true;
            }
        });

    }
}
