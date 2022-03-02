package Model;

import java.math.BigDecimal;

public class Historico extends  AbstractEntity {
    private Agenda agenda;
    private String observacao;
    private Secretaria secretaria;
    private Paciente paciente;
    private BigDecimal data;
    private StatusAgenda statusAgenda;

    public Historico() {
    }

    public Historico(Agenda agenda, String observacao, Secretaria secretaria, Paciente paciente, BigDecimal data, StatusAgenda statusAgenda) {
        this.agenda = agenda;
        this.observacao = observacao;
        this.secretaria = secretaria;
        this.paciente = paciente;
        this.data = data;
        this.statusAgenda = statusAgenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public BigDecimal getData() {
        return data;
    }

    public void setData(BigDecimal data) {
        this.data = data;
    }

    public StatusAgenda getStatusAgenda() {
        return statusAgenda;
    }

    public void setStatusAgenda(StatusAgenda statusAgenda) {
        this.statusAgenda = statusAgenda;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "agenda=" + agenda +
                ", observacao='" + observacao + '\'' +
                ", secretaria=" + secretaria +
                ", paciente=" + paciente +
                ", data=" + data +
                ", statusAgenda=" + statusAgenda +
                '}';
    }
}
