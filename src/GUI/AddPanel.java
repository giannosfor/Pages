package GUI;

import API.Connector;
import API.DatabaseManagement;
import Beans.Article;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class AddPanel extends javax.swing.JPanel implements Connector {

    private final DatabaseManagement databasemanagement;
    private ArrayList<Article> articles;

    public AddPanel() {
        setDisabledItem();
        databasemanagement = getDatabase();
        articles = databasemanagement.getArticles();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        title = new javax.swing.JTextField(10);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        savebutton = new javax.swing.JButton();

        textarea.setColumns(20);
        textarea.setRows(5);
        jScrollPane1.setViewportView(textarea);

        jLabel1.setText("Title");

        jLabel2.setText("Content");

        savebutton.setText("Save");
        savebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(65, 65, 65)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(savebutton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jLabel2)
                        .add(title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .add(24, 24, 24)
                .add(savebutton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void savebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
    }//GEN-LAST:event_saveMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebuttonMouseClicked
        String titletext = title.getText();
        try {
            if (titletext.trim().isEmpty() || textarea.getText().trim().isEmpty()) {
                throw new NoInputException();
            }
            if (titletext.length() > 40) {
                int n = JOptionPane.showConfirmDialog(
                        this,
                        "Your title is to large.\n"
                        + "Do you want constrain to 40 characters? ",
                        null,
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.NO_OPTION) {
                    return;
                }

                titletext = titletext.substring(0, 40);
            }

            Article article = new Article(titletext, textarea.getText());
            databasemanagement.addArticle(article);
            articles.add(article);
            textarea.setText(null);
            title.setText(null);

        } catch (SQLException sqle) {
            Logger.getLogger(AddPanel.class.getName()).log(Level.SEVERE, null, sqle);
            JOptionPane.showMessageDialog(this,
                    sqle.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NoInputException nie) {
            JOptionPane.showMessageDialog(this,
                    "You must fill in the fields.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_savebuttonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton savebutton;
    private javax.swing.JTextArea textarea;
    private javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}

class NoInputException extends Exception {

    public NoInputException() {
        super("No input Exception");
    }
}
