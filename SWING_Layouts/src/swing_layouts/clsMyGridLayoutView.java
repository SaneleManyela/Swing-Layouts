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
public class clsMyGridLayoutView extends JDialog{
    JTextField txtFirstName;
    JTextField txtLastName;
    JTextField txtPostion;
    private DefaultListModel model = new DefaultListModel();
    
    public clsMyGridLayoutView() {
        super(null, "MyGridBagLayout", Dialog.ModalityType.APPLICATION_MODAL);
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mCreateWindow();
        this.setVisible(true);
    }
    
    private void mCreateWindow() {
        this.setLayout(new BorderLayout());
        JPanel jpPanel = new JPanel(new GridBagLayout());
        jpPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        jpPanel.setOpaque(true);
        jpPanel.setBackground(Color.CYAN);
        mAddComponent(jpPanel, mCreateLabel("First Name", 120, 20),
        0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START,
        new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtFirstName = mCreateField(120, 20),
                2, 0, 10, 2, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 
                new Insets(0, 0, 10, 20));
        mAddComponent(jpPanel, mCreateLabel("Last Name", 120, 20),
        0, 2, 2, 1, 1, 0, GridBagConstraints.NONE, GridBagConstraints.LINE_START,
        new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtLastName = mCreateField(120, 20),
                2, 2, 6, 2, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 
                new Insets(0, 0, 20, 20));
        mAddComponent(jpPanel, mCreateLabel("Position", 120, 20),
                0, 4, 2, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 
                new Insets(0, 0, 0, 0));
        mAddComponent(jpPanel, txtPostion = mCreateField(120, 20),
                2, 4, 8, 2, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.LINE_START, 
                new Insets(0, 0, 20, 20));
        mAddComponent(jpPanel, mCreateList(), 0, 8, 2, 4, 0, 1, 
                GridBagConstraints.BOTH, GridBagConstraints.LINE_START,
                new Insets(0, 0, 10, 0));
        mAddComponent(jpPanel, mCreateButton("OK", 90, 23, this::mOk), 0, 18, 1,
                1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(20, 0, 0, 10));
        mAddComponent(jpPanel, mCreateButton("Clear", 90, 23, this::mClear), 1, 18, 1,
                1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(20, 0, 0, 10));
        mAddComponent(jpPanel, mCreateButton("Delete List", 90, 23, this::mDelete), 2, 18, 1,
                1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.LINE_START,
                new Insets(20, 0, 0, 10));
        this.add(jpPanel);
    }
    
    private JScrollPane mCreateList() {
        JList list = new JList(model);
        list.setEnabled(false);
        list.setOpaque(true);
        list.setBackground(Color.BLACK);
        list.setForeground(Color.GREEN);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(50, 100));
        return scroll;
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
    
    private JTextField mCreateField(int intWidth, int intHeight) {
        JTextField txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(intWidth, intHeight));
        txtField.setHorizontalAlignment(JTextField.LEFT);
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
    
    private void mOk(ActionEvent e) {
        
        if(txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtPostion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No textfield is allowed to be empty", "Error Message", JOptionPane.ERROR_MESSAGE);
        } else {
            clsPerson person = new clsPerson(txtFirstName.getText(), txtLastName.getText(), txtPostion.getText());
            model.addElement(person.toString());
            mClear(e);
        }
    }
    
    
    private void mClear(ActionEvent e) {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPostion.setText("");
        txtFirstName.requestFocus();
    }
    
    private void mDelete(ActionEvent e) {
        model.clear();
        mClear(e);
    }
    
    class clsPerson {
        private String strFirstName, strLastName, strPosition;
    
        public clsPerson(String strFirstName, String strLastName,
            String strPosition) {
            this.strFirstName = strFirstName;
            this.strLastName = strLastName;
            this.strPosition = strPosition;
        }
    
        public String toString() {
            return strFirstName + " " + strLastName + ", " + strPosition;
        }
    }
}
