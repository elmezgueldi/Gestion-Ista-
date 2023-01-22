package com.example.gestin_ista_3;


import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyHalper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "G_I.db"; // nom base donnee

    private static final String TABLE_NAME = "Directeur"; // table de derecteur

    private static final String DIRECTEUR_USERNAME = "D_username"; // name de derecteur par defaut
    private static final String DIRECTEUR_PASSWORD = "D_password"; // password par defaut de derecteue


    private static final String TABLE_NAME_1 = "Formateur"; // table de Formateur par defaut

    private static final String FORMATEUR_NAME = "F_nom";
    private static final String FORMATUER_PRENOM = "F_prenom";
    private static final String FORMATUER_MATRICULE = "F_matricule";
    private static final String FORMATEUR_DIPLOME = "F_diplome";
    private static final String FORMATUER_SPECIALITE = "F_specialite";
    private static final String FORMATUER_DATE = "F_date";
    private static final String FORMATUER_USER_NAME = "F_username";
    private static final String FORMATUER_PASSWORD = "F_password";


    private static final String TABLE_NAME_2 = "Stagiaire"; // table name of stagiaire

    private static final String STAGIAIRE_USERNAME = "S_username";
    private static final String STAGIAIRE_PASSWORD = "S_password";
    private static final String STAGIAIRE_NAME = "S_name";
    private static final String STAGIAIRE_PRENOM = "S_prenom";
    private static final String STAGIAIRE_SEXE = "S_sexe";
    private static final String STAGIAIRE_FILIERE = "S_filiere";
    private static final String STAGIAIRE_BAC = "S_bac";
    private static final String STAGIAIRE_NOTES = "notes";

    private static final String TABLE_NAME_3 = "Filiere"; // table of filier

    private static final String FILIERE_NAME = "F_name";
    private static final String FILIERE_ID = "F_id";


    public MyHalper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS Formateur (F_nom TEXT  , F_prenom TEXT , F_matricule TEXT , F_diplome TEXT , F_specialite TEXT , F_date TEXT , F_username TEXT PRIMARY KEY , F_password TEXT)");


        String query = "CREATE TABLE IF NOT EXISTS Directeur (D_username TEXT PRIMARY KEY , D_password TEXT) ";

        String query1 = "INSERT INTO Directeur  ( D_username, D_password) values ('admin','admin')";

        String query2 = "CREATE TABLE IF NOT EXISTS Formateur (F_nom TEXT  , F_prenom TEXT , F_matricule TEXT , F_diplome TEXT , F_specialite TEXT , F_date TEXT , F_username TEXT PRIMARY KEY , F_password TEXT);";


        String query3 = "CREATE TABLE IF NOT EXISTS Stagiaire (S_username TEXT PRIMARY KEY, S_password TEXT , S_name TEXT , S_prenom TEXT , " +
                "S_sexe TEXT , S_filiere TEXT , S_bac INTEGER , notes INTEGER DEFAULT 0, CONSTRAINT FK_FIL_STA FOREIGN KEY (S_filiere) REFERENCES Filiere(F_id));";






        String query4 = "CREATE TABLE IF NOT EXISTS Filiere (F_id TEXT PRIMARY KEY , F_name TEXT  );";


        db.execSQL(query);
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query4);
        db.execSQL(query3);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_3);
    }


    public Boolean CheckedFormateur(String USERNAME, String PASSWORD)// Checked if Formateur is in database
    {
        ArrayList<String> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_1, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {
//
            String user = c.getString(c.getColumnIndexOrThrow(FORMATUER_USER_NAME));
            String password = c.getString(c.getColumnIndexOrThrow(FORMATUER_PASSWORD));


            ls.add(user + " / " + password);
            c.moveToNext();
        }
        for (String item : ls
        ) {
            String[] liste = item.split(" / ");
            if (USERNAME.equals(liste[0]) && PASSWORD.equals(liste[1])) {

                return true;

            }
        }
        return false;
    }


    public Boolean CheckedDirecteur(String USERNAME, String PASSWORD) // Checked if directeur is in database
    {

        ArrayList<String> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {
//
            String user = c.getString(c.getColumnIndexOrThrow(DIRECTEUR_USERNAME));
            String password = c.getString(c.getColumnIndexOrThrow(DIRECTEUR_PASSWORD));


            ls.add(user + " / " + password);
            c.moveToNext();
        }
        for (String item : ls
        ) {
            String[] liste = item.split(" / ");
            if (USERNAME.equals(liste[0]) && PASSWORD.equals(liste[1])) {

                return true;

            }
        }
        return false;
    }


    public Boolean CheckedStagiaire(String USERNAME, String PASSWORD)//Checked Stagiaire
    {

        ArrayList<String> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_2, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {
//
            String user = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_USERNAME));
            String password = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_PASSWORD));


            ls.add(user + " / " + password);
            c.moveToNext();
        }
        for (String item : ls
        ) {

            String[] liste = item.split(" / ");
            if (USERNAME.equals(liste[0]) && PASSWORD.equals(liste[1])) {

                return true;

            }
        }
        return false;
    }


    public boolean AddFormateur(String name, String prenom, String matricule,
                                String diplome, String specialite, String date,
                                String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORMATEUR_NAME, name);
        contentValues.put(FORMATUER_PRENOM, prenom);
        contentValues.put(FORMATUER_MATRICULE, matricule);
        contentValues.put(FORMATEUR_DIPLOME, diplome);
        contentValues.put(FORMATUER_SPECIALITE, specialite);
        contentValues.put(FORMATUER_DATE, date);
        contentValues.put(FORMATUER_USER_NAME, user);
        contentValues.put(FORMATUER_PASSWORD, password);


        long result = db.insert(TABLE_NAME_1, null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public boolean AddStagiaire(String username, String pass, String name,
                                String prenom, String sexe, String filiere,
                                int bac) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STAGIAIRE_USERNAME, username);
        contentValues.put(STAGIAIRE_PASSWORD, pass);
        contentValues.put(STAGIAIRE_NAME, name);
        contentValues.put(STAGIAIRE_PRENOM, prenom);
        contentValues.put(STAGIAIRE_SEXE, sexe);
        contentValues.put(STAGIAIRE_FILIERE, filiere);
        contentValues.put(STAGIAIRE_BAC, bac);


        long result = db.insert(TABLE_NAME_2, null, contentValues);
        if (result == -1) return false;
        else return true;
    }


    public boolean AddFiliere(String name, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FILIERE_NAME, name);
        contentValues.put(FILIERE_ID, id);


        long result = db.insert(TABLE_NAME_3, null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public boolean AddNotes(String username, int notes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STAGIAIRE_NOTES, notes);
        long result = db.update(TABLE_NAME_2, contentValues, "S_name=?", new String[]{username});
        if (result == -1) return false;
        else return true;
    }


    public ArrayList<String> GetFormateurProfilParUserName(String matricule)//Get formateur par username
    {
        ArrayList<String> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_1 + " where F_username=?", new String[]{matricule}, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {

            String F_nom = c.getString(c.getColumnIndexOrThrow(FORMATEUR_NAME));
            String F_prenom = c.getString(c.getColumnIndexOrThrow(FORMATUER_PRENOM));
            String F_matricule = c.getString(c.getColumnIndexOrThrow(FORMATUER_MATRICULE));
            String F_diplome = c.getString(c.getColumnIndexOrThrow(FORMATEUR_DIPLOME));
            String F_specialite = c.getString(c.getColumnIndexOrThrow(FORMATUER_SPECIALITE));
            String F_date = c.getString(c.getColumnIndexOrThrow(FORMATUER_DATE));


            ls.add(F_nom + " / " + F_prenom + " / " + F_matricule + " / " + F_specialite + " / " + F_date);
            c.moveToNext();
        }
        return ls;
    }


    public ArrayList<String> GetStagiaire(String username)//Profil to Stagiaire par user Name
    {
        ArrayList<String> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_2 + " where S_username=?", new String[]{username}, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {

            String S_name = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_NAME));
            String S_prenom = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_PRENOM));
            String S_sexe = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_SEXE));
            String S_filiere = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_FILIERE));
            String S_bac = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_BAC));
            String notes = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_NOTES));

            ls.add(S_name + " / " + S_prenom + " / " + S_sexe + " / " + S_filiere + " / " + S_bac + " / " + notes);
            c.moveToNext();
        }
        return ls;
    }


    public ArrayList<String> GetSpinnerfilier()//Get filieres For Spinner
    {
        ArrayList<String> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_3, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {
            String F_name = c.getString(c.getColumnIndexOrThrow(FILIERE_NAME));


            ls.add(F_name);
            c.moveToNext();
        }
        return ls;
    }


    public ArrayList<stagiaire> GetStagiaireListView()//get stagiaire pour  list items adapter
    {
        ArrayList<stagiaire> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_2, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {

            String S_name = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_NAME));
            String S_prenom = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_PRENOM));
            String notes = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_NOTES));

            ls.add(new stagiaire(S_name, S_prenom, Integer.parseInt(notes)));
            c.moveToNext();
        }
        return ls;
    }


    public String GetNameStagiaireNotes(String username )//get stagiaire
    {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_2 + " where S_name=?", new String[]{username}, null);
