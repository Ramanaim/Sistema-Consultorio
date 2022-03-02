package Model;

import java.math.BigDecimal;

public class Convenio extends AbstractEntity {

    private String nome;
    private BigDecimal valor;

    public Convenio() {
    }

    public Convenio(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Convenio{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
