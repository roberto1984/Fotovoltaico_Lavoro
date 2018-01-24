package com.example.roberto.fotovoltaico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calcolo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Intent intent = this.getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcolo2);
        //setto il titolo dell'activity,l'id è titolo_activity cui definisco il suo layout in activity_calcolo2.xml
        TextView titolo_activity = (TextView)findViewById(R.id.titolo_activity);
        titolo_activity.setText("Dimensionamento batteria");
        //setto la textview dove andro a scrivere il dato di watt inserito nella editext della mainactivity e da calcolo
        TextView ricevo_watt = (TextView)findViewById(R.id.ricevo_watt);
        ricevo_watt.setText("Il tuo carico è di "+getIntent().getExtras().getString("watt")+" watt");
        //setto la textview dove andro a scrivere il dato di giorni inserito nella editext della activity calcolo
        TextView ricevo_giorni = (TextView)findViewById(R.id.ricevo_giorni);
        ricevo_giorni.setText("Il tuo ore è di "+getIntent().getExtras().getString("giorni")+" giorni");

        final String giorni_received_from_calcolo = getIntent().getExtras().getString("giorni");
        final String watt_received_from_main = getIntent().getExtras().getString("watt");

        int risultato = Integer.valueOf(giorni_received_from_calcolo) * Integer.valueOf(watt_received_from_main);

        TextView totale = (TextView)findViewById(R.id.totale);
        totale.setText("Il tuo ore è di "+risultato+" mah");

        /*final EditText etLocation = (EditText) findViewById(R.id.editText);

        Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(Calcolo2.this,
                        Calcolo2.class);
                Calcolo2.putExtra("senddata",etLocation.getText().toString());
                startActivity(Calcolo2);
            }
        });
        //texto.setText("Ciao!");

        /*Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });*/
    }
}