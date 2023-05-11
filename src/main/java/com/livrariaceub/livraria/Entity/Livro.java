package com.livrariaceub.livraria.Entity;

/**
 * Classe que representa um Livro
 * @author Pedro Mota
 *
 */

public class Livro {

    private int id;
    private String titulo;
    private String autor;

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
