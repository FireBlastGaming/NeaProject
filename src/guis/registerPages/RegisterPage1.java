package guis.registerPages;

import constants.CommonConstants;
import guis.Form;
import guis.LoginFormGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPage1 extends Form {

    // initialize components
    JLabel usernameLabel = new JLabel("Username:");
    JTextField usernameField = new JTextField();
    JLabel passwordLabel = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField();
    JLabel rePasswordLabel = new JLabel("Re-enter Password:");
    JPasswordField rePasswordField = new JPasswordField();
    public static String usernameText;
    public static String passwordResult;
    public static String repasswordResult;


    public RegisterPage1() {
        super("Register");
        addPage1GuiComponents();
    }

    private void addPage1GuiComponents () {
        // create register label
        JLabel registerLabel = new JLabel("Register");

        // configure component's x, y position and width/height values relative to the GUI
        registerLabel.setBounds(0, 25, 520, 100);

        //change the font colour
        registerLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // change the font size
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // centre text
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add component to GUI
        add(registerLabel);

        // create username label
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(CommonConstants.TEXT_COLOUR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create username text field
        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(CommonConstants.SECONDARY_COLOUR);
        usernameField.setForeground(CommonConstants.TEXT_COLOUR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernameLabel);
        add(usernameField);

        // create password label
        passwordLabel.setBounds(30, 255, 400, 25);
        passwordLabel.setForeground(CommonConstants.TEXT_COLOUR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create password text field
        passwordField.setBounds(30, 285, 450, 55);
        passwordField.setBackground(CommonConstants.SECONDARY_COLOUR);
        passwordField.setForeground(CommonConstants.TEXT_COLOUR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);

        // create re-enter password label

        rePasswordLabel.setBounds(30, 365, 400, 25);
        rePasswordLabel.setForeground(CommonConstants.TEXT_COLOUR);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create password text field
        rePasswordField.setBounds(30, 395, 450, 55);
        rePasswordField.setBackground(CommonConstants.SECONDARY_COLOUR);
        rePasswordField.setForeground(CommonConstants.TEXT_COLOUR);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(rePasswordLabel);
        add(rePasswordField);

        // create next page button
        JButton toPage2Button = new JButton("Next page");
        toPage2Button.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        toPage2Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toPage2Button.setBackground(CommonConstants.TEXT_COLOUR);
        toPage2Button.setBounds(125, 520, 250, 50);
        add(toPage2Button);



        // add functionality so that when clicked it will launch the next page GUI
        toPage2Button.addActionListener(e -> {
            usernameText = usernameField.getText();

            passwordResult = new String(passwordField.getPassword());

            repasswordResult = new String(rePasswordField.getPassword());

            boolean valid = validationPage1(usernameText, passwordResult, repasswordResult);
            if (valid) {

                // dispose of this page
                RegisterPage1.this.dispose();

                // launch the next page
                new RegisterPage2().setVisible(true);
            }
        });

        // create login label (used to load the login GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                RegisterPage1.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private boolean validationPage1 (String username, String password, String repassword){

        // all fields must have a value

        if (username.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "One of the three are empty.");
            return false;
        }

        // username has to be at least 4 characters long

        if (username.length() < 4) {
            JOptionPane.showMessageDialog(this, "Username is less than 4 characters.");
            return false;
        }

        // password and repassword must be the same

        if (!password.equals(repassword)) {
            JOptionPane.showMessageDialog(this, "Password and RePassword do not match.");
            return false;
        }

        // uses Regex (Regular Expressions) for password validity

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password is less than 8 characters. " +
                    "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
            return false;
        } else {
            Pattern upper = Pattern.compile("[A-Z]");
            Pattern lower = Pattern.compile("[a-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasUpper = upper.matcher(password);
            Matcher hasLower = lower.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            if (!(hasUpper.find() && hasLower.find())) {
                JOptionPane.showMessageDialog(this, "Password should contain an upper and lower case character. " +
                        "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
                return false;
            }
            if (!hasDigit.find()) {
                JOptionPane.showMessageDialog(this, "Password should contain at least one digit. " +
                        "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
                return false;
            }
            if (!hasSpecial.find()) {
                JOptionPane.showMessageDialog(this, "Password should contain at least one special character. " +
                        "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
                return false;
            }
            return true;
        }
    }
}
