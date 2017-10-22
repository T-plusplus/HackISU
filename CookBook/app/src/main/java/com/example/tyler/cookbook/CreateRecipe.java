package com.example.tyler.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
//import com.google.gson.Gson;

public class CreateRecipe extends AppCompatActivity {
    EditText RN, Ing, SS, CT, DIR;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        RN = (EditText) findViewById(R.id.recipeName);
        Ing = (EditText) findViewById(R.id.ingr);
        SS = (EditText) findViewById(R.id.servesize);
        CT = (EditText) findViewById(R.id.cooktime);
        DIR = (EditText) findViewById(R.id.cookdir);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RN.getText().toString().isEmpty()) {
                    if (Ing.getText().toString().isEmpty()) {
                        if (SS.getText().toString().isEmpty()) {
                            if (CT.getText().toString().isEmpty()) {
                                if (DIR.getText().toString().isEmpty()) {
                                    //copy to text file database
                                    updateTXT(RN.getText().toString(),Ing.getText().toString(),
                                            SS.getText().toString(),CT.getText().toString(),DIR.getText().toString());
                                    //start new display activity of that one
                                    Intent i = new Intent(CreateRecipe.this, RecipeActivity.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(CreateRecipe.this, "Must have Cooking Directions", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(CreateRecipe.this, "Must have a Cooking/Preparation Time", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(CreateRecipe.this, "Must have a Serving Size", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(CreateRecipe.this, "Must have an Ingedients List", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(CreateRecipe.this, "Must have a Recipe Name", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void updateTXT(String rn, String ing,String ss,String ct,String dir) {
        File file=new File(textfileKeeper.MyRecipes);
        try {
            Scanner scan = new Scanner(file);
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(file), "UTF-8");
            StringBuilder sb = new StringBuilder();
            while(scan.hasNextLine()) {
                String temp=scan.nextLine();
                sb.append(temp+"\n");
            }
            writer.write(sb.toString());
            StringBuilder json=new StringBuilder();
            json.append("{"+"recipeName:"+rn+","+"ingredients:"+ing+","+"servingSize:"+ss+","+
                    "cookingTime:"+ct+","+"directions:"+dir+"}\n");
            writer.write(json.toString());
            scan.close();
            writer.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}