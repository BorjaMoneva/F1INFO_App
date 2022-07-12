package presentacion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.f1app.R;

import datos.ClaseBD;
import modelo.AdapterCircuito;
import modelo.AdapterPiloto;

public class PilotoActivity extends AppCompatActivity {

    //Variables
    RecyclerView piloto;
    ClaseBD claseBD;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piloto);

        //Inicializacion
        piloto = findViewById(R.id.pilotos);
        claseBD = new ClaseBD(this);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloPilotos);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Metodos
        mostrarPilotos();
    }

    //Metodo para mostrar los pilotos
    public void mostrarPilotos(){

        //Utilizamos la clase AdapterPiloto para cargar los pilotos del recyclerview
        AdapterPiloto adapter = new AdapterPiloto(this, claseBD.getPilotos());

        //utilizamos el adaptador en el recyclerview
        piloto.setAdapter(adapter);
    }

    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}