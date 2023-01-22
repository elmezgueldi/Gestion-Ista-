package com.example.gestin_ista_3;

import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button singup;
    EditText user, pass;
    Spinner spin;

    MyHalper myHalper = new MyHalper(LoginActivity.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singup = findViewById(R.id.buttONLOGIN);
        user = findViewById(R.id.USERNAMELOGIN);
        pass = findViewById(R.id.PASSWORDLOGIN);
        spin = findViewById(R.id.spinnerLOGIN);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.loginSpinner, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String x = adapterView.getItemAtPosition(i).toString();

        singup.setOnClickListener(view1 -> {
            if (x.equals("Directeur")) {

                if (myHalper.CheckedDirecteur(user.getText().toString(), pass.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DirecteurActivity.class);
                    startActivity(intent);

                } else
                    Toast.makeText(LoginActivity.this, "Erreur", Toast.LENGTH_SHORT).show();

            } else if (x.equals("Formateur")) {

                if (myHalper.CheckedFormateur(user.getText().toString(), pass.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Formateur_Menu.class);
                    Bundle b = new Bundle();
                    b.putString("USER",user.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);

                } else
                    Toast.makeText(LoginActivity.this, "Erreur", Toast.LENGTH_SHORT).show();

            } else {

                if (myHalper.CheckedStagiaire(user.getText().toString(), pass.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, profil_stagiaire.class);
                    Bundle b = new Bundle();
                    b.putString("USER",user.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);

                } else
                    Toast.makeText(LoginActivity.this, "Stagiaire Not Found", Toast.LENGTH_SHORT).show();

            }
        });
     }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
singup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(LoginActivity.this, "Selectionnez un choix!", Toast.LENGTH_SHORT).show();
    }
});
    }
}