package com.flavio.liter_alura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;
    private String tituloLivro;
    private String idiomaLivro;

    public Livro(){
    }

    public Livro(DadosLivro dadosLivro) {
        this.tituloLivro = dadosLivro.tituloLivro();
        this.idiomaLivro = dadosLivro.idiomaLivro().get(0);
        this.autor = new Autor(dadosLivro.autor().get(0));
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getIdioma() {
        return idiomaLivro;
    }

    public void setIdioma(String idiomalivro) {
        this.idiomaLivro = idiomalivro;
    }

    public Livro(Autor autor, String tituloLivro, String idiomaLivro) {
        this.autor = autor;
        this.tituloLivro = tituloLivro;
        this.idiomaLivro = idiomaLivro;
    }
}
