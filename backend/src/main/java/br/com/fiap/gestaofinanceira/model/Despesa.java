package br.com.fiap.gestaofinanceira.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_DESPESA")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DESPESA")
    @SequenceGenerator(name = "SEQ_DESPESA", sequenceName = "SEQ_DESPESA", allocationSize = 1)
    @Column(name ="ID_DESPESA")
    private Long id;

    private String descricao;
    private Double valor;

    private String categoria;

    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dataPagamento = LocalDate.now();

    private char pago;


    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false) // cria a coluna no banco
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public char getPago() {
        return pago;
    }

    public void setPago(char pago) {
        this.pago = pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
