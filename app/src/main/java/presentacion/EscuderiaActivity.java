package presentacion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.f1app.R;

import datos.ClaseBD;
import modelo.AdapterEscuderia;
import modelo.AdapterPiloto;

public class EscuderiaActivity extends AppCompatActivity {

    //Variables
    RecyclerView escuderia;
    ClaseBD claseBD;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuderia);

        //Inicializacion
        escuderia = findViewById(R.id.escuderias);
        claseBD = new ClaseBD(this);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloEscuderias);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Metodos
        mostrarEscuderias();
    }

    //Metodo para mostrar las escuderias
    public void mostrarEscuderias(){

        //Utilizamos la clase AdapterEscuderia para cargar las escuderias del recyclerview
        AdapterEscuderia adapter = new AdapterEscuderia(this, claseBD.getEscuderias());

        //utilizamos el adaptador en el recyclerview
        escuderia.setAdapter(adapter);
    }

    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}