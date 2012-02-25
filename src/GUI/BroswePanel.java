package GUI;

import API.Connector;
import API.DatabaseManagement;
import Beans.Article;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;

public abstract class BroswePanel extends JPanel implements Connector {

    private DatabaseManagement databasemanagement= getDatabase();
    private ArrayList<Article> articles = databasemanagement.getArticles();

    public BroswePanel() {
        initComponents();
        setDisabledItem();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitpane = new javax.swing.JSplitPane();
        listscrollpane = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        textscrollpane = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();

        list.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        list.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return articles.size(); }
            public Object getElementAt(int i) { return articles.get(i).getTitle(); }
        });
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listClicked(evt);
            }
        });
        listscrollpane.setViewportView(list);

        splitpane.setLeftComponent(listscrollpane);

        textarea.setColumns(20);
        textarea.setEditable(false);
        textarea.setRows(5);
        textscrollpane.setViewportView(textarea);

        splitpane.setRightComponent(textscrollpane);

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

    private void listClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listClicked
        JList theList = (JList) evt.getSource();
                int index = theList.locationToIndex(evt.getPoint());
                textarea.setText(
                        articles.get(index).getStory().toString());
    }//GEN-LAST:event_listClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList list;
    private javax.swing.JScrollPane listscrollpane;
    private javax.swing.JSplitPane splitpane;
    private javax.swing.JTextArea textarea;
    private javax.swing.JScrollPane textscrollpane;
    // End of variables declaration//GEN-END:variables
}
