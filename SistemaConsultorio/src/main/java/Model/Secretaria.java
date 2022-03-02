package Model;

import java.math.BigDecimal;

public class Secretaria extends Pessoa {

    private BigDecimal salario;
    private BigDecimal dataContratacao;
    private String pis;

    public Secretaria() {
    }

    public Secretaria(BigDecimal salario, BigDecimal dataContratacao, String pis) {
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.pis = pis;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(BigDecimal dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", pis='" + pis + '\'' +
                '}';
    }
}

