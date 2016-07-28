
package br.edu.ifnmg.sistemaescritorio.apresentacao;

import br.edu.ifnmg.sistemaescritorio.entidade.Funcionario;
import br.edu.ifnmg.sistemaescritorio.excecao.CampoObrigatorioException;
import br.edu.ifnmg.sistemaescritorio.excecao.SistemaEscritorioException;
import br.edu.ifnmg.sistemaescritorio.negocio.FuncionarioBO;
import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
public class CadastroFuncionarioForm extends javax.swing.JFrame {
    
    private Funcionario funcionario;
    private boolean funcionarioParaEdicao;
    private ConsultaFuncionarioForm listaFuncionarios;
    
    public CadastroFuncionarioForm() {
        funcionario = new Funcionario();
        initComponents();
    }

    public CadastroFuncionarioForm(Funcionario funcionarioSelecionado, ConsultaFuncionarioForm listaFuncionarios) {    
        funcionario = funcionarioSelecionado;
        initComponents();
        this.inicializarCamposTela();
        funcionarioParaEdicao = true;
    }

    private void inicializarCamposTela() {
        this.txtNome.setText(this.funcionario.getNome()); 
        this.txtCpf.setText(this.funcionario.getCpf());
        this.txtRg.setText(this.funcionario.getRg());
        this.txtTelefone.setText(this.funcionario.getTelefone());
        this.txtEndereco.setText(this.funcionario.getEndereco());
        this.txtLogin.setText(this.funcionario.getLogin());
        this.pwdSenha.setText(this.funcionario.getSenha());
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");        
        this.txtDataNascimento.setText(formatador.format(this.funcionario.getData_Nascimento()));
        
        if(funcionario.getSexo().equals("M")){
            rdoMasculino.setSelected(true);
        }else{
            rdoFeminino.setSelected(true);
        }
        
        if(funcionario.getCargo().equals("Advogado")){
            rdoAdvogado.setSelected(true);
        }else{
            rdoSecretaria.setSelected(true);
        }
    }
    
    private void limparCamposTela() {
        this.txtNome.setText("");
        this.txtRg.setText("");
        this.txtCpf.setText("");
        this.txtDataNascimento.setText("");
        this.txtTelefone.setText("");
        this.txtEndereco.setText("");
        this.txtLogin.setText("");
        this.pwdSenha.setText("");
        
        if (rdoMasculino.isSelected()) {
           rdoMasculino.setSelected(false);
        } else{
           rdoFeminino.setSelected(false);
        }
        
        if (rdoAdvogado.isSelected()) {
           rdoAdvogado.setSelected(false);
        } else{
           rdoSecretaria.setSelected(false);
        }
    }
    
