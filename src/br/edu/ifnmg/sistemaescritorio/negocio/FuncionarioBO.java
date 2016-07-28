
package br.edu.ifnmg.sistemaescritorio.negocio;

import br.edu.ifnmg.sistemaescritorio.entidade.Funcionario;
import br.edu.ifnmg.sistemaescritorio.excecao.CampoObrigatorioException;
import br.edu.ifnmg.sistemaescritorio.excecao.CpfExistenteException;
import br.edu.ifnmg.sistemaescritorio.excecao.LoginExistenteException;
import br.edu.ifnmg.sistemaescritorio.excecao.LoginSenhaInvalidoException;
import br.edu.ifnmg.sistemaescritorio.persistencia.FuncionarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Miih Santos
 */
public class FuncionarioBO {

    public void cadastrarFuncionario(Funcionario funcionario)  throws SQLException{
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        this.ValidarCPF(funcionario);
        this.ValidarLogin(funcionario);
        funcionarioDAO.cadastrarFuncionario(funcionario);
    }

    public void editarFuncionario(Funcionario funcionario) throws SQLException{
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario editarFuncionario = funcionarioDAO.editarFuncionario(funcionario);
    }

    public void excluirFuncionario(int id) throws SQLException{
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.excluirFuncionario(id);
    }
    
    public List<Funcionario> buscarTodos() throws SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.buscarTodos();
    }

    public Funcionario buscarLogin(Funcionario funcionario) throws SQLException {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if (funcionario.getLogin().isEmpty() || funcionario.getSenha().isEmpty()) {
            throw new CampoObrigatorioException();
        }
        if (!funcionarioDAO.buscarLogin(funcionario)) {
            throw new LoginSenhaInvalidoException();
        }
        return funcionario;
    }

    public String criptografaSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = null;
        messageDigest = algoritmo.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaCriptografada = hexString.toString();

        return senhaCriptografada;

    }
 
    private void ValidarCPF(Funcionario funcionario) throws SQLException {
        Funcionario cpfExistente = null;
        FuncionarioDAO usuarioDAO = new FuncionarioDAO();
        cpfExistente = usuarioDAO.ValidarCPF(funcionario.getCpf());
        if (cpfExistente != null) {
            throw new CpfExistenteException();
        }
    }

    private void ValidarLogin(Funcionario funcionario) throws SQLException {
        Funcionario loginExistente = null;
        FuncionarioDAO usuarioDAO = new FuncionarioDAO();
        loginExistente = usuarioDAO.ValidarLogin(funcionario.getLogin());
        if (loginExistente != null) {
            throw new LoginExistenteException();
        }
    }

    public List<Funcionario> pesquisar(String filtro, String palavraPesquisada) {
        return null;

    }

}
    

