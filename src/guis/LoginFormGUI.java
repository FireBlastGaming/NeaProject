package guis;

import constants.CommonConstants;

import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;

public class LoginFormGUI extends Form {
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
        add(loginButton);





    }
}