    private void recuperarCamposTela() throws ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (!txtNome.getText().trim().equals("")) {
            funcionario.setNome(txtNome.getText().trim());
        }else {
            throw new CampoObrigatorioException();
        }
        if (!txtRg.getText().trim().equals("")) {
            funcionario.setRg(txtRg.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        if (!txtCpf.getText().trim().equals("")) {
            funcionario.setCpf(txtCpf.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        if (!txtEndereco.getText().trim().equals("")) {
            funcionario.setEndereco(txtEndereco.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        if (!txtTelefone.getText().trim().equals("")) {
            funcionario.setTelefone(txtTelefone.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        if (!txtLogin.getText().trim().equals("")) {
            funcionario.setLogin(txtLogin.getText().trim());
        } else {
            throw new CampoObrigatorioException();
        }
        if (!pwdSenha.getText().trim().equals("")) {
            char[] chars = pwdSenha.getPassword();  
            String senha = String.valueOf(chars);
            
            String senhaCriptografada;
            
            FuncionarioBO funcionarioBO = new FuncionarioBO();
            senhaCriptografada = funcionarioBO.criptografaSenha(senha);
        
            funcionario.setSenha(senhaCriptografada);
        } else {
            throw new CampoObrigatorioException();
        }
        if (rdoMasculino.isSelected()) {
           funcionario.setSexo("M");
        } else if(rdoFeminino.isSelected()){
            funcionario.setSexo("F");
        } else{
            throw new CampoObrigatorioException();
        }
        if (rdoAdvogado.isSelected()) {
           funcionario.setCargo("Advogado");
        } else if(rdoSecretaria.isSelected()){
            funcionario.setCargo("Secretária");
        } else{
            throw new CampoObrigatorioException();
        }
        if (!txtDataNascimento.getText().trim().equals("")) {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatador.parse(txtDataNascimento.getText().trim());
            funcionario.setData_Nascimento(data);
        } else {
            throw new CampoObrigatorioException();
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFuncionario = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblDataNascimento = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        rdoMasculino = new javax.swing.JRadioButton();
        rdoFeminino = new javax.swing.JRadioButton();
        rdoAdvogado = new javax.swing.JRadioButton();
        rdoSecretaria = new javax.swing.JRadioButton();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        pwdSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGEA  - Cadastro de Funcionário");
        setExtendedState(6);

        pnlFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N
        pnlFuncionario.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        lblNome.setText("* Nome:");

        lblRg.setText("* RG:");

        lblCpf.setText("*CPF:");

        lblCargo.setText("*Cargo:");

        lblTelefone.setText("*Telefone:");

        lblSexo.setText("*Sexo:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/diskette.png"))); // NOI18N
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

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/sistemaescritorio/apresentacao/imagens/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblDataNascimento.setText("*Data de Nascimento:");

        lblEndereco.setText("*Endereço:");

        rdoMasculino.setText("Masculino");
        rdoMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMasculinoActionPerformed(evt);
            }
        });

        rdoFeminino.setText("Feminino");
        rdoFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemininoActionPerformed(evt);
            }
        });

        rdoAdvogado.setText("Advogado");
        rdoAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAdvogadoActionPerformed(evt);
            }
        });

        rdoSecretaria.setText("Secretária");
        rdoSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSecretariaActionPerformed(evt);
            }
        });

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        lblLogin.setText("*Login:");

        lblSenha.setText("*Senha:");

        pwdSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSenha)
                .addGap(18, 18, 18)
                .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(lblSenha)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("* Campos de preechimento obrigatório.");

        javax.swing.GroupLayout pnlFuncionarioLayout = new javax.swing.GroupLayout(pnlFuncionario);
        pnlFuncionario.setLayout(pnlFuncionarioLayout);
        pnlFuncionarioLayout.setHorizontalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                            .addComponent(btnPesquisar)
                            .addGap(18, 18, 18)
                            .addComponent(btnSalvar)
                            .addGap(18, 18, 18)
                            .addComponent(btnFechar))
                        .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome))
                            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                .addComponent(lblSexo)
                                .addGap(18, 18, 18)
                                .addComponent(rdoMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoFeminino))
                            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                .addComponent(lblDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataNascimento))
                            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCpf))
                                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRg))))
                            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone))
                            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                                .addComponent(lblCargo)
                                .addGap(18, 18, 18)
                                .addComponent(rdoAdvogado)
                                .addGap(18, 18, 18)
                                .addComponent(rdoSecretaria)))
                        .addComponent(jLabel1)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        pnlFuncionarioLayout.setVerticalGroup(
            pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRg)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMasculino)
                    .addComponent(rdoFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDataNascimento)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(rdoAdvogado)
                    .addComponent(rdoSecretaria))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pnlFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(pnlFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(563, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(funcionarioParaEdicao){
            try {
                this.editarFuncionario();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                this.cadastrarFuncionario();
            } catch (ParseException ex) {
                Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void desabilitarBotao() {
        btnSalvar.setEnabled(false);
    }
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.limparCamposTela();
        this.dispose();
        ConsultaFuncionarioForm consulta;
        try {
            consulta = new ConsultaFuncionarioForm();
            consulta.setVisible(true);
            consulta.toFront();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void rdoMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMasculinoActionPerformed
        if (rdoMasculino.isSelected()){
           rdoFeminino.setSelected(false);
        }
    }//GEN-LAST:event_rdoMasculinoActionPerformed

    private void rdoFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemininoActionPerformed
        if (rdoFeminino.isSelected()){
           rdoMasculino.setSelected(false);
        }
    }//GEN-LAST:event_rdoFemininoActionPerformed

    private void rdoAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAdvogadoActionPerformed
        if(rdoAdvogado.isSelected()){
            rdoSecretaria.setSelected(false);
        }
    }//GEN-LAST:event_rdoAdvogadoActionPerformed

    private void rdoSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSecretariaActionPerformed
         if(rdoSecretaria.isSelected()){
            rdoAdvogado.setSelected(false);
        }
    }//GEN-LAST:event_rdoSecretariaActionPerformed

    private void pwdSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdSenhaActionPerformed
    
    
    private void cadastrarFuncionario() throws ParseException {
        
        try{
            
            this.recuperarCamposTela();
            FuncionarioBO funcionarioBO = new FuncionarioBO();
            funcionarioBO.cadastrarFuncionario(funcionario);
            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!", "Cadastro de Funcionário", JOptionPane.INFORMATION_MESSAGE);
            this.limparCamposTela();
        }catch(Exception e){
        String mensagem = "Funcionário não cadastrado!\n"+ e.getMessage();
        JOptionPane.showMessageDialog(this, mensagem, "Cadastro de Funcionário", JOptionPane.ERROR_MESSAGE);            
        } 
    }

    private void editarFuncionario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            this.recuperarCamposTela();

            FuncionarioBO funcionarioBO = new FuncionarioBO();
            funcionarioBO.editarFuncionario(funcionario);

            JOptionPane.showMessageDialog(this,
                    "Funcionário alterado com sucesso!",
                    "Alteração de dados do funcionário",
                    JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
            listaFuncionarios = new ConsultaFuncionarioForm();
            listaFuncionarios.setVisible(true);
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
            java.util.logging.Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel pnlFuncionario;
    private javax.swing.JPasswordField pwdSenha;
    private javax.swing.JRadioButton rdoAdvogado;
    private javax.swing.JRadioButton rdoFeminino;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JRadioButton rdoSecretaria;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
