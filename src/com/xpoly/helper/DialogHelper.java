/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class DialogHelper extends JDialog {

    private static JOptionPane pane;

    private static JDialog createJDialog(JOptionPane p) {
        getComponents(p);
        p.setBackground(new Color(240, 240, 240));
        JDialog jd = p.createDialog("Thư viện XPoly");
        jd.add(p);
        jd.setVisible(true);
        return jd;
    }
   

    public static void alert(Component parent, String message) {
        pane = new JOptionPane(message,
                JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, new ImageIcon("icon\\fpt.png"));
        createJDialog(pane);
    }

    public static boolean confirm(Component parent, String message) {
        String options[] = {"Yes", "Cancel"};
        pane = new JOptionPane(message, JOptionPane.YES_NO_OPTION, JOptionPane.YES_OPTION, new ImageIcon("icon\\fpt.png"), options, options[0]);
        createJDialog(pane);
        if (pane.getValue() != null) {
            String result = (String) pane.getValue();
            return result.equals(options[0]);
        }
        return false;
    }

    private static void getComponents(Container c) {

        Component[] m = c.getComponents();

        for (int i = 0; i < m.length; i++) {

            if (m[i].getClass().getName() == "javax.swing.JPanel") {
                m[i].setBackground(new Color(240, 240, 240));
            }

            if (c.getClass().isInstance(m[i]));
            getComponents((Container) m[i]);
        }
    }   
}
