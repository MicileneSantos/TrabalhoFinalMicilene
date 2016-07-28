
package br.edu.ifnmg.sistemaescritorio.excecao;

/**
 *
 * @author Miih Santos
 */
public class CampoObrigatorioException extends SistemaEscritorioException{
    public CampoObrigatorioException() {
        super("Campo obrigatório não preenchido! \nPor favor, preencha todos os campos.");
    }
}
