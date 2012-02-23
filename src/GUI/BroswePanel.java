package GUI;

import API.Connector;
import API.DatabaseManagement;
import Beans.Article;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;

public abstract class BroswePanel extends JPanel implements Connector {

    private DatabaseManagement databasemanagement;
    private ArrayList<Article> articles;

    public BroswePanel() {
        databasemanagement = getDatabase();
        articles = databasemanagement.getArticles();

        initComponents();
        MouseListener mouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                int index = theList.locationToIndex(mouseEvent.getPoint());
                textarea.setText(
                        articles.get(index).getStory().toString());
            }
        };
        list.addMouseListener(mouseListener);
        textarea.setEditable(false);
        list.setFont(new Font("sansserif", Font.BOLD, 12));

        setDisabledItem();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitpane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        JScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();

        list.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return articles.size(); }
            public Object getElementAt(int i) { return articles.get(i).getTitle(); }
        });
        jScrollPane1.setViewportView(list);

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list;
    private javax.swing.JSplitPane splitpane;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
