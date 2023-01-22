package com.example.gestin_ista_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.ImageTransformation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class profil_stagiaire extends AppCompatActivity {
    TextView nomStagiaire, prenomStagiaire, Sexe, filiere, bac, note;
    Button logout;
    MyHalper myHalper = new MyHalper(profil_stagiaire.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_stagiaire);
        logout = findViewById(R.id.buttonLOGOUT);
        nomStagiaire = findViewById(R.id.ProfilStagiaireNom);
        prenomStagiaire = findViewById(R.id.ProfilStagiairePrenom);
        Sexe = findViewById(R.id.ProfilStagiaireSexe);
        filiere = findViewById(R.id.ProfilStagiaireFiliere);
        bac = findViewById(R.id.ProfilStagiaireBac);
        note = findViewById(R.id.textNote);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("USER");


        ArrayList<String> list = myHalper.GetStagiaire(name);

        if (list.size() != 0) {
            String[] ls = list.get(0).split(" / ");
            nomStagiaire.setText(ls[0]);
            prenomStagiaire.setText(ls[1]);
            Sexe.setText(ls[2]);
            filiere.setText(ls[3]);
            bac.setText(ls[4]);
            note.setText(ls[5]);
        } else Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(profil_stagiaire.this)
                        .setTitle("Confirm Log Out")
                        .setMessage("Are you sure To Log Out?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(profil_stagiaire.this, LoginActivity.class);
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