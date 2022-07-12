package presentacion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.f1app.R;

import datos.ClaseBD;
import datos.ConstantesBD;
import modelo.AdapterSistemaPuntos;

public class SistemaPuntosActivity extends AppCompatActivity {

    //Variables
    RecyclerView sistemaPuntos;
    ClaseBD claseBD;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_puntos);

        //Inicializacion
        sistemaPuntos = findViewById(R.id.sistemaPuntos);
        claseBD = new ClaseBD(this);


        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloPuntos);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Metodos
        mostrarPuntos();
    }

    //Metodo para mostrar el sistema de puntos
    private void mostrarPuntos(){

        //Utilizamos la clase AdapterSistemaPuntos para cargar los puntos del recyclerview
        AdapterSistemaPuntos adapter = new AdapterSistemaPuntos(this, claseBD.getPuntos());

        //utilizamos el adaptador en el recyclerview
        sistemaPuntos.setAdapter(adapter);
    }

    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}