package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {

    private Connection connection;

    public PacienteDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void CriarTabelaPaciente(){
        String sql = "CREAT TABLE IF NOT EXISTS consultorio.paciente (" +
                "id BIGINT PRIMARY KEY," +
                "idTipoAtendimento BIGINT," +
                "numeroCartaoConvenio BIGINT," +
                "dataVencimento TIMESTAMP," +
                "idConvenio INT NOT NULL," +
                    "CONSTRAINT fk_idConvenio FOREIGN KEY (idConvenio)" +
                    "REFERENCES cosultorio.convenio (id)" +
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
