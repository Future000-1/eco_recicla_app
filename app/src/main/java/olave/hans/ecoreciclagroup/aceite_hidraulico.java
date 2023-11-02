package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class aceite_hidraulico extends AppCompatActivity {

    ImageView home_5;
    ImageView categoria_5;
    ImageView sabias_5;
    ImageView ubi_5;
    ImageView estadistica_5;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceite_hidraulico);


        home_5=findViewById(R.id.home_5);
        categoria_5=findViewById(R.id.categoria_5);
        sabias_5= findViewById(R.id.sabias_5);
        ubi_5= findViewById(R.id.ubi_5);
        estadistica_5= findViewById(R.id.estadistica_5);


        Intent regresoHome= new Intent(getApplicationContext(),
                Home.class);

        home_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoHome);
            }
        });





        Intent regresocategoria= new Intent(getApplicationContext(),
                identificaAceite.class);

        categoria_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresocategoria);
            }
        });



        Intent regresosabias= new Intent(getApplicationContext(),
                sabias_que.class);

        sabias_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresosabias);
            }
        });



        Intent regresoubi= new Intent(getApplicationContext(),
                puntos_recoleccion.class);

        ubi_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoubi);
            }
        });





        Intent regresoestadistica= new Intent(getApplicationContext(),
                EstadisticasActivity.class);

        estadistica_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoestadistica);
            }
        });



    }
}