package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import olave.hans.ecoreciclagroup.modelos.Model_Aceite_Domestico;

public class EstadisticasActivity extends AppCompatActivity {

    ImageView home_7;
    ImageView categoria_7;
    ImageView sabias_7;
    ImageView ubi_7;
    ImageView estadistica_7;
    EditText totalAceiteDomestico;
    EditText totalAceiteIndustria;
    EditText totalAceiteAutomotriz;
    EditText totalAceiteLubricacion;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        home_7= findViewById(R.id.home_7);
        categoria_7=findViewById(R.id.categoria_7);
        sabias_7= findViewById(R.id.sabias_7);
        ubi_7= findViewById(R.id.ubi_7);
        estadistica_7= findViewById(R.id.estadistica_7);
        totalAceiteDomestico=findViewById(R.id.editTexResultado1);
        totalAceiteIndustria=findViewById(R.id.editTexResultado2);
        totalAceiteAutomotriz=findViewById(R.id.editTexResultado3);
        totalAceiteLubricacion=findViewById(R.id.editTexResultado4);


        // INTENTS DEL MENU
        Intent regresoHome= new Intent(getApplicationContext(),
                Home.class);

        home_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoHome);
            }
        });




        Intent regresocategoria= new Intent(getApplicationContext(),
                identificaAceite.class);

        categoria_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresocategoria);
            }
        });



        Intent regresosabias= new Intent(getApplicationContext(),
                sabias_que.class);

        sabias_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresosabias);
            }
        });



        Intent regresoubi= new Intent(getApplicationContext(),
                puntos_recoleccion.class);

        ubi_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoubi);
            }
        });


        Intent regresoestadistica= new Intent(getApplicationContext(),
                EstadisticasActivity.class);

        estadistica_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoestadistica);
            }


        });





    // CREAR FILES Y ARRAYLIST

        File aceiteDomestico= new File(getFilesDir(), "Domestico_file.txt");
        ArrayList <Integer> lista_domestico= listaDomestico(aceiteDomestico);

        totalDomestico(lista_domestico);

        File aceiteIndustria= new File(getFilesDir(),"Industria_File.txt");
        ArrayList<Integer>lista_industria= listaIndustria(aceiteIndustria);

        totalIndustria(lista_industria);


        File aceiteAutomotriz= new File(getFilesDir(),"Automotriz_File.txt");
        ArrayList<Integer>lista_automotriz= listaAutomotriz(aceiteAutomotriz);

        totalAutomotriz(lista_automotriz);

        File aceiteHidraulico= new File(getFilesDir(),"Hidraulico_File.txt");
        ArrayList<Integer>lista_Hidraulico= listaHidraulico(aceiteHidraulico);

        totalHidraulico(lista_Hidraulico);


    }


    // RECIBIR LOS FILES Y ARRAYLIST DE LOS ACEITES


    // ACEITE DOMESTICO

    private void totalDomestico(ArrayList<Integer> list) {
    int total1= 0;

    for (int i: list) {
        total1 += i;
    }

    totalAceiteDomestico.setText(String.valueOf(total1 + " L"));    }

    private ArrayList<Integer> listaDomestico(File aceiteDomestico) {
    ArrayList<Integer> list = new ArrayList<>();

    try {
        FileReader reader1=new FileReader(aceiteDomestico);
        BufferedReader buffreader1 = new BufferedReader(reader1);
        String cadena;
        while((cadena = buffreader1.readLine()) != null){
            String [] data= cadena.split(",");

                int domestico = Integer.parseInt(data[0]);

                list.add(domestico);

            }

    }catch (Exception e){
        e.printStackTrace();
    }

    return list;

    }



    // ACEITE INDUSTRIAL

    private void totalIndustria(ArrayList<Integer> list) {
        int total1= 0;

        for (int i: list) {
            total1 += i;
        }

        totalAceiteIndustria.setText(String.valueOf(total1 + " G"));
    }

    private ArrayList<Integer> listaIndustria(File aceiteIndustria) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileReader reader1=new FileReader(aceiteIndustria);
            BufferedReader buffreader1 = new BufferedReader(reader1);
            String cadena;
            while((cadena = buffreader1.readLine()) != null){
                String [] data= cadena.split(",");

                int industria = Integer.parseInt(data[0]);

                list.add(industria);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



    // ACEITE AUTOMOTRIZ
    private void totalAutomotriz(ArrayList<Integer> list) {
        int total1= 0;

        for (int i: list) {
            total1 += i;
        }

        totalAceiteAutomotriz.setText(String.valueOf(total1 + " T"));

    }

    private ArrayList<Integer> listaAutomotriz(File aceiteAutomotriz) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            FileReader reader1=new FileReader(aceiteAutomotriz);
            BufferedReader buffreader1 = new BufferedReader(reader1);
            String cadena;
            while((cadena = buffreader1.readLine()) != null){
                String [] data= cadena.split(",");

                int automotriz = Integer.parseInt(data[0]);

                list.add(automotriz);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }


    //ACEITE HIDRAULICO

    private void totalHidraulico(ArrayList<Integer> list) {
        int total1= 0;

        for (int i: list) {
            total1 += i;
        }

        totalAceiteLubricacion.setText(String.valueOf(total1+ " T"));

    }

    private ArrayList<Integer> listaHidraulico(File aceiteHidraulico) {
        ArrayList<Integer> list = new ArrayList<>();

        try {
            FileReader reader1=new FileReader(aceiteHidraulico);
            BufferedReader buffreader1 = new BufferedReader(reader1);
            String cadena;
            while((cadena = buffreader1.readLine()) != null){
                String [] data= cadena.split(",");

                int hidraulico = Integer.parseInt(data[0]);

                list.add(hidraulico);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}