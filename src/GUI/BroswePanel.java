package GUI;

import API.DatabaseManagement;
import Beans.Article;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

public class BroswePanel extends javax.swing.JPanel {

    private DatabaseManagement databasemanagement;
    private Vector<Article> articles;

    public BroswePanel() {
        try {
            databasemanagement = new DatabaseManagement();
            articles = databasemanagement.getArticles();
            initComponents();
            MouseListener mouseListener = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    JList theList = (JList) mouseEvent.getSource();
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    textarea.setText(
                            articles.get(index).getStory().toString()
                            );
                }
            };
            jList1.addMouseListener(mouseListener);
            textarea.setEditable(false);
            jList1.setFont(new Font("sansserif", Font.BOLD, 12));
            //jList1.setForeground(Color.BLUE);
        } catch (SQLException ex) {
            Logger.getLogger(BroswePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitpane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        JScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();

        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return articles.size(); }
            public Object getElementAt(int i) { return articles.get(i).getTitle(); }
        });
        jScrollPane1.setViewportView(jList1);

        splitpane.setLeftComponent(jScrollPane1);

        textarea.setColumns(20);
        textarea.setRows(5);
        JScrollPane1.setViewportView(textarea);

        splitpane.setRightComponent(JScrollPane1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(splitpane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(splitpane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane splitpane;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
