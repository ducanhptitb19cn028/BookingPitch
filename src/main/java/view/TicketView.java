/*
 * Created by JFormDesigner on Thu May 19 12:31:21 ICT 2022
 */

package view;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Duc Anh
 */
public class TicketView extends JFrame {
    public TicketView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        scrollPane1 = new JScrollPane();
        txtTicket = new JTextArea();
        label1 = new JLabel();
        subprint = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(txtTicket);
        }

        //---- label1 ----
        label1.setText("Booking Ticket");

        //---- subprint ----
        subprint.setText("Print");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(146, 146, 146))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(subprint)
                            .addGap(151, 151, 151))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(subprint)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JScrollPane scrollPane1;
    private JTextArea txtTicket;
    private JLabel label1;
    private JButton subprint;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
