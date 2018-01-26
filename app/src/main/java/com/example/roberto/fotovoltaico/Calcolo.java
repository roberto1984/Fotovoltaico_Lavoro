package com.example.roberto.fotovoltaico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class Calcolo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Intent intent = this.getIntent();
        super.onCreate(savedInstanceState);
        //setto il layout xml che voglio usare(definito in activity_calcolo)
        setContentView(R.layout.activity_calcolo);
        final String watt_received_from_main = getIntent().getExtras().getString("watt");
        final int fabbisogno_giornaliero = Integer.valueOf(watt_received_from_main)*24;
        //setto il titolo dell'activity,l'id è titolo_activity cui definisco il suo layout in activity_calcolo.xml
        TextView titolo_activity = (TextView)findViewById(R.id.titolo_activity);
        titolo_activity.setText("Giorni di autonomia senza sole?");
        //setto la textvie dove andro a scrivere il dato di watt inserito nella editext della mainactivity
        TextView ricevo_watt = (TextView)findViewById(R.id.ricevo_watt);
        //nella stringa watt_received_from_main inserisco il valore che ho inserito nella editext della mainactivity

        //setto la textview di cui sopra
        ricevo_watt.setText("Il tuo carico è di "+watt_received_from_main+" watt");
        TextView fabbisogno_giornaliero_watt = (TextView)findViewById(R.id.fabbisogno_giornaliero_watt);
        fabbisogno_giornaliero_watt.setText("Il fabbisogno giornaliero del carico è di  "+fabbisogno_giornaliero+" watt");
        //creo un'altra editext, dove andro ad inserire il valore dei giorni il cui carico deve rimanere acceso
        final EditText inserisco_giorni = (EditText) findViewById(R.id.inserisco_giorni);
        //setto il bottono eer passare alla successiva activity e ci passo i dati che ho messo nella editext di cui sopra
        Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(Calcolo.this,
                        Calcolo2.class);
                myIntent.putExtra("giorni",inserisco_giorni.getText().toString());
                myIntent.putExtra("watt",watt_received_from_main);
                startActivity(myIntent);
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