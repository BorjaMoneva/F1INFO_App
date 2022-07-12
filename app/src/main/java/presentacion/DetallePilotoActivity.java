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
import modelo.Piloto;

public class DetallePilotoActivity extends AppCompatActivity {

    //Variables
    TextView nPodios, nVictorias, nGpDisputados, cumpleaños, nVueltas, titulo, escuderia, cabecera;
    ImageView image;
    ClaseBD claseBD;
    Piloto piloto;
    String idem, pod, vic, dis, cum, vue, tit, esc, foto;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_piloto);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloDetallePiloto);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Inicializacion
        claseBD = new ClaseBD(this);

        Bundle extras = getIntent().getExtras();
        idem = extras.getString("id");

        nPodios = findViewById(R.id.podios);
        nVictorias = findViewById(R.id.victoria);
        nGpDisputados = findViewById(R.id.gpDis);
        cumpleaños = findViewById(R.id.cumple);
        nVueltas = findViewById(R.id.vueltasR);
        titulo = findViewById(R.id.tituloP);
        escuderia = findViewById(R.id.escu);
        image = findViewById(R.id.ivFotoPiloto);

        //Metodos
        mostrarDetalle(idem);
    }

    //Metodo para mostrar el detalle del piloto seleccionado
    public void mostrarDetalle(String id){
        piloto = claseBD.getPiloto(id);

        Escuderia e = claseBD.getEscuderia(piloto.getIdEscuderia());
        String nombreE = e.getNombre();
        pod = piloto.getnPodios();
        vic = piloto.getnVictorias();
        dis = piloto.getGpDisputados();
        cum = piloto.getCumpleaños();
        vue = piloto.getnVueltasRapidas();
        tit = piloto.getTitulos();
        esc = nombreE;
        foto = piloto.getFotoPiloto();

        nPodios.setText(pod);
        nVictorias.setText(vic);
        nGpDisputados.setText(dis);
        cumpleaños.setText(cum);
        nVueltas.setText(vue);
        titulo.setText(tit);
        escuderia.setText(esc);
        image.setImageURI(Uri.parse(foto));

    }

    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}