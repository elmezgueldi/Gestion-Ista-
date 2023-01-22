package com.example.gestin_ista_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AddStagiaire_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText nom, prenom, username, pass, bac, filiere;
Spinner spinnerStagiaire;
    RadioButton homme, femme;
    Button addStagiaire;
    String Sexe = "";
    MyHalper myHalper = new MyHalper(AddStagiaire_Activity.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stagiaire);
        nom = findViewById(R.id.NomStagiaireEditText);
        prenom = findViewById(R.id.PrenomStagiaireEditText);
        homme = findViewById(R.id.hommeStagiaire);
        femme = findViewById(R.id.FemmeStagiaire);
        bac = findViewById(R.id.BacStagiaireEditText);
        spinnerStagiaire = findViewById(R.id.spinner2);
        username = findViewById(R.id.UserNameStagiaireEditText);
        pass = findViewById(R.id.PasswordStagiaireEditText);
        addStagiaire = findViewById(R.id.AddStagiaireButton);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(AddStagiaire_Activity.this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, myHalper.GetSpinnerfilier());
        spinnerStagiaire.setAdapter(arrayAdapter);


        spinnerStagiaire.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String x = adapterView.getItemAtPosition(i).toString();
        if (femme.isChecked()) {
            Sexe = "Femme";
        }
        else Sexe = "Homme";
         addStagiaire.setOnClickListener(view1 -> {
         if (myHalper.AddStagiaire(username.getText().toString(), pass.getText().toString(), nom.getText().toString(), prenom.getText().toString(), Sexe, x, Integer.parseInt(bac.getText().toString()))
         ) {
         Toast.makeText(AddStagiaire_Activity.this, "Stagiaire Bien Ajouter", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(AddStagiaire_Activity.this, DirecteurActivity.class);
         startActivity(intent);
         } else
         Toast.makeText(AddStagiaire_Activity.this, "Erreur", Toast.LENGTH_SHORT).show();
         });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


        addStagiaire.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
        Toast.makeText(AddStagiaire_Activity.this, "Selectionnez une filiere", Toast.LENGTH_SHORT).show();
        }
        });

    }
}