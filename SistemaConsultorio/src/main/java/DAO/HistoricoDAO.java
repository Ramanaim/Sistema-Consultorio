package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoricoDAO {

    private Connection connection;

    public HistoricoDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaHistorico(){
        String sql = "CREAT TABLE IF NOT EXISTS consultorio.historico (" +
                "id BIGINT PRIMARY KEY," +
                "observacao VARCHAR(50)," +
                "data DECIMAL(30,30)," +
                "idStatusAgenda BIGINT" +
                "idAgenda INT NOT NULL," +
                    "CONSTRAINT fk_idAgenda FOREIGN KEY (idAgenda)" +
                    "REFERENCES consultorio.agenda(id)" +
                "idSecretaria INT NOT NULL," +
                    "CONSTRAINT fk_idSecretaria FOREIGN KEY (idSecretaria)" +
                    "REFERENCES consultorio.secretaria(id)" +
                "idPaciente INT NOT NULL," +
                    "CONSTRAINT fk_idPaciente FOREIGN KEY (idPaciente)" +
                    "REFERENCES consultorio.paciente(id)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            System.out.println("Erro em criar a tabela\n");
            throw new RuntimeException(e);
        }
    }
}
