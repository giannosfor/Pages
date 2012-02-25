package GUI;

import API.Connector;
import API.DatabaseManagement;
import Beans.Article;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;

public abstract class RemovePanel extends JPanel implements Connector {

    private DatabaseManagement databasemanagement;
    private ArrayList<Article> articles;

    public RemovePanel() {
        setDisabledItem();
        databasemanagement = getDatabase();
        articles = databasemanagement.getArticles();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList(new ListModel());
        deletebutton = new javax.swing.JButton();

        jScrollPane1.setViewportView(list);

        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deletebutton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        int num = list.getSelectedIndex();
        if (num != -1) {
            try {
                databasemanagement.deleteArticle(articles.get(num));
                ListModel model = (ListModel) list.getModel();
                model.removeElementAt(num);
            } catch (SQLException ex) {
                Logger.getLogger(RemovePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deletebuttonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deletebutton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list;
    // End of variables declaration//GEN-END:variables

    class ListModel extends AbstractListModel {

        @Override
        public int getSize() {
            return articles.size();
        }

        @Override
        public Object getElementAt(int i) {
            return articles.get(i).getTitle();
        }

        public void removeElementAt(int i) {
            articles.remove(i);
            fireIntervalRemoved(this, 0, articles.size());
        }
    }
}
