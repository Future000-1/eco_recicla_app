package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button btnCerrar;
    Button btnIdentifica;

    Button btnsabias;

    Button btnpuntos;

    Button btnaportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCerrar= findViewById(R.id.btnCerrar);
        btnIdentifica= findViewById(R.id.btnIdentifica);
        btnsabias= findViewById(R.id.btnSabias);
        btnaportes= findViewById(R.id.btnAportes);
        btnpuntos= findViewById(R.id.btnPuntos);

        Intent cerrarsesion= new Intent(getApplicationContext(),
                inicio_sesion.class
                );

        Intent identifica= new Intent(getApplicationContext(),
                identificaAceite.class);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cerrarsesion);
            }
        });

        btnIdentifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(identifica);
            }
        });



        Intent sabias= new Intent(getApplicationContext(),
                sabias_que.class);

        btnsabias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(sabias);
            }
        });


        Intent aportes= new Intent(getApplicationContext(),
                EstadisticasActivity.class);

        btnaportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(aportes);
            }
        });


        Intent puntos= new Intent(getApplicationContext(),
                puntos_recoleccion.class);

        btnpuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(puntos);
            }
        });

    }
}