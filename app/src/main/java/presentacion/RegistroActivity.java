package presentacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.f1app.R;

import java.util.ArrayList;

import datos.ClaseBD;
import modelo.Registro;

public class RegistroActivity extends AppCompatActivity {

    //Variables
    EditText et1, et2, et3;
    ClaseBD claseBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Inicializacion
        et1 = (EditText)findViewById(R.id.etEmail);
        et2 = (EditText)findViewById(R.id.etNomUsu);
        et3 = (EditText)findViewById(R.id.etContraseñaR);

    }

    //Metodo para registrar un usuario
    public void registrarse(View view){
        String email =et1.getText().toString();
        String nombre_Usuario = et2.getText().toString();
        String contraseña = et3.getText().toString();
        claseBD = new ClaseBD(this);
        ArrayList<Registro> usuarios = claseBD.comprobarUsuarios();
        if((email.isEmpty()) || (nombre_Usuario.isEmpty()) || (contraseña.isEmpty())){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ERROR");
            builder.setMessage("Debes rellenar todos los campos");
            builder.setPositiveButton("Aceptar", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }else{
            claseBD.registrarUsuario(email, nombre_Usuario, contraseña);
            Intent inicio = new Intent(this, MainActivity.class);
            startActivity(inicio);
        }
    }
}