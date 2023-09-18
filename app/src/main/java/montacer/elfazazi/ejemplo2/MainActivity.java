package montacer.elfazazi.ejemplo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import montacer.elfazazi.ejemplo2.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    //variables de la vista o interfaz

    private Button btnRegistrar;
    private EditText txtEmail;
    private EditText txtPassword;

    //variables para la logica

    ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //inicializar cosas

        listaUsuarios = new ArrayList<>();

        inicializaVista();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //coger los textos de las cajas
                String email = txtEmail.getText().toString(); //aunq sea texto habra q convertirlo
                String password = txtPassword.getText().toString();

                //comprobar que estan rellenados y sino avisar
                if (email.isEmpty() || password.isEmpty()){
                    //no se puede guardar
                    Toast.makeText(MainActivity.this, "faltan datos", Toast.LENGTH_SHORT).show();
                }else {
                    //guardamos en la lista
                    Usuario miusuario = new Usuario(email, password);
                    listaUsuarios.add(miusuario);
                    Toast.makeText(MainActivity.this, "usuario almacenado: " +miusuario.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void inicializaVista() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistrar = findViewById(R.id.btnRegisterMain);
    }
}