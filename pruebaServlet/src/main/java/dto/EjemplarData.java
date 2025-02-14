package dto;


public class EjemplarData  {
    private int id;
    private String isbn;
    private String estado;
    public EjemplarData(Ejemplar o) {
        id=o.getId();
        isbn=o.getIsbn().getIsbn();
        estado=o.getEstado();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
