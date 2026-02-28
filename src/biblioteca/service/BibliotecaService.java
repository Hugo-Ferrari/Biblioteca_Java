package biblioteca.service;

import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.repository.BibliotecaRepository;

import java.util.List;

public class BibliotecaService {

    private BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    public void adicionarLivro(Livro livro) {
        repository.salvarLivro(livro);
    }

    public void listarLivros() {
        List<Livro> livros = repository.listarLivros();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }


            System.out.println(livros);

    }

    public void emprestarLivro(Usuario usuario, int indice) {

        Livro livro = repository.buscarLivroPorIndice(indice);

        if (livro == null) {
            System.out.println("Livro inválido!");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println(repository.listarLivros());
            System.out.println("Livro já está emprestado!");
            return;
        }

        livro.setDisponivel(false);

        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        repository.salvarEmprestimo(emprestimo);

        System.out.println("Livro emprestado com sucesso!");
    }

    public void devolverLivro(int indice) {

        Livro livro = repository.buscarLivroPorIndice(indice);

        if (livro == null) {
            System.out.println("Livro inválido!");
            return;
        }

        if (livro.isDisponivel()) {
            System.out.println("Esse livro já está disponível!");
            return;
        }

        livro.setDisponivel(true);
        System.out.println("Livro devolvido com sucesso!");
    }
}