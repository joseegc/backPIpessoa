package com.senac.pessoa.services;

import com.senac.pessoa.entities.Pessoa;
import com.senac.pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Bean
    public void instanciarDB() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Pessoa pessoa1 = new Pessoa("Jose Camargo", formato.parse("08/05/2018"), true);

        Pessoa pessoa2 = new Pessoa("Edson Correia", formato.parse("22/08/2016"), false);

        Pessoa pessoa3 = new Pessoa("Gustavo Batista", formato.parse("16/04/2024"), false);

        Pessoa pessoa4 = new Pessoa("Samuel Xavier", formato.parse("12/03/2024"), true);

        pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4));
    }
}


