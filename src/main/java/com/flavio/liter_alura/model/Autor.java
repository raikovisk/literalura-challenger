package com.flavio.liter_alura.model;


import jakarta.persistence.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String autor;

    private Integer dataNascimento;

    private Integer dataMorte;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    List<Livro> livros = new ArrayList<>();

    public Autor(){
    }

    public Autor(DadosAutor dadosAutor) {
        this.autor = dadosAutor.autor();
        this.dataNascimento = dadosAutor.dataNascimento() != null ? dadosAutor.dataNascimento() : -1;
        this.dataMorte = dadosAutor.dataMorte() != null ? dadosAutor.dataMorte() : -1;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Integer dataMorte) {
        this.dataMorte = dataMorte;
    }

    public Autor(String autor, Integer dataNascimento, Integer dataMorte) {
        this.autor = autor;
        this.dataNascimento = dataNascimento;
        this.dataMorte = dataMorte;
    }
}
