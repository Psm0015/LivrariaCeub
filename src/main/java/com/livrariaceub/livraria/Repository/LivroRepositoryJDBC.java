package com.livrariaceub.livraria.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.livrariaceub.livraria.Entity.Livro;

@Repository
public class LivroRepositoryJDBC {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LivroRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";
        jdbcTemplate.update(sql,livro.getTitulo(), livro.getAutor());
    }

    public void update(Livro livro) {
        String sql = "UPDATE livros SET titulo = ?, autor = ? WHERE id = ?";
        jdbcTemplate.update(sql, livro.getTitulo(), livro.getAutor(), livro.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Livro findById(int id) {
        String sql = "SELECT * FROM livros WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Livro livro = new Livro();
            livro.setId(rs.getInt("id"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutor(rs.getString("autor"));
            return livro;
        }, id);
    }

    public List<Livro> findAll() {
        String sql = "SELECT * FROM livros";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Livro livro = new Livro();
            livro.setId(rs.getInt("id"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutor(rs.getString("autor"));
            return livro;
        });
    }

}
