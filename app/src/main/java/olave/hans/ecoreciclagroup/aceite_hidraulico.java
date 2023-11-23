package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class aceite_hidraulico extends AppCompatActivity {

    ImageView home_5;
    ImageView categoria_5;
    ImageView sabias_5;
    ImageView ubi_5;
    ImageView estadistica_5;

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
        setContentView(R.layout.activity_aceite_hidraulico);


        home_5= findViewById(R.id.home_5);
        categoria_5= findViewById(R.id.categoria_5);
        sabias_5= findViewById(R.id.sabias_5);
        ubi_5= findViewById(R.id.ubi_5);
        estadistica_5= findViewById(R.id.estadistica_5);
        numcantidad= findViewById(R.id.Ingresa_la_cantidad);
        acumagua=findViewById(R.id.acumAgua);
        registrarcantidad= findViewById(R.id.ingresar1);
        acumAceite= findViewById(R.id.acumAceite);
        acumJabon= findViewById(R.id.acumJabon);


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



<<<<<<< HEAD
        //FUNCION DE LA APP


        ArrayList<Integer> cantidadAceite= new ArrayList<>(); //lista para aceites

        ArrayList <Integer> cantidadagua= new ArrayList<>(); // lista para agua

        ArrayList <Integer> cantidadJabon= new ArrayList<>(); //lista para jabon



        //ACUMULADO AGUA
        registrarcantidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valoringresado= numcantidad.getText().toString();
                int valor = Integer.parseInt(numcantidad.getText().toString());
                resultadoacumulado=   valor * 40;
                resultadototal= resultadoacumulado + resultadototal;
                cantidadagua.add(resultadoacumulado);
                acumagua.setText(String.valueOf(resultadototal + " " + "T"));

                //ACUMULADO ACEITE

                String valoringresado1= numcantidad.getText().toString();
                int valor1= Integer.parseInt(numcantidad.getText().toString());
                resultadoacumulado1= valor1 + resultadoacumulado1;
                cantidadAceite.add(resultadoacumulado1);
                acumAceite.setText(String.valueOf(resultadoacumulado1 + " " + "T"));


                //ACUMULADO JABON

                String valoringresado2= numcantidad.getText().toString();
                int valor2= Integer.parseInt(numcantidad.getText().toString());
                resultadoacumulado2= valor2 * 3000;
                resultadototal2= resultadoacumulado2 + resultadototal2;
                cantidadJabon.add(resultadoacumulado2);
                acumJabon.setText(String.valueOf(resultadototal2 + " " + "T"));


                // TRANSFERENCIA DATOS

                Intent intent= new Intent(aceite_hidraulico.this, EstadisticasActivity.class);

                intent.putExtra("datoAceite4", acumAceite.getText().toString());
                startActivity(intent);



            }
        });
    } }
=======





    }
}
>>>>>>> 42fc4af57d6a40bafaf56e050357fbb18c1e3b24
