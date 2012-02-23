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
    private JMenuItem disableditem = Main;
    private DatabaseManagement database;

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

        if (screenSize.width > 900 && screenSize.height > 700) {
            setSize(900, 700);
        } else {
            setSize(screenSize.width / 2, screenSize.height / 2);
        }
    }

    private void alteratePanel(JPanel panel) {
        remove(current);
        current = panel;
        add(current);
        invalidate();
        validate();
    }

    protected void changeMenuItem() {
        disableditem.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        About = new javax.swing.JMenu();
        Info = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Article Manager");

        Menu.setText("Menu");

        Main.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        Main.setText("Browse");
        Main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainActionPerformed(evt);
            }
        });
        Menu.add(Main);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        Menu.add(Exit);

        jMenuBar1.add(Menu);

        jMenu2.setText("Actions");

        Add.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jMenu2.add(Add);

        Remove.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        jMenu2.add(Remove);

        jMenuBar1.add(jMenu2);

        About.setText("About");

        Info.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Info.setText("Info");
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });
        About.add(Info);

        jMenuBar1.add(About);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        changeMenuItem();
        alteratePanel(new AddModel());
    }//GEN-LAST:event_AddActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        changeMenuItem();
        alteratePanel(new RemoveModel());
    }//GEN-LAST:event_RemoveActionPerformed

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
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
    }//GEN-LAST:event_InfoActionPerformed

    private void MainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainActionPerformed
        changeMenuItem();
        alteratePanel(new BrosweModel());
    }//GEN-LAST:event_MainActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    protected static final javax.swing.JMenuItem Add = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Info;
    protected static final javax.swing.JMenuItem Main = new javax.swing.JMenuItem();
    private javax.swing.JMenu Menu;
    protected static final javax.swing.JMenuItem Remove = new javax.swing.JMenuItem();
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    class BrosweModel extends BroswePanel {
        @Override
        public void setDisabledItem() {
            disableditem = Main;
            disableditem.setEnabled(false);
        }
        @Override
        public DatabaseManagement getDatabase() {
            return database;
        }
    }

    class AddModel extends AddPanel {
        @Override
        public void setDisabledItem() {
            disableditem = Add;
            disableditem.setEnabled(false);
        }
        @Override
        public DatabaseManagement getDatabase() {
            return database;
        }
    }

    class RemoveModel extends RemovePanel {
        @Override
        public void setDisabledItem() {
            disableditem = Remove;
            disableditem.setEnabled(false);
        }
        @Override
        public DatabaseManagement getDatabase() {
            return database;
        }
    }
}
