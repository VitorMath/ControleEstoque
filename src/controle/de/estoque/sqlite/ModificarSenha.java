/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.de.estoque.sqlite;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vitorbrito
 */
public class ModificarSenha extends javax.swing.JFrame {

    /**
     * Creates new form ModificarSenha
     */
    public ModificarSenha() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldUsuarioAtual = new javax.swing.JTextField();
        fieldNovoUsuario = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        fieldConfirmarSenha = new javax.swing.JPasswordField();
        fieldNovaSenha = new javax.swing.JPasswordField();
        fieldSenhaAtual = new javax.swing.JPasswordField();

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuário Atual:");

        jLabel2.setText("Senha Atual:");

        jLabel3.setText("Novo Usuário:");

        jLabel4.setText("Nova Senha:");

        jLabel5.setText("Confirmar Senha: ");

        jLabel6.setText("Alterar Dados do Usuário");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(85, 85, 85)
                            .add(jLabel6)
                            .add(47, 47, 47))
                        .add(layout.createSequentialGroup()
                            .add(16, 16, 16)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(jLabel5)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(fieldConfirmarSenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(layout.createSequentialGroup()
                                    .add(17, 17, 17)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                .add(jLabel2)
                                                .add(jLabel1))
                                            .add(18, 18, 18)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                .add(fieldUsuarioAtual)
                                                .add(fieldSenhaAtual, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                                        .add(layout.createSequentialGroup()
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                .add(jLabel4)
                                                .add(jLabel3))
                                            .add(18, 18, 18)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                .add(fieldNovoUsuario)
                                                .add(fieldNovaSenha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(btnAlterar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnLimpar)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel6)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(fieldUsuarioAtual, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(fieldSenhaAtual, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(fieldNovoUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(fieldNovaSenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(fieldConfirmarSenha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAlterar)
                    .add(btnLimpar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (!(Arrays.equals(fieldNovaSenha.getPassword(), fieldConfirmarSenha.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Confirme corretamente sua nova senha!");
        } else {
            Conexao dbCon = new Conexao();
            String senha = null;

            try {
                senha = dbCon.getSenha(fieldUsuarioAtual.getText());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ModificarSenha.class.getName()).log(Level.SEVERE, null, ex);
            }

            char[] senhaFinal = fieldSenhaAtual.getPassword();
            String testSenha = "[" + String.valueOf(senhaFinal) + "]";

            if (senha.equals(testSenha)) {
                char[] senhaNova = fieldNovaSenha.getPassword();
                String novaSenha = String.valueOf(senhaNova);

                try {
                    dbCon.modificarSenha(fieldNovoUsuario.getText(), novaSenha, fieldUsuarioAtual.getText());
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ModificarSenha.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.dispose();

                senha = null; //Apenas para limpar as variaveis
                testSenha = null;
                senhaFinal = null;

                fieldUsuarioAtual.setText("");
                fieldSenhaAtual.setText("");
                fieldNovoUsuario.setText("");
                fieldNovaSenha.setText("");
                fieldConfirmarSenha.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Digite corretamente os dados atuais do usuário!");
            }
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        fieldUsuarioAtual.setText("");
        fieldSenhaAtual.setText("");
        fieldNovoUsuario.setText("");
        fieldNovaSenha.setText("");
        fieldConfirmarSenha.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarSenha().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JPasswordField fieldConfirmarSenha;
    private javax.swing.JPasswordField fieldNovaSenha;
    private javax.swing.JTextField fieldNovoUsuario;
    private javax.swing.JPasswordField fieldSenhaAtual;
    private javax.swing.JTextField fieldUsuarioAtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
