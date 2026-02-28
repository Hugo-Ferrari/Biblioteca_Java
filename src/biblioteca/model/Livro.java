package biblioteca.model;

public class Livro {

    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "\nTítulo: " + titulo +
                "\n | Autor: " + autor +
                "\n | Disponível: " + (disponivel ? "Sim" : "Não") +
                "\n==========================";

    }
}



