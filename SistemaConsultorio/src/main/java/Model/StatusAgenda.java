package Model;

public enum StatusAgenda {
    paciente("Paciente"),
        aprovado("Aprovado"), rejeitado("Rejeitado"), cancelado("C"), compareceu("D"), nao_compareceu("E");

    public final String valor;

    private StatusAgenda(String valor){
        this.valor = valor;
    }
}
