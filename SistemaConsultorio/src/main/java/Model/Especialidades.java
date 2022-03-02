package Model;

public class Especialidades extends AbstractEntity {

    private String nome;

    public Especialidades() {
    }

    public Especialidades(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Especialidades{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
