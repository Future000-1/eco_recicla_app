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

import olave.hans.ecoreciclagroup.modelos.Model_Aceite_Industria;

public class aceite_industria extends AppCompatActivity {

    ImageView home_3;
    ImageView categoria_3;
    ImageView sabias_3;

    ImageView ubi_3;

    ImageView estadisticas_3;

    Button registrarCantidad2;

    EditText numcantidad;
    EditText acumagua;

    EditText acumAceite;

    private int resultadoacumulado=0;
    private  int resultadoacumulado1=0;

    private  int resultadototal=0;
    private  int resultadoacumulado2=0;
    EditText acumJabon;


    private int resultadototal2=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceite_industria);

        home_3= findViewById(R.id.home_3);
        categoria_3=findViewById(R.id.categoria_3);
        sabias_3=findViewById(R.id.sabias_3);
        ubi_3=findViewById(R.id.ubi_3);
        estadisticas_3=findViewById(R.id.estadistica_3);
        registrarCantidad2=findViewById(R.id.ingresar2);
        acumAceite=findViewById(R.id.acumAceite2);
        acumagua=findViewById(R.id.acumAgua2);
        acumJabon=findViewById(R.id.acumJabon2);
        numcantidad=findViewById(R.id.Ingresa_la_cantidad2);



        // INTENTS DEL MENU

        Intent regresoHome= new Intent(getApplicationContext(),
                Home.class);

        home_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoHome);
            }
        });




        Intent regresocategoria= new Intent(getApplicationContext(),
                identificaAceite.class);

        categoria_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresocategoria);
            }
        });



        Intent regresosabias= new Intent(getApplicationContext(),
                sabias_que.class);

        sabias_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresosabias);
            }
        });



        Intent regresoubi= new Intent(getApplicationContext(),
                puntos_recoleccion.class);

        ubi_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoubi);
            }
        });


        Intent regresoestadistica= new Intent(getApplicationContext(),
                EstadisticasActivity.class);

        estadisticas_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoestadistica);
            }
        });



        //FUNCION DE LA APP Y FILES


        ArrayList<Integer> cantidadAceite= new ArrayList<>(); //lista para aceites

        ArrayList <Integer> cantidadagua= new ArrayList<>(); // lista para agua

        ArrayList <Integer> cantidadJabon= new ArrayList<>(); //lista para jabon




        registrarCantidad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (numcantidad.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debes ingresar la cantidad",
                            Toast.LENGTH_SHORT).show();

                }else{

                //ACUMULADO AGUA

                String valoringresado= numcantidad.getText().toString();
                int valor = Integer.parseInt(numcantidad.getText().toString());
                resultadoacumulado=   valor * 1000000;
                resultadototal= resultadoacumulado + resultadototal;
                cantidadagua.add(resultadoacumulado);
                acumagua.setText(String.valueOf(resultadototal + " " + "G"));

                //ACUMULADO ACEITE

                resultadoacumulado1= valor + resultadoacumulado1;
                cantidadAceite.add(resultadoacumulado1);
                acumAceite.setText(String.valueOf(resultadoacumulado1 + " " + "G"));


                //ACUMULADO JABON

                resultadoacumulado2= valor * 15;
                resultadototal2= resultadoacumulado2 + resultadototal2;
                cantidadJabon.add(resultadoacumulado2);
                acumJabon.setText(String.valueOf(resultadototal2 + " " + "L"));
                    Model_Aceite_Industria acumulador = new Model_Aceite_Industria(resultadoacumulado1 + "",
                            resultadototal +"", resultadototal2 +"", valor);
                    registrosaceites(acumulador);
                    Toast.makeText(getApplicationContext(), "APORTE REGISTRADO ;)", Toast.LENGTH_SHORT).show();
                }



            }
        });



    }

    private void registrosaceites(Model_Aceite_Industria acumulador) {
        File industriafile= new File(getFilesDir(), "Industria_File.txt");

        try {
            FileWriter writer= new FileWriter(industriafile, true);
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