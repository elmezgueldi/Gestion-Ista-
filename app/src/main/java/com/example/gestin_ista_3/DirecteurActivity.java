package com.example.gestin_ista_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DirecteurActivity extends AppCompatActivity {
    ImageButton AddStagiaire, AddFormateur, AddFilier, ListStagiaire, ListFormateur, ListFiliere;
    Button logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directeur);
        AddStagiaire = findViewById(R.id.AddStagiaire);
        AddFormateur = findViewById(R.id.AddFormateur);
        AddFilier = findViewById(R.id.AddFiliere);
        logout = findViewById(R.id.buttonLOGOUT);
        ListStagiaire = findViewById(R.id.ListStagiaire);
        ListFormateur = findViewById(R.id.ListFormateur);
        ListFiliere = findViewById(R.id.ListFiliere);


        AddStagiaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirecteurActivity.this, AddStagiaire_Activity.class);
                startActivity(intent);
            }
        });
        AddFormateur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirecteurActivity.this, Add_Formateur.class);
                startActivity(intent);
            }
        });
        AddFilier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirecteurActivity.this, Add_Filiere.class);
                startActivity(intent);
            }
        });

        ListStagiaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirecteurActivity.this, ListStagiaire_Activity.class);
                startActivity(intent);
            }
        });
        ListFiliere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirecteurActivity.this, List_Filiere.class);
                startActivity(intent);
            }
        });

        ListFormateur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirecteurActivity.this, Liste_Formateur.class);
                startActivity(intent);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(DirecteurActivity.this)
                        .setTitle("Confirm Log Out")
                        .setMessage("Are you sure To Log Out?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(DirecteurActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });


    }
}