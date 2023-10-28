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

    }

}



