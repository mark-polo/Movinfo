package com.mrm.movinfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class EnterInfoActivity extends AppCompatActivity {

    private EditText editFilmName , editFilmYear , editFilmDirector , editFilmDescription;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        editFilmName = findViewById(R.id.editFilmName);
        editFilmYear = findViewById(R.id.editFilmYear);
        editFilmDirector = findViewById(R.id.editFilmDirector);
        editFilmDescription = findViewById(R.id.editFilmDescription);

        Button addBtn = findViewById(R.id.addBtn);

        db = FirebaseFirestore.getInstance();

        addBtn.setOnClickListener(l -> {
            Intent i = new Intent(EnterInfoActivity.this, MainActivity.class);

            if(TextUtils.isEmpty(editFilmName.getText().toString())) {
                Toast.makeText(EnterInfoActivity.this, "Empty name", Toast.LENGTH_SHORT).show();
            } else if(TextUtils.isEmpty(editFilmYear.getText().toString())) {
                Toast.makeText(EnterInfoActivity.this, "Empty year", Toast.LENGTH_SHORT).show();
            } else if(TextUtils.isEmpty(editFilmDirector.getText().toString())) {
                Toast.makeText(EnterInfoActivity.this, "Empty director", Toast.LENGTH_SHORT).show();
            } else if(TextUtils.isEmpty(editFilmDescription.getText().toString())) {
                Toast.makeText(EnterInfoActivity.this, "Empty description", Toast.LENGTH_SHORT).show();
            } else {

                addToDb(editFilmName.getText().toString(), editFilmYear.getText().toString(), editFilmDirector.getText().toString(), editFilmDescription.getText().toString());
            }

            startActivity(i);
        });
    }

    private void addToDb(String name , String year , String director , String description) {
        CollectionReference cr = db.collection("info_about_movie");

        Model m = new Model(1, name, year, director, description);

        cr.add(m).addOnSuccessListener(documentReference ->
                Toast.makeText(EnterInfoActivity.this, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(EnterInfoActivity.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show());
    }

}