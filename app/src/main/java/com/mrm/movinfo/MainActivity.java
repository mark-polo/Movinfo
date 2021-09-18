package com.mrm.movinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*

    In EnterInfoActivity - write data to firebase +

    In MainActivity - from firebase add data to MovieAdapter +

    In MovieInfoActivity - send data from  MovieAdapter to MovieInfoActivity +

     */

    private MovieAdapter movieAdapter;
    private List<Model> movies;
    private FirebaseFirestore db;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_movie = findViewById(R.id.rv_movie);

        Button addBtn = findViewById(R.id.addBtn);

        movies = new ArrayList<>();

        db = FirebaseFirestore.getInstance();

        rv_movie.setHasFixedSize(true);
        rv_movie.setLayoutManager(new LinearLayoutManager(this));

        movieAdapter = new MovieAdapter(movies, this);

        rv_movie.setAdapter(movieAdapter);

        db.collection("info_about_movie").get().addOnSuccessListener(queryDocumentSnapshots -> {


                    if(!queryDocumentSnapshots.isEmpty()) {
                        // if the snapshot is not empty we are
                        // hiding our progress bar and adding
                        // our data in a list.

                        List<DocumentSnapshot> l = queryDocumentSnapshots.getDocuments();

                        for(DocumentSnapshot d : l) {
                            // after getting this list we are passing
                            // that list to our object class.
                            Model m = d.toObject(Model.class);

                            // and we will pass this object class
                            // inside our arraylist which we have
                            // created for recycler view.
                            movies.add(m);
                        }
                        // after adding the data to recycler view.
                        // we are calling recycler view notifuDataSetChanged
                        // method to notify that data has been changed in recycler view.
                        movieAdapter.notifyDataSetChanged();
                    }

                }).addOnFailureListener(e -> {
                    // if we do not get any data or any error we are displaying
                    // a toast message that we do not get any data
                    Toast.makeText(MainActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                });


        addBtn.setOnClickListener(l -> {
            Intent i = new Intent(MainActivity.this, EnterInfoActivity.class);
            startActivity(i);
        });
    }
}