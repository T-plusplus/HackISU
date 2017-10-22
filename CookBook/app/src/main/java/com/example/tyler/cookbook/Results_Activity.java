package com.example.tyler.cookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Results_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_);

        ////////////////////////////////////////////
        System.out.println("DEBUG - bundle Results");
        ////////////////////////////////////////////
        
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String title = bundle.getString("title");
        String ingredients = bundle.getString("ingredients");
        int time = bundle.getInt("time");
        int servings = bundle.getInt("servings");

        //////////////////////////////////////////////////////
        System.out.println("DEBUG - retrieving recipe elements");
        ////////////////////////////////////////////////////////

        String[] RecipeBookJson = bundle.getStringArray("RecipeBookJson");

        Scanner scanner = new Scanner(ingredients);  // we turn our ingredients into an array of indredients
        ArrayList<String> ListOfSearchingIngredients = new ArrayList<String>();
        while(scanner.hasNext()){
            ListOfSearchingIngredients.add(scanner.next());
        }
        scanner.close();
        Gson gson = new Gson();
        ArrayList<Recipe> RecipeBook = new ArrayList<Recipe>();

        String[] temp = bundle.getStringArray("JsonRecipe");
        for(int i = 0; i < temp.length; ++i){
            Recipe temp2 = gson.fromJson(temp[i], Recipe.class);
            RecipeBook.add(temp2); }

        ArrayList<Recipe> ResultRecipes = new ArrayList<Recipe>();

        for(int i = 0; i < RecipeBook.size();++i){
            boolean NameEquals = RecipeBook.get(i).getRecipeName().toLowerCase().equals(title.toLowerCase());
            boolean containsIngredients = RecipeBook.containsAll(ListOfSearchingIngredients); //RecipeBook.get(i)
            boolean timeEquals = RecipeBook.get(i).overallTime(time);
            boolean correctServing = RecipeBook.get(i).servingSize( (servings-(servings/3)),(servings+(servings/3)));

            if(NameEquals && containsIngredients && timeEquals && correctServing ){
                ResultRecipes.add(RecipeBook.get(i) );
            }
        }

        //Now display the resulting recipes, or something else if there is none.
        ScrollView scroll = (ScrollView) this.findViewById(R.id.scrollView);
        if(ResultRecipes.size() == 0){
            TextView noResults = new TextView(this);
            noResults.setText("No Results!");
            scroll.addView(noResults); // fix
        }
    }
}
