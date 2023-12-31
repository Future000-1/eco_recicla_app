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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import olave.hans.ecoreciclagroup.modelos.Model_Aceite_Hidraulico;

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



        //FUNCION DE LA APP Y FILES


        ArrayList<Integer> cantidadAceite= new ArrayList<>(); //lista para aceites

        ArrayList <Integer> cantidadagua= new ArrayList<>(); // lista para agua

        ArrayList <Integer> cantidadJabon= new ArrayList<>(); //lista para jabon




        registrarcantidad.setOnClickListener(new View.OnClickListener() {
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
                    Model_Aceite_Hidraulico acumulador= new Model_Aceite_Hidraulico(resultadoacumulado1 +"",
                            resultadototal+"", resultadototal2+"", valor);
                    registrosAceites(acumulador);
                    Toast.makeText(getApplicationContext(), "APORTE REGISTRADO ;)", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private void registrosAceites(Model_Aceite_Hidraulico acumulador) {
        File hidraulicoFile= new File(getFilesDir(),"Hidraulico_File.txt");

        try {
            FileWriter writer= new FileWriter(hidraulicoFile, true);
            BufferedWriter buffWriter= new BufferedWriter(writer);
            buffWriter.write(
                    acumulador.getAcumaceite()+","+
                            acumulador.getAcumagua()+","+
                            acumulador.getAcumjabon()+","+
                            acumulador.getValorcantidadlitros()
            );

            buffWriter.newLine();
            buffWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }



        //FILES READER PARA LOS CONTADORES


        File contadoraceite= new File(getFilesDir(),"Industria_File.txt");

        File contadoragua= new File(getFilesDir(),"Industria_File.txt");

        File contadorjabon= new File(getFilesDir(),"Industria_File.txt");


        ArrayList<Integer> lista_aceite=listaaceite(contadoraceite);
        ArrayList<Integer> lista_agua= listaagua(contadoragua);
        ArrayList<Integer> lista_jabon= listajabon(contadorjabon);


        ContadorTotalaceite(lista_aceite);
        ContadorTotalAgua(lista_agua);
        ContadorTotalJabon(lista_jabon);


    }


    // ACEITE
    private void ContadorTotalaceite(ArrayList<Integer> list) {
        int total=0;

        for (int i: list){
            total += i;
        }
        acumAceite.setText(String.valueOf(total+ " T"));}

    private ArrayList<Integer> listaaceite(File contador) {
        ArrayList<Integer> list = new ArrayList<>();

        try {
            FileReader reader= new FileReader(contador);
            BufferedReader reader2 = new BufferedReader(reader);
            String cadena;
            while((cadena = reader2.readLine()) != null){
                String [] data= cadena.split(",");
                int aceite = Integer.parseInt(data[0]);
                list.add(aceite);

            }

            reader2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



    // AGUA

    private void ContadorTotalAgua(ArrayList<Integer> list) {
        int total=0;

        for (int i: list){
            total += i;
        }
        acumagua.setText(String.valueOf(total+" T"));

    }


    private ArrayList<Integer> listaagua(File contador) {
        ArrayList<Integer> list = new ArrayList<>();

        try {
            FileReader reader= new FileReader(contador);
            BufferedReader reader2 = new BufferedReader(reader);
            String cadena;
            while((cadena = reader2.readLine()) != null){
                String [] data= cadena.split(",");
                int agua = Integer.parseInt(data[1]);
                list.add(agua);
            }

            reader2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    //JABON


    private void ContadorTotalJabon(ArrayList<Integer> list) {
        int total=0;

        for (int i: list){
            total += i;
        }
        acumJabon.setText(String.valueOf(total+ " T"));

    }

    private ArrayList<Integer> listajabon(File contador) {
        ArrayList<Integer> list = new ArrayList<>();

        try {
            FileReader reader= new FileReader(contador);
            BufferedReader reader2 = new BufferedReader(reader);
            String cadena;
            while((cadena = reader2.readLine()) != null){
                String [] data= cadena.split(",");
                int aceite = Integer.parseInt(data[2]);
                list.add(aceite);

            }

            reader2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;


    }



}




