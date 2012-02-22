package GUI;

import API.DatabaseManagement;
import Beans.DatabaseBean;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginPanel extends javax.swing.JPanel {

    private String username, password, server = "localhost";
    private JFrame frame;

    public LoginPanel(JFrame fr) {
        frame = fr;
        initComponents();
        serverfield.setEnabled(false);
        serverlabel.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginbutton = new javax.swing.JButton();
        usernamefield = new javax.swing.JTextField();
        localcheck = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        serverfield = new javax.swing.JTextField();
        serverlabel = new javax.swing.JLabel();
        passwordfield = new javax.swing.JPasswordField();

        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        localcheck.setSelected(true);
        localcheck.setText("localhost");
        localcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localcheckActionPerformed(evt);
            }
        });

        jLabel2.setText("password");

        jLabel3.setText("username");

        serverfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverfieldActionPerformed(evt);
            }
        });

        serverlabel.setText("Server");

        passwordfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordfieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverlabel)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordfield, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverfield, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(localcheck, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernamefield, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(loginbutton)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(localcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(serverlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginbutton)
                    .addComponent(serverfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void serverfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverfieldActionPerformed
    }//GEN-LAST:event_serverfieldActionPerformed

    private void localcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localcheckActionPerformed
        if (localcheck.isSelected()) {
            serverfield.setEnabled(false);
            serverlabel.setEnabled(false);
        } else {
            serverfield.setEnabled(true);
            serverlabel.setEnabled(true);
        }
    }//GEN-LAST:event_localcheckActionPerformed

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        try {
            if (usernamefield.getText().isEmpty() || passwordfield.getText().isEmpty()) {
                throw new InputMismatchException();
            } else {

                DatabaseBean databasebean = new DatabaseBean(usernamefield.getText(), passwordfield.getText());
                DatabaseManagement databaseManagement = new DatabaseManagement(databasebean);

                MainForm main = new MainForm("Article Manger", databaseManagement);
                BroswePanel broswepanel = new BroswePanel(main);
                //broswepanel.setItemDisabled(main);
                main.addPanel(broswepanel);
                main.setVisible(true);

                frame.dispose();
            }

        } catch (InputMismatchException inex) {
            usernamefield.setText(null);
            passwordfield.setText(null);

            JOptionPane.showMessageDialog(this,
                    "You must fill in the fields.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            usernamefield.setText(null);
            passwordfield.setText(null);

            JOptionPane.showMessageDialog(this,
                    "There is being an error on the database.\n"
                    + "Possible username\\password mismatch.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException clex) {
            JOptionPane.showMessageDialog(this,
                    "Drivers Problem",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void passwordfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordfieldKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            loginbuttonActionPerformed(null);
        }
    }//GEN-LAST:event_passwordfieldKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox localcheck;
    private javax.swing.JButton loginbutton;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JTextField serverfield;
    private javax.swing.JLabel serverlabel;
    private javax.swing.JTextField usernamefield;
    // End of variables declaration//GEN-END:variables
}
