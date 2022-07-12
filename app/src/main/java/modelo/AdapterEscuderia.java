package modelo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1app.R;

import java.util.ArrayList;

import datos.ClaseBD;
import presentacion.DetalleCircuitoActivity;
import presentacion.DetalleEscuderiaActivity;

public class AdapterEscuderia extends RecyclerView.Adapter<AdapterEscuderia.HolderEscuderia>{
    //Variables
    private Context contexto;
    private ArrayList<Escuderia> listaEscuderia;

    //Declaramos un objeto de tipo BD
    ClaseBD clasebd;

    //Constructor
    public AdapterEscuderia(Context contexto, ArrayList<Escuderia> listaEscuderia) {
        this.contexto = contexto;
        this.listaEscuderia = listaEscuderia;
        clasebd = new ClaseBD(contexto);
    }
    @NonNull
    @Override
    public AdapterEscuderia.HolderEscuderia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflamos el layout con el de lista_escuderia
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_escuderia, parent, false);

        //Devolvemos el HolderEscuderia con todas las vistas de lista_escuderia inicializadas, es donde pondremos los datos de las escuderias
        return new AdapterEscuderia.HolderEscuderia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEscuderia.HolderEscuderia holder, int position) {
        //Con este método obtenemos datos, los establecemos y vemos los clicks

        //Primero obtenemos los datos de cada escuderia por la posición
        Escuderia escuderia = listaEscuderia.get(position);
        final String id = escuderia.getId();

        final String nombreEscuderia = escuderia.getNombre();
        final String paisEscuderia = escuderia.getPais();
        final String sedeEscuderia = escuderia.getSede();

        holder.nombre.setText(nombreEscuderia);
        holder.pais.setText(paisEscuderia);
        holder.sede.setText(sedeEscuderia);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, DetalleEscuderiaActivity.class);
                intent.putExtra("id", id);
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Devuelve el número de escuderias almacenadas
        return listaEscuderia.size();
    }

    public class HolderEscuderia extends RecyclerView.ViewHolder{
        TextView nombre, pais, sede;
        public HolderEscuderia(@NonNull View itemView) {
            super(itemView);

            //Inicializamos los elementos de la vista
            nombre = itemView.findViewById(R.id.tv_nombre_escuderia);
            pais = itemView.findViewById(R.id.tv_pais_escuderia);
            sede = itemView.findViewById(R.id.tv_sede_escuderia);
        }
    }
}
