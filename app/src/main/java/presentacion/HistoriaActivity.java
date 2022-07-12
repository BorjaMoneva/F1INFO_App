package presentacion;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.f1app.R;

public class HistoriaActivity extends AppCompatActivity {

    //Variables
    private Spinner s;
    private TextView tv;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.tituloHistoria);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //Inicializacion
        s = (Spinner) findViewById(R.id.spinner);

        //Rellenar spinner
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.historia_array, android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adaptador);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv = (TextView) findViewById(R.id.textView);

                switch (s.getSelectedItem().toString()) {
                    case "":
                        tv.setText("Selección");
                        break;
                    case "Los años 50":
                        tv.setText("Se celebró el primer campeonato. El campeón de esta temporada fue el italiano Giuseppe Farina. En 1952 y 1953 por motivos económicos el mundial se compitió con coches de Fórmula 2. En 1958 se instaura el campeonato de constructores (por equipos).");
                        break;
                    case "Los años 60":
                        tv.setText("Fue un dominio británico, además se produjo un hecho histórico ya que John Surtees es el único piloto que ha ganado el campeonato mundial de motociclismo (1958-1960) y su único campeonato de automovilismo en 1964 con la escudería Ferrari.");
                        break;
                    case "Los años 70":
                        tv.setText("Estuvieron marcados por la rivalidad entre Niki Lauda y James Hunt. En 1975, Niki Lauda logro su primer mundial con Ferrari, que llevaba sin ganar un mundial de pilotos desde 1964. En  1976 fue el año de la rivalidad entre el Niki Lauda y James Hunt, donde el campeonato llego hasta la última carrera, el titulo se lo llevo James Hunt. En 1977, Niki Lauda volvió a conquistar el mundial.");
                        break;
                    case "1978":
                        tv.setText("Bernie Ecclestone compro los derechos de la Formula 1 para extenderlos por el mundo e hizo a la fórmula uno un negocio. Aparte se convirtió en el presidente de la categoría.");
                        break;
                    case "Los años 80":
                        tv.setText("Comenzó la época dorada de McLaren con su vínculo con los motores japoneses, Honda. También fue la década de las escuderías inglesas con McLaren, Brabham y Williams. Durante esta década, no hubo una escudería que no fuera inglesa que no ganara el título de constructores. Los mundiales en esta época se repartieron entre Nelson Piquet, Keke Rosberg, Ayrton Senna y Alain Prost. Los más dominadores fueron Ayrton Senna y Alain Prost.");
                        break;
                    case "Los años 90":
                        tv.setText("McLaren bajo su potencial en 1992, cuando Williams revoluciono con su coche y superó con creces al resto de rivales. En dicho año Nigel Mansell logro su primer y único mundial con Williams. En 1993 Alain Prost dejo McLaren para irse a Williams donde gano su cuarto mundial y fue su última temporada.");
                        break;
                    case "1994":
                        tv.setText("Este año marco la década de los 90, por el fatídico fin de semana del gran premio de San Marino. El sábado, Roland Ratzenberger tuvo un gravísimo accidente que acabo con su vida a los 33 años de edad. Pero eso no es todo ya que el domingo, día de la carrera, Ayrton Senna a su paso por la curva Tamburello, se salió de pista e impacto con el mura a 221 km/h. El tricampeón del mundo falleció antes de llegar al hospital a los 34 años de edad.");
                        break;

                    case "La leyenda del ‘Káiser’":
                        tv.setText("Aquel 1994, fue el comienzo de la leyenda de un piloto alemán, Michael Schumacher. Debuto en Formula 1 en 1991, tres años más tarde consiguió su primer mundial, al año siguiente consiguió también el mundial. Ferrari decidió fichar a Schumacher, pero hasta el año 2000 cuando el dominio Schumacher-Ferrari comenzaría,  no logro su primer título con Ferrari. Desde el 2000 hasta el 2004 fue el dominador absoluto. Un total de 7 mundiales, dos con Benetton y 5 con Ferrari.");
                        break;
                    case "La época dorada del automovilismo español":
                        tv.setText("Un piloto español logro lo que casi nadie podía esperar, romper la hegemonía de Schumacher y Ferrari. Fernando Alonso con su Renault consiguió dos mundiales consecutivos en 2005, 2006. Estas temporadas son recordadas por las increíbles luchas en pista entre el piloto español y el piloto alemán.");
                        break;
                    case "2009":
                        tv.setText("Este año fue importante ya que traía cambios en cuanto a la aerodinámica del coche. La escudería Brawn Gp, la sucesora de Honda en 2008, con una revolución en su coche sobre todo en el difusor, logro llevar a lo más alto a Jenson Button, además de lograr el mundial de constructores, todo esto a pesar de que a mediados de temporada los superaron Red-Bull y McLaren.");
                        break;
                    case "2010 hasta ahora":
                        tv.setText("Si algo está marcando esta década son las hegemonías de Red-Bull y Mercedes. La escudería de bebidas energéticas tuvo su dominio entre 2010 y 2013 donde lo ganaron absolutamente todo, tanto el mundial de pilotos como el de constructores, los 4 títulos de pilotos los logro el alemán Sebastián Vettel. A partir de aquí cambiaron las tornas y la escudería alemana Mercedes ha logrado 8 títulos de constructores y 7 de pilotos. 6 de esos títulos, los logro el inglés Lewis Hamilton que sumado al que logro en McLaren igualo en 2020 a Michael Schumacher como el piloto que más títulos tiene en la historia. El título que queda lo gano Nico Rosberg y se retiró en esa misma temporada. La temporada 2021 fue de las más igualadas de la historia ya que dos pilotos, Lewis Hamilton y Max Verstappen, llegaron empatados a puntos a la última carrera y el mundial se decidiría en la última vuelta. Max Verstappen logro su primer título de pilotos.");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    //Para que desde el ActionBar vaya a la actividad anterior
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}