package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import olave.hans.ecoreciclagroup.modelos.Model_Aceite_Automotriz;

public class aceite_automotriz extends AppCompatActivity {

    ImageView home_4;
    ImageView categoria_4;
    ImageView sabias_4;
    ImageView ubi_4;
    ImageView estadistica_4;

    Button registrarCantidad;

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
        setContentView(R.layout.activity_aceite_automotriz);

        home_4= findViewById(R.id.home_4);
        categoria_4= findViewById(R.id.categoria_4);
        sabias_4= findViewById(R.id.sabias_4);
        ubi_4=findViewById(R.id.ubi_4);
        estadistica_4= findViewById(R.id.estadistica_4);
        numcantidad= findViewById(R.id.Ingresa_la_cantidad);
        acumagua=findViewById(R.id.acumAgua);
        registrarCantidad= findViewById(R.id.ingresoCantidad);
        acumAceite= findViewById(R.id.acumAceite);
        acumJabon= findViewById(R.id.acumJabon);



        Intent regresoHome= new Intent(getApplicationContext(),
                Home.class);

        home_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoHome);
            }
        });




        Intent regresocategoria= new Intent(getApplicationContext(),
                identificaAceite.class);

        categoria_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresocategoria);
            }
        });



        Intent regresosabias= new Intent(getApplicationContext(),
                sabias_que.class);

        sabias_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresosabias);
            }
        });



        Intent regresoubi= new Intent(getApplicationContext(),
                puntos_recoleccion.class);

        ubi_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoubi);
            }
        });


        Intent regresoestadistica= new Intent(getApplicationContext(),
                EstadisticasActivity.class);

        estadistica_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoestadistica);
            }
        });





        //FUNCION DE LA APP Y FILES


        ArrayList <Integer> cantidadAceite= new ArrayList<>(); //lista para aceites

        ArrayList <Integer> cantidadagua= new ArrayList<>(); // lista para agua

        ArrayList <Integer> cantidadJabon= new ArrayList<>(); //lista para jabon




        registrarCantidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numcantidad.getText().toString().isEmpty()){

                    Toast.makeText(getApplicationContext(), "Debes ingresar la cantidad",
                            Toast.LENGTH_SHORT).show();
                }else {

                    //ACUMULADO AGUA

                    String valoringresado = numcantidad.getText().toString();
                    int valor = Integer.parseInt(numcantidad.getText().toString());
                    resultadoacumulado = valor * 40;
                    resultadototal = resultadoacumulado + resultadototal;
                    cantidadagua.add(resultadoacumulado);
                    acumagua.setText(String.valueOf(resultadototal + " " + "T"));

                    //ACUMULADO ACEITE


                    resultadoacumulado1 = valor + resultadoacumulado1;
                    cantidadAceite.add(resultadoacumulado1);
                    acumAceite.setText(String.valueOf(resultadoacumulado1 + " " + "T"));


                    //ACUMULADO JABON


                    resultadoacumulado2 = valor * 3000;
                    resultadototal2 = resultadoacumulado2 + resultadototal2;
                    cantidadJabon.add(resultadoacumulado2);
                    acumJabon.setText(String.valueOf(resultadototal2 + " " + "T"));
                    Model_Aceite_Automotriz acumulador =new Model_Aceite_Automotriz(resultadoacumulado1 + "",
                            resultadototal + "", resultadototal2 +"", valor);
                    registrosaceites(acumulador);
                    Toast.makeText(getApplicationContext(), "APORTE REGISTRADO ;)", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void registrosaceites(Model_Aceite_Automotriz acumulador) {
        File automotrizFile= new File(getFilesDir(), "Automotriz_File.txt");
        try {
            FileWriter writer= new FileWriter(automotrizFile, true);
            BufferedWriter buffWriter= new BufferedWriter(writer);
            buffWriter.write(
                    acumulador.getAcumAceite()+","+
                            acumulador.getAcumagua()+","+
                            acumulador.getAcumJabon()+","+
                            acumulador.getValorcantidadlitros()
            );

            buffWriter.newLine();
            buffWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}