package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class EstadisticasActivity extends AppCompatActivity {

    ImageView home_7;
    ImageView categoria_7;
    ImageView sabias_7;
    ImageView ubi_7;
    ImageView estadistica_7;
    EditText totalAceiteDomestico;

    EditText totalAceiteHidraulico;


    EditText totalAceiteIndustria;



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
        totalAceiteHidraulico=findViewById(R.id.editTexResultado4);

        home_7 = findViewById(R.id.home_7);
        categoria_7 = findViewById(R.id.categoria_7);
        sabias_7 = findViewById(R.id.sabias_7);
        ubi_7 = findViewById(R.id.ubi_7);
        estadistica_7 = findViewById(R.id.estadistica_7);
        totalAceiteDomestico = findViewById(R.id.editTexResultado1);
        totalAceiteIndustria= findViewById(R.id.editTexResultado2);



        Intent regresoHome = new Intent(getApplicationContext(),
                Home.class);

        home_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoHome);
            }
        });


        Intent regresocategoria = new Intent(getApplicationContext(),
                identificaAceite.class);

        categoria_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresocategoria);
            }
        });


        Intent regresosabias = new Intent(getApplicationContext(),
                sabias_que.class);

        sabias_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresosabias);
            }
        });


        Intent regresoubi = new Intent(getApplicationContext(),
                puntos_recoleccion.class);

        ubi_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoubi);
            }
        });


        Intent regresoestadistica = new Intent(getApplicationContext(),
                EstadisticasActivity.class);

        estadistica_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoestadistica);
            }


        });


        //FUNCIÓN RECIBIR ESTADISTICAS


        //FUNCIÓN RECIBIR ESTADISTICAS ACEITE DOMESTICO

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String CantidadAceiteRecibido = extras.getString("datoAceite1");

            if (CantidadAceiteRecibido != null) {
                totalAceiteDomestico.setText(CantidadAceiteRecibido);



                } else {
                    // Manejo en caso de que el valor sea nulo
                }
            } else {
                // Manejo en caso de que no haya extras
            }


        //FUNCIÓN RECIBIR ESTADISTICAS ACEITE INDUSTRIA DE FRITOS

        Bundle extras2 = getIntent().getExtras();

        if (extras2 != null) {
            String CantidadAceiteRecibido2 = extras2.getString("datoAceite2");

            if (CantidadAceiteRecibido2 != null) {
                totalAceiteIndustria.setText(CantidadAceiteRecibido2);



            } else {
                // Manejo en caso de que el valor sea nulo
            }
        } else {
            // Manejo en caso de que no haya extras
        }


    }
}










