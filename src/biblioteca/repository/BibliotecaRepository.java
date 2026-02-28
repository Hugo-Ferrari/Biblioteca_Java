package biblioteca.repository;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepository {

    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void salvarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivroPorIndice(int indice) {
        if (indice >= 0 && indice < livros.size()) {
            return livros.get(indice);
        }
        return null;
    }

    public void salvarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public List<Livro> listarLivros() {
        return livros;
    }
}