/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_layouts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sanele
 */
public class clsMainView extends JFrame {
    public clsMainView() {
        this.setTitle("Components and their locations");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mCreateWindow();
        this.setVisible(true);
    }
    
    private void mCreateWindow() {
        JPanel jpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 10));
        jpPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        jpPanel.setOpaque(true);
        jpPanel.setBackground(Color.YELLOW);
        jpPanel.add(mCreateButton("BorderLayout", 150, 30, this::mOpenBorderLayoutView));
        jpPanel.add(mCreateButton("FlowLayout", 150, 30, this::mOpenFlowLayoutView));
        jpPanel.add(mCreateButton("GridLayout", 150, 50, this::mOpenGridLayoutView));
        jpPanel.add(mCreateButton("GridBagLayout", 150, 50, this::mOpenGridBagLayout));
        jpPanel.add(mCreateButton("My_GridBagLayout", 150, 60, this::mOpenMyGridBagLayoutView));
        jpPanel.add(mCreateButton("BoxLayout", 150, 60, this::mOpenBoxLayoutView));
        jpPanel.add(mCreateButton("Null Layout", 352, 40, this::mOpenNullLayoutView));
        this.add(jpPanel);
    }
    
    private JButton mCreateButton(String strText, int intWidth, int intHeight,
        ActionListener listener) {
        JButton btn = new JButton(strText);
        btn.addActionListener(listener);
        btn.setPreferredSize(new Dimension(intWidth, intHeight));
        return btn;
    }
    
    private void mOpenBorderLayoutView(ActionEvent e) {
        clsBorderLayoutView clsBorderLayout = new clsBorderLayoutView();
    }
    
    private void mOpenFlowLayoutView(ActionEvent e) {
        clsFlowLayoutView clsFlowLayout = new clsFlowLayoutView();
    }
    
    private void mOpenGridLayoutView(ActionEvent e) {
        clsGridLayoutView clsGridLayout = new clsGridLayoutView();
    }
    
    private void mOpenGridBagLayout(ActionEvent e) {
        clsGridBagLayoutView clsGridBagLayout = new clsGridBagLayoutView();
    }
    
    private void mOpenMyGridBagLayoutView(ActionEvent e) {
        clsMyGridLayoutView clsMyGridBagLayout = new clsMyGridLayoutView();
    }
    
    private void mOpenBoxLayoutView(ActionEvent e) {
        clsBoxLayoutView clsBoxLayout = new clsBoxLayoutView();
    }
    
    private void mOpenNullLayoutView(ActionEvent e) {
        clsNullLayoutView clsNullLayout = new clsNullLayoutView();
    }
}