String x = "";
        c.moveToFirst();
        while (c.isAfterLast() == false) {

            String S_name = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_NAME));
            String S_prenom = c.getString(c.getColumnIndexOrThrow(STAGIAIRE_PRENOM));


            x= S_name + " " + S_prenom;
            c.moveToNext();
        }
        return x;
    }


    public ArrayList<String> GetDataformateurProfil() // get all data for formateur items
    {
        ArrayList<String> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_1, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {

            String F_nom = c.getString(c.getColumnIndexOrThrow(FORMATEUR_NAME));
            String F_prenom = c.getString(c.getColumnIndexOrThrow(FORMATUER_PRENOM));
            String F_matricule = c.getString(c.getColumnIndexOrThrow(FORMATUER_MATRICULE));
            String F_diplome = c.getString(c.getColumnIndexOrThrow(FORMATEUR_DIPLOME));
            String F_specialite = c.getString(c.getColumnIndexOrThrow(FORMATUER_SPECIALITE));
            String F_date = c.getString(c.getColumnIndexOrThrow(FORMATUER_DATE));


            ls.add(F_nom + " / " + F_prenom + " / " + F_matricule + " / " + F_diplome + " / " + F_specialite + " / " + F_date);
            c.moveToNext();
        }
        return ls;
    }


    public ArrayList<Formateur> formateurListView() // get all data for formateur items
    {
        ArrayList<Formateur> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_1, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {

            String F_nom = c.getString(c.getColumnIndexOrThrow(FORMATEUR_NAME));
            String F_prenom = c.getString(c.getColumnIndexOrThrow(FORMATUER_PRENOM));
            String F_mat = c.getString(c.getColumnIndexOrThrow(FORMATUER_MATRICULE));


            ls.add(new Formateur(F_nom, F_prenom, F_mat));
            c.moveToNext();
        }
        return ls;
    }


    public ArrayList<Filiere> GetfiliereListView()//Get filieres items
    {
        ArrayList<Filiere> ls = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME_3, null);

        c.moveToFirst();
        while (c.isAfterLast() == false) {
            String F_name = c.getString(c.getColumnIndexOrThrow(FILIERE_NAME));
            String F_id = c.getString(c.getColumnIndexOrThrow(FILIERE_ID));

            ls.add((new Filiere(F_id, F_name)));
            c.moveToNext();
        }
        return ls;
    }


}