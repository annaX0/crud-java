/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import classes.Funcionarios;
import conexoes.MySQL;
import javax.swing.JOptionPane;

/**
 *
 * @author annas
 */
public class Pesquisa extends javax.swing.JFrame {
       MySQL conectar = new MySQL();
       Funcionarios novoFuncionario = new Funcionarios();
    /**
     * Creates new form Cadastro
     */
    public Pesquisa() {
        initComponents();
    }
    
    private void pesquisaFuncionario(Funcionarios novoFuncionario){
    this.conectar.conectaBanco();
        
        String pesquisaFuncionario = txtCpf.getText();
        
        try{
        this.conectar.executarSQL("SELECT "
            + "nome,"
            + "cpf,"
            + "funcao,"
            + "telefone,"
            + "endereco,"
            + "salario" 
            + " FROM"
            + " funcionarios"
            + " WHERE"
            + " cpf = '" + pesquisaFuncionario + "'" + ";"
        );
        while (this.conectar.getResultSet().next()){
            novoFuncionario.setNome(this.conectar.getResultSet().getString(1));
            novoFuncionario.setCPF(this.conectar.getResultSet().getString(2));
            novoFuncionario.setFuncao(this.conectar.getResultSet().getString(3));
            novoFuncionario.setTelefone(this.conectar.getResultSet().getString(4));
            novoFuncionario.setEndereco(this.conectar.getResultSet().getString(5));
            novoFuncionario.setSalario(this.conectar.getResultSet().getString(6));

        }
        if (novoFuncionario.getNome() == ""){
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");

        }
        
        } catch (Exception e){
            System.out.println("Erro ao consultar funcionario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário!");
            
        } finally{
            txtNone.setText(novoFuncionario.getNome());
            txtCpf.setText(novoFuncionario.getCPF());
            txtTelefone.setText(novoFuncionario.getTelefone());
            txtFuncao.setText(novoFuncionario.getFuncao());
            txtEndereco.setText(novoFuncionario.getEndereco());
            txtSalario.setText(novoFuncionario.getSalario());

            this.conectar.fechaBanco();
                

        }
    }
    private void DeletaFuncionario(Funcionarios novoFuncionario){
        this.conectar.conectaBanco();
        
        String consultaCPF = this.txtCpf.getText();


        novoFuncionario.setNome(txtNone.getText());
        novoFuncionario.setCPF(txtCpf.getText());
        novoFuncionario.setTelefone(txtTelefone.getText());
        novoFuncionario.setFuncao(txtFuncao.getText());
        novoFuncionario.setEndereco(txtEndereco.getText());
        novoFuncionario.setSalario(txtSalario.getText());
        
        try{
            this.conectar.updateSQL(
            " DELETE FROM funcionarios"
            + " WHERE"
            + " cpf = '" + consultaCPF + "'"
            );
        }catch(Exception e){
            System.out.println("Erro ao deletar funcionário" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar funcionário");
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Funcionário deletado!");
        }
    }
    
    private void atualizaFuncionario(Funcionarios novoFuncionario){
        this.conectar.conectaBanco();

        String consultaCpf = this.txtCpf.getText();
        
        novoFuncionario.setNome(txtNone.getText());
        novoFuncionario.setCPF(txtCpf.getText());
        novoFuncionario.setTelefone(txtTelefone.getText());
        novoFuncionario.setFuncao(txtFuncao.getText());
        novoFuncionario.setEndereco(txtEndereco.getText());
        novoFuncionario.setSalario(txtSalario.getText());
        
        try{
            this.conectar.updateSQL(
            " UPDATE funcionarios SET "
            + " nome = '" + novoFuncionario.getNome()+"'"
            + ", telefone = '" + novoFuncionario.getTelefone()+"'"
            + ", funcao = '" + novoFuncionario.getFuncao()+"'"
            + ", endereco = '" + novoFuncionario.getEndereco()+"'"
            + ", salario = '" + novoFuncionario.getSalario()+"'"
            + " WHERE"
            + " cpf = '"+ consultaCpf + "'" + ";"
            );
        }catch(Exception e){
            System.out.println("Erro ao atualizar funcionário" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário");
            
        }finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Funcionário atualizado!");
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
        txtFuncao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        btnDeletar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(755, 544));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pesquisa de Funcionarios");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 40, 270, 25);
        jPanel1.add(txtNone);
        txtNone.setBounds(150, 100, 470, 37);
        jPanel1.add(txtFuncao);
        txtFuncao.setBounds(150, 340, 470, 37);

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

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeletar);
        btnDeletar.setBounds(150, 550, 120, 50);

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
        jPanel1.add(txtTelefone);
        txtTelefone.setBounds(150, 260, 470, 37);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/binoculars.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisar);
        btnPesquisar.setBounds(330, 550, 120, 50);

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/updated.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar);
        btnAtualizar.setBounds(500, 550, 120, 50);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 58, 40);

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

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        DeletaFuncionario(novoFuncionario);
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisaFuncionario(novoFuncionario);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizaFuncionario(novoFuncionario);
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPesquisar;
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
    private javax.swing.JTextField txtFuncao;
    private javax.swing.JTextField txtNone;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
