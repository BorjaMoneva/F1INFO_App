package presentacion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.f1app.R;

import datos.ClaseBD;
import modelo.Escuderia;

public class DetalleEscuderiaActivity extends AppCompatActivity {

    //Variables
    TextView jefeEscuderia, jefeTecnico, chasis, motor, titulo;
    ImageView image;
    ClaseBD claseBD;
    Escuderia escuderia;
    String idem, jefeE, jefeT, cha, mot, tit, foto;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_escuderia);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloDetalleEscuderia);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Inicializacion
        claseBD = new ClaseBD(this);

        Bundle extras = getIntent().getExtras();
        idem = extras.getString("id");

        jefeEscuderia = findViewById(R.id.jefeEscuderia);
        jefeTecnico = findViewById(R.id.jefeTecnico);
        chasis = findViewById(R.id.chasis);
        motor = findViewById(R.id.motor);
        titulo = findViewById(R.id.tituloEs);
        image = findViewById(R.id.ivFotoEscuderia);

        //Metodos
        mostrarDetalle(idem);
    }

    //Metodo para mostrar el detalle de la escuderia seleccionada
    public void mostrarDetalle(String id){
        escuderia = claseBD.getEscuderia(id);

        jefeE = escuderia.getJefeEscuderia();
        jefeT = escuderia.getJefeTecnico();
        cha = escuderia.getChasis();
        mot = escuderia.getMotor();
        tit = escuderia.getTitulos();
        foto = escuderia.getFotoEscuderia();

        jefeEscuderia.setText(jefeE);
        jefeTecnico.setText(jefeT);
        chasis.setText(cha);
        motor.setText(mot);
        titulo.setText(tit);
        image.setImageURI(Uri.parse(foto));

    }

    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}