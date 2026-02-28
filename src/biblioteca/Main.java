package biblioteca;

import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.repository.BibliotecaRepository;
import biblioteca.service.BibliotecaService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BibliotecaRepository repository = new BibliotecaRepository();
        BibliotecaService service = new BibliotecaService(repository);
        Usuario usuario = new Usuario("Hugo", "12345678900");

        int opcao;

        do {
            System.out.println("\n===== SISTEMA BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Emprestar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    System.out.println("quantos livros desja adicionar?");
                    int quant = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < quant; i++) {
                        System.out.println("\n Livro " + (i + 1)); // o indice começa no 0 por isso adicionamos 1
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();

                        Livro novoLivro = new Livro(titulo, autor);
                        service.adicionarLivro(novoLivro);
                    }

                    System.out.println("Livro cadastrado!");
                    break;

                case 2:
                    service.listarLivros();
                    break;

                case 3:
                    repository.listarLivros();
                    System.out.print("Digite o índice do livro: (começa com 0 :) ) ");
                    int indiceEmprestar = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroEmprestar = repository.buscarLivroPorIndice(indiceEmprestar);

                    if (livroEmprestar != null) {
                        service.emprestarLivro(usuario, indiceEmprestar);
                    } else {
                        System.out.println("biblioteca.biblioteca.model.Livro inválido!");
                    }
                    break;

                case 4:
                    service.listarLivros();
                    System.out.print("Digite o índice do livro: ");
                    int indiceDevolver = scanner.nextInt();
                    scanner.nextLine();

                    service.devolverLivro(indiceDevolver);
                    break;

                case 5:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        scanner.close();
    }
}
