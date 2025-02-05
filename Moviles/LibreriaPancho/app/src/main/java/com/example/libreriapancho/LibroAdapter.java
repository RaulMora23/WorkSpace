package com.example.libreriapancho;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolder> {
    private List<Libro> listaLibros;

    public LibroAdapter(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.libro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Libro libro = listaLibros.get(position);
        holder.tvTitulo.setText(libro.getTitulo());
        holder.tvAutor.setText(libro.getAutor());
        holder.tvISBN.setText(libro.getISBN());
        holder.tvDescripcion.setText(libro.getDescripcion());
        holder.tvFavorito.setText(libro.isFavorito());
        holder.btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaLibros.remove(position);
                notifyItemRemoved(position); // Notifica al RecyclerView
                notifyItemRangeChanged(position, listaLibros.size());
            }
        });
        holder.btModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.btModificar.getText().toString().equals("Modificar")) {
                    holder.tvTitulo.setEnabled(true);
                    holder.tvAutor.setEnabled(true);
                    holder.tvISBN.setEnabled(true);
                    holder.tvDescripcion.setEnabled(true);
                    holder.tvFavorito.setEnabled(true);
                    holder.btModificar.setText("Guardar");
                }else {
                    //Aqui se podria hacer bien y modificar el libro de la lista pero meh
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

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvAutor, tvISBN, tvFavorito, tvDescripcion, btEliminar, btModificar;

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
