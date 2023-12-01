package olave.hans.ecoreciclagroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import olave.hans.ecoreciclagroup.modelos.Usuario;

public class inicio_sesion extends AppCompatActivity {


        Button btnInicio;
        TextView tvRegistro;

        TextInputLayout edNombreUsuario, edContrasena;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.inicio_sesion);

        btnInicio= findViewById(R.id.btnInicio);
        tvRegistro= findViewById(R.id.tvRegistro);
        edNombreUsuario= findViewById(R.id.edNombreusuario);
        edContrasena=   findViewById(R.id.edContraseñausuario);


        Intent home= new Intent(getApplicationContext(),
                olave.hans.ecoreciclagroup.Home.class
        );

        Intent registrar= new Intent(getApplicationContext(),
                crearusuario.class
                );

        //PARA IR A REGISTRO USUARIO
        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registrar);
            }
        });


        File fileUsuario= new File(getFilesDir(), "Datos_Usuario.txt");

        ArrayList<Usuario> usuarios= listaUsuarios(fileUsuario);


        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean state= false;
                if(edNombreUsuario.getEditText().getText().toString().isEmpty() ||
                   edContrasena.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debes diligenciar los campos", Toast.LENGTH_SHORT).show();

                }   else {
                    String LoginUsuario= edNombreUsuario.getEditText().getText().toString();
                    for (Usuario i: usuarios){
                        if (i.getEdNombre().equals(LoginUsuario) ||
                            i.getEdcorreo().equals(LoginUsuario)) {
                            state= true;

                            if (i.getEdContrasena().equals(edContrasena.getEditText().getText().toString())){
                                startActivity(home);
                                break;
                            }else {
                                Toast.makeText(getApplicationContext(),"Contraseña Incorrecta",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    if (!state){
                        Toast.makeText(getApplicationContext(),"El usuario no esta registrado :(",Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });


    }




    public ArrayList<Usuario> listaUsuarios(File data){
        ArrayList<Usuario> lista= new ArrayList<>();

        try {
            FileReader reader= new FileReader(data);
            BufferedReader buffReader= new BufferedReader(reader);
            String user;

            while ((user=buffReader.readLine()) != null){
                String[] userData= user.split(",");
                String nombre = userData[0];
                String correo = userData[1];
                String contraseña= userData[2];

                Usuario userUsuario= new Usuario(nombre, correo, contraseña);
                lista.add(userUsuario);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return lista;
    }


}

