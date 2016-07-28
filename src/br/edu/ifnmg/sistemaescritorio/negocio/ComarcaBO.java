/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.negocio;

import br.edu.ifnmg.sistemaescritorio.entidade.Comarca;
import br.edu.ifnmg.sistemaescritorio.persistencia.ComarcaDAO;

/**
 *
 * @author Miih Santos
 */
public class ComarcaBO {

    public void cadastrar(Comarca comarca) {
        ComarcaDAO comarcaDAO = new ComarcaDAO();
        comarcaDAO.cadastrar(comarca);
    }
    
}
