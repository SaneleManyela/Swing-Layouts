/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sanele
 */
public class clsBoxLayoutView extends JFrame{
    public clsBoxLayoutView() {
        this.setTitle("BoxLayout");
        this.setSize(300, 330);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateWindow();
        this.setVisible(true);
    }
    
    private void mCreateWindow() {
        this.setLayout(new BorderLayout());
        JPanel jpPanel = new JPanel();
        jpPanel.setLayout(new BoxLayout(jpPanel, BoxLayout.Y_AXIS));
        jpPanel.add(mCreateButton("Example 1", 150, 25, this::mOpenBoxLayoutExample1));
        jpPanel.add(mCreateButton("Example 2", 150, 25, this::mOpenBoxLayoutExample2));
        jpPanel.add(mCreateButton("My Example", 150, 25, this::mOpenBoxLayoutMyExample));
        this.add(jpPanel);
    }
    
    private JButton mCreateButton(String strText, int intWidth, int intHeight,
            ActionListener listener) {
        JButton btn = new JButton(strText);
        btn.setPreferredSize(new Dimension(intWidth, intHeight));
        btn.setMinimumSize(new Dimension(intWidth, intHeight));
        btn.setMaximumSize(new Dimension(intWidth, intHeight));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(listener);
        return btn;
    }
    
    private void mOpenBoxLayoutExample1(ActionEvent e) {
        clsBoxLayoutExample1 clsBoxLayout1 = new clsBoxLayoutExample1();
    }
    
    private void mOpenBoxLayoutExample2(ActionEvent e) {
      clsBoxLayoutExample2 clsBoxLayout2 = new clsBoxLayoutExample2();  
    }
    
    private void mOpenBoxLayoutMyExample(ActionEvent e) {
        clsMyExample clsMyExmp = new clsMyExample();
    }
    class clsBoxLayoutExample1 extends JDialog {
        public clsBoxLayoutExample1() {
            super(null, "BoxLayout", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(400, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreateLayoutView();
            this.setVisible(true);
        }
        
        private void mCreateLayoutView() {
            this.setLayout(new BorderLayout());
            JPanel jpPanel = new JPanel();
            jpPanel.setLayout(new BoxLayout(jpPanel, BoxLayout.Y_AXIS));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            jpPanel.add(mCreateLayoutLabel(100, 50, Color.RED));
            jpPanel.add(mCreateLayoutLabel(150, 75, Color.GREEN));
            jpPanel.add(mCreateLayoutLabel(200, 100, Color.BLUE));
            
            this.add(jpPanel);
        }
        
        private JLabel mCreateLayoutLabel(int intWidth, int intHeight, Color c) {
            JLabel lblLabel = new JLabel();
            lblLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            lblLabel.setOpaque(true);
            lblLabel.setBackground(c);
            lblLabel.setPreferredSize(new Dimension(intWidth, intHeight));
            lblLabel.setMinimumSize(new Dimension(intWidth / 2, intHeight / 2));
            lblLabel.setMaximumSize(new Dimension(intWidth * 2, intHeight * 2));
            return lblLabel;
        }
    }
    
    class clsBoxLayoutExample2 extends JDialog {
        public clsBoxLayoutExample2() {
            super(null, "BoxLayout", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(600, 200);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreateLayoutView();
            this.setVisible(true);
        }
        
        private void mCreateLayoutView() {
            this.setLayout(new BorderLayout());
            JPanel jpPanel = new JPanel();
            jpPanel.setLayout(new BoxLayout(jpPanel, BoxLayout.X_AXIS));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            jpPanel.add(mCreateLayoutLabel(100, 50, Color.RED));
            jpPanel.add(Box.createRigidArea(new Dimension(10, 0)));
            jpPanel.add(mCreateLayoutLabel(150, 75, Color.GREEN));
            jpPanel.add(Box.createHorizontalGlue());
            jpPanel.add(mCreateLayoutLabel(200, 100, Color.BLUE));
            this.add(jpPanel);
        }
        
        private JLabel mCreateLayoutLabel(int intWidth, int intHeight, Color c) {
            JLabel lblLabel = new JLabel();
            lblLabel.setAlignmentY(Component.TOP_ALIGNMENT);
            lblLabel.setOpaque(true);
            lblLabel.setBackground(c);
            lblLabel.setPreferredSize(new Dimension(intWidth, intHeight));
            lblLabel.setMinimumSize(new Dimension(intWidth / 2, intHeight / 2));
            lblLabel.setMaximumSize(new Dimension(intWidth * 2, intHeight * 2));
            return lblLabel;
        }
    }
    
    class clsMyExample extends JDialog {
        public clsMyExample() {
            super(null, "Boxes and Their Locations", Dialog.ModalityType.APPLICATION_MODAL);
            this.setSize(800, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            mCreateLayoutView();
            this.setVisible(true);
        }
        
        private void mCreateLayoutView() {
            this.setLayout(new BorderLayout());
            JPanel jpPanel = new JPanel();
            jpPanel.setLayout(new BoxLayout(jpPanel, BoxLayout.Y_AXIS));
            jpPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            
            jpPanel.add(mCreateLayoutLabel(50, 25, Color.RED, LEFT_ALIGNMENT));
            jpPanel.add(Box.createRigidArea(new Dimension(300, 0)));
            jpPanel.add(mCreateLayoutLabel(100, 50, Color.GREEN, LEFT_ALIGNMENT));
            jpPanel.add(Box.createHorizontalGlue());
            jpPanel.add(Box.createRigidArea(new Dimension(200, 0)));
            jpPanel.add(mCreateLayoutLabel(150, 72, Color.BLUE, LEFT_ALIGNMENT));
            jpPanel.add(Box.createHorizontalGlue());
            jpPanel.add(Box.createRigidArea(new Dimension(100, 0)));
            jpPanel.add(Box.createHorizontalGlue());
            jpPanel.add(mCreateLayoutLabel(50, 25, Color.RED, RIGHT_ALIGNMENT));
            jpPanel.add(mCreateLayoutLabel(100, 50, Color.GREEN, RIGHT_ALIGNMENT));
            jpPanel.add(mCreateLayoutLabel(150, 72, Color.BLUE, RIGHT_ALIGNMENT));
            
            this.add(jpPanel);
        }
        
        private JLabel mCreateLayoutLabel(int intWidth, int intHeight,
                Color c, float flAlignment) {
            JLabel lblLabel = new JLabel();
            lblLabel.setAlignmentX(flAlignment);
            lblLabel.setOpaque(true);
            lblLabel.setBackground(c);
            lblLabel.setPreferredSize(new Dimension(intWidth, intHeight));
            lblLabel.setMinimumSize(new Dimension(intWidth / 2, intHeight / 2));
            lblLabel.setMaximumSize(new Dimension(intWidth * 2, intHeight * 2));
            return lblLabel;
        }
    }
    
}
