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
        final String giorni_received_from_calcolo = getIntent().getExtras().getString("giorni");
        final String watt_received_from_main = getIntent().getExtras().getString("watt");
        final double fabbisogno_giornaliero = Double.parseDouble(watt_received_from_main)*24;
        final double valore_batteria = (fabbisogno_giornaliero*Double.parseDouble(giorni_received_from_calcolo))/12;
        //Milano
        //final int minimo_ore_ricarica_pannello_caso_peggiore_dicembre = 2;
        //Roma
        final int minimo_ore_ricarica_pannello_caso_peggiore_dicembre = 4;
        //Palermo
        //final int minimo_ore_ricarica_pannello_caso_peggiore_dicembre = 6;

        //Il metodo sotto, mi calcola il valore pannello, ipotizzando di ricaricare il valore_batteria però normalizzato per i giorni_received_from_calcolo,ossia il pannello in 4 ore(se Roma)
        // mi deve immagazzinare nella batteria tutta l'energia che serve per i giorni_received_from_calcolo successivi
        final double valore_pannello = (fabbisogno_giornaliero*Double.parseDouble(giorni_received_from_calcolo)/minimo_ore_ricarica_pannello_caso_peggiore_dicembre);
        //Il metodo sotto, mi calcola il valore pannello, ipotizzando di ricaricare il fabbisogno_giornaliero nelle poche ore del caso peggiore di dicembre
        //final double fattore_conversione_pannello = 1.4;
        //final double valore_pannello = (fabbisogno_giornaliero/minimo_ore_ricarica_pannello_caso_peggiore_dicembre) *fattore_conversione_pannello;

        //setto il titolo dell'activity,l'id è titolo_activity cui definisco il suo layout in activity_calcolo2.xml
        TextView titolo_activity = (TextView)findViewById(R.id.titolo_activity);
        titolo_activity.setText("Dimensionamento Impianto");
        //setto la textview dove andro a scrivere il dato di watt inserito nella editext della mainactivity e da calcolo
        TextView ricevo_watt = (TextView)findViewById(R.id.ricevo_watt);
        ricevo_watt.setText("Il tuo carico è di "+watt_received_from_main+" watt");
        //setto la textview dove andro a scrivere il dato di fabbisogno giornaliero che calcolo come 24h * carico_watt
        TextView fabbisogno_giornaliero_watt = (TextView)findViewById(R.id.fabbisogno_giornaliero);
        fabbisogno_giornaliero_watt.setText("Il fabbisogno giornaliero del carico è di  "+fabbisogno_giornaliero+" watt");
        //setto la textview dove andro a scrivere il dato di giorni inserito nella editext della activity calcolo
        TextView ricevo_giorni = (TextView)findViewById(R.id.ricevo_giorni);
        ricevo_giorni.setText("Il numero di giorni senza sole è di "+giorni_received_from_calcolo+" giorni");
        TextView valore_batteria_mah = (TextView)findViewById(R.id.valore_batteria_mah);
        valore_batteria_mah.setText("La tua batterià dovrà essere di almeno "+valore_batteria+" mah");
        TextView valore_pannello_watt = (TextView)findViewById(R.id.valore_pannello_watt);
        valore_pannello_watt.setText("Il tuo pannello dovrà essere di almeno "+valore_pannello+" watt");


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