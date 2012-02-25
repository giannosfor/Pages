package GUI;

import API.DatabaseManagement;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class MainForm extends JFrame {

    private JPanel current;
    private JMenuItem disableditem = MAIN;
    private final DatabaseManagement database;

    public MainForm(DatabaseManagement dbase) {
        database = dbase;
        initComponents();
        current = new BrosweModel();
        add(current);
        setResolution();
        setLocationRelativeTo(null);
    }

    private void setResolution() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//        if (screenSize.width > 900 && screenSize.height > 700) {
//            setSize(900, 700);
//        } else {
            setSize(screenSize.width / 2, screenSize.height / 2);
//        }
    }

    private void alteratePanel(JPanel panel) {
        remove(current);
        current = panel;
        add(current);
        invalidate();
        validate();
        //((JComponent)getContentPane()).revalidate();
    }

    private void changeMenuItem(JMenuItem item) {
        disableditem.setEnabled(true);
        disableditem = item;
        disableditem.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Article Manager");

        Menu.setText("Menu");

        MAIN.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        MAIN.setText("Browse");
        MAIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAINActionPerformed(evt);
            }
        });
        Menu.add(MAIN);

        EXIT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        EXIT.setText("Exit");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });
        Menu.add(EXIT);

        MenuBar.add(Menu);

        Menu2.setText("Actions");

        ADD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        Menu2.add(ADD);

        REMOVE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        REMOVE.setText("Remove");
        REMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REMOVEActionPerformed(evt);
            }
        });
        Menu2.add(REMOVE);

        MenuBar.add(Menu2);

        About.setText("About");

        INFO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        INFO.setText("Info");
        INFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INFOActionPerformed(evt);
            }
        });
        About.add(INFO);

        MenuBar.add(About);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        alteratePanel(new AddModel());
    }//GEN-LAST:event_ADDActionPerformed

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        System.exit(0);
    }//GEN-LAST:event_EXITActionPerformed

    private void REMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REMOVEActionPerformed
        alteratePanel(new RemoveModel());
    }//GEN-LAST:event_REMOVEActionPerformed

    private void INFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INFOActionPerformed
        JOptionPane.showMessageDialog(this,
                "Development: "
                + "Giannis Christofakis\n"
                + "email: "
                + "giannis_christofakis@hotmail.com\n\n"
                + "This application was built due to\n"
                + "work demand.\n"
                + "The purpose of this application\n"
                + "was to demonstrate my abilities\n"
                + "refered to Java.",
                "About us",
                JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_INFOActionPerformed

    private void MAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAINActionPerformed
        alteratePanel(new BrosweModel());
    }//GEN-LAST:event_MAINActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static final javax.swing.JMenuItem ADD = new javax.swing.JMenuItem();
    private static final javax.swing.JMenu About = new javax.swing.JMenu();
    private static final javax.swing.JMenuItem EXIT = new javax.swing.JMenuItem();
    private static final javax.swing.JMenuItem INFO = new javax.swing.JMenuItem();
    private static final javax.swing.JMenuItem MAIN = new javax.swing.JMenuItem();
    private static final javax.swing.JMenu Menu = new javax.swing.JMenu();
    private static final javax.swing.JMenu Menu2 = new javax.swing.JMenu();
    private static final javax.swing.JMenuBar MenuBar = new javax.swing.JMenuBar();
    private static final javax.swing.JMenuItem REMOVE = new javax.swing.JMenuItem();
    // End of variables declaration//GEN-END:variables

    class BrosweModel extends BroswePanel {

        @Override
        public void setDisabledItem() {
            changeMenuItem(MAIN);
        }

        @Override
        public DatabaseManagement getDatabase() {
            return database;
        }
    }

    class AddModel extends AddPanel {

        @Override
        public void setDisabledItem() {
            changeMenuItem(ADD);
        }

        @Override
        public DatabaseManagement getDatabase() {
            return database;
        }
    }

    class RemoveModel extends RemovePanel {

        @Override
        public void setDisabledItem() {
            changeMenuItem(REMOVE);
        }

        @Override
        public DatabaseManagement getDatabase() {
            return database;
        }
    }
}
