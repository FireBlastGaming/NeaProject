package guis;

import com.toedter.calendar.JDateChooser;
import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFormGUI extends Form {
    public RegisterFormGUI() {
        super("Register");
        addPage0GuiComponents();
    }


    private static boolean pressed = false;
    public static String role = "";

    public static ArrayList<Object> staffResults = new ArrayList<>();
    public static ArrayList<Object> customerResults = new ArrayList<>();

    private void addPage0GuiComponents() {
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

        // create staff button
        JButton staffButton = new JButton("Staff");
        staffButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        staffButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        staffButton.setBackground(CommonConstants.TEXT_COLOUR);
        staffButton.setBounds(30, 185, 450, 55);
        // add functionality that makes a variable true if the button has been pressed

        while (!pressed) {
            staffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pressed = true;
                    role = "Staff";

                }
            });
        }
        add(staffButton);

        // create manager button
        JButton managerButton = new JButton("Manager");
        managerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        managerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        managerButton.setBackground(CommonConstants.TEXT_COLOUR);
        managerButton.setBounds(30, 285, 450, 55);
        // add functionality that makes a variable true if the button has been pressed
        while (!pressed) {
            staffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pressed = true;
                    role = "Manager";
                }
            });
        }
        add(managerButton);

        // create customer button
        JButton customerButton = new JButton("Customer");
        customerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        customerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        customerButton.setBackground(CommonConstants.TEXT_COLOUR);
        customerButton.setBounds(30, 395, 450, 55);
        // add functionality that makes a variable true if the button has been pressed
        while (!pressed) {
            staffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pressed = true;
                    role = "Customer";
                }
            });
        }
        add(customerButton);

        // create next page button
        JButton toPage1Button = new JButton("Next page");
        toPage1Button.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        toPage1Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toPage1Button.setBackground(CommonConstants.TEXT_COLOUR);
        toPage1Button.setBounds(125, 520, 250, 50);
        add(toPage1Button);

        // add functionality so that when clicked it will launch the next page GUI
        toPage1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this page
                remove(registerLabel);
                remove(staffButton);
                remove(customerButton);
                remove(toPage1Button);

                // launch the next page
                addPage1GuiComponents();
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
                RegisterFormGUI.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);

    }

    private void addPage1GuiComponents() {
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
        passwordLabel.setBounds(30, 255, 400, 25);
        passwordLabel.setForeground(CommonConstants.TEXT_COLOUR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create password text field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 285, 450, 55);
        passwordField.setBackground(CommonConstants.SECONDARY_COLOUR);
        passwordField.setForeground(CommonConstants.TEXT_COLOUR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);

        // create re-enter password label

        JLabel rePasswordLabel = new JLabel("Re-enter Password:");
        rePasswordLabel.setBounds(30, 365, 400, 25);
        rePasswordLabel.setForeground(CommonConstants.TEXT_COLOUR);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create password text field
        JPasswordField rePasswordField = new JPasswordField();
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

        String passwordResult = new String(passwordField.getPassword());
        String repasswordResult = new String(passwordField.getPassword());

        // append the results into the array
        boolean valid = false;

        if (validationPage1(String.valueOf(usernameField), passwordResult, repasswordResult)) {
            staffResults.add(usernameField);
            staffResults.add(passwordResult);
            staffResults.add(repasswordResult);
            customerResults.add(usernameField);
            customerResults.add(passwordField);
            customerResults.add(rePasswordField);
            valid = true;
        }

        if (valid) {

            // add functionality so that when clicked it will launch the next page GUI
            toPage2Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // dispose of this page
                    remove(registerLabel);
                    remove(usernameLabel);
                    remove(usernameField);
                    remove(passwordLabel);
                    remove(passwordLabel);
                    remove(rePasswordLabel);
                    remove(rePasswordField);
                    remove(toPage2Button);

                    // launch the next page
                    addPage2GuiComponents();
                }
            });

        }

        // create login label (used to load the login GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                RegisterFormGUI.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
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
        JLabel firstNameLabel = new JLabel("Firstname:");
        firstNameLabel.setBounds(30, 150, 400, 25);
        firstNameLabel.setForeground(CommonConstants.TEXT_COLOUR);
        firstNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create firstname text field
        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(30, 185, 450, 55);
        firstNameField.setBackground(CommonConstants.SECONDARY_COLOUR);
        firstNameField.setForeground(CommonConstants.TEXT_COLOUR);
        firstNameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(firstNameLabel);
        add(firstNameField);

        // create lastname label
        JLabel lastNameLabel = new JLabel("Lastname:");
        lastNameLabel.setBounds(30, 255, 400, 25);
        lastNameLabel.setForeground(CommonConstants.TEXT_COLOUR);
        lastNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create lastname text field
        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(30, 285, 450, 55);
        lastNameField.setBackground(CommonConstants.SECONDARY_COLOUR);
        lastNameField.setForeground(CommonConstants.TEXT_COLOUR);
        lastNameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(lastNameLabel);
        add(lastNameField);

        boolean validP1 = false;
        boolean validP2 = false;
        boolean validP3 = false;

        if (validationPage2(String.valueOf(firstNameField), String.valueOf(lastNameField), null, false, true, true)) {
            staffResults.add(firstNameField);
            staffResults.add(lastNameField);
            customerResults.add(firstNameField);
            customerResults.add(lastNameField);
            validP1 = true;
        }

        JLabel sexLabel = new JLabel("Sex:");
        JTextField sexField = new JTextField();
        JLabel companyNameLabel = new JLabel("Company Name:");
        JTextField companyNameField = new JTextField();


        if (!Objects.equals(role, "Customer")) {

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

            if (validationPage2(null, null, String.valueOf(sexField), true, false, false)) {
                staffResults.add(sexField);
                validP2 = true;
            }
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

            customerResults.add(companyNameField);
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
        if (validP1 && validP2 && validP3) {
            toPage3Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // dispose of this page
                    remove(registerLabel);
                    remove(firstNameLabel);
                    remove(firstNameField);
                    remove(lastNameLabel);
                    remove(lastNameField);
                    remove(sexLabel);
                    remove(sexField);
                    remove(companyNameLabel);
                    remove(companyNameField);
                    remove(toPage3Button);

                    // launch the next page
                    addPage3GuiComponents();
                }
            });
        }


        // create login label (used to load the login GUI)

        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new

                                            MouseAdapter() {
                                                @Override
                                                public void mouseClicked(MouseEvent e) {
                                                    // dispose of this GUI
                                                    RegisterFormGUI.this.dispose();

                                                    // launch the login GUI
                                                    new LoginFormGUI().setVisible(true);

                                                }
                                            });
        loginLabel.setBounds(125, 600, 250, 30);

        add(loginLabel);
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

        JLabel nationalityLabel = new JLabel("Nationality:");
        JTextField nationalityField = new JTextField();
        JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
        JDateChooser dateOfBirthField = new JDateChooser();
        JLabel taxRegistrationNoLabel = new JLabel("Tax Registration Number:");
        JTextField taxRegistrationNoField = new JTextField();

        boolean validP1 = false;
        boolean validP2 = false;
        boolean validP3 = false;

        if (!Objects.equals(role, "Customer")) {

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

            if (validationPage3(String.valueOf(nationalityField), Date.valueOf(String.valueOf(dateOfBirthField)), null, false, true, true)) {
                staffResults.add(nationalityField);
                staffResults.add(dateOfBirthField);
                validP1 = true;
            }
        } else {

            // create address label

            taxRegistrationNoLabel.setBounds(30, 365, 400, 25);
            taxRegistrationNoLabel.setForeground(CommonConstants.TEXT_COLOUR);
            taxRegistrationNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create address text field

            taxRegistrationNoField.setBounds(30, 395, 450, 55);
            taxRegistrationNoField.setBackground(CommonConstants.SECONDARY_COLOUR);
            taxRegistrationNoField.setForeground(CommonConstants.TEXT_COLOUR);
            taxRegistrationNoField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(taxRegistrationNoLabel);
            add(taxRegistrationNoField);

            customerResults.add(taxRegistrationNoField);
        }

        // create address label

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 365, 400, 25);
        addressLabel.setForeground(CommonConstants.TEXT_COLOUR);
        addressLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create address text field
        JTextField addressField = new JTextField();
        addressField.setBounds(30, 395, 450, 55);
        addressField.setBackground(CommonConstants.SECONDARY_COLOUR);
        addressField.setForeground(CommonConstants.TEXT_COLOUR);
        addressField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(addressLabel);
        add(addressField);

        if (validationPage3(null, null, String.valueOf(addressField), true, false, false)) {
            staffResults.add(addressField);
            customerResults.add(addressField);
            validP2 = true;
        }

        // create next page button
        JButton toPage4Button = new JButton("Next Page");
        toPage4Button.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        toPage4Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toPage4Button.setBackground(CommonConstants.TEXT_COLOUR);
        toPage4Button.setBounds(125, 520, 250, 50);
        add(toPage4Button);

        // add functionality so that when clicked it will launch the next page GUI
        if (validP1 && validP2 && validP3) {
            toPage4Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // dispose of this page
                    remove(registerLabel);
                    remove(nationalityLabel);
                    remove(nationalityField);
                    remove(dateOfBirthLabel);
                    remove(dateOfBirthField);
                    remove(taxRegistrationNoLabel);
                    remove(taxRegistrationNoField);
                    remove(addressLabel);
                    remove(addressField);
                    remove(toPage4Button);

                    // launch the next page
                    addPage4GuiComponents();
                }
            });
        }


        // create login label (used to load the login GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                RegisterFormGUI.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private void addPage4GuiComponents() {
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

        // create telephone number label
        JLabel telephoneNoLabel = new JLabel("Telephone Number:");
        telephoneNoLabel.setBounds(30, 150, 400, 25);
        telephoneNoLabel.setForeground(CommonConstants.TEXT_COLOUR);
        telephoneNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create telephone number text field
        JTextField telephoneNoField = new JTextField();
        telephoneNoField.setBounds(30, 185, 450, 55);
        telephoneNoField.setBackground(CommonConstants.SECONDARY_COLOUR);
        telephoneNoField.setForeground(CommonConstants.TEXT_COLOUR);
        telephoneNoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(telephoneNoLabel);
        add(telephoneNoField);

        boolean validP1 = false;
        boolean validP2 = false;

        if (validationPage4(null, Integer.valueOf(String.valueOf(telephoneNoField)), null, false, false, true)) {
            staffResults.add(telephoneNoField);
            customerResults.add(telephoneNoField);
            validP1 = true;
        }


        JLabel emergencyContactNoLabel = new JLabel("Emergency Contact Number:");
        JTextField emergencyContactNoField = new JTextField();
        JLabel dateJoinedLabel = new JLabel("Date Joined:");
        JDateChooser dateJoinedField = new JDateChooser();
        JButton toPage5Button = new JButton("Next Page");
        JButton registerButton = new JButton("Register");

        if (!Objects.equals(role, "Customer")) {

            // create emergency contact number label

            emergencyContactNoLabel.setBounds(30, 255, 400, 25);
            emergencyContactNoLabel.setForeground(CommonConstants.TEXT_COLOUR);
            emergencyContactNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create emergency contact number text field

            emergencyContactNoField.setBounds(30, 285, 450, 55);
            emergencyContactNoField.setBackground(CommonConstants.SECONDARY_COLOUR);
            emergencyContactNoField.setForeground(CommonConstants.TEXT_COLOUR);
            emergencyContactNoField.setFont(new Font("Dialog", Font.PLAIN, 24));

            add(emergencyContactNoLabel);
            add(emergencyContactNoField);

            // create date joined label

            dateJoinedLabel.setBounds(30, 365, 400, 25);
            dateJoinedLabel.setForeground(CommonConstants.TEXT_COLOUR);
            dateJoinedLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

            // create date joined field

            dateJoinedField.setBounds(30, 285, 450, 55);
            dateJoinedField.setBackground(CommonConstants.SECONDARY_COLOUR);
            dateJoinedField.setForeground(CommonConstants.TEXT_COLOUR);
            dateJoinedField.setFont(new Font("Dialog", Font.PLAIN, 24));
            dateJoinedField.setLocale(Locale.UK);

            add(dateJoinedLabel);
            add(dateJoinedField);

            if (validationPage4(Date.valueOf(String.valueOf(dateJoinedField)), null, Integer.valueOf(String.valueOf(emergencyContactNoField)), true, true, false)) {
                staffResults.add(emergencyContactNoField);
                staffResults.add(dateJoinedField);
                validP2 = true;
            }


            // create next page button

            toPage5Button.setFont(new Font("Dialog", Font.BOLD, 18));

            // change the cursor to a hand when hover over the button
            toPage5Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            toPage5Button.setBackground(CommonConstants.TEXT_COLOUR);
            toPage5Button.setBounds(125, 520, 250, 50);
            add(toPage5Button);

            // add functionality so that when clicked it will launch the next page GUI
            if (validP1 && validP2) {
                toPage5Button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // dispose of this page
                        remove(registerLabel);
                        remove(telephoneNoLabel);
                        remove(telephoneNoField);
                        remove(emergencyContactNoLabel);
                        remove(emergencyContactNoField);
                        remove(dateJoinedLabel);
                        remove(dateJoinedField);
                        remove(toPage5Button);

                        // launch the next page
                        addPage5GuiComponents();
                    }
                });
            }

        } else {
            // create register button

            registerButton.setFont(new Font("Dialog", Font.BOLD, 18));

            // change the cursor to a hand when hover over the button
            registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            registerButton.setBackground(CommonConstants.TEXT_COLOUR);
            registerButton.setBounds(125, 520, 250, 50);
            add(registerButton);


        }

        // create login label (used to load the login GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                RegisterFormGUI.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private void addPage5GuiComponents() {
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

        boolean validP1 = false;

        // create date left label
        JLabel dateLeftLabel = new JLabel("Date Left:");
        dateLeftLabel.setBounds(30, 150, 400, 25);
        dateLeftLabel.setForeground(CommonConstants.TEXT_COLOUR);
        dateLeftLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create date left text field
        JDateChooser dateLeftField = new JDateChooser();
        dateLeftField.setBounds(30, 285, 450, 55);
        dateLeftField.setBackground(CommonConstants.SECONDARY_COLOUR);
        dateLeftField.setForeground(CommonConstants.TEXT_COLOUR);
        dateLeftField.setFont(new Font("Dialog", Font.PLAIN, 24));
        dateLeftField.setLocale(Locale.UK);

        add(dateLeftLabel);
        add(dateLeftField);

        // create visa status label
        JLabel visaStatusLabel = new JLabel("Is Your Visa Valid:");
        visaStatusLabel.setBounds(30, 255, 400, 25);
        visaStatusLabel.setForeground(CommonConstants.TEXT_COLOUR);
        visaStatusLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create visa status text field
        JCheckBox visaStatusField = new JCheckBox();
        visaStatusField.setBounds(30, 285, 450, 55);
        visaStatusField.setBackground(CommonConstants.SECONDARY_COLOUR);
        visaStatusField.setForeground(CommonConstants.TEXT_COLOUR);
        visaStatusField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(visaStatusLabel);
        add(visaStatusField);

        // create visa issue date label

        JLabel visaIssueDateLabel = new JLabel("Visa Issue Date:");
        visaIssueDateLabel.setBounds(30, 365, 400, 25);
        visaIssueDateLabel.setForeground(CommonConstants.TEXT_COLOUR);
        visaIssueDateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create visa issue date field
        JDateChooser visaIssueDateField = new JDateChooser();
        visaIssueDateField.setBounds(30, 285, 450, 55);
        visaIssueDateField.setBackground(CommonConstants.SECONDARY_COLOUR);
        visaIssueDateField.setForeground(CommonConstants.TEXT_COLOUR);
        visaIssueDateField.setFont(new Font("Dialog", Font.PLAIN, 24));
        visaIssueDateField.setLocale(Locale.UK);

        add(visaIssueDateLabel);
        add(visaIssueDateField);

        if (validationPage5(Date.valueOf(String.valueOf(dateLeftField)), Boolean.valueOf(String.valueOf(visaStatusField)), Date.valueOf(String.valueOf(visaIssueDateField)), true, true, true)) {

            staffResults.add(dateLeftField);
            staffResults.add(visaStatusField);
            staffResults.add(visaIssueDateField);
            validP1 = true;
        }

        // create next page button
        JButton toPage6Button = new JButton("Next Page");
        toPage6Button.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        toPage6Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toPage6Button.setBackground(CommonConstants.TEXT_COLOUR);
        toPage6Button.setBounds(125, 520, 250, 50);
        add(toPage6Button);

        // add functionality so that when clicked it will launch the next page GUI
        if (validP1) {
            toPage6Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // dispose of this page
                    remove(registerLabel);
                    remove(dateLeftLabel);
                    remove(dateLeftField);
                    remove(visaStatusLabel);
                    remove(visaStatusField);
                    remove(visaIssueDateLabel);
                    remove(visaIssueDateField);
                    remove(toPage6Button);

                    // launch the next page
                    addPage6GuiComponents();
                }
            });
        }


        // create login label (used to load the login GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                RegisterFormGUI.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private void addPage6GuiComponents() {
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

        boolean validP1 = false;

        // create visa expiry date label
        JLabel visaExpiryDateLabel = new JLabel("Visa Expiry Date:");
        visaExpiryDateLabel.setBounds(30, 150, 400, 25);
        visaExpiryDateLabel.setForeground(CommonConstants.TEXT_COLOUR);
        visaExpiryDateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create visa expiry date text field
        JDateChooser visaExpiryDateField = new JDateChooser();
        visaExpiryDateField.setBounds(30, 285, 450, 55);
        visaExpiryDateField.setBackground(CommonConstants.SECONDARY_COLOUR);
        visaExpiryDateField.setForeground(CommonConstants.TEXT_COLOUR);
        visaExpiryDateField.setFont(new Font("Dialog", Font.PLAIN, 24));
        visaExpiryDateField.setLocale(Locale.UK);

        add(visaExpiryDateLabel);
        add(visaExpiryDateField);

        // create emirates id number label
        JLabel emiratesIDNoLabel = new JLabel("Emirates ID Number:");
        emiratesIDNoLabel.setBounds(30, 255, 400, 25);
        emiratesIDNoLabel.setForeground(CommonConstants.TEXT_COLOUR);
        emiratesIDNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create emirates id number text field
        JTextField emiratesIDNoField = new JTextField();
        emiratesIDNoField.setBounds(30, 285, 450, 55);
        emiratesIDNoField.setBackground(CommonConstants.SECONDARY_COLOUR);
        emiratesIDNoField.setForeground(CommonConstants.TEXT_COLOUR);
        emiratesIDNoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(emiratesIDNoLabel);
        add(emiratesIDNoField);

        // create health insurance number label

        JLabel healthInsuranceNoLabel = new JLabel("Health Insurance Number:");
        healthInsuranceNoLabel.setBounds(30, 365, 400, 25);
        healthInsuranceNoLabel.setForeground(CommonConstants.TEXT_COLOUR);
        healthInsuranceNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create health insurance number field
        JTextField healthInsuranceNoField = new JTextField();
        healthInsuranceNoField.setBounds(30, 285, 450, 55);
        healthInsuranceNoField.setBackground(CommonConstants.SECONDARY_COLOUR);
        healthInsuranceNoField.setForeground(CommonConstants.TEXT_COLOUR);
        healthInsuranceNoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(healthInsuranceNoLabel);
        add(healthInsuranceNoField);

        if (validationPage6(Date.valueOf(String.valueOf(visaExpiryDateField)), String.valueOf(emiratesIDNoField), String.valueOf(healthInsuranceNoField), true, true, true)) {

            staffResults.add(visaExpiryDateField);
            staffResults.add(emiratesIDNoField);
            staffResults.add(healthInsuranceNoField);
            validP1 = true;
        }

        // create next page button
        JButton toPage7Button = new JButton("Next Page");
        toPage7Button.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        toPage7Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toPage7Button.setBackground(CommonConstants.TEXT_COLOUR);
        toPage7Button.setBounds(125, 520, 250, 50);
        add(toPage7Button);

        // add functionality so that when clicked it will launch the next page GUI
        if (validP1) {
            toPage7Button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // dispose of this page
                    remove(registerLabel);
                    remove(visaExpiryDateLabel);
                    remove(visaExpiryDateField);
                    remove(emiratesIDNoLabel);
                    remove(emiratesIDNoField);
                    remove(healthInsuranceNoLabel);
                    remove(healthInsuranceNoField);
                    remove(toPage7Button);

                    // launch the next page
                    addPage7GuiComponents();
                }
            });
        }

        // create login label (used to load the login GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                RegisterFormGUI.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private void addPage7GuiComponents() {
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

        boolean validP1 = false;

        // create passport number label
        JLabel passportNoLabel = new JLabel("Passport Number:");
        passportNoLabel.setBounds(30, 150, 400, 25);
        passportNoLabel.setForeground(CommonConstants.TEXT_COLOUR);
        passportNoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // create visa expiry date text field
        JTextField passportNoField = new JTextField();
        passportNoField.setBounds(30, 285, 450, 55);
        passportNoField.setBackground(CommonConstants.SECONDARY_COLOUR);
        passportNoField.setForeground(CommonConstants.TEXT_COLOUR);
        passportNoField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passportNoLabel);
        add(passportNoField);

        if (validationPage7(String.valueOf(passportNoField), true)) {
            staffResults.add(passportNoField);
            validP1 = true;
        }

        // create register button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(CommonConstants.TEXT_COLOUR);
        registerButton.setBounds(125, 520, 250, 50);

        if (validP1) {
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // get username
                    String username = (String) staffResults.get(0);

                    // get password
                    String password = (String) staffResults.get(1);

                    // get repassword
                    String repassword = (String) staffResults.get(2);

                    // get firstname
                    String firstName = (String) staffResults.get(3);

                    // get lastname
                    String lastName = (String) staffResults.get(4);

                    // get sex
                    String sex = (String) staffResults.get(5);

                    // get nationality
                    String nationality = (String) staffResults.get(6);

                    // get date of birth
                    Date dateOfBirth = (Date) staffResults.get(7);

                    // get address
                    String address = (String) staffResults.get(8);

                    // get telephone number
                    Integer telephoneNo = (Integer) staffResults.get(9);

                    // get emergency contact number
                    Integer emergencyContactNo = (Integer) staffResults.get(10);

                    // get date joined
                    Date dateJoined = (Date) staffResults.get(11);

                    // get date left
                    Date dateLeft = (Date) staffResults.get(12);

                    // get visa status
                    Boolean visaStatus = (Boolean) staffResults.get(13);

                    // get visa issue date
                    Date visaIssueDate = (Date) staffResults.get(14);

                    // get visaExpiryDate
                    Date visaExpiryDate = (Date) staffResults.get(15);

                    // get emirates ID number
                    String emiratesIDNo = (String) staffResults.get(16);

                    // get health insurance number
                    String healthInsuranceNo = (String) staffResults.get(17);

                    // get passport number
                    String passportNo = (String) staffResults.get(18);
                }
            });
        }
        add(registerButton);


        // create login label (used to load the login GUI)
        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // add functionality so that when clicked it will launch the login form GUI
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                RegisterFormGUI.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);
    }

    private boolean validationPage1(String username, String password, String repassword) {

        // all fields must have a value

        if (username.isEmpty() || password.isEmpty() || repassword.isEmpty()) return false;

        // username has to be at least 4 characters long

        if (username.length() < 4) return false;

        // password and repassword must be the same

        if (!password.equals(repassword)) return false;

        // uses Regex (Regular Expressions) for password validity

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password is less than 8 characters." +
                    "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
            return false;
        } else {
            Pattern letter = Pattern.compile("[a-zA-Z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            if (!hasLetter.find()) {
                JOptionPane.showMessageDialog(this, "Password should contain an upper and lower case character." +
                        "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
                return false;
            }
            if (!hasDigit.find()) {
                JOptionPane.showMessageDialog(this, "Password should contain at least one digit." +
                        "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
                return false;
            }
            if (!hasSpecial.find()) {
                JOptionPane.showMessageDialog(this, "Password should contain at least one special character." +
                        "Password should contain at least 8 characters, an uppercase and lowercase character, a special character and a digit!");
                return false;
            }
            return true;
        }
    }

    private boolean validationPage2(String firstName, String lastName, String sex, Boolean validS, Boolean validF, Boolean validL) {

        // all fields must have a value

        return (!firstName.isEmpty() || !validF) && (!lastName.isEmpty() || !validL) && (!sex.isEmpty() || !validS);
    }

    private boolean validationPage3(String nationality, Date dob, String address, Boolean validA, Boolean validN, Boolean validD) {

        // all fields must have a value

        return (((!nationality.isEmpty() || !validN) && (!dob.equals(null) || !validD) && (!address.isEmpty() || !validA)) && dob.before(Calendar.getInstance().getTime()));
    }

    private boolean validationPage4(Date dateJoined, Integer telephoneNo, Integer emergencyContactNo, Boolean validEC, Boolean validDJ, Boolean validT) {

        // all fields must have a value

        return (((!dateJoined.equals(null) || !validDJ) && (!telephoneNo.equals(null) || !validT) && (!emergencyContactNo.equals(null) || !validEC)) &&
                telephoneNo.toString().length() > 9 && emergencyContactNo.toString().length() > 9 && dateJoined.before(Calendar.getInstance().getTime()));
    }

    private boolean validationPage5(Date dateLeft, Boolean visaStatus, Date visaIssueDate, Boolean validDL, Boolean validVS, Boolean validVID) {

        // all fields must have a value

        return (((!dateLeft.equals(null) || !validDL) && (!visaStatus.equals(null) || !validVS) && (!visaIssueDate.equals(null) || !validVID)) &&
                dateLeft.after((java.util.Date) staffResults.get(11)) && visaIssueDate.before(Calendar.getInstance().getTime()));
    }

    private boolean validationPage6(Date visaExpiryDate, String emiratesIDNo, String healthInsuranceNo, Boolean validVED, Boolean validEIN, Boolean validHIN) {

        // all fields must have a value

        return (((!visaExpiryDate.equals(null) || !validVED) && (!emiratesIDNo.isEmpty() || !validEIN) && (!healthInsuranceNo.isEmpty() || !validHIN)) && visaExpiryDate.after((java.util.Date) staffResults.get(14)));
    }

    private boolean validationPage7(String passportNo, Boolean validPN) {

        // all fields must have a value

        return (!passportNo.isEmpty() || !validPN);
    }

}
