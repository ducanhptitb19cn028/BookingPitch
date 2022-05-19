/*
 * Created by JFormDesigner on Thu May 19 07:47:30 ICT 2022
 */

package view;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Duc Anh
 */
public class DateInputView extends JFrame {
    public DateInputView() {
        initComponents();
    }

    public static void main(String[] args) {
        DateInputView div = new DateInputView();
        div.setVisible(true);
    }

    private void subSelect(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(this, "please confirm!");
    }

    private void subconfirm(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        label1 = new JLabel();
        label2 = new JLabel();
        txtStartdate = new JTextField();
        txtEnddate = new JTextField();
        subSelect = new JButton();
        subconfirm = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Start date");

        //---- label2 ----
        label2.setText("End date");

        //---- subSelect ----
        subSelect.setText("Select");
        subSelect.addActionListener(e -> subSelect(e));

        //---- subconfirm ----
        subconfirm.setText("Confirm");
        subconfirm.addActionListener(e -> subconfirm(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(label2))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(txtEnddate, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addComponent(txtStartdate, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(subSelect)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                    .addComponent(subconfirm)
                    .addGap(61, 61, 61))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(txtStartdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(txtEnddate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(subSelect)
                        .addComponent(subconfirm))
                    .addContainerGap(89, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JLabel label1;
    private JLabel label2;
    private JTextField txtStartdate;
    private JTextField txtEnddate;
    private JButton subSelect;
    private JButton subconfirm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
