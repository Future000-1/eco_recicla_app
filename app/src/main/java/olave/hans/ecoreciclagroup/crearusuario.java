package olave.hans.ecoreciclagroup;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import olave.hans.ecoreciclagroup.modelos.Usuario;


public class crearusuario extends AppCompatActivity {
    Button btnCrearUsuario;
    TextInputLayout edNombre, edcorreo, edcontrasena;
    CheckBox check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearusuario);

        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);
        edNombre = findViewById(R.id.edNombre);
        edcorreo = findViewById(R.id.edCorreo);
        edcontrasena = findViewById(R.id.edContrasena);
        check = findViewById(R.id.check);


        Intent inicio = new Intent(getApplicationContext(),
                inicio_sesion.class);


        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarUsuario()) {
                    Usuario user = createUsuario();
                    saveUsuario(user);
                    Toast.makeText(getApplicationContext(), "Usuario Registrado con Exito :)", Toast.LENGTH_SHORT).show();

                    try {
                        sleep(500);

                        startActivity(inicio);
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                } else {
                    Toast.makeText(getApplicationContext(), "Debes diligenciar todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }




    // VALIDADOR DE DATOS DEL USUARIO

    private boolean validarUsuario() {


        boolean validador = true;

        if (edNombre.getEditText().getText().toString().isEmpty()) {
            edNombre.setBoxBackgroundColor(Color.RED);
            validador = false;
        }
        if (edcorreo.getEditText().getText().toString().isEmpty()) {
            edcorreo.setBoxBackgroundColor(Color.RED);
            validador = false;
        }
        if (edcontrasena.getEditText().getText().toString().isEmpty()) {
            edcontrasena.setBoxBackgroundColor(Color.RED);
            validador = false;
        }
        if (check.getText().toString().isEmpty()) {
            check.setBackgroundColor(Color.RED);
            check.setChecked(false);
            validador = false;
        }

        return validador;
    }


    // CREAR USUARIO
    private Usuario createUsuario() {
        String nombreUsuario, correoUsuario, contraseñausuario, check;

        nombreUsuario= edNombre.getEditText().getText().toString();
        correoUsuario= edcorreo.getEditText().getText().toString();
        contraseñausuario= edcontrasena.getEditText().getText().toString();

        Usuario user=new Usuario(nombreUsuario,correoUsuario,contraseñausuario);

        return user;
    }



    // FILE PARA GUARDAR AL USUARIO


    public void saveUsuario(Usuario user){

        File fileUsuario = new File(getFilesDir(),"Datos_Usuario.txt");

        try {

            FileWriter writer = new FileWriter(fileUsuario, true);
            BufferedWriter buffWriter = new BufferedWriter(writer);
            buffWriter.write(
                    user.getEdNombre()+","+
                        user.getEdcorreo()+","+
                        user.getEdContrasena()

            );

            buffWriter.newLine();
            buffWriter.close();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

}


















