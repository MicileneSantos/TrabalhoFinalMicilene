/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.persistencia;

import br.edu.ifnmg.sistemaescritorio.entidade.Comarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Miih Santos
 */
public class ComarcaDAO {
    
    private final String SQL_INSERT = "INSERT INTO CLIENTE(NOME, CIDADE)VALUES(?,?)";

    public void cadastrar(Comarca comarca) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        conexao = BancoDadosUtil.getConnection();
        comando = conexao.prepareStatement(SQL_INSERT);
        
        try{
            comando.setString(1, comarca.getNome());
            comando.setString(2, comarca.getCidade());
                                   
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
    
}
