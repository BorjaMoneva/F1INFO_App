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
import presentacion.DetallePilotoActivity;

public class AdapterPiloto extends RecyclerView.Adapter<AdapterPiloto.HolderPiloto>{

    //Variables
    private Context contexto;
    private ArrayList<Piloto> listaPilotos;

    //Declaramos un objeto de tipo BD
    ClaseBD clasebd;

    //Constructor
    public AdapterPiloto(Context contexto, ArrayList<Piloto> listaPilotos) {
        this.contexto = contexto;
        this.listaPilotos = listaPilotos;
        clasebd = new ClaseBD(contexto);
    }
    @NonNull
    @Override
    public AdapterPiloto.HolderPiloto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflamos el layout con el de lista_piloto
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_piloto, parent, false);

        //Devolvemos el HolderPiloto con todas las vistas de lista_piloto inicializadas, es donde pondremos los datos de los pilotos
        return new AdapterPiloto.HolderPiloto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPiloto.HolderPiloto holder, int position) {
        //Con este método obtenemos datos, los establecemos y vemos los clicks

        //Primero obtenemos los datos de cada piloto por la posición
        Piloto piloto = listaPilotos.get(position);
        final String id = piloto.getId();

        final String nombrePiloto = piloto.getNombre();
        final String apellidoPiloto = piloto.getApellido();
        final String paisPiloto = piloto.getPais();

        holder.nombre.setText(nombrePiloto + " " + apellidoPiloto);
        holder.pais.setText(paisPiloto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, DetallePilotoActivity.class);
                intent.putExtra("id", id);
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Devuelve el número de pilotos almacenados
        return listaPilotos.size();
    }

    public class HolderPiloto extends RecyclerView.ViewHolder{
        TextView nombre, pais;
        public HolderPiloto(@NonNull View itemView) {
            super(itemView);

            //Inicializamos los elementos de la vista
            nombre = itemView.findViewById(R.id.tv_nombre_piloto);
            pais = itemView.findViewById(R.id.tv_pais_piloto);
        }
    }
}
