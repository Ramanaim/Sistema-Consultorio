package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {
     private Connection connection;

     public MedicoDAO() throws SQLException {
          this.connection = new ConnectionFactory().getConnection();
     }

     public void criarTabelaMedico(){
          String sql = "CREAT TABLE IF NOT EXISTS consultorio.medico (" +
                  "id BIGINT PRIMARY KEY," +
                  "crm VARCHAR(50)," +
                  "porcenParticipacao DECIMAL(30,30)," +
                  "consultorio VARCHAR(50)." +
                  "idEspecialidades INT NOT NULL," +
                    "CONSTRAINT fk_idEspecialidades FOREIGN KEY (idEspecialidades)" +
                    "REFERENCES consultorio.especialidades(id)" +
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
