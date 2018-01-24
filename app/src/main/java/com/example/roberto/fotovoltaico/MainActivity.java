package com.example.roberto.fotovoltaico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setto il layout xml che voglio usare(definito in activity_main-xml)
        setContentView(R.layout.activity_main);
        //setto il titolo dell'activity,l'id è titolo_activity cui definisco il suo layout in activity_main.xml
        //posso definire il testo nelle textview anche solo nel layout xml,ma preferisco fare tutto da qui e poi mettere l'id nell'xml del layout,per avere tutto pulito il codice
        TextView titolo_activity = (TextView)findViewById(R.id.titolo_activity);
        titolo_activity.setText("Inserisci il valore del carico in Watt");
        //setto il box per inserire il testo e ne definisco il layout in activity_main.xml con id editText
        final EditText inserisco_watt = (EditText) findViewById(R.id.editText);

        //setto il button per passare all'activity calcolo  e ne definisco il layout in activity_main.xml con id button_id
        Button button = findViewById(R.id.button_id);
        //dico al bottone cosa deve fare quando premuto,in questo caso passare all'activity calcolo e passare i dati inseriti nell'editbox
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start NewActivity.class e qui gli dico di passare all'activity calcolo
                Intent myIntent = new Intent(MainActivity.this,
                        Calcolo.class);
                //qui dico che all'activity calcolo deve passargli il valore che sta dentro l'edittext etlocation nella chiave "senddata"
                myIntent.putExtra("watt",inserisco_watt.getText().toString());
                //starto l'activity calcolo premendo il pulsante ufficialmente
                startActivity(myIntent);
            }
        });
    }
}
