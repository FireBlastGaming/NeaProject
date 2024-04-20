package guis.registerPages;

import com.toedter.calendar.JDateChooser;
import constants.CommonConstants;
import db.MyJDBC;
import guis.Form;
import guis.LoginFormGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


public class RegisterPage3 extends Form {

    // initialize components
    JLabel nationalityLabel = new JLabel("Nationality:");
    JTextField nationalityField = new JTextField();
    JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
    JDateChooser dateOfBirthField = new JDateChooser();
    JLabel taxRegistrationNoLabel = new JLabel("Tax Registration Number:");
    JTextField taxRegistrationNoField = new JTextField();
    JLabel addressLabel = new JLabel("Address:");
    JTextField addressField = new JTextField();
    JButton registerButton = new JButton("Register");
    LoginFormGUI loginFormGUI = new LoginFormGUI();
    JLabel companyAddressLabel = new JLabel("Company Address:");
    JTextField companyAddressField = new JTextField();

    public static String nationalityText;
    public static Date dateOfBirthDate;
    public static String taxRegistrationNoText;
    public static String addressText;
    public static String companyAddressText;

    public RegisterPage3() {
        super("title");
        addPage3GuiComponents();
    }

    private void addPage3GuiComponents() {
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

        if (!Objects.equals(RegisterPage0.role, "Customer")) {

            // create nationality label

            nationalityLabel.setBounds(30, 150, 400, 25);
            nationalityLabel.setForeground(CommonConstants.TEXT_COLOUR);
            nationalityLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create nationality text field

            nationalityField.setBounds(30, 185, 450, 55);
            nationalityField.setBackground(CommonConstants.SECONDARY_COLOUR);
            nationalityField.setForeground(CommonConstants.TEXT_COLOUR);
            nationalityField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(nationalityLabel);
            add(nationalityField);

            // create date of birth label

            dateOfBirthLabel.setBounds(30, 255, 400, 25);
            dateOfBirthLabel.setForeground(CommonConstants.TEXT_COLOUR);
            dateOfBirthLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create date of birth text field

            dateOfBirthField.setBounds(30, 285, 450, 55);
            dateOfBirthField.setBackground(CommonConstants.SECONDARY_COLOUR);
            dateOfBirthField.setForeground(CommonConstants.TEXT_COLOUR);
            dateOfBirthField.setFont(new Font("Dialog", Font.PLAIN, 24));
            dateOfBirthField.setLocale(Locale.UK);

            add(dateOfBirthLabel);
            add(dateOfBirthField);

            // create address label

            addressLabel.setBounds(30, 365, 400, 25);
            addressLabel.setForeground(CommonConstants.TEXT_COLOUR);
            addressLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create address text field
            addressField.setBounds(30, 395, 450, 55);
            addressField.setBackground(CommonConstants.SECONDARY_COLOUR);
            addressField.setForeground(CommonConstants.TEXT_COLOUR);
            addressField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(addressLabel);
            add(addressField);

        } else {

            // create tax registration number label

            taxRegistrationNoLabel.setBounds(30, 150, 400, 25);
            taxRegistrationNoLabel.setForeground(CommonConstants.TEXT_COLOUR);
            taxRegistrationNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create tax registration number text field

            taxRegistrationNoField.setBounds(30, 185, 450, 55);
            taxRegistrationNoField.setBackground(CommonConstants.SECONDARY_COLOUR);
            taxRegistrationNoField.setForeground(CommonConstants.TEXT_COLOUR);
            taxRegistrationNoField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(taxRegistrationNoLabel);
            add(taxRegistrationNoField);

            // create address label

            companyAddressLabel.setBounds(30, 255, 400, 25);
            companyAddressLabel.setForeground(CommonConstants.TEXT_COLOUR);
            companyAddressLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create address text field

            companyAddressField.setBounds(30, 285, 450, 55);
            companyAddressField.setBackground(CommonConstants.SECONDARY_COLOUR);
            companyAddressField.setForeground(CommonConstants.TEXT_COLOUR);
            companyAddressField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(companyAddressLabel);
            add(companyAddressField);
        }

        // create register button
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(CommonConstants.TEXT_COLOUR);
        registerButton.setBounds(125, 520, 250, 50);
        add(registerButton);

        // add functionality so that when clicked it will launch the next page GUI
        registerButton.addActionListener(e -> {
            boolean validP1 = true;
            boolean validP2 = true;

            nationalityText = nationalityField.getText();
            dateOfBirthDate = dateOfBirthField.getDate();
            taxRegistrationNoText = taxRegistrationNoField.getText();
            addressText = addressField.getText();
            companyAddressText = companyAddressField.getText();

            if (!Objects.equals(RegisterPage0.role, "Customer")) {
                validP1 = false;
                if (validationPage3Staff(nationalityText, dateOfBirthDate, addressText)) {
                    validP1 = true;
                } else {
                    JOptionPane.showMessageDialog(this, "One of the three are empty. Or the date is after the current date");
                }
            } else {
                validP2 = false;
                if (validationPage3Customer(taxRegistrationNoText, companyAddressText)) {
                    validP2 = true;
                } else {
                    JOptionPane.showMessageDialog(this, "One of the two are empty");
                }
            }
            if (validP1 && validP2) {

                // get username
                String username = RegisterPage1.usernameText;

                // get password
                String password = RegisterPage1.passwordResult;

                // get firstname
                String firstName = RegisterPage2.firstNameText;

                // get lastname
                String lastName = RegisterPage2.lastNameText;

                if (!Objects.equals(RegisterPage0.role, "Customer")) {
                    // get sex
                    String sex = RegisterPage2.sexText;

                    // get nationality
                    String nationality = nationalityText;

                    // get date of birth
                    Date dateOfBirth = dateOfBirthDate;

                    // get address
                    String address = addressText;

                    // register user to the database
                    if (MyJDBC.registerStaff(username, password, firstName, lastName, sex, nationality, dateOfBirth, address, RegisterPage0.role)) {
                        // dispose of this page
                        RegisterPage3.this.dispose();

                        // take user back to login gui
                        loginFormGUI.setVisible(true);

                        // create a result dialog
                        JOptionPane.showMessageDialog(loginFormGUI,
                                "Registered Account Successfully!");
                    } else {
                        // register failed (likely due to the user already existing in the database)
                        JOptionPane.showMessageDialog(RegisterPage3.this,
                                "Error: Username already taken");
                    }
                } else {
                    // get companyname
                    String companyName = RegisterPage2.companyNameText;

                    // get companyaddress
                    String companyAddress = companyAddressText;

                    // get taxregistrationno
                    String taxRegistrationNo = taxRegistrationNoText;

                    // register user to the database
                    if (MyJDBC.registerCustomer(username, password, firstName, lastName, companyName, taxRegistrationNo, companyAddress)) {
                        // dispose of this page
                        RegisterPage3.this.dispose();

                        // take user back to login gui
                        loginFormGUI.setVisible(true);

                        // create a result dialog
                        JOptionPane.showMessageDialog(loginFormGUI,
                                "Registered Account Successfully!");
                    } else {
                        // register failed (likely due to the user already existing in the database)
                        JOptionPane.showMessageDialog(RegisterPage3.this,
                                "Error: Username already taken");
                    }
                }
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
                RegisterPage3.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private boolean validationPage3Staff(String nationality, Date dob, String address) {

        // all fields must have a value

        return (!nationality.isEmpty() && dob != null && !address.isEmpty() && dob.before(Calendar.getInstance().getTime()));
    }

    private boolean validationPage3Customer(String taxRegistrationNo, String companyAddress) {

        // all fields must have a value

        return !taxRegistrationNo.isEmpty() && !companyAddress.isEmpty();
    }
}

