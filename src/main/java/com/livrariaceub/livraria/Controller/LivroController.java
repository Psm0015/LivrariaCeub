package com.livrariaceub.livraria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livrariaceub.livraria.Entity.Livro;
import com.livrariaceub.livraria.Repository.LivroRepositoryJDBC;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepositoryJDBC livroRepository;

    @Autowired
    public LivroController(LivroRepositoryJDBC livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable int id) {
        return livroRepository.findById(id);
    }

    @PostMapping
    public void addLivro(@RequestBody Livro livro) {
        livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public void updateLivro(@PathVariable int id, @RequestBody Livro livro) {
        livro.setId(id);
        livroRepository.update(livro);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable int id) {
        livroRepository.delete(id);
    }
}
