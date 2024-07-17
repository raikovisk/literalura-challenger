package com.flavio.liter_alura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Year;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(@JsonAlias("name") String autor,
                         @JsonAlias("birth_year") Integer dataNascimento,
                         @JsonAlias("death_year") Integer dataMorte) {
}
