package com.mrm.movinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MovieInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        TextView movieInfoName = findViewById(R.id.movieInfoName);
        TextView movieInfoYear = findViewById(R.id.movieInfoYear);
        TextView movieInfoDirector = findViewById(R.id.movieInfoDirector);
        TextView movieInfoDescription = findViewById(R.id.movieInfoDescription);
        TextView movieName = findViewById(R.id.movieName);

        movieInfoName.setText(getIntent().getStringExtra("Name"));
        movieInfoYear.setText(getIntent().getStringExtra("Year"));
        movieInfoDirector.setText(getIntent().getStringExtra("Director"));
        movieInfoDescription.setText(getIntent().getStringExtra("Description"));
        movieName.setText(getIntent().getStringExtra("Name"));
    }
}