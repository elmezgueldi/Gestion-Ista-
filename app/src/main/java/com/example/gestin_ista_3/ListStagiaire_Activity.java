package com.example.gestin_ista_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListStagiaire_Activity extends AppCompatActivity {
    ListView listView;
    MyHalper myHalper = new MyHalper(ListStagiaire_Activity.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_stagiaire);
        listView = findViewById(R.id.list_item_stagiaire);
        ArrayList<stagiaire> listS = myHalper.GetStagiaireListView();
        c_stagiaire c_stagiaire = new c_stagiaire(listS);
        listView.setAdapter(c_stagiaire);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String w = listS.get(i).nom;
                Intent intent = new Intent(ListStagiaire_Activity.this,Add_Note.class);
                Bundle bundle  =  new Bundle();
                bundle.putString("USER",w);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    class c_stagiaire extends BaseAdapter {

        ArrayList<stagiaire> ls ;
        public c_stagiaire(ArrayList<stagiaire>ls2){

            this.ls=ls2;
        }

        @Override
        public int getCount() {


            return ls.size();
        }

        @Override
        public Object getItem(int position) {
            return ls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return ls.get(position).note;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater li =getLayoutInflater();
            View v = li.inflate(R.layout.myshow,null);
            TextView txtnom,txtprenom,txtnote;

            txtnom = v.findViewById(R.id.nomItem);
            txtprenom =v.findViewById(R.id.prenomITEM);
            txtnote = v.findViewById(R.id.ageITEM);

            txtnom.setText(ls.get(position).nom);
            txtprenom.setText(ls.get(position).prenom);
            txtnote.setText(String.valueOf(ls.get(position).note));



            return v;
        }
    }

}