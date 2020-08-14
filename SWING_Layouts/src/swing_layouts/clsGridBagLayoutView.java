/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_layouts;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Sanele
 */
public class clsGridBagLayoutView extends JDialog {

    private DefaultListModel model = new DefaultListModel();
    private ButtonGroup bgGroup = new ButtonGroup();
    private JTextField txtUnits;
    private JTextField txtPrice;
    private JTextField txtExcl;
    private JTextField txtVAT;
    private JTextField txtIncl;
    private JRadioButton rbExcl;
    private JRadioButton rbIncl;
    private JTextField txtExclSum;
    private JTextField txtVATSum;
    private JTextField txtInclSum;
    private double dblUnits;
    private double dblPrice;
    private double dblExcl;
    private double dblVAT;
    private double dblIncl;
    private double dblExclSum;
    private double dblVATSum;
    private double dblInclSum;
    
    public clsGridBagLayoutView() {
        super(null, "GridBagLayout", Dialog.ModalityType.APPLICATION_MODAL);
        this.setSize(500, 500);
        this.setMinimumSize(new Dimension(800, 450));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateWindow();
        this.setVisible(true);
    }
    
    private void mCreateWindow() {
        this.setLayout(new BorderLayout());
        JPanel jpPanel = new JPanel(new GridBagLayout());
        jpPanel.setBorder(new EmptyBorder(20, 20, 30, 20));
        mAddComponent(jpPanel, mCreateLabel("Number of Units", 120, 20),
        0, 0, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START,
        new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtUnits = mCreateField(120, 20, true), 2, 0, 1, 1, 0, 0,
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(0, 0, 20, 20));
        mAddComponent(jpPanel, mCreateLabel("Unit Price", 120, 20), 0, 1, 2, 1, 0, 0,
                GridBagConstraints.NONE, GridBagConstraints.LINE_START, new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtPrice = mCreateField(120, 20, true), 2, 1, 1, 1, 0, 0,
                GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START, new Insets(0, 0, 20, 20));
        mAddComponent(jpPanel, rbExcl = mCreateRadioButton("Unit price excl. VAT", 200, 20,
                true, bgGroup), 0, 2, 3, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START,
                new Insets(0, 0, 10, 0));
        mAddComponent(jpPanel, rbIncl = mCreateRadioButton("Unit price incl. VAT",
                200, 20, false, bgGroup), 0, 3, 3, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START,
                new Insets(0, 0, 20, 0));
        mAddComponent(jpPanel, mCreateLabel("Amount",
                100, 20), 0, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtExcl = mCreateField(150, 20, false), 
                1, 4, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_END,
                new Insets(0, 0, 20, 20));
        mAddComponent(jpPanel, mCreateLabel("VAT",
                100, 20), 0, 5, 1, 1, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.FIRST_LINE_END,
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtVAT = mCreateField(150, 20, false), 
                1, 5, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.FIRST_LINE_END,
                new Insets(0, 0, 20, 20));
        mAddComponent(jpPanel, mCreateList(), 3, 0, 3, 7, 1, 1, 
                GridBagConstraints.BOTH, GridBagConstraints.LINE_START,
                new Insets(0, 0, 10, 0));
        mAddComponent(jpPanel, mCreateLabel("Total",
                100, 20), 0, 6, 1, 1, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.FIRST_LINE_START,
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtExcl = mCreateField(150, 20, false), 
                1, 6, 2, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_END,
                new Insets(0, 0, 20, 20));
        mAddComponent(jpPanel, mCreateLabel("Amount", 80, 20), 0, 6, 1, 1, 0, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, mCreateLabel("VAT", 80, 20), 4, 7, 1, 1, 1, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, mCreateLabel("Total", 80, 20), 5, 7, 1, 1, 1, 0, 
                GridBagConstraints.NONE, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, mCreateButton("OK", 90, 23, this::mOk), 0, 9, 1,
                1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(20, 0, 0, 10));
        mAddComponent(jpPanel, mCreateButton("Clear", 90, 23, this::mClear), 1, 9, 1,
                1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(20, 0, 0, 10));
        mAddComponent(jpPanel, mCreateButton("Calculate", 90, 23, this::mCalculate), 2, 9, 1,
                1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(20, 0, 0, 40));
        mAddComponent(jpPanel, txtExclSum = mCreateField(100, 20, false), 
                3, 8, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 10));
        mAddComponent(jpPanel, txtInclSum = mCreateField(100, 20, false), 
                5, 8, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, mCreateButton("Delete", 90, 23, this::mDelete), 5, 9, 1,
                1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_END,
                new Insets(20, 0, 0, 0));
        this.add(jpPanel);
    }
    
    private JScrollPane mCreateList() {
        JList list = new JList(model);
        list.setEnabled(false);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(400, 200));
        return scroll;
    }
    
    private JRadioButton mCreateRadioButton(String strText, int intWidth, int intHeight,
            boolean isChecked, ButtonGroup bgGroup) {
            JRadioButton rb = new JRadioButton(strText);
            rb.setPreferredSize(new Dimension(intWidth, intHeight));
            rb.setSelected(isChecked);
            bgGroup.add(rb);
            return rb;
    }
    
    private JLabel mCreateLabel(String strText, int intWidth, int intHeight) {
        JLabel lblLabel = new JLabel(strText);
        lblLabel.setPreferredSize(new Dimension(intWidth, intHeight));
        return lblLabel;
    }
    
    private JButton mCreateButton(String strText, int intWidth, int intHeight,
            ActionListener listener) {
            JButton btn = new JButton(strText);
            btn.setPreferredSize(new Dimension(intWidth, intHeight));
            btn.addActionListener(listener);
            return btn;
    }
    
    private JTextField mCreateField(int intWidth, int intHeight, boolean isEditable) {
        JTextField txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(intWidth, intHeight));
        txtField.setEditable(isEditable);
        txtField.setHorizontalAlignment(JTextField.RIGHT);
        return txtField;
    }
    
    public static void mAddComponent(Container container, Component component,
        int intGridX, int intGridY, int intGridWidth, int intGridHeight, 
        double dblWeightX, double dblWeightY, int intFill, int intAnchor, 
        Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = intGridX;
        constraints.gridy = intGridY;
        constraints .gridwidth = intGridWidth;
        constraints.gridheight = intGridHeight;
        constraints.weightx = dblWeightX;
        constraints.weighty = dblWeightY;
        constraints.fill = intFill;
        constraints.anchor = intAnchor;
        constraints.insets = insets;
        container.add(component, constraints);
    }

    private void mCalculate(ActionEvent e) {
        try {
            dblUnits = Double.parseDouble(txtUnits.getText().trim());
            dblPrice = Double.parseDouble(txtPrice.getText().trim());
            
            if(dblUnits > 0 && dblPrice > 0) {
                if(rbIncl.isSelected()) {
                    dblPrice *= 0.8;
                }
                dblExcl = dblPrice * dblUnits;
                dblVAT = dblExcl * 0.25;
                dblIncl = dblExcl + dblVAT;
                txtExcl.setText(String.format("%1.2f", dblExcl));
                txtVAT.setText(String.format("%1.2f", dblVAT));
                txtIncl.setText(String.format("%1.2f", dblIncl));
                return;
            }
        } catch(Exception eX) {
            JOptionPane.showMessageDialog(this, "Illegal value for the number of"
                    + " units or unit price", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mOk(ActionEvent e) {
        if(dblIncl > 0) {
            model.addElement(String.format(
                    "%1.1f units a kr. %1.2f, amount = %1.2f, VAT = %1.2f, Total = %1.2f",
                    dblUnits, dblPrice, dblExcl, dblVAT, dblIncl));
            dblExclSum += dblExcl;
            dblVATSum += dblVAT;
            dblInclSum += dblIncl;
            txtExclSum.setText(String.format("%1.2f", dblExclSum));
            txtVATSum.setText(String.format("%1.2f", dblVATSum));
            txtInclSum.setText(String.format("%1.2f", dblInclSum));
            mClear(e);
        }
    }
    
    private void mClear(ActionEvent e) {
        dblUnits = dblPrice = dblExcl = dblIncl = dblVAT = 0;
        txtUnits.setText("");
        txtPrice.setText("");
        txtExcl.setText("");
        txtVAT.setText("");
        txtIncl.setText("");
        txtUnits.requestFocus();
    }
    
    private void mDelete(ActionEvent e) {
        model.clear();
        mClear(e);
    }
}
