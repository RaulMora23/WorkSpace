package com.example.libreriapancho;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private boolean favorito;
    private String descripcion;

    public Libro(String ISBN, String titulo, String autor, boolean favorito, String descripcion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.favorito = favorito;
        this.descripcion = descripcion;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String isFavorito() {
        if (favorito){
            return "★";
        }else {
            return "";
        }
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
