package com.flavio.liter_alura.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadoResult(@JsonAlias("results") List<DadosLivro> dadosLivro) {
}

