package com.example.gestin_ista_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class List_Filiere extends AppCompatActivity {
ListView listView;
MyHalper myHalper = new MyHalper(List_Filiere.this);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filiere);

        listView = findViewById(R.id.list_item_filiere);

        c_filiere c_filiere = new c_filiere(myHalper.GetfiliereListView());
        listView.setAdapter(c_filiere);



    }




    class c_filiere extends BaseAdapter {

        ArrayList<Filiere> ls = new ArrayList<>();
        public c_filiere(ArrayList<Filiere>ls2){


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
            return 0;
        }

        @SuppressLint("MissingInflatedId")
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
            txtnote.setText("");



            return v;
        }
    }

}