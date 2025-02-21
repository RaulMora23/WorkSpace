package com.example.examen2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adaptador para gestionar una lista de libros en un RecyclerView.
 */
public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolder> {
    private List<Libro> listaLibros; // Lista de libros a mostrar

    private Context contexto;

    /**
     * Constructor del adaptador.
     * @param listaLibros Lista de libros a gestionar.
     */
    public LibroAdapter(List<Libro> listaLibros, Context contexto) {
        //Es clave pasarle el contexto como parámetro para poder instanciar el dao
        this.contexto = contexto;
        this.listaLibros = listaLibros;
    }

    /**
     * Infla el diseño de cada elemento de la lista.
     * @param parent El contenedor padre donde se agregará el elemento.
     * @param viewType Tipo de vista (no utilizado en este caso).
     * @return Un nuevo ViewHolder con la vista inflada.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.libro, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Asocia los datos de un libro a la vista en la posición correspondiente.
     * @param holder ViewHolder que contiene las vistas a modificar.
     * @param position Posición del libro en la lista.
     */
    @Override
    //Bindeamos cada elemento de la lista con su vista
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Libro libro = listaLibros.get(holder.getAdapterPosition());
        holder.tvTitulo.setText(libro.getTitulo());
        holder.tvAutor.setText(libro.getAutor());
        holder.tvAno.setText(""+libro.getAnoPublicacion());
        holder.tvGenero.setText(libro.getGenero());

        // Configura el botón de eliminar
        holder.btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Instanciamos dao
                DAOLibros daoLibros = new DAOLibros(contexto);
                //Eliminar de la bbdd
                daoLibros.eliminarLibro(listaLibros.get(holder.getAdapterPosition()).getId());
                //Eliminar de la lista
                listaLibros.remove(holder.getAdapterPosition());
                //Notificar cambios al RV
                notifyItemRemoved(holder.getAdapterPosition()); // Notifica la eliminación
                notifyItemRangeChanged(holder.getAdapterPosition(), listaLibros.size()); // Ajusta las posiciones restantes
            }
        });

    }

    /**
     * Devuelve el número total de elementos en la lista.
     * @return Tamaño de la lista de libros.
     */
    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    /**
     * Clase interna que representa la vista de cada elemento en el RecyclerView.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvAutor, tvAno, tvGenero, btEliminar;

        /**
         * Constructor del ViewHolder.
         * @param itemView Vista del elemento de la lista.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvISBN);
            tvAutor = itemView.findViewById(R.id.tvTitulo);
            tvAno = itemView.findViewById(R.id.tvAutor);
            tvGenero = itemView.findViewById(R.id.tvDescripcion);
            btEliminar = itemView.findViewById(R.id.btEliminar);
        }
    }
}
