package com.example.gestin_ista_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.IdentityHashMap;

public class Add_Filiere extends AppCompatActivity {
EditText idFiliere , NameFiliere ;
Button addfiliere;
MyHalper myHalper = new MyHalper(Add_Filiere.this);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_filiere);

        idFiliere = findViewById(R.id.IdFiliere_EditText);
        NameFiliere = findViewById(R.id.NameFiliere_Edittxt);
        addfiliere=findViewById(R.id.AddFiliere_Button);
        addfiliere.setOnClickListener(view -> {
            if (NameFiliere.getText().length()!=0 && idFiliere.getText().length()!=0){
                if (myHalper.AddFiliere(NameFiliere.getText().toString(),idFiliere.getText().toString())) {
                    Toast.makeText(this, "Filiere ADDED", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Add_Filiere.this, List_Filiere.class);
                    startActivity(intent);
                }

                else
                    Toast.makeText(this, "Filiere Not ADDED", Toast.LENGTH_SHORT).show();

            }
            else Toast.makeText(this, "Saisie les champs !", Toast.LENGTH_SHORT).show();
        });

    }
}