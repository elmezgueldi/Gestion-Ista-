package com.example.gestin_ista_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Note extends AppCompatActivity {
EditText note;
TextView user;
Button addNote;
MyHalper myHalper = new MyHalper(Add_Note.this);
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        note = findViewById(R.id.AddNoteEditText);
        addNote= findViewById(R.id.AddNoteButton);
        user= findViewById(R.id.NomPrenomNote);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("USER");

        String x= myHalper.GetNameStagiaireNotes(name);
        user.setText(x);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myHalper.AddNotes(name,Integer.parseInt(note.getText().toString()))) {
                    Toast.makeText(Add_Note.this, "Note ADDED", Toast.LENGTH_SHORT).show();                    Intent intent = new Intent(Add_Note.this, ListStagiaire_Activity.class);
                    startActivity(intent);
                }
                else Toast.makeText(Add_Note.this, "Note Not ADDED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}