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

public class AdapterCircuito  extends RecyclerView.Adapter<AdapterCircuito.HolderCircuito>{

    //Variables
    private Context contexto;
    private ArrayList<Circuito> listaCircuitos;

    //Declaramos un objeto de tipo BD
    ClaseBD clasebd;

    //Constructor
    public AdapterCircuito(Context contexto, ArrayList<Circuito> listaCircuitos) {
        this.contexto = contexto;
        this.listaCircuitos = listaCircuitos;
        clasebd = new ClaseBD(contexto);
    }

    @NonNull
    @Override
    public AdapterCircuito.HolderCircuito onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflamos el layout con el de lista_circuitos
        View view = LayoutInflater.from(contexto).inflate(R.layout.lista_circuitos, parent, false);

        //Devolvemos el HolderCircuito con todas las vistas de lista_circuito inicializadas, es donde pondremos los datos de los circuitos
        return new HolderCircuito(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCircuito.HolderCircuito holder, int position) {
        //Con este método obtenemos datos, los establecemos y vemos los clicks

        //Primero obtenemos los datos de cada circuito por la posición
        Circuito circuito = listaCircuitos.get(position);
        final String id = circuito.getId();

        final String nombreGp = circuito.getNombreGp();
        final String fechaGp = circuito.getFechaGp();
        final String paisGp = circuito.getPaisGp();

        holder.nombre.setText(nombreGp);
        holder.fecha.setText(fechaGp);
        holder.pais.setText(paisGp);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, DetalleCircuitoActivity.class);
                intent.putExtra("id", id);
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Devuelve el número de circuitos almacenados
        return listaCircuitos.size();
    }
    public class HolderCircuito extends RecyclerView.ViewHolder {
        TextView nombre, fecha, pais;

        public HolderCircuito(@NonNull View itemView) {
            super(itemView);

            //Inicializamos los elementos de la vista
            nombre = itemView.findViewById(R.id.tv_nombre);
            fecha = itemView.findViewById(R.id.tv_fecha);
            pais = itemView.findViewById(R.id.tv_pais);
        }
    }
}
