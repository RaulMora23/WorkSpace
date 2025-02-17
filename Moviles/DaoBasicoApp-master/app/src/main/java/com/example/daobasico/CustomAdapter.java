package com.example.daobasico;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolderDatos> {

    ArrayList<LibroDTO> libros;

    public CustomAdapter(ArrayList<LibroDTO> libros) {
        this.libros = libros;
    }

    @NonNull
    @NotNull
    @Override
    public CustomAdapter.ViewHolderDatos onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomAdapter.ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.asignarDatos(libros.get(i));

    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tituloTextView;
        TextView isbnTextView;
        TextView autorTextView;

        public ViewHolderDatos(@NonNull @NotNull View itemView) {
            super(itemView);
            this.tituloTextView = (TextView) itemView.findViewById(R.id.idTitulo);
            this.autorTextView = (TextView) itemView.findViewById(R.id.idAutor);
            this.isbnTextView = (TextView) itemView.findViewById(R.id.idISBN);
        }

        public void asignarDatos(LibroDTO libro) {

            tituloTextView.setText("Titulo: " + libro.getTitulo());
            autorTextView.setText("Autor: " + libro.getAutor());
            isbnTextView.setText("ISBN: " +libro.getIsbn());
        }
    }
}
