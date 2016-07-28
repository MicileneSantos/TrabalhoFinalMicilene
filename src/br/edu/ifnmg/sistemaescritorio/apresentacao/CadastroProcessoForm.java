
package br.edu.ifnmg.sistemaescritorio.apresentacao;

import br.edu.ifnmg.sistemaescritorio.entidade.Cliente;
import br.edu.ifnmg.sistemaescritorio.entidade.Processo;
import br.edu.ifnmg.sistemaescritorio.excecao.CampoObrigatorioException;
import br.edu.ifnmg.sistemaescritorio.excecao.SistemaEscritorioException;
import br.edu.ifnmg.sistemaescritorio.negocio.ClienteBO;
import br.edu.ifnmg.sistemaescritorio.negocio.ProcessoBO;
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
public class CadastroProcessoForm extends javax.swing.JFrame {
    
    private Processo processo;
    private boolean processoParaEdicao;
    private ConsultaProcessoForm listaProcesso;
    Cliente clientes = new Cliente();
    
    
    public CadastroProcessoForm() throws SQLException {
        initComponents();
        listaProcesso = new ConsultaProcessoForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProcesso = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblDescricao = new javax.swing.JLabel();
        lblSituacao = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        txtNumero = new javax.swing.JTextField();
        lblDataInicio = new javax.swing.JLabel();
        txtDataInicio = new javax.swing.JFormattedTextField();
        lblDataAtualizacao = new javax.swing.JLabel();
        txtDataAtualizacao = new javax.swing.JFormattedTextField();
        rdoCriminal = new javax.swing.JRadioButton();
        rdoTrabalhista = new javax.swing.JRadioButton();
        rdoDivorcio = new javax.swing.JRadioButton();
        rdoPensao = new javax.swing.JRadioButton();
        rdoOutros = new javax.swing.JRadioButton();
        rdoEmAndamento = new javax.swing.JRadioButton();
        rdoPendentes = new javax.swing.JRadioButton();
        rdoFinalizados = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        pnlProcesso.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Processo"));

        lblNumero.setText("Número:");

        lblTipo.setText("Tipo do Processo:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        lblDescricao.setText("Descrição:");

        lblSituacao.setText("Situação:");

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

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        lblDataInicio.setText("Data Início:");

        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblDataAtualizacao.setText("Data de Atualização:");

        try {
            txtDataAtualizacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        rdoCriminal.setText("Criminal");

        rdoTrabalhista.setText("Trabalhista");

        rdoDivorcio.setText("Divórcio");

        rdoPensao.setText("Pensão");

        rdoOutros.setText("Outros");

        rdoEmAndamento.setText("Em andamento");

        rdoPendentes.setText("Pendentes");

        rdoFinalizados.setText("Finalizados");

        jLabel1.setText("Cliente:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProcessoLayout = new javax.swing.GroupLayout(pnlProcesso);
        pnlProcesso.setLayout(pnlProcessoLayout);
        pnlProcessoLayout.setHorizontalGroup(
            pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlProcessoLayout.createSequentialGroup()
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero))
                    .addGroup(pnlProcessoLayout.createSequentialGroup()
                        .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao)
                            .addGroup(pnlProcessoLayout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btnFechar))
                            .addComponent(lblTipo)
                            .addComponent(lblSituacao)
                            .addGroup(pnlProcessoLayout.createSequentialGroup()
                                .addComponent(lblDataInicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDataAtualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataAtualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProcessoLayout.createSequentialGroup()
                                .addComponent(rdoCriminal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoTrabalhista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoDivorcio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoPensao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoOutros))
                            .addGroup(pnlProcessoLayout.createSequentialGroup()
                                .addComponent(rdoEmAndamento)
                                .addGap(31, 31, 31)
                                .addComponent(rdoPendentes)
                                .addGap(31, 31, 31)
                                .addComponent(rdoFinalizados))
                            .addGroup(pnlProcessoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlProcessoLayout.setVerticalGroup(
            pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoCriminal)
                    .addComponent(rdoTrabalhista)
                    .addComponent(rdoDivorcio)
                    .addComponent(rdoPensao)
                    .addComponent(rdoOutros))
                .addGap(25, 25, 25)
                .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataAtualizacao)
                    .addComponent(txtDataAtualizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataInicio))
                .addGap(24, 24, 24)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSituacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoEmAndamento)
                    .addComponent(rdoPendentes)
                    .addComponent(rdoFinalizados))
                .addGap(18, 18, 18)
                .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(pnlProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnFechar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(504, 528));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(processoParaEdicao){
            try {
                this.editar();
            } catch (Exception ex) {
                Logger.getLogger(CadastroProcessoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                this.cadastrar();
            } catch (Exception ex) {
                Logger.getLogger(CadastroProcessoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Cliente clientePesquisado = new Cliente();
            String nome = txtNome.getText().trim();
            clientePesquisado.setNome(nome);
            ClienteBO clienteBO = new ClienteBO();
            try {
                clientes = clienteBO.pesquisarCliente(clientePesquisado);
            } catch (SQLException ex) {
                Logger.getLogger(CadastroProcessoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.recuperarCamposBusca();
        } catch (SistemaEscritorioException e) {
            String mensagem = "Pesquisa não realizada:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de cliente", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProcessoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProcessoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProcessoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProcessoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroProcessoForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroProcessoForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataAtualizacao;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pnlProcesso;
    private javax.swing.JRadioButton rdoCriminal;
    private javax.swing.JRadioButton rdoDivorcio;
    private javax.swing.JRadioButton rdoEmAndamento;
    private javax.swing.JRadioButton rdoFinalizados;
    private javax.swing.JRadioButton rdoOutros;
    private javax.swing.JRadioButton rdoPendentes;
    private javax.swing.JRadioButton rdoPensao;
    private javax.swing.JRadioButton rdoTrabalhista;
    private javax.swing.JFormattedTextField txtDataAtualizacao;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

    private void editar() throws Exception {
        try {
            this.recuperarCamposTela();

            ProcessoBO processoBO = new ProcessoBO();
            processoBO.editar(processo);

            JOptionPane.showMessageDialog(this,
                    "Funcionário alterado com sucesso!",
                    "Alteração de dados do funcionário",
                    JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
            
            listaProcesso.setVisible(true);
        }catch(SistemaEscritorioException e){
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Alteração de dados do funcionário",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        catch (ParseException | SQLException | HeadlessException e) {
            System.out.println("Erro ao tentar Alterar! Informe o erro ao administrador.");
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao tentar alterar dados do funcionário! \nInforme o erro ao administrador do sistema",
                    "Alteração de dados do funcionário",
                    JOptionPane.ERROR_MESSAGE
            );
        }
  
    }

    private void cadastrar() throws Exception {
        
        try {
            this.recuperarCamposTela();
            Processo processos = new Processo();
            processos.setCliente(clientes);
            

            ProcessoBO processoBO = new ProcessoBO();
            processoBO.salvar(processo);
            JOptionPane.showMessageDialog(this, "Processo cadastrado com sucesso!", "cadastro de Processo", JOptionPane.INFORMATION_MESSAGE);
            this.limparCamposTela(); 
        } catch (CampoObrigatorioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void recuperarCamposTela() throws ParseException {
        if (!txtNumero.getText().trim().equals("")) {
            processo.setNumero(txtNumero.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        if (!txtDescricao.getText().trim().equals("")) {
            processo.setDescricao(txtDescricao.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        if (!txtDataInicio.getText().trim().equals("")) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatador.parse(txtDataInicio.getText().trim());
            processo.setData_inicio(data);
        } else {
            throw new CampoObrigatorioException();
        }
        if (!txtDataAtualizacao.getText().trim().equals("")) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatador.parse(txtDataAtualizacao.getText().trim());
            processo.setData_atualizacao(data);
        } 
        
        if (rdoEmAndamento.isSelected()) {
           processo.setStatus("Em Andamento");
        } else if(rdoPendentes.isSelected()){
            processo.setStatus("Pendentes");
        } else if(rdoFinalizados.isSelected()){
            processo.setStatus("Finalizados");
        } else{
            throw new CampoObrigatorioException();
        }
        
        if (rdoCriminal.isSelected()) {
           processo.setTipo_Processo("Criminal");
        } else if(rdoTrabalhista.isSelected()){
            processo.setTipo_Processo("Trabalhista");
        } else if(rdoDivorcio.isSelected()){
            processo.setTipo_Processo("Divórcio");
        } else if(rdoPensao.isSelected()){
            processo.setTipo_Processo("Pensão");
        } else if(rdoOutros.isSelected()){
            processo.setTipo_Processo("Outros");
        } else{
            throw new CampoObrigatorioException();
        }
    }
    
    private void limparCamposTela() {
        this.txtNumero.setText("");
        this.txtDescricao.setText("");
        this.txtDataInicio.setText("");
        this.txtDataAtualizacao.setText("");
        
        if (rdoCriminal.isSelected()) {
           rdoCriminal.setSelected(false);
        }else if (rdoTrabalhista.isSelected()) {
           rdoTrabalhista.setSelected(false);
        }else if (rdoDivorcio.isSelected()) {
           rdoDivorcio.setSelected(false);
        }else if (rdoPensao.isSelected()) {
           rdoPensao.setSelected(false);
        } else{
           rdoOutros.setSelected(false);
        }
        
        if (rdoEmAndamento.isSelected()) {
           rdoEmAndamento.setSelected(false);
        }else if (rdoPendentes.isSelected()) {
           rdoPendentes.setSelected(false);
        } else{
           rdoFinalizados.setSelected(false);
        }
    }

    private void recuperarCamposBusca() {
        if (!txtNome.getText().trim().equals("")) {
            clientes.setNome(txtNome.getText().trim());
        }
    }
}
