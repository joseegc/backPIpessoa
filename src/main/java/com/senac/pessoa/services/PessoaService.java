package com.senac.pessoa.services;

import com.senac.pessoa.entities.Pessoa;
import com.senac.pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa findById(Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    public Pessoa findByNome(String nome) {
        List<Pessoa> pessoas = pessoaRepository.findByNome(nome);

        if (!pessoas.isEmpty()) {
            return pessoas.get(0); // Retorna o primeiro pessoa se existir
        }
        return null; // Retorna null se não houver pessoas com esse nome
    }

    public List<Pessoa> listarTodosAbertos() {
        List<Pessoa> pessoas = pessoaRepository.listarTodosAbertos();
        return pessoas;
    }

    public List<Pessoa> listarTodosFechados() {
        List<Pessoa> pessoas = pessoaRepository.listarTodosFechados();
        return pessoas;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas;
    }

    public Pessoa gravarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletar(Integer id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa update(Integer id, Pessoa pessoa) {
        Pessoa alterado = findById(id);
        if (alterado != null) {
            alterado.setNome(pessoa.getNome());
            alterado.setDataAdmissao(pessoa.getDataAdmissao());
            alterado.setAtivo(pessoa.isAtivo());
            return pessoaRepository.save(alterado);
        }
        return null;
    }

}
