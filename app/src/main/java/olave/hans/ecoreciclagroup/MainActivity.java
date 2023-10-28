package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        Button btnInicio;
        TextView tvRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.inicio_sesion);

        btnInicio= findViewById(R.id.btnInicio);
        tvRegistro= findViewById(R.id.tvRegistro);

        Intent home= new Intent(getApplicationContext(),
                olave.hans.ecoreciclagroup.Home.class
        );

        Intent registrar= new Intent(getApplicationContext(),
                crearusuario.class
                );

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(home);
            }
        });

        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registrar);
            }
        });


        setContentView(R.layout.activity_main);


    }
}