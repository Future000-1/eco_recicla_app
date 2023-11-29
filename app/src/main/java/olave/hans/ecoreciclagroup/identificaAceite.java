package olave.hans.ecoreciclagroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class identificaAceite extends AppCompatActivity {

    ImageView botonRegreso;
    ImageView botonimDomestico;
    ImageView botonimfritos;
    ImageView botonimAutomotriz;
    ImageView botonimLubricacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identifica_aceite);

        botonRegreso= findViewById(R.id.botonRegreso);

        Intent regresoHome= new Intent(getApplicationContext(),
                Home.class
                );

        botonRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regresoHome);
            }
        });


        //codigos botones que lleven a las vistas de cada tipo de aceite


        botonimDomestico= findViewById(R.id.imDomestico);
        Intent irdomestico= new Intent(getApplicationContext(),
                aceite_domestico.class
        );

        botonimDomestico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(irdomestico);
            }
        });




        botonimfritos= findViewById(R.id.imfritos);
        Intent irfritos= new Intent(getApplicationContext(),
                aceite_industria.class
        );

        botonimfritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(irfritos);
            }
        });



        botonimLubricacion= findViewById(R.id.imlubricacion);
        Intent irlubricacion= new Intent(getApplicationContext(),
                aceite_hidraulico.class
        );

        botonimLubricacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(irlubricacion);
            }
        });


        botonimAutomotriz= findViewById(R.id.imAutomotriz);


        Intent irautomotriz= new Intent(getApplicationContext(),
                aceite_automotriz.class
        );

        botonimAutomotriz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(irautomotriz);
            }
        });



    }

}



