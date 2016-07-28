/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.persistencia;

import br.edu.ifnmg.sistemaescritorio.entidade.Processo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miih Santos
 */
public class ProcessoDAO {
    
    private final String SQL_INSERT = "INSERT INTO PROCESSO (NUMERO, TIPO_PROCESSO, DESCRICAO, STATUS, DATA_INICIO, DATA_ATUALIZACAO,ID_CLIENTE) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE PROCESSO SET NUMERO = ?, TIPO_PROCESSO = ?, DESCRICAO = ?, STATUS = ?,DATA_INICIO = ?,DATA_ATUALIZACAO = ? WHERE ID = ?";
    private final String DELETE = "DELETE FROM PROCESSO WHERE ID_PROCESSO = ?";
    
    public void salvar(Processo processo) throws Exception {
        Connection conexao = null;
        PreparedStatement comando = null;
        conexao = BancoDadosUtil.getConnection();
        comando = conexao.prepareStatement(SQL_INSERT);
        try{
            comando.setString(1, processo.getNumero());
            comando.setString(2, processo.getTipo_Processo());
            comando.setString(3, processo.getDescricao());
            comando.setString(4, processo.getStatus());
            java.sql.Date dataSql = new java.sql.Date(processo.getData_Inicio().getTime());
            comando.setDate(5, dataSql);
            java.sql.Date data = new java.sql.Date(processo.getData_Atualizacao().getTime());
            comando.setDate(6, dataSql);    
            comando.setInt(1,processo.getCliente().getId());
                           
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

    public Processo editar(Processo processo) throws Exception {
        Connection conexao = null;
        PreparedStatement comando = null;
        

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(UPDATE);
            
            comando.setString(1, processo.getNumero());
            comando.setString(2, processo.getTipo_Processo());
            comando.setString(3, processo.getDescricao());
            comando.setString(4, processo.getStatus());
            java.sql.Date dataSql = new java.sql.Date(processo.getData_Inicio().getTime());
            comando.setDate(5, dataSql);
            java.sql.Date data = new java.sql.Date(processo.getData_Atualizacao().getTime());
            comando.setDate(6, dataSql);
            comando.setInt(7, processo.getId());

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
        return processo;
    }

    public void excluir(int id) throws SQLException {
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
    
    public List<Processo> buscarTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;      
        List<Processo> listaCliente = new ArrayList<>();      
        try{
            conexao = BancoDadosUtil.getConnection();
            
            //comando = conexao.prepareStatement(SQL_BUSCAR_TODOS);
            resultado = comando.executeQuery();
            while(resultado.next()){
               Processo processo = this.extrairLinhaResultado(resultado);
               //listaProcesso.add(processo);
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
            //return listaProcesso;
        return null;
    }
    
    private Processo extrairLinhaResultado(ResultSet resultado) throws SQLException {
        Processo processo = new Processo();        
        processo.setId(resultado.getInt(1));
        /*processo.setNome(resultado.getString(2));
        processo.setRg(resultado.getString(3));
        processo.setTipo(resultado.getString(4));
        processo.setCpf(resultado.getString(5));
        processo.setCnpj(resultado.getString(6));
        processo.setSexo(resultado.getString(7));        
        java.sql.Date dataNascimento = resultado.getDate(8);        
        processo.setData_Nascimento(new Date(dataNascimento.getTime()));
        processo.setEndereco(resultado.getString(9));
        processo.setTelefone(resultado.getString(10));*/
        
        
        return processo;
    }
    
}
