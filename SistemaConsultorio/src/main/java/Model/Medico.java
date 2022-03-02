package Model;

import java.math.BigDecimal;

public class Medico extends Pessoa {

    private String CRM;
    private BigDecimal porcenparticipacao;
    private String consultorio;
    private Especialidades especialidades;

    public Medico() {
    }

    public Medico(String CRM, BigDecimal porcenparticipacao, String consultorio, Especialidades especialidades) {
        this.CRM = CRM;
        this.porcenparticipacao = porcenparticipacao;
        this.consultorio = consultorio;
        this.especialidades = especialidades;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public BigDecimal getPorcenparticipacao() {
        return porcenparticipacao;
    }

    public void setPorcenparticipacao(BigDecimal porcenparticipacao) {
        this.porcenparticipacao = porcenparticipacao;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Especialidades getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Especialidades especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "CRM='" + CRM + '\'' +
                ", porcenparticipacao=" + porcenparticipacao +
                ", consultorio='" + consultorio + '\'' +
                ", especialidades=" + especialidades +
                '}';
    }
}
