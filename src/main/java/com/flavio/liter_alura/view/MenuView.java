package com.flavio.liter_alura.view;


import org.springframework.stereotype.Service;

@Service
public class MenuView {

    public void exibeMenu(){
        String menu = """
                ************************************************************
                *                                                          *
                *                    API GUTENDEX E JPA                    *
                * -------------------------------------------------------- *
                *                1 - Buscar livro                          *
                *                2 - Livros registrados                    *
                *                3 - Listar autores                        *
                *          4 - Listar autores vivos em determinado ano     *
                *          5 - Lista de livros por idioma                  *
                *     6 - Quantidade de livros em determinado idioma       *
                *                0 - Sair                                  *
                *                                                          *
                ************************************************************
                """;

        System.out.println(menu);
    }
}
