package com.example.tyler.cookbook;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    Button Grocery;
    Button Search;
    Button Exit;
    Button Add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Exit = (Button) findViewById(R.id.buttonExit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


        Search = (Button) findViewById(R.id.buttonSearch);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainPage.this,Filter_Activity.class);
                startActivity(i);
                //finish();

            }
        });

        //Grocery = (Button) findViewById(R.id.buttonSearch);
        //Grocery.setOnClickListener(new View.OnClickListener() {
            //@overide
            //public void onClick(View v) {

                //Intent i = new Intent(MainPage.this,TO DO.class);
                //startActivity(i);
                //finish();

            //}
        //});
    }
}
