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
public class clsNullLayoutView extends JDialog{
    public clsNullLayoutView() {
        super(null, "Null Layout", Dialog.ModalityType.MODELESS);
        this.setSize(340, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateView();
        this.setVisible(true);
    }
    
    private void mCreateView() {
        this.setLayout(null);
        this.mAddComponent(this, new JLabel("Zip Code:"), 20, 20, 100, 20);
        this.mAddComponent(this, new JLabel("Town:"), 20, 60, 100, 20);
        this.mAddComponent(this, new JTextField(), 100, 20, 50, 20);
        this.mAddComponent(this, new JTextField(), 100, 60, 220, 20);
        this.mAddComponent(this, new JButton("Cancel"), 230, 110, 90, 24);
        this.mAddComponent(this, new JButton("Ok"), 120, 110, 90, 24);
    }
            
    private void mAddComponent(Container container, Component component,
            int intLeft, int intTop, int intWidth, int intHeight) {
        component.setBounds(intLeft, intTop, intWidth, intHeight);
        container.add(component);
        
    }
}
