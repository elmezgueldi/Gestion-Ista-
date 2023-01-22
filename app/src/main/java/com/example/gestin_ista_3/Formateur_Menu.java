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

public class Formateur_Menu extends AppCompatActivity {
    ImageButton ListStagiaire, ListFiliere, Profile;
    Button logout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formateur_menu);
        Bundle bundle = getIntent().getExtras();
        String nameProf = bundle.getString("USER");

        logout = findViewById(R.id.buttonLOGOUT);
        ListStagiaire = findViewById(R.id.ListStagiaire);
        ListFiliere = findViewById(R.id.ListFiliere);
        Profile = findViewById(R.id.profil);


        ListStagiaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formateur_Menu.this, ListStagiaire_Activity.class);
                startActivity(intent);
            }
        });
        ListFiliere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formateur_Menu.this, List_Filiere.class);
                startActivity(intent);
            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formateur_Menu.this, Profile_Formateur.class);
                Bundle b = new Bundle();
                b.putString("USER", nameProf);
                intent.putExtras(b);
                startActivity(intent);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(Formateur_Menu.this)
                        .setTitle("Confirm Log Out")
                        .setMessage("Are you sure To Log Out?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Formateur_Menu.this, LoginActivity.class);
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