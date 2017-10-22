package com.example.tyler.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateRecipe extends AppCompatActivity {
EditText RN,Ing,SS,CT,DIR;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        RN=(EditText)findViewById(R.id.recipeName);
        Ing=(EditText)findViewById(R.id.ingr);
        SS=(EditText)findViewById(R.id.servesize);
        CT=(EditText)findViewById(R.id.cooktime);
        DIR=(EditText)findViewById(R.id.cookdir);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(RN.getText().toString().isEmpty()) {
                    if(Ing.getText().toString().isEmpty()) {
                        if(SS.getText().toString().isEmpty()) {
                            if(CT.getText().toString().isEmpty()) {
                                if(DIR.getText().toString().isEmpty()) {
                                    //It took me so long to do the nested if elses, i literally forgot what goes here.

                                    //copy to text file database

                                    //start new display activity of that one
                                    Intent i=new Intent(CreateRecipe.this, RecipeActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                else {
                                    Toast.makeText(CreateRecipe.this,"Must have Cooking Directions",Toast.LENGTH_LONG).show();
                                }
                            }
                            else {
                                Toast.makeText(CreateRecipe.this,"Must have a Coooking/Preparation Time",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(CreateRecipe.this,"Must have a Serving Size",Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(CreateRecipe.this,"Must have an Ingedients List",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(CreateRecipe.this,"Must have a Recipe Name",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
