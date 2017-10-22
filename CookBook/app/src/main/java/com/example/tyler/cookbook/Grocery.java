package com.example.tyler.cookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Grocery extends AppCompatActivity {

    Button Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);


        Back = (Button) findViewById(R.id.button2);
        Back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent i = new Intent(Grocery.this, MainPage.class);
                startActivity(i);
                finish();
            }
        });
    }
}
