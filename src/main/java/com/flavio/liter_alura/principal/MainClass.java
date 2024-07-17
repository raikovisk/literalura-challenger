package com.flavio.liter_alura.principal;

import com.flavio.liter_alura.model.Autor;
import com.flavio.liter_alura.model.DadoResult;
import com.flavio.liter_alura.model.DadosLivro;
import com.flavio.liter_alura.model.Livro;
import com.flavio.liter_alura.repository.LivroRepository;
import com.flavio.liter_alura.service.ApiCall;
import com.flavio.liter_alura.service.ConverterDados;
import com.flavio.liter_alura.view.MenuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


@Component
public class MainClass {



    Scanner scanner = new Scanner(System.in);

    private LivroRepository repository;
    public MainClass(LivroRepository repository) {
        this.repository = repository;
    }

    ConverterDados converter = new ConverterDados();

    private String url = "https://gutendex.com/books/?search=";


    ApiCall api = new ApiCall();

    public void run(MenuView menu) {

        var opcao = -1;
        while (opcao != 0) {
            menu.exibeMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();



            switch (opcao) {
                case 1 :
                    buscarLivro();
                    break;
                case 2 :
                    listarLivros();
                    break;
                case 3 :
                    listarAutores();
                    break;
                case 4 :
                    autoresVivos();
                    break;
                case 5 :
                    listarPorIdioma();
                    break;
                case 0 :
                    System.out.println("Saindo..");
                    break;
                default:
                    System.out.println("Opcão inválida");
            }


        }
    }

    private void buscarLivro() {
        DadoResult dados = livroWeb();
        List<DadosLivro> dadosLivros = new ArrayList<>();
        dadosLivros = dados.dadosLivro();

        if (!dadosLivros.isEmpty()) {
            Livro livro = new Livro(dadosLivros.get(0));

            Autor autor = repository.buscarAutor(livro.getAutor().getAutor());
            if (autor != null) {
                livro.setAutor(null);
                repository.save(livro);
                livro.setAutor(autor);
            }
            livro = repository.save(livro);
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado");
        }
    }


    private DadoResult livroWeb(){
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = scanner.nextLine().replace(" ", "%20");
        var json = api.obterDados(url + nomeLivro);
        DadoResult dados = converter.obterDados(json, DadoResult.class);
        return dados;
    }

    private void listarLivros(){
        List<Livro> livros = repository.findAll();
        livros.forEach(System.out::println);
    }

    private void listarAutores(){
        List<Autor> autores = repository.listarAutores();
        autores.forEach(System.out::println);
    }

    private void autoresVivos(){
        try{
            System.out.println("Digite o ano desejado");
            var ano = scanner.nextInt();

            List<Autor> autores = repository.autoresVivosAno(ano);
            autores.forEach(System.out::println);
        }catch (InputMismatchException e){
            System.out.println("Digite um ano válido, somente números");
            scanner.nextInt();
        }
    }

    private void listarPorIdioma(){
        System.out.println("""
                Escolha um idioma!
                1 - en
                2 - pt
                3 - es
                """);
        var idioma = scanner.nextLine();
        List<Livro> livros = repository.findByIdioma(idioma);
        if (!livros.isEmpty()){
            livros.forEach(System.out::println);
        }else{
            System.out.println("Idioma não cadastrado");
        }
    }



}
