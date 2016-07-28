
package br.edu.ifnmg.sistemaescritorio.apresentacao;

import br.edu.ifnmg.sistemaescritorio.entidade.Cliente;
import br.edu.ifnmg.sistemaescritorio.excecao.CampoObrigatorioException;
import br.edu.ifnmg.sistemaescritorio.excecao.SistemaEscritorioException;
import br.edu.ifnmg.sistemaescritorio.negocio.ClienteBO;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miih Santos
 */
public class CadastroClienteForm extends javax.swing.JFrame {
    
    private Cliente cliente;
    private boolean clienteParaEdicao;
    private ConsultaClienteForm listaClientes;
    
    public CadastroClienteForm() {
        cliente = new Cliente();
        initComponents();
        desabilitarCampos();
    }
    
    public CadastroClienteForm(Cliente clienteSelecionado,ConsultaClienteForm listaClientes) {
        cliente = clienteSelecionado;
        initComponents();
        this.inicializarCamposTela();
        clienteParaEdicao = true;
    }
    
    private void inicializarCamposTela() {
        this.txtNome.setText(this.cliente.getNome());
        this.txtTelefone.setText(this.cliente.getTelefone());
        this.txtRg.setText(this.cliente.getRg());
        this.txtEndereco.setText(this.cliente.getEndereco());
        
        if (cliente.getTipo().equals("F")) {
           rdoPessoaFisica.setSelected(true);
           txtCpf.setText(cliente.getCpf());
        } else if (cliente.getTipo().equals("J")){
           rdoPessoaJuridica.setSelected(true);
           txtCnpj.setText(cliente.getCnpj());
        }
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");        
        this.txtDataNascimento.setText(formatador.format(this.cliente.getData_Nascimento()));
                
        if(cliente.getSexo().equals("M")){
            rdoMasculino.setSelected(true);
        }else if(cliente.getSexo().equals("F")){
            rdoFeminino.setSelected(true);
        }
    }

