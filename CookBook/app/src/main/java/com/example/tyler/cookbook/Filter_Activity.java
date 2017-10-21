package com.example.tyler.cookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class Filter_Activity extends AppCompatActivity {

    Button b1;
    EditText Title;
    EditText Ingredients;
    EditText Time;
    EditText Servings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String title = Title.getText().toString();
                String ingredients = Ingredients.getText().toString();
                int time = Integer.parseInt(Time.getText().toString());
                int servings = Integer.parseInt(Servings.getText().toString());


                Intent intent = new Intent(Filter_Activity.this, Results_Activity.class);
                intent.putExtra("title", title);
                intent.putExtra("ingredients", ingredients);
                intent.putExtra("time", time);
                intent.putExtra("servings",servings);


                startActivity(intent);
            }

        });

        Title = (EditText) findViewById(R.id.editText2);
        Ingredients = (EditText) findViewById(R.id.editText);
        Time = (EditText) findViewById(R.id.editText3);
        Servings = (EditText) findViewById(R.id.editText4);
    }



}
