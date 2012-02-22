
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginDialog extends JDialog implements ActionListener {

    public LoginDialog(JFrame parent, String title, JPanel panel) {
        
        super(parent, title, true);
        
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        }
        
        getContentPane().add(panel);
        JPanel buttonPane = new JPanel();
        JButton okbutton = new JButton("OK");
        JButton cancelbutton = new JButton("Cancel");
        
        buttonPane.add(okbutton);
        buttonPane.add(cancelbutton);
        
        okbutton.addActionListener(this);
        cancelbutton.addActionListener(this);
        
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public LoginDialog(JFrame parent, JPanel panel) {
        this(parent, null, panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//            setVisible(false);
//            dispose();
        System.out.println("get actioncommand " + e.getActionCommand());
        System.out.println("get source " + e.getSource());
        
    }
}