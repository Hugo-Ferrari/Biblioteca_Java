package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String cpf;
    private List<Livro>livros = new ArrayList<>();

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
}

