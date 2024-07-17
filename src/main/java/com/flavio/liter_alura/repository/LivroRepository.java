package com.flavio.liter_alura.repository;

import com.flavio.liter_alura.model.Autor;
import com.flavio.liter_alura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro , Long> {

    @Query("SELECT a FROM Livro l JOIN l.autor a WHERE a.autor = :autor")
    Autor buscarAutor(String autor);

    List<Livro> findByIdioma(String idioma);


    @Query("SELECT a FROM Livro l JOIN l.autor a")
    List<Autor> listarAutores();

    @Query ("SELECT a FROM Livro l JOIN l.autor a WHERE a.anoNascimento <= :ano and a.anoFalecimento >= :ano")
    List<Autor> autoresVivosAno(Integer ano);

    Integer countByIdioma(String idioma);
}
