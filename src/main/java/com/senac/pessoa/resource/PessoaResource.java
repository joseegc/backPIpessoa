package com.senac.pessoa.resource;

import com.senac.pessoa.entities.Pessoa;
import com.senac.pessoa.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:58386", "http://localhost:61000", "http://localhost:61357", "http://localhost:61562", "http://localhost:63139", "http://localhost:65032"})
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Pessoa> findByNome(@PathVariable String nome) {
        Pessoa pessoa = pessoaService.findByNome(nome);
        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping(value = "/abertos")
    public ResponseEntity<List<Pessoa>> listarAbertos() {
        List<Pessoa> pessoas = pessoaService.listarTodosAbertos();

        return ResponseEntity.ok().body(pessoas);
    }

    @GetMapping(value = "/fechados")
    public ResponseEntity<List<Pessoa>> listarFechados() {
        List<Pessoa> pessoas = pessoaService.listarTodosFechados();

        return ResponseEntity.ok().body(pessoas);
    }

    // READ
    @GetMapping
    public List<Pessoa> findAll() {
        List<Pessoa> pessoa = pessoaService.findAll();
        return pessoa;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Pessoa> gravarPessoa(@RequestBody Pessoa pessoa) {
        pessoa = pessoaService.gravarPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoa);
    }

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        Pessoa alterado = pessoaService.update(id, pessoa);

        return ResponseEntity.noContent().build();
    }

}
