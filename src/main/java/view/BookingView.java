/*
 * Created by JFormDesigner on Wed May 18 22:32:04 ICT 2022
 */

package view;

import dao.DBConnection;

import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Duc Anh
 */
public class BookingView extends JFrame {
    public BookingView() {
        initComponents();
    }

    private void subSearch(ActionEvent e) {
        // TODO add your code here
        String type = txtType.getText();
        String timeslot = txtTimeslot.getText();
        if (type.isEmpty() || timeslot.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all these fields","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] columns = {"ID", "Pitch type", "Time slot", "Price","Status"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM tblminipitch WHERE pitchtype like '%" + type + "%' AND timeslot like '%" + timeslot + "%' AND status = 0 "  ;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            Vector<Serializable> data = new Vector<>();
            model.setRowCount(0);
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "There is no mini pitch with this information!");
                return;
            }
            while (rs.next()) {
                data.add(rs.getInt("pid"));
                data.add(rs.getString("pitchtype"));
                data.add(rs.getString("timeslot"));
                data.add(rs.getBigDecimal("price"));
                data.add(rs.getBoolean("status"));
            }
            model.addRow(data);
            tblEmptyPitch.setModel(model);
        }catch (SQLException | ClassNotFoundException ez) {
            ez.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookingView bv = new BookingView();
        bv.setVisible(true);
    }

    private void tblEmptyPitchMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        InfoSearchView isv = new InfoSearchView();
        isv .setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        label1 = new JLabel();
        label2 = new JLabel();
        txtTimeslot = new JTextField();
        txtType = new JTextField();
        scrollPane1 = new JScrollPane();
        tblEmptyPitch = new JTable();
        subSearch = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Time slot:");

        //---- label2 ----
        label2.setText("Type");

        //======== scrollPane1 ========
        {

            //---- tblEmptyPitch ----
            tblEmptyPitch.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Pitch type", "Time slot", "Price", "Status"
                }
            ));
            tblEmptyPitch.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tblEmptyPitchMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tblEmptyPitch);
        }

        //---- subSearch ----
        subSearch.setText("Search");
        subSearch.addActionListener(e -> subSearch(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(subSearch)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label1)
                                    .addComponent(label2)))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(txtTimeslot, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addComponent(txtType))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(txtTimeslot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(txtType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addComponent(subSearch)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JLabel label1;
    private JLabel label2;
    private JTextField txtTimeslot;
    private JTextField txtType;
    private JScrollPane scrollPane1;
    private JTable tblEmptyPitch;
    private JButton subSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
