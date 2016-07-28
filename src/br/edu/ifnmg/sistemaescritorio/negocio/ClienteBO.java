/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.negocio;

import br.edu.ifnmg.sistemaescritorio.entidade.Cliente;
import br.edu.ifnmg.sistemaescritorio.excecao.CpfExistenteException;
import br.edu.ifnmg.sistemaescritorio.excecao.PesquisaNaoEncontradaException;
import br.edu.ifnmg.sistemaescritorio.persistencia.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Miih Santos
 */
public class ClienteBO {

    public void cadastrarCliente(Cliente cliente) throws SQLException{
        ClienteDAO clienteDAO = new ClienteDAO();
        this.ValidarCPF(cliente);
        clienteDAO.cadastrarCliente(cliente);
    }

    public void editarCliente(Cliente cliente) throws SQLException{
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.editarCliente(cliente);
    }

    public void excluirCliente(int id) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.excluirCliente(id);
    }
    
    public List<Cliente> buscarTodos() throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.buscarTodos();
    }

    private void ValidarCPF(Cliente cliente) throws SQLException {
        Cliente cpfExistente = null;
        ClienteDAO clienteDAO = new ClienteDAO();
        cpfExistente = clienteDAO.ValidarCPF(cliente.getCpf());
        if (cpfExistente != null) {
            throw new CpfExistenteException();
        }
    }

    public Cliente pesquisarCliente(Cliente clientePesquisado) throws SQLException {
        Cliente cliente = null;
        ClienteDAO clienteDAO = new ClienteDAO();
        cliente = clienteDAO.pesquisarCliente(clientePesquisado.getNome());
        if(cliente != null){
            return cliente;
        }else{
            throw new PesquisaNaoEncontradaException();
        }
    }
}
