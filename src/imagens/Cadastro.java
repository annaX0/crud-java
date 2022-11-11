/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package imagens;

import telas.*;
import classes.Funcionarios;
import conexoes.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author annas
 */
public class Cadastro extends javax.swing.JFrame {
       MySQL conectar = new MySQL();
       Funcionarios novoFuncionario = new Funcionarios();
    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        initComponents();
    }
    
    private void cadastraFuncionario(Funcionarios novoFuncionario){
    this.conectar.conectaBanco();
    
        novoFuncionario.setNome(txtNone.getText());
        novoFuncionario.setCPF(txtCpf.getText());
        novoFuncionario.setTelefone(txtTelefone.getText());
        novoFuncionario.setFuncao((String) txtFuncao.getSelectedItem());
        novoFuncionario.setEndereco(txtEndereco.getText());
        novoFuncionario.setSalario(txtSalario.getText());
        
        
        try{
        this.conectar.insertSQL("INSERT INTO funcionarios("
            + "nome,"
            + "cpf,"
            + "telefone,"
            + "funcao,"
            + "endereco,"
            + "salario" 
            + ") VALUES ("
            + "'" + novoFuncionario.getNome() + "',"            
            + "'" + novoFuncionario.getCPF()+ "',"
            + "'" + novoFuncionario.getTelefone()+ "',"
            + "'" + novoFuncionario.getFuncao()+ "',"
            + "'" + novoFuncionario.getEndereco()+ "',"
            + "'" + novoFuncionario.getSalario()+ "'"
            + ");");
        } catch (Exception e){
            System.err.println("Erro ao cadastrar funcionario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        } finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Cliente cadastro com sucesso");    

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNone = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        txtFuncao = new javax.swing.JComboBox<>();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(755, 544));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Funcionarios");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 40, 270, 25);
        jPanel1.add(txtNone);
        txtNone.setBounds(150, 100, 470, 37);
        jPanel1.add(txtTelefone);
        txtTelefone.setBounds(150, 260, 470, 37);

        jLabel2.setText("Telefone");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 230, 180, 16);

        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 80, 130, 16);

        jLabel4.setText("CPF");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 160, 130, 16);
        jPanel1.add(txtCpf);
        txtCpf.setBounds(150, 180, 470, 37);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mole.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(330, 550, 120, 50);

        jLabel5.setText("Função");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 310, 180, 16);

        jLabel6.setText("Endereço");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 390, 180, 16);
        jPanel1.add(txtEndereco);
        txtEndereco.setBounds(150, 410, 470, 37);

        jLabel7.setText("Salário");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(150, 470, 180, 16);
        jPanel1.add(txtSalario);
        txtSalario.setBounds(150, 490, 470, 37);

        txtFuncao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Porteiro", "Jardineiro", "Faxineira", "Cozinheira" }));
        jPanel1.add(txtFuncao);
        txtFuncao.setBounds(150, 330, 470, 40);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar);
        btnVoltar.setBounds(10, 10, 58, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastraFuncionario(novoFuncionario);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JComboBox<String> txtFuncao;
    private javax.swing.JTextField txtNone;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
