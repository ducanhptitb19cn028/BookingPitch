/*
 * Created by JFormDesigner on Fri May 13 23:18:49 ICT 2022
 */

package view;

import dao.CustomerDAO;
import dao.DBConnection;
import model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author Duc Anh
 */
public class InfoSearchView extends JFrame {
    public InfoSearchView() {
        initComponents();
    }

    private void subSearch(ActionEvent e) {
        // TODO add your code here
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill these fields");
            return;
        }
        String[] columns = {"ID", "Name", "Email", "Phone number"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM tblcustomers WHERE name like '%" + name + "%' AND email like '%"+ email +"%' AND phonenumber like '%"+ phone +"%' "  ;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            Vector<java.io.Serializable> data = new Vector<>();
            model.setRowCount(0);
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "There is no customer with this information!");
                return;
            }
            while (rs.next()) {
                data.add(rs.getInt("id"));
                data.add(rs.getString("name"));
                data.add(rs.getString("email"));
                data.add(rs.getString("phonenumber"));
            }
            model.addRow(data);
            tableCustomer.setModel(model);
        }catch (SQLException | ClassNotFoundException ez) {
            ez.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InfoSearchView bv = new InfoSearchView();
        bv.setVisible(true);
    }

    private void subAdd(ActionEvent e) {
        // TODO add your code here
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        Customer customer = new Customer(name,email,phone);
        if (CustomerDAO.CustomerExists(customer)){
            JOptionPane.showMessageDialog(this, "Customer does exist !!","Don't try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        CustomerDAO.AddCustomer(customer);
    }

    private void tableCustomerMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        DateInputView dtv = new DateInputView();
        dtv.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtPhone = new JTextField();
        subSearch = new JButton();
        subAdd = new JButton();
        scrollPane1 = new JScrollPane();
        tableCustomer = new JTable();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Name:");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label2 ----
        label2.setText("Email:");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label3 ----
        label3.setText("Phone number: ");
        label3.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- subSearch ----
        subSearch.setText("Search");
        subSearch.addActionListener(e -> subSearch(e));

        //---- subAdd ----
        subAdd.setText("Add");
        subAdd.addActionListener(e -> subAdd(e));

        //======== scrollPane1 ========
        {

            //---- tableCustomer ----
            tableCustomer.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Name", "Email", "Phone number"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    true, true, true, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            tableCustomer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tableCustomerMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(tableCustomer);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(subSearch)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                            .addComponent(subAdd))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtName, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEmail))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(subSearch)
                        .addComponent(subAdd))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JButton subSearch;
    private JButton subAdd;
    private JScrollPane scrollPane1;
    private JTable tableCustomer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