    private void recuperarCamposTela() throws ParseException {
        if (!txtNome.getText().trim().equals("")) {
            cliente.setNome(txtNome.getText().trim());
        }else {
            throw new CampoObrigatorioException();
        }
        
        if (rdoPessoaFisica.isSelected()) {
           cliente.setTipo("F");
           cliente.setCpf(txtCpf.getText().trim());
           
        } else if (rdoPessoaJuridica.isSelected()){
           cliente.setTipo("J");
           cliente.setCnpj(txtCnpj.getText().trim());
        } else{
           throw new CampoObrigatorioException();
        }
        
        if (!txtRg.getText().trim().equals("")) {
            cliente.setRg(txtRg.getText().trim());
        }else {
            throw new CampoObrigatorioException();
        } 
        
        if (!txtTelefone.getText().trim().equals("")) {
            cliente.setTelefone(txtTelefone.getText().trim());
        }else {
            throw new CampoObrigatorioException();
        }
        
        if (!txtEndereco.getText().trim().equals("")) {
            cliente.setEndereco(txtEndereco.getText().trim());
        }else {
            throw new CampoObrigatorioException();
        }
        
        if (rdoMasculino.isSelected()) {
           cliente.setSexo("M");
        } else if(rdoFeminino.isSelected()){
            cliente.setSexo("F");
        } else{
            throw new CampoObrigatorioException();
        }
        
        if (!txtDataNascimento.getText().trim().equals("")) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatador.parse(txtDataNascimento.getText().trim());
            cliente.setData_Nascimento(data);
        } else {
            throw new CampoObrigatorioException();
        }
    }

    private void limparCamposTela() {
        this.txtNome.setText("");
        this.txtTelefone.setText("");
        this.txtRg.setText("");
        this.txtEndereco.setText("");
        this.txtDataNascimento.setText("");
        
        if (rdoPessoaFisica.isSelected()) {
           rdoPessoaFisica.setSelected(false);
           txtCpf.setText("");
        } else{
           rdoPessoaJuridica.setSelected(false);
           txtCnpj.setText("");
        }
        
        if (rdoMasculino.isSelected()) {
           rdoMasculino.setSelected(false);
        } else{
           rdoFeminino.setSelected(false);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCliente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblTipo = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtRg = new javax.swing.JFormattedTextField();
        rdoPessoaFisica = new javax.swing.JRadioButton();
        rdoPessoaJuridica = new javax.swing.JRadioButton();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        lblCnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        rdoMasculino = new javax.swing.JRadioButton();
        rdoFeminino = new javax.swing.JRadioButton();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGEA - Cadastro de Cliente");
        setExtendedState(6);

        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Clientes"));

        lblNome.setText("Nome: ");

        lblRg.setText("RG:");

        lblDataNascimento.setText("Data Nascimento:");

        lblTelefone.setText("Telefone:");

        lblSexo.setText("Sexo:");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter(" ##/ ##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/delete.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTipo.setText("Tipo Cliente:");

        lblEndereco.setText("Endereço:");

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });

        rdoPessoaFisica.setText("Pessoa Física");
        rdoPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPessoaFisicaActionPerformed(evt);
            }
        });

        rdoPessoaJuridica.setText("Pessoa Jurídica");
        rdoPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPessoaJuridicaActionPerformed(evt);
            }
        });

        lblCpf.setText("CPF:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCnpj.setText("CNPJ:");

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnpjActionPerformed(evt);
            }
        });

        rdoMasculino.setText("Masculino");

        rdoFeminino.setText("Feminino");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNome)
                            .addComponent(lblTipo)
                            .addComponent(lblRg)
                            .addComponent(lblSexo)
                            .addComponent(lblEndereco)
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtEndereco)
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(rdoPessoaFisica)
                                .addGap(18, 18, 18)
                                .addComponent(rdoPessoaJuridica)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                        .addComponent(txtRg))
                                    .addGroup(pnlClienteLayout.createSequentialGroup()
                                        .addComponent(rdoMasculino)
                                        .addGap(38, 38, 38)
                                        .addComponent(rdoFeminino)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataNascimento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCnpj, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCnpj))
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(rdoPessoaFisica)
                    .addComponent(rdoPessoaJuridica))
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlClienteLayout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(lblDataNascimento))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCpf)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCnpj)
                                .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRg)))))
                .addGap(18, 18, 18)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(rdoMasculino)
                    .addComponent(rdoFeminino))
                .addGap(18, 18, 18)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(557, 427));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascimentoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(clienteParaEdicao){
            this.editarCliente();
        }else{
            try {
                try {
                    this.salvarCliente();
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroClienteForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(CadastroClienteForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void rdoPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPessoaFisicaActionPerformed
       if (rdoPessoaFisica.isSelected())
       {
           rdoPessoaJuridica.setSelected(false);
           txtCpf.setEnabled(true);
           txtCnpj.setEnabled(false);
           rdoMasculino.setEnabled(true);
           rdoFeminino.setEnabled(true);
       }
    }//GEN-LAST:event_rdoPessoaFisicaActionPerformed

    private void rdoPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPessoaJuridicaActionPerformed
        if(rdoPessoaJuridica.isSelected())
        {
            rdoPessoaFisica.setSelected(false);
            txtCnpj.setEnabled(true);
            txtCpf.setEnabled(false);
            rdoMasculino.setEnabled(false);
            rdoFeminino.setEnabled(false);
        }
    }//GEN-LAST:event_rdoPessoaJuridicaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.limparCamposTela();
        this.dispose();
        ConsultaClienteForm consulta;
        try {
            consulta = new ConsultaClienteForm();
            consulta.setVisible(true);
            consulta.toFront();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroClienteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCnpjActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClienteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JRadioButton rdoFeminino;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JRadioButton rdoPessoaFisica;
    private javax.swing.JRadioButton rdoPessoaJuridica;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    
    private void desabilitarBotao() {
        btnSalvar.setEnabled(false);    
    }
    
    private void desabilitarCampos() {
        txtCnpj.setEnabled(false);
        txtCpf.setEnabled(false);
    }

    private void editarCliente() {
        try {
            this.recuperarCamposTela();

            ClienteBO clienteBO = new ClienteBO();
            clienteBO.editarCliente(cliente);

            JOptionPane.showMessageDialog(this,
                    "Cliente alterado com sucesso!",
                    "Alteração de dados do cliente",
                    JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
            listaClientes = new ConsultaClienteForm();
            listaClientes.setVisible(true);
        }catch(SistemaEscritorioException e){
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Alteração de dados do cliente",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        catch (ParseException | SQLException | HeadlessException e) {
            System.out.println("Erro ao tentar Alterar! Informe o erro ao administrador.");
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao tentar alterar dados do cliente! \nInforme o erro ao administrador do sistema",
                    "Alteração de dados do cliente",
                    JOptionPane.ERROR_MESSAGE
            );
        } 
    }

    private void salvarCliente() throws ParseException, SQLException{
        try{
            this.recuperarCamposTela();
            ClienteBO clienteBO = new ClienteBO();
            clienteBO.cadastrarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Cadastro de cliente", JOptionPane.INFORMATION_MESSAGE);
            this.limparCamposTela();
        }catch(Exception e){
            String mensagem = "Cliente não cadastrado!\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Cadastro de cliente", JOptionPane.ERROR_MESSAGE);            
        }
    }
}
