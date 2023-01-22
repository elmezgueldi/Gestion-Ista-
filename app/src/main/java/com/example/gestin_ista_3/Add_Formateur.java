package com.example.gestin_ista_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Add_Formateur extends AppCompatActivity {
    EditText nameFormateur, PrenomFormateur, Matricule, specialite, date, username, password;
    Button addFormateur;
    MyHalper myHalper = new MyHalper(Add_Formateur.this);

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_formateur);
        nameFormateur = findViewById(R.id.nameFormateur);
        PrenomFormateur = findViewById(R.id.prenomFormateur);
        Matricule = findViewById(R.id.matricule);
        specialite = findViewById(R.id.specialite);
        date = findViewById(R.id.date);
        username = findViewById(R.id.usernameFormateur);
        password = findViewById(R.id.passwordFormateur);
        addFormateur = findViewById(R.id.AddFormateurbutton);

        addFormateur.setOnClickListener(view -> {
            if (nameFormateur.getText().length()!=0 && PrenomFormateur.getText().length()!=0
                    && Matricule.getText().length()!=0&& specialite.getText().length()!=0
                    && date.getText().length()!=0&& username.getText().length()!=0
                    && password.getText().length()!=0){
                if (myHalper.AddFormateur(nameFormateur.getText().toString(),PrenomFormateur.getText().toString()
                        ,Matricule.getText().toString(),"Lisence ABC",specialite.getText().toString()
                        ,date.getText().toString(),username.getText().toString()
                        ,password.getText().toString()))
                    Toast.makeText(this, "Formateur ADDED", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(this, "Formateur Not ADDED", Toast.LENGTH_SHORT).show();

            }
            else Toast.makeText(this, "Saisie les champs !", Toast.LENGTH_SHORT).show();
        });

    }
}