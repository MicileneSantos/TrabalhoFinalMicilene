/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemaescritorio.excecao;

/**
 *
 * @author Miih Santos
 */
public class PesquisaNaoEncontradaException extends SistemaEscritorioException{
    public PesquisaNaoEncontradaException() {
        super("Cliente não encontrado!");
    }
}
