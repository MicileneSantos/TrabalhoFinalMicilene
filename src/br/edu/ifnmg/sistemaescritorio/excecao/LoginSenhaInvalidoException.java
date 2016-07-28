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
public class LoginSenhaInvalidoException  extends SistemaEscritorioException{

    public LoginSenhaInvalidoException() {
        super("Login ou Senha Inválidos.");
    }
    
}
