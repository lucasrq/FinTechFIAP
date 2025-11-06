package br.com.fiap.gestaofinanceira.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_RECEITA")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RECEITA")
    @SequenceGenerator(name = "SEQ_RECEITA", sequenceName = "SEQ_RECEITA", allocationSize = 1)
    @Column(name ="ID_RECEITA")
    private Long id;

    private String descricao;
    private Double valor;

    @Column(name ="DATA_RECEBIMENTO")
    private LocalDate dataRecebimento;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}