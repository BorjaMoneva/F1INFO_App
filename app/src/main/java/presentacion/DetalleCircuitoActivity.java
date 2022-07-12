package presentacion;

import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.f1app.R;

import datos.ClaseBD;
import modelo.Circuito;

public class DetalleCircuitoActivity extends AppCompatActivity {

    //Variables
    TextView longitud, vueltas, distancia, primero, cabecera;
    ImageView image;
    ClaseBD claseBD;
    Circuito circuito;
    String idem, foto, lon, vuelt, dis, pri, cab;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_circuito);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloDetalleCircuito);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Inicializacion
        claseBD = new ClaseBD(this);

        Bundle extras = getIntent().getExtras();
        idem = extras.getString("id");

        cabecera = findViewById(R.id.cabecera);
        longitud = findViewById(R.id.longitudGp);
        vueltas = findViewById(R.id.nVuelta);
        distancia = findViewById(R.id.distanciaGp);
        primero = findViewById(R.id.primerGp);
        image = findViewById(R.id.ivFoto);

        //Metodos
        mostrarDetalle(idem);
    }

    //Metodo para mostrar los detalles del circuito seleccionado
    public void mostrarDetalle(String id){
        circuito = claseBD.getCircuito(id);

        lon = circuito.getLongitud();
        vuelt = circuito.getVueltas();
        dis = circuito.getDistancia();
        pri = circuito.getPrimerGp();
        foto = circuito.getFotoGp();

        cabecera.setText("Detalles del circuito de " + circuito.getPaisGp());
        longitud.setText(lon + " km");
        vueltas.setText(vuelt + "");
        distancia.setText(dis + " km");
        primero.setText(pri + "");
        image.setImageURI(Uri.parse(foto));
    }

    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}