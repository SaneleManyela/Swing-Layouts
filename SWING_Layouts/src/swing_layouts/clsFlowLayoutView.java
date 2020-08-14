/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_layouts;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Sanele
 */
public class clsFlowLayoutView extends JDialog {
    public clsFlowLayoutView() {
        super(null, "FlowLayout", Dialog.ModalityType.APPLICATION_MODAL);
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        mCreateWindow();
        this.setVisible(true);
    }
    
    private void mCreateWindow() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        for(char c = 'A'; c <= 'z'; c++) {
            this.add(mCreateButton("" + c, 50, 30));
        }
    }
    
    private JButton mCreateButton(String strText, int intWidth, int intHeight) {
        JButton btn = new JButton(strText);
        btn.setPreferredSize(new Dimension(intWidth, intHeight));
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(clsFlowLayoutView.this, 
                        "You have clicked " + strText);
            }
        });
        return btn;
    }
}
