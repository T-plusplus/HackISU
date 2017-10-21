package com.example.tyler.cookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Results_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String title = bundle.getString("title");
    }
}
