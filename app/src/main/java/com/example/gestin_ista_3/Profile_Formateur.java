package com.example.gestin_ista_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Profile_Formateur extends AppCompatActivity {
    TextView nomFormateur, prenomFormateur, matricule, specialite, date;
    Button logout;
    MyHalper myHalper = new MyHalper(Profile_Formateur.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_formateur);


        nomFormateur = findViewById(R.id.ProfilFormateurNom);
        prenomFormateur = findViewById(R.id.ProfilFormateurPrenom);
        matricule = findViewById(R.id.ProfilFormateurMatricule);
        specialite = findViewById(R.id.ProfilFormateurSpecialite);
        date = findViewById(R.id.ProfilFormateurDate);
        logout = findViewById(R.id.buttonLOGOUT);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("USER");

        ArrayList<String> list = myHalper.GetFormateurProfilParUserName(name);

        if (list.size()!=0){
            String[] ls = list.get(0).split(" / ");
            nomFormateur.setText(ls[0]);
            prenomFormateur.setText(ls[1]);
            matricule.setText(ls[2]);
            specialite.setText(ls[3]);
            date.setText(ls[4]);
        }
        else Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();


    logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            new AlertDialog.Builder(Profile_Formateur.this)
                    .setTitle("Confirm Log Out")
                    .setMessage("Are you sure To Log Out?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Profile_Formateur.this,LoginActivity.class);
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