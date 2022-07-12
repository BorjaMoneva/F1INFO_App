package presentacion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.f1app.R;

import datos.ClaseBD;
import datos.ConstantesBD;
import modelo.AdapterCircuito;

public class CircuitoActivity extends AppCompatActivity {

    //Variables
    RecyclerView circuito;
    ClaseBD claseBD;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuito);

        //Inicializacion
        circuito = findViewById(R.id.circuitos);
        claseBD = new ClaseBD(this);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloCircuito);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Metodos
        mostrarCircuitos();
    }

    //Metodo para mostrar los circuitos
    public void mostrarCircuitos(){

        //Utilizamos la clase AdapterCircuito para cargar los circuitos del recyclerview
        AdapterCircuito adapter = new AdapterCircuito(this, claseBD.getCircuitos());

        //utilizamos el adaptador en el recyclerview
        circuito.setAdapter(adapter);
    }

    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}