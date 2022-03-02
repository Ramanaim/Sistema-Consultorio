package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SecretariaDAO {

    private Connection connection;

    public SecretariaDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaSecretaria(){
        String sql = "CREAT TABLE IF NOT EXISTS consultorio.Secretaria (" +
                "id BIGINT PRIMARY KEY," +
                "salario DECIMAL(30,30)" +
                "dataContratacao DECIMAL(30,30)," +
                "pis VARCHAR(50)," +
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
