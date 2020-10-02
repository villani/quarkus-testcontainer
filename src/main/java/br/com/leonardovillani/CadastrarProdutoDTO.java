package br.com.leonardovillani;

import java.math.BigDecimal;

public class CadastrarProdutoDTO {

    private String nome;

    private BigDecimal valor;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
