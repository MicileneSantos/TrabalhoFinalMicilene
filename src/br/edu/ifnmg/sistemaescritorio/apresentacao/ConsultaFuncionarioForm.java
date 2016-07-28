package br.edu.ifnmg.sistemaescritorio.apresentacao;

import br.edu.ifnmg.sistemaescritorio.entidade.Funcionario;
import br.edu.ifnmg.sistemaescritorio.excecao.SistemaEscritorioException;
import br.edu.ifnmg.sistemaescritorio.excecao.ValidarCamposPesquisaException;
import br.edu.ifnmg.sistemaescritorio.negocio.FuncionarioBO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miih Santos
 */
public class ConsultaFuncionarioForm extends javax.swing.JFrame {

    private List<Funcionario> funcionarios;
    private Funcionario funcionario;
    TelaInicialForm telaInicio;
    
    public ConsultaFuncionarioForm() throws SQLException {
        this.prepararTela();
    }


    private void prepararTela() throws SQLException {
        this.initComponents();
        this.carregarTabelaFuncionario();
        telaInicio = new TelaInicialForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFiltro = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        pnlResultado = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGEA - Consulta Funcionário");
        setExtendedState(6);

        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        lblNome.setText("Nome");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/search102.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE))
        );

        pnlResultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/delete16.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblResultado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblResultado);

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/voltar.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResultadoLayout = new javax.swing.GroupLayout(pnlResultado);
        pnlResultado.setLayout(pnlResultadoLayout);
        pnlResultadoLayout.setHorizontalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addGroup(pnlResultadoLayout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlResultadoLayout.setVerticalGroup(
            pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(542, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.pesquisarFuncionario(); 
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        telaInicio.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void excluir() {
       int linhaSelecionada = this.tblResultado.getSelectedRow();
            
        try { 
            Funcionario funcionarioSelecionado = funcionarios.get(linhaSelecionada);
            FuncionarioBO funcionarioBO = new FuncionarioBO();
            
            String mensagem = "Realmente deseja excluir o funcionário "+funcionarioSelecionado.getNome()+"?";
                   
            int opcao = JOptionPane.showConfirmDialog(this,
                            mensagem,
                            "Exclusão de funcionário",
                            JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                funcionarioBO.excluirFuncionario(funcionarioSelecionado.getId());
                this.carregarTabelaFuncionario();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "É necessário selecionar uma linha da tabela para possibilitar a exclusão de funcionário.",
                    "Exclusão de funcionário",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }  

    }

    private void editar() {
        int linhaSelecionada = tblResultado.getSelectedRow();

        try {
            Funcionario funcionarioSelecionado = funcionarios.get(linhaSelecionada);
                        
            String mensagem = "Realmente deseja alterar  os dados do funcionário "+funcionarioSelecionado.getNome()+"?";
            
            this.dispose();
            CadastroFuncionarioForm telaCadastro = new CadastroFuncionarioForm(funcionarioSelecionado,this);
            telaCadastro.setVisible(true);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "É necessário selecionar uma linha da tabela para possibilitar a alteração de funcionários.",
                    "Alteração de dados do funcionário",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }

    void carregarTabelaFuncionario() throws SQLException {
        FuncionarioBO funcionarioBO = new FuncionarioBO();
        this.funcionarios = funcionarioBO.buscarTodos();
        ModeloTabelaFuncionario modeloTabelaFuncionario = new ModeloTabelaFuncionario() {
        };
        tblResultado.setModel(modeloTabelaFuncionario);
    }

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
            java.util.logging.Logger.getLogger(ConsultaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsultaFuncionarioForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JPanel pnlResultado;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void pesquisarFuncionario() {
        try {
            this.validarCamposPesquisa();
            String filtro = this.recuperarFiltro();
            String nomePesquisado = this.recuperarNomePesquisado();

            FuncionarioBO funcionarioBO = new FuncionarioBO();
            this.funcionarios = funcionarioBO.pesquisar(filtro, nomePesquisado);

            //this.carregarTabelaPesquisaUsuario();

        } catch (SistemaEscritorioException e) {
            String mensagem = "Pesquisa não realizada:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de Funcionário", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Pesquisa de Funcionário", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void validarCamposPesquisa() {
        if (txtNome.getText().trim().isEmpty()) {
            throw new ValidarCamposPesquisaException();
        }
    }

    private String recuperarFiltro() {
        return null;
    }

    private String recuperarNomePesquisado() {
        return null;
    }

    private abstract class ModeloTabelaFuncionario extends AbstractTableModel {

        @Override
        public String getColumnName(int coluna) {
            if (coluna == 0) {
                return "ID";
            } else if (coluna == 1) {
                return "Nome";
            } else if (coluna == 2) {
                return "RG";
            } else if (coluna == 3) {
                return "CPF";
            } else if (coluna == 4) {
                return "Sexo";
            } else if (coluna == 5) {
                return "Data de Nascimento";
            } else if (coluna == 6) {
                return "Endereço";
            } else if (coluna == 7) {
                return "Telefone";
            } else if (coluna == 8){
                return "Cargo";
            } else{
                return "Login";
            }
        }

        @Override
        public int getRowCount() {
            return funcionarios.size();
        }

        @Override
        public int getColumnCount() {
            return 10;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Funcionario funcionario = funcionarios.get(rowIndex);
            if (columnIndex == 0) {
                return funcionario.getId();
            } else if (columnIndex == 1) {
                return funcionario.getNome();
            } else if (columnIndex == 2) {
                return funcionario.getRg();
            } else if (columnIndex == 3) {
                return funcionario.getCpf();
            } else if (columnIndex == 4) {
                return funcionario.getSexo();
            } else if (columnIndex == 5) {
                return funcionario.getData_Nascimento();
            } else if (columnIndex == 6) {
                return funcionario.getEndereco();
            } else if (columnIndex == 7) {
                return funcionario.getTelefone();
            }else if (columnIndex == 8) {
                return funcionario.getCargo();
            } else{
                return funcionario.getLogin();
            } 
        }
    }
}



