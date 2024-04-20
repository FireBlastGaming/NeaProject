package guis.registerPages;

import constants.CommonConstants;
import guis.Form;
import guis.LoginFormGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public final class RegisterPage2 extends Form {

    // initialize components
    JLabel firstNameLabel = new JLabel("Firstname:");
    JTextField firstNameField = new JTextField();
    JLabel lastNameLabel = new JLabel("Lastname:");
    JTextField lastNameField = new JTextField();
    JLabel sexLabel = new JLabel("Sex:");
    JTextField sexField = new JTextField();
    JLabel companyNameLabel = new JLabel("Company Name:");
    JTextField companyNameField = new JTextField();

    public static String firstNameText;
    public static String lastNameText;
    public static String sexText;
    public static String companyNameText;


    public RegisterPage2() {
        super("title");
        addPage2GuiComponents();
    }

    private void addPage2GuiComponents() {
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

        // create firstname label
        firstNameLabel.setBounds(30, 150, 400, 25);
        firstNameLabel.setForeground(CommonConstants.TEXT_COLOUR);
        firstNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create firstname text field
        firstNameField.setBounds(30, 185, 450, 55);
        firstNameField.setBackground(CommonConstants.SECONDARY_COLOUR);
        firstNameField.setForeground(CommonConstants.TEXT_COLOUR);
        firstNameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(firstNameLabel);
        add(firstNameField);

        // create lastname label
        lastNameLabel.setBounds(30, 255, 400, 25);
        lastNameLabel.setForeground(CommonConstants.TEXT_COLOUR);
        lastNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create lastname text field
        lastNameField.setBounds(30, 285, 450, 55);
        lastNameField.setBackground(CommonConstants.SECONDARY_COLOUR);
        lastNameField.setForeground(CommonConstants.TEXT_COLOUR);
        lastNameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(lastNameLabel);
        add(lastNameField);

        if (!Objects.equals(RegisterPage0.role, "Customer")) {

            // create sex label
            sexLabel.setBounds(30, 365, 400, 25);
            sexLabel.setForeground(CommonConstants.TEXT_COLOUR);
            sexLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create sex text field
            sexField.setBounds(30, 395, 450, 55);
            sexField.setBackground(CommonConstants.SECONDARY_COLOUR);
            sexField.setForeground(CommonConstants.TEXT_COLOUR);
            sexField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(sexLabel);
            add(sexField);
        } else {

            // create company name label
            companyNameLabel.setBounds(30, 365, 400, 25);
            companyNameLabel.setForeground(CommonConstants.TEXT_COLOUR);
            companyNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create company name text field
            companyNameField.setBounds(30, 395, 450, 55);
            companyNameField.setBackground(CommonConstants.SECONDARY_COLOUR);
            companyNameField.setForeground(CommonConstants.TEXT_COLOUR);
            companyNameField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(companyNameLabel);
            add(companyNameField);
        }


        // create next page button
        JButton toPage3Button = new JButton("Next Page");
        toPage3Button.setFont(new

                Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        toPage3Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toPage3Button.setBackground(CommonConstants.TEXT_COLOUR);
        toPage3Button.setBounds(125, 520, 250, 50);

        add(toPage3Button);

        // add functionality so that when clicked it will launch the next page GUI
        toPage3Button.addActionListener(e -> {

            boolean validP1 = true;
            boolean validP2 = true;
            firstNameText = firstNameField.getText();
            lastNameText = lastNameField.getText();
            sexText = sexField.getText();
            companyNameText = companyNameField.getText();

            if (!Objects.equals(RegisterPage0.role, "Customer")) {
                validP1 = false;
                if (validationPage2Staff(firstNameText, lastNameText, sexText)) {
                    validP1 = true;
                } else {
                    JOptionPane.showMessageDialog(this, "One of the three are empty.");
                }
            } else {
                validP2 = false;
                if (validationPage2Customer(firstNameText, lastNameText, companyNameText)) {
                    validP2 = true;
                } else {
                    JOptionPane.showMessageDialog(this, "One of the three are empty.");
                }
            }

            if (validP1 && validP2) {
                // dispose of this page
                RegisterPage2.this.dispose();

                // launch the next page
                new RegisterPage3().setVisible(true);
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
                RegisterPage2.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);

        add(loginLabel);
    }

    private boolean validationPage2Staff(String firstName, String lastName, String sex) {

        // all fields must have a value

        return !firstName.isEmpty() && !lastName.isEmpty() && !sex.isEmpty();

    }

    private boolean validationPage2Customer(String firstName, String lastName, String companyName) {

        // all fields must have a value

        return !firstName.isEmpty() && !lastName.isEmpty() && !companyName.isEmpty();

    }
}
