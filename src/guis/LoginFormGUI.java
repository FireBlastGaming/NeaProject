package guis;

import constants.CommonConstants;
import db.MyJDBC;
import guis.registerPages.RegisterPage0;
import guis.registerPages.RegisterPage1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public final class LoginFormGUI extends Form {


    public LoginFormGUI() {
        super("Login");
        addGuiComponents();
    }

    private void addGuiComponents() {
        // create login label
        JLabel loginLabel = new JLabel("Login");

        // configure component's x, y position and width/height values relative to the GUI
        loginLabel.setBounds(0, 25, 520, 100);

        //change the font colour
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // change the font size
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // centre text
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add component to GUI
        add(loginLabel);

        // create username label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOUR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create username text field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(CommonConstants.SECONDARY_COLOUR);
        usernameField.setForeground(CommonConstants.TEXT_COLOUR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernameLabel);
        add(usernameField);

        // create password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 335, 400, 25);
        passwordLabel.setForeground(CommonConstants.TEXT_COLOUR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create password text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 365, 450, 55);
        passwordField.setBackground(CommonConstants.SECONDARY_COLOUR);
        passwordField.setForeground(CommonConstants.TEXT_COLOUR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);

        // create login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(CommonConstants.TEXT_COLOUR);
        loginButton.setBounds(125, 520, 250, 50);
        loginButton.addActionListener(e -> {
            // get username
            String username = usernameField.getText();

            // get password
            String password = new String(passwordField.getPassword());
            String hashedPassword = Hasher.hasher(username, password);
            String table;

            if (Objects.equals(RegisterPage0.role, "Customer")) {
                table = "customer";
            }
            else {
                table = "staff";
            }

            // check database if the username and password combo is valid
            if (MyJDBC.validateLogin(username, hashedPassword, table)){
                // login successful
                JOptionPane.showMessageDialog(this,
                        "Login Successful!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException k) {
                    Thread.currentThread().interrupt();
                }
                LoginFormGUI.this.dispose();
                new HomePage().setVisible(true);
            }
            else {
                // login failed
                JOptionPane.showMessageDialog(this,
                        "Login Failed...");
            }
        });
        add(loginButton);

        // create register label (used to load the register GUI)
        JLabel registerLabel = new JLabel("Not a user? Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the register form GUI
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                LoginFormGUI.this.dispose();

                // launch the register GUI
                new RegisterPage1().setVisible(true);
            }
        });
        registerLabel.setBounds(125, 600, 250, 30);
        add(registerLabel);
    }
}
