package DAO;

import Factory.ConnectionFactory;
import Model.Convenio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDAO {

    private Connection connection;

    public ConvenioDAO() throws SQLException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaConvenio(){
        String sql = "CREAT TABLE IF NOT EXSITS consultorio.convenio (" +
                "id BIGINT PRIMARY KEY," +
                "nome VARCHAR(50)," +
                "valor DECIMAL(30,30)," +
                ");";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarConvenio(Convenio convenio){
        String sql = "INSERT INTO consultorio.convenio " +
                "(nome, valor) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, convenio.getNome());
            preparedStatement.setBigDecimal(2, convenio.getValor());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Convenio> convenioList(){
        String sql = "SELECT * FROM consultorio.convenio";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Convenio> convenioList = new ArrayList<>();
            while (resultSet.next()){
                Convenio convenio = new Convenio();
                convenio.setId(resultSet.getLong("id"));
                convenio.setNome(resultSet.getString("nome"));
                convenio.setValor(resultSet.getBigDecimal("valor"));
                convenioList.add(convenio);
            }
            return convenioList;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Convenio selectId (Long id){
        String sql = "SELECT * FROM consultorio.convenio WHERE id = ?";
        Convenio convenio = new Convenio();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                convenio.setId(resultSet.getLong("id"));
                convenio.setNome(resultSet.getString("nome"));
                convenio.setValor(resultSet.getBigDecimal("valor"));
            }
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return convenio;
    }

    public void editarConvenio(Convenio convenio){
        String sql = "UPDATE consultorio.convenio SET atualizado = now(), nome = ?, valor = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, convenio.getNome());
            preparedStatement.setBigDecimal(2,convenio.getValor());
            preparedStatement.setLong(3,convenio.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void excluirConvenio(Long id){
        String sql = "UPDATE consultorio.convenio SET excluido = now() WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
