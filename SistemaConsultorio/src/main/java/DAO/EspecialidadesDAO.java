package DAO;

import Factory.ConnectionFactory;
import Model.Especialidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadesDAO {

    private Connection connection;

    public  EspecialidadesDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaEspecialidades(){
        String sql = "CREAT TABLE IF NOT EXISTS consultorio.especialdidades (" +
                "id BIGINT PRIMARY KEY," +
                "nome VARCHAR(50)," +
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

    public void cadastrarEspecialidade(Especialidades especialidades){
        String sql = "INSERT INTO consultorio.especialidades (nome) VALUE (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,especialidades.getNome());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Especialidades> especialidadesList(){
        String sql = "SELECT * FROM consultorio.especialidades";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Especialidades> especialidadesList = new ArrayList<>();
            while (resultSet.next()){
                Especialidades especialidades = new Especialidades();
                especialidades.setId(resultSet.getLong("id"));
                especialidades.setNome(resultSet.getString("nome"));
                especialidadesList.add(especialidades);
            }
            return especialidadesList;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Especialidades selectId (Long id){
        String sql = "SELECT * FROM consultorio.especialidades WHERE id = ?";
        Especialidades especialidades = new Especialidades();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                especialidades.setId(resultSet.getLong("id"));
                especialidades.setNome(resultSet.getString("nome"));
            }
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return especialidades;
    }


}
