package com.example.libreriapancho;

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

    /**
     * Constructor del adaptador.
     * @param listaLibros Lista de libros a gestionar.
     */
    public LibroAdapter(List<Libro> listaLibros) {
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
    // A
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Libro libro = listaLibros.get(holder.getAdapterPosition());
        holder.tvTitulo.setText(libro.getTitulo());
        holder.tvAutor.setText(libro.getAutor());
        holder.tvISBN.setText(libro.getISBN());
        holder.tvDescripcion.setText(libro.getDescripcion());
        holder.tvFavorito.setText(libro.isFavorito()); // Corrige el problema de tipo boolean

        // Configura el botón de eliminar
        holder.btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaLibros.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition()); // Notifica la eliminación
                notifyItemRangeChanged(holder.getAdapterPosition(), listaLibros.size()); // Ajusta las posiciones restantes
            }
        });

        // Configura el botón de modificar
        holder.btModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.btModificar.getText().toString().equals("Modificar")) {
                    // Habilita los campos para su edición
                    holder.tvTitulo.setEnabled(true);
                    holder.tvAutor.setEnabled(true);
                    holder.tvISBN.setEnabled(true);
                    holder.tvDescripcion.setEnabled(true);
                    holder.tvFavorito.setEnabled(true);
                    holder.btModificar.setText("Guardar");
                } else {
                    // Deshabilita los campos y vuelve al estado original
                    holder.tvTitulo.setEnabled(false);
                    holder.tvAutor.setEnabled(false);
                    holder.tvISBN.setEnabled(false);
                    holder.tvDescripcion.setEnabled(false);
                    holder.tvFavorito.setEnabled(false);
                    holder.btModificar.setText("Modificar");
                }
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
        TextView tvTitulo, tvAutor, tvISBN, tvFavorito, tvDescripcion, btEliminar, btModificar;

        /**
         * Constructor del ViewHolder.
         * @param itemView Vista del elemento de la lista.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvAutor = itemView.findViewById(R.id.tvAutor);
            tvISBN = itemView.findViewById(R.id.tvISBN);
            tvFavorito = itemView.findViewById(R.id.tvFavorito);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            btEliminar = itemView.findViewById(R.id.btEliminar);
            btModificar = itemView.findViewById(R.id.btModificar);
        }
    }
}
