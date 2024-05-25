package com.InnGen.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Alocacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto;


    private LocalDateTime allocatedAt;
    public Alocacao(){}

    public Alocacao(Long id, User user, Cliente cliente, Quarto quarto, LocalDateTime allocatedAt) {
        this.id = id;
        this.user = user;
        this.cliente = cliente;
        this.quarto = quarto;
        this.allocatedAt = allocatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDateTime getAllocatedAt() {
        return allocatedAt;
    }

    public void setAllocatedAt(LocalDateTime allocatedAt) {
        this.allocatedAt = allocatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alocacao alocacao = (Alocacao) o;
        return Objects.equals(id, alocacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
