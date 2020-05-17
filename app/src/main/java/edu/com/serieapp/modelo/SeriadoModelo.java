package edu.com.serieapp.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SeriadoModelo  implements Serializable {

    private Long id;
    private String genero;
    private String status;
    private String nome;
    private String comentario;
    private int nota;
    private Date datalacamento;

    public SeriadoModelo() {
    }

    public SeriadoModelo(Long id, String genero, String status, String nome, String comentario, int nota, Date datalacamento) {
        this.id = id;
        this.genero = genero;
        this.status = status;
        this.nome = nome;
        this.comentario = comentario;
        this.nota = nota;
        this.datalacamento = datalacamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Date getDatalacamento() {
        return datalacamento;
    }

    public void setDatalacamento(Date datalacamento) {
        this.datalacamento = datalacamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriadoModelo that = (SeriadoModelo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
