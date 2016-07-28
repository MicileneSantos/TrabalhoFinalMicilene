/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.negocio;

import br.edu.ifnmg.sistemaescritorio.entidade.Cliente;
import br.edu.ifnmg.sistemaescritorio.entidade.Processo;
import br.edu.ifnmg.sistemaescritorio.persistencia.ProcessoDAO;

/**
 *
 * @author Miih Santos
 */
public class ProcessoBO {

    public void salvar(Processo processo) throws Exception {
        ProcessoDAO processoDAO = new ProcessoDAO();
        processoDAO.salvar(processo);
    }

    public void editar(Processo processo) throws Exception{
        ProcessoDAO processoDAO = new ProcessoDAO();
        processoDAO.editar(processo);
    }

    public void excluirProcesso(int id) throws Exception{
        ProcessoDAO processoDAO = new ProcessoDAO();
        processoDAO.excluir(id);
    }
   
}
