package modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1app.R;

import java.util.ArrayList;

import datos.ClaseBD;

public class AdapterSistemaPuntos  extends RecyclerView.Adapter<AdapterSistemaPuntos.HolderPuntos>{
    //Variables
    private Context contexto;
    private ArrayList<SistemaPuntos> listaPuntos;

    //Declaramos un objeto de tipo BD
    ClaseBD clasebd;

    //Constructor
    public AdapterSistemaPuntos(Context contexto, ArrayList<SistemaPuntos> listaPuntos) {
        this.contexto = contexto;
        this.listaPuntos = listaPuntos;
        clasebd = new ClaseBD(contexto);
    }
    @NonNull
    @Override
    public AdapterSistemaPuntos.HolderPuntos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflamos el layout con el de lista_sistema_puntos
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_sistema_puntos, parent, false);

        //Devolvemos el HolderGp con todas las vistas de lista_sistema_puntos inicializadas, es donde pondremos los datos de los puntos
        return new HolderPuntos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSistemaPuntos.HolderPuntos holder, int position) {
        //Con este método obtenemos datos, los establecemos y vemos los clicks

        //Primero obtenemos los datos de cada punto por la posición
        SistemaPuntos puntos = listaPuntos.get(position);
        final String id = puntos.getId();

        final String pos = puntos.getPosicion();
        final String pun = puntos.getPuntosRepartir();

        holder.posicion.setText(pos);
        holder.punto.setText(pun + " puntos");

    }

    @Override
    public int getItemCount() {
        //Devuelve el número de puntos almacenados
        return listaPuntos.size();
    }

    public class HolderPuntos extends RecyclerView.ViewHolder {
        TextView posicion, punto;

        public HolderPuntos(@NonNull View itemView) {
            super(itemView);

            //Inicializamos los elementos de la vista
            posicion = itemView.findViewById(R.id.tv_posicion);
            punto = itemView.findViewById(R.id.tv_puntos);
        }
    }
}
