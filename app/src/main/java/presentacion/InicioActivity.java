package presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.f1app.R;

public class InicioActivity extends AppCompatActivity {

    //Variable
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Inicializacion
        tv = findViewById(R.id.tv_Inicio);
        String nombreUsu = getIntent().getStringExtra("nombreUsuario");
        tv.setText("Bienvenido " + nombreUsu + " a F1 INFO");
    }

    //Cambio de ventana a SistemaPuntosActivity
    public void irPuntos(View view){
        Intent puntos = new Intent(this, SistemaPuntosActivity.class);
        startActivity(puntos);
    }

    //Cambio de ventana a HistoriaActivity
    public void irHistoria(View view){
        Intent historia = new Intent(this, HistoriaActivity.class);
        startActivity(historia);
    }

    //Cambio de ventana a CircuitoActivity
    public void irCircuito(View view){
        Intent circuito = new Intent(this, CircuitoActivity.class);
        startActivity(circuito);
    }

    //Cambio de ventana a PilotoActivity
    public void irPiloto(View view){
        Intent piloto = new Intent(this, PilotoActivity.class);
        startActivity(piloto);
    }

    //Cambio de ventana a EscuderiaActivity
    public void irEscuderia(View view){
        Intent escuderia = new Intent(this, EscuderiaActivity.class);
        startActivity(escuderia);
    }
}