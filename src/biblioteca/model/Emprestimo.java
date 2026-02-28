package biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {

    private Usuario usuario;
    private Livro livro;
    private LocalDate date;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.date = LocalDate.now();
    }

    public void mostrarInfo() {
        System.out.println("biblioteca.biblioteca.model.Livro: " + livro.getTitulo());
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Data: " + date);
    }
}

