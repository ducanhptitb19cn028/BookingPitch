/*
 * Created by JFormDesigner on Fri May 13 22:37:12 ICT 2022
 */

package view;

import dao.UserDAO;
import model.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Duc Anh
 */
public class LoginView extends JFrame {
    public UserDAO userDAO;
    public LoginView() {
        initComponents();
        this.userDAO = new UserDAO();
    }

    private void subLogin(ActionEvent e) {
        // TODO add your code here
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        User user = new User(username, password);
        if (username.isEmpty() || password.isEmpty() || !userDAO.getAuthenticatedUser(user) ){
            JOptionPane.showMessageDialog(LoginView.this,
                    "Email or Password incorrect!!!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.dispose();
        InfoSearchView bv = new InfoSearchView();
        bv.setVisible(true);
    }

    public static void main(String[] args) {
        LoginView lv = new LoginView();
        lv.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        label1 = new JLabel();
        label2 = new JLabel();
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        subLogin = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Username: ");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- label2 ----
        label2.setText("Password");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- subLogin ----
        subLogin.setText("Login");
        subLogin.addActionListener(e -> subLogin(e));

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
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(subLogin)
                            .addGap(0, 212, Short.MAX_VALUE))
                        .addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addComponent(subLogin)
                    .addContainerGap(59, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JLabel label1;
    private JLabel label2;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton subLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
