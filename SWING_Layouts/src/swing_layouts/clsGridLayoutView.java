/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_layouts;

import java.util.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Sanele
 */
public class clsGridLayoutView extends JDialog {
    private static Random rndNumber = new Random();
    
    public clsGridLayoutView() {
        super(null, "GridLayout", Dialog.ModalityType.MODELESS);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateWindow();
        this.setVisible(true);
    }
    
    private void mCreateWindow() {
        this.setLayout(new GridLayout(10, 20));
        for(int r = 0; r < 10; r++) {
            for(int c = 0; c < 20; c++) {
                this.add(mCreateLabel());
            }
        }
    }
    
    private JLabel mCreateLabel() {
        JLabel lblLabel = new JLabel();
        lblLabel.setOpaque(true);
        lblLabel.setBackground(new Color(rndNumber.nextInt(256), rndNumber.nextInt(256),
        rndNumber.nextInt(256)));
        return lblLabel;
    }
}
