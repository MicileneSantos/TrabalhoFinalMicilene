/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.persistencia;

import br.edu.ifnmg.sistemaescritorio.entidade.Cliente;
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
public class ClienteDAO {
    
    private final String SQL_INSERT = "INSERT INTO CLIENTE(NOME, RG, TIPO,CPF,CNPJ, SEXO, DATA_NASCIMENTO, ENDERECO, TELEFONE) VALUES(?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE CLIENTE SET NOME = ?,RG = ?,TIPO = ?,CPF = ?,CNPJ = ?,SEXO = ?,DATA_NASCIMENTO = ?,ENDERECO = ?,TELEFONE = ? WHERE ID_CLIENTE = ?";
    private final String DELETE = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
    private final String SQL_BUSCAR_TODOS = "SELECT * FROM CLIENTE";
    private final String SQL_CPF_EXISTENTE = "SELECT * FROM CLIENTE WHERE CPF = ?";
    private static final String NOME = "SELECT * FROM CLIENTE WHERE NOME = ?";
    
    public void cadastrarCliente(Cliente cliente) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        conexao = BancoDadosUtil.getConnection();
        comando = conexao.prepareStatement(SQL_INSERT);
        
        try{
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getRg());
            comando.setString(3, cliente.getTipo());
            comando.setString(4, cliente.getCpf());
            comando.setString(5, cliente.getCnpj());
            comando.setString(6, cliente.getSexo());
            java.sql.Date dataSql = new java.sql.Date(cliente.getData_Nascimento().getTime());
            comando.setDate(7, dataSql);
            comando.setString(8, cliente.getEndereco());
            comando.setString(9, cliente.getTelefone());  
                       
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

    public void editarCliente(Cliente cliente) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(UPDATE);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getRg());
            comando.setString(3, cliente.getTipo());
            comando.setString(4, cliente.getCpf());
            comando.setString(5, cliente.getCnpj());
            comando.setString(6, cliente.getSexo());
            java.sql.Date dataSql = new java.sql.Date(cliente.getData_Nascimento().getTime());
            comando.setDate(7, dataSql);
            comando.setString(8, cliente.getEndereco());
            comando.setString(9, cliente.getTelefone());
            comando.setInt(10, cliente.getId());

            comando.execute();
            conexao.commit();

        } catch (Exception e) {
            if (conexao == null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }
    
    public void excluirCliente(int id) throws SQLException {
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

    public List<Cliente> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;      
        List<Cliente> listaCliente = new ArrayList<>();      
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement(SQL_BUSCAR_TODOS);
            resultado = comando.executeQuery();
            while(resultado.next()){
               Cliente cliente = this.extrairLinhaResultado(resultado);
               listaCliente.add(cliente);
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
            return listaCliente;
    }
    
    private Cliente extrairLinhaResultado(ResultSet resultado) throws SQLException {
        Cliente cliente = new Cliente();        
        cliente.setId(resultado.getInt(1));
        cliente.setNome(resultado.getString(2));
        cliente.setRg(resultado.getString(3));
        cliente.setTipo(resultado.getString(4));
        cliente.setCpf(resultado.getString(5));
        cliente.setCnpj(resultado.getString(6));
        cliente.setSexo(resultado.getString(7));        
        java.sql.Date dataNascimento = resultado.getDate(8);        
        cliente.setData_Nascimento(new Date(dataNascimento.getTime()));
        cliente.setEndereco(resultado.getString(9));
        cliente.setTelefone(resultado.getString(10));
        
        
        return cliente;
    }

    public Cliente ValidarCPF(String cpf) throws SQLException {
        Cliente cliente = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_CPF_EXISTENTE);
            comando.setString(1, cpf);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                cliente = new Cliente();        
                cliente.setId(resultado.getInt(1));
                cliente.setNome(resultado.getString(2));
                cliente.setRg(resultado.getString(3));
                cliente.setCpf(resultado.getString(4));
                cliente.setSexo(resultado.getString(5));        
                java.sql.Date dataNascimento = resultado.getDate(6);        
                cliente.setData_Nascimento(new Date(dataNascimento.getTime()));
                cliente.setEndereco(resultado.getString(7));
                cliente.setTelefone(resultado.getString(8));  
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return cliente;
    }

    public Cliente pesquisarCliente(String nome) throws SQLException {
        Cliente cliente = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(NOME);
            comando.setString(1, nome);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                cliente = new Cliente();
                cliente.setId(resultado.getInt(1));
                cliente.setNome(resultado.getString(2));
                cliente.setRg(resultado.getString(3));
                cliente.setCpf(resultado.getString(4));
                cliente.setSexo(resultado.getString(5));        
                java.sql.Date dataNascimento = resultado.getDate(6);        
                cliente.setData_Nascimento(new Date(dataNascimento.getTime()));
                cliente.setEndereco(resultado.getString(7));
                cliente.setTelefone(resultado.getString(8)); 
            }
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return cliente;
    }
}
