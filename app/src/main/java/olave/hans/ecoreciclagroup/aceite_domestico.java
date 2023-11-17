package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class aceite_domestico extends AppCompatActivity {

    ImageView home_2;
    ImageView categoria_2;
    ImageView sabias_2;

    ImageView ubi_2;

    ImageView estadisticas_2;

    Button registrarcantidad;

    EditText numcantidad;
    EditText acumagua;

    EditText acumAceite;
    private int resultadoacumulado=0;
    private  int resultadoacumulado1=0;

    private  int resultadototal=0;
    private  int resultadoacumulado2=0;
    EditText acumJabon;


    private int resultadototal2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceite_domestico);

        home_2= findViewById(R.id.home_2);
        categoria_2= findViewById(R.id.categoria_2);
        sabias_2= findViewById(R.id.sabias_2);
        ubi_2= findViewById(R.id.ubi_2);
        estadisticas_2= findViewById(R.id.estadisticas_2);
        numcantidad= findViewById(R.id.Ingresa_la_cantidad);
        acumagua=findViewById(R.id.acumAgua);
        registrarcantidad= findViewById(R.id.ingresocantidad);
        acumAceite= findViewById(R.id.acumAceite);
        acumJabon= findViewById(R.id.acumJabon);

        Intent regresoHome= new Intent(getApplicationContext(),
                Home.class);

        home_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoHome);
            }
        });




        Intent regresocategoria= new Intent(getApplicationContext(),
                identificaAceite.class);

        categoria_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresocategoria);
            }
        });



        Intent regresosabias= new Intent(getApplicationContext(),
                sabias_que.class);

        sabias_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresosabias);
            }
        });



        Intent regresoubi= new Intent(getApplicationContext(),
                puntos_recoleccion.class);

        ubi_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoubi);
            }
        });


        Intent regresoestadistica= new Intent(getApplicationContext(),
                EstadisticasActivity.class);

        estadisticas_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoestadistica);
            }
        });





        //FUNCION DE LA APP


        ArrayList <Integer> cantidadAceite= new ArrayList<>(); //lista para aceites

        ArrayList <Integer> cantidadagua= new ArrayList<>(); // lista para agua

        ArrayList <Integer> cantidadJabon= new ArrayList<>(); //lista para jabon



        //ACUMULADO AGUA
        registrarcantidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valoringresado= numcantidad.getText().toString();
                    int valor = Integer.parseInt(numcantidad.getText().toString());
                    resultadoacumulado=   valor * 40000;
                    resultadototal= resultadoacumulado + resultadototal;
                    cantidadagua.add(resultadoacumulado);
                    acumagua.setText(String.valueOf(resultadototal + " " + "L"));

                    //ACUMULADO ACEITE

                String valoringresado1= numcantidad.getText().toString();
                    int valor1= Integer.parseInt(numcantidad.getText().toString());
                    resultadoacumulado1= valor1 + resultadoacumulado1;
                    cantidadAceite.add(resultadoacumulado1);
                    acumAceite.setText(String.valueOf(resultadoacumulado1 + " " + "L"));


                    //ACUMULADO JABON

                String valoringresado2= numcantidad.getText().toString();
                    int valor2= Integer.parseInt(numcantidad.getText().toString());
                    resultadoacumulado2= valor2 * 3;
                    resultadototal2= resultadoacumulado2 + resultadototal2;
                    cantidadJabon.add(resultadoacumulado2);
                    acumJabon.setText(String.valueOf(resultadototal2 + " " + "L"));


                    // TRANSFERENCIA DATOS

                Intent intent= new Intent(aceite_domestico.this, EstadisticasActivity.class);

                intent.putExtra("datoAceite1", acumAceite.getText().toString());
                startActivity(intent);



                }
        });
        



    }
}