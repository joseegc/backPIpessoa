package com.senac.pessoa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.senac.pessoa.entities.Pessoa;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("SELECT pessoas FROM Pessoa pessoas WHERE pessoas.nome LIKE ?1")
    List<Pessoa> findByNome(String nome);

    @Query("SELECT pessoas FROM Pessoa pessoas WHERE pessoas.ativo=true ORDER BY pessoas.nome")
    List<Pessoa> listarTodosAbertos();

    @Query("SELECT pessoas FROM Pessoa pessoas WHERE pessoas.ativo=false ORDER BY pessoas.nome")
    List<Pessoa> listarTodosFechados();
}
