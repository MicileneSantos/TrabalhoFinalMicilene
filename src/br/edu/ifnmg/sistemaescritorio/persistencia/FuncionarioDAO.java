
package br.edu.ifnmg.sistemaescritorio.persistencia;

import br.edu.ifnmg.sistemaescritorio.entidade.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miih Santos
 */
public class FuncionarioDAO {
    private final String SQL_INSERT = "INSERT INTO FUNCIONARIO (NOME, RG, CPF, SEXO, DATA_NASCIMENTO, ENDERECO, TELEFONE, CARGO,LOGIN,SENHA) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE FUNCIONARIO SET NOME = ?,RG = ?,CPF = ?,SEXO = ?,DATA_NASCIMENTO = ?,ENDERECO = ?,TELEFONE = ?,CARGO = ?, LOGIN = ?,SENHA = ? WHERE ID_FUNCIONARIO = ?";
    private final String SQL_BUSCAR_TODOS = "SELECT * FROM FUNCIONARIO";
    private final String SELECT_LOGIN = "SELECT LOGIN,SENHA FROM FUNCIONARIO WHERE LOGIN = ? AND SENHA=?";
    private final String DELETE = "DELETE FROM FUNCIONARIO WHERE ID_FUNCIONARIO = ?";
    private final String SQL_CPF_EXISTENTE = "SELECT * FROM FUNCIONARIO WHERE CPF = ?";
    private final String SQL_LOGIN_EXISTENTE = "SELECT * FROM FUNCIONARIO WHERE LOGIN = ?";
    
    
    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        conexao = BancoDadosUtil.getConnection();
        comando = conexao.prepareStatement(SQL_INSERT);
        try{
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getRg());
            comando.setString(3, funcionario.getCpf());
            comando.setString(4, funcionario.getSexo());
            java.sql.Date dataSql = new java.sql.Date(funcionario.getData_Nascimento().getTime());
            comando.setDate(5, dataSql);
            comando.setString(6, funcionario.getEndereco());
            comando.setString(7, funcionario.getTelefone());
            comando.setString(8, funcionario.getCargo());
            comando.setString(9, funcionario.getLogin());
            comando.setString(10, funcionario.getSenha());
            
                    
            comando.execute();
            conexao.commit();
        }catch(Exception e){
            if(conexao != null){
                conexao.rollback();
            }
            throw e;
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }    

    public Funcionario editarFuncionario(Funcionario funcionario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(UPDATE);
            
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getRg());
            comando.setString(3, funcionario.getCpf());
            comando.setString(4, funcionario.getSexo());
            java.sql.Date dataSql = new java.sql.Date(funcionario.getData_Nascimento().getTime());
            comando.setDate(5, dataSql);
            comando.setString(6, funcionario.getEndereco());
            comando.setString(7, funcionario.getTelefone());
            comando.setString(8, funcionario.getCargo());
            comando.setString(9, funcionario.getLogin());
            comando.setString(10, funcionario.getSenha());
            comando.setInt(11, funcionario.getId());

            comando.execute();
            conexao.commit();
        }catch(Exception e){
            if(conexao != null){
                conexao.rollback();
            }
            throw e;
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        return funcionario;
        

    }

    public List<Funcionario> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;      
        List<Funcionario> listaFuncionario = new ArrayList<>();      
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement(SQL_BUSCAR_TODOS);
            resultado = comando.executeQuery();
            while(resultado.next()){
               Funcionario funcionario = this.extrairLinhaResultado(resultado);
               listaFuncionario.add(funcionario);
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
            return listaFuncionario;
    }
    
    private Funcionario extrairLinhaResultado(ResultSet resultado) throws SQLException{
        Funcionario funcionario = new Funcionario();        
        funcionario.setId(resultado.getInt(1));
        funcionario.setNome(resultado.getString(2));
        funcionario.setRg(resultado.getString(3));
        funcionario.setCpf(resultado.getString(4));
        funcionario.setSexo(resultado.getString(5));        
        java.sql.Date dataNascimento = resultado.getDate(6);        
        funcionario.setData_Nascimento(new Date(dataNascimento.getTime()));
        funcionario.setEndereco(resultado.getString(7));
        funcionario.setTelefone(resultado.getString(8));
        funcionario.setCargo(resultado.getString(9));
        funcionario.setLogin(resultado.getString(10));
        funcionario.setSenha(resultado.getString(11));
        
        return funcionario;
    }

    public boolean buscarLogin(Funcionario funcionario) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SELECT_LOGIN);

            comando.setString(1, funcionario.getLogin());
            comando.setString(2, funcionario.getSenha());
            resultado = comando.executeQuery();
            
            if (resultado.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void excluirFuncionario(int id) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(DELETE);
            comando.setInt(1, id);

            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public Funcionario ValidarCPF(String cpf) throws SQLException {
        Funcionario funcionario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_CPF_EXISTENTE);
            comando.setString(1, cpf);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                funcionario = new Funcionario();
                
                funcionario.setId(resultado.getInt(1));
                funcionario.setNome(resultado.getString(2));
                funcionario.setRg(resultado.getString(3));
                funcionario.setCpf(resultado.getString(4));
                funcionario.setSexo(resultado.getString(5));        
                java.sql.Date dataNascimento = resultado.getDate(6);        
                funcionario.setData_Nascimento(new Date(dataNascimento.getTime()));
                funcionario.setEndereco(resultado.getString(7));
                funcionario.setTelefone(resultado.getString(8));
                funcionario.setCargo(resultado.getString(9));
                funcionario.setLogin(resultado.getString(10));
                funcionario.setSenha(resultado.getString(11));
                
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return funcionario;
    }

    public Funcionario ValidarLogin(String login) throws SQLException {
        Funcionario funcionario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_LOGIN_EXISTENTE);
            comando.setString(1, login);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                funcionario = new Funcionario();
                
                funcionario.setId(resultado.getInt(1));
                funcionario.setNome(resultado.getString(2));
                funcionario.setRg(resultado.getString(3));
                funcionario.setCpf(resultado.getString(4));
                funcionario.setSexo(resultado.getString(5));        
                java.sql.Date dataNascimento = resultado.getDate(6);        
                funcionario.setData_Nascimento(new Date(dataNascimento.getTime()));
                funcionario.setEndereco(resultado.getString(7));
                funcionario.setTelefone(resultado.getString(8));
                funcionario.setCargo(resultado.getString(9));
                funcionario.setLogin(resultado.getString(10));
                funcionario.setSenha(resultado.getString(11));
                
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return funcionario;
    }
}
    

