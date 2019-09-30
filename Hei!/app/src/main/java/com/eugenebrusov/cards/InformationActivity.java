package com.eugenebrusov.cards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class InformationActivity extends AppCompatActivity {
    ImageButton button;
    boolean isButtonSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // SET IS MARKED TO 1-VALUE!
                if (isButtonSet==false){
                    button.setImageResource(android.R.drawable.btn_star_big_on);
                    isButtonSet = true;
                }else{
                    button.setImageResource(android.R.drawable.btn_star_big_off);
                    isButtonSet = false;}

            }
        });

        // Get the Intent that started this activity and do something with it:)
        //Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }

}
