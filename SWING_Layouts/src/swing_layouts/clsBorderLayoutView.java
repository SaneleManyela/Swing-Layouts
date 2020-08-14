/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_layouts;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Sanele
 */
public class clsBorderLayoutView extends JDialog {
    public clsBorderLayoutView() {
        super(null, "BorderLayout", Dialog.ModalityType.APPLICATION_MODAL);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateWindow();
        this.setVisible(true);
    }
    
    private void mCreateWindow() {
        this.setLayout(new BorderLayout(10, 20));
        this.setBackground(Color.LIGHT_GRAY);
        this.add(mCreateLabel("North", 0, 30, Color.WHITE, Color.BLUE), BorderLayout.NORTH);
        this.add(mCreateLabel("South", 0, 40, Color.WHITE, Color.RED), BorderLayout.SOUTH);
        this.add(mCreateLabel("West", 80, 0, Color.BLACK, Color.GREEN), BorderLayout.WEST);
        this.add(mCreateLabel("East", 100, 0, Color.WHITE, Color.MAGENTA), BorderLayout.EAST);
        this.add(mCreateLabel("Center", 0, 0, Color.BLACK, Color.YELLOW));
    }
    
    private JLabel mCreateLabel(String strText, int intWidth, int intHeight, 
            Color clrColorX, Color clrColorY) {
        JLabel lblLabel = new JLabel(strText);
        lblLabel.setHorizontalAlignment(JLabel.CENTER);
        lblLabel.setOpaque(true);
        lblLabel.setBackground(clrColorY);
        lblLabel.setForeground(clrColorX);
        lblLabel.setPreferredSize(new Dimension(intWidth, intHeight));
        return lblLabel;
    }
}
