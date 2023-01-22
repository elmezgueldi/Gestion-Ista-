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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Liste_Formateur extends AppCompatActivity {
    ListView listView;
    MyHalper myHalper = new MyHalper(Liste_Formateur.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_formateur);
        listView = findViewById(R.id.list_item_formateur);

        ArrayList<Formateur> listF = myHalper.formateurListView();
        c_formateur c = new c_formateur(listF);
        listView.setAdapter(c);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String w = listF.get(i).matricule;
                Intent intent = new Intent(Liste_Formateur.this,Profile_Formateur.class);
                Bundle bundle  =  new Bundle();
                bundle.putString("USER",w);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    class c_formateur extends BaseAdapter {

        ArrayList<Formateur> ls = new ArrayList<>();

        public c_formateur(ArrayList<Formateur> ls2) {

            this.ls = ls2;
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
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater li = getLayoutInflater();
            View v = li.inflate(R.layout.myshow, null);
            TextView txtnom, txtprenom, txtnote;

            txtnom = v.findViewById(R.id.nomItem);
            txtprenom = v.findViewById(R.id.prenomITEM);
            txtnote = v.findViewById(R.id.ageITEM);

            txtnom.setText(ls.get(position).nom);
            txtprenom.setText(ls.get(position).prenom);
            txtnote.setText((ls.get(position).matricule));


            return v;
        }
    }

}