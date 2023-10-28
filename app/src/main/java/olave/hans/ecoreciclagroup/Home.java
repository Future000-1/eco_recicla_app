package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button btnCerrar;
    Button btnIdentifica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCerrar= findViewById(R.id.btnCerrar);
        btnIdentifica= findViewById(R.id.btnIdentifica);

        Intent cerrarsesion= new Intent(getApplicationContext(),
                MainActivity.class
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
    }
}