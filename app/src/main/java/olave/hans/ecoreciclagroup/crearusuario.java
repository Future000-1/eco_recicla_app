package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class crearusuario extends AppCompatActivity {
    Button btnCrearUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearusuario);

        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);

        Intent inicio = new Intent(getApplicationContext(),
                MainActivity.class);

        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(inicio);
            }
        });
    }
}