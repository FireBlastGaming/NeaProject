package guis.registerPages;

import constants.CommonConstants;
import guis.Form;
import guis.LoginFormGUI;

import javax.swing.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class RegisterPage0 extends Form implements ActionListener {

    public static String role = "";

    // initialize components
    JToggleButton staffButton = new JToggleButton("Staff");
    JToggleButton managerButton = new JToggleButton("Manager");
    JToggleButton customerButton = new JToggleButton("Customer");

    public RegisterPage0() {
        super("Register");
        addPage0GuiComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == staffButton) {
            if (staffButton.isSelected()) {
                role = "Staff";
            }
        }
        if (e.getSource() == managerButton) {
            if (managerButton.isSelected()) {
                role = "Manager";
            }
        }
        if (e.getSource() == customerButton) {
            if (customerButton.isSelected()) {
                role = "Customer";
            }
        }
    }

    private void addPage0GuiComponents () {
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
        staffButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        staffButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        staffButton.setBackground(CommonConstants.TEXT_COLOUR);
        staffButton.setBounds(30, 185, 450, 55);
        staffButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(staffButton);

        // create manager button
        managerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        managerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        managerButton.setBackground(CommonConstants.TEXT_COLOUR);
        managerButton.setBounds(30, 285, 450, 55);
        managerButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(managerButton);

        // create customer button
        customerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        customerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        customerButton.setBackground(CommonConstants.TEXT_COLOUR);
        customerButton.setBounds(30, 395, 450, 55);
        customerButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(customerButton);

        // create a button group so only one button can be toggled at one time
        ButtonGroup roleButtonGroup = new ButtonGroup();
        roleButtonGroup.add(staffButton);
        roleButtonGroup.add(managerButton);
        roleButtonGroup.add(customerButton);

        staffButton.addActionListener(this);
        managerButton.addActionListener(this);
        customerButton.addActionListener(this);


        // create next page button
        JButton toPage1Button = new JButton("Next page");
        toPage1Button.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        toPage1Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toPage1Button.setBackground(CommonConstants.TEXT_COLOUR);
        toPage1Button.setBounds(125, 520, 250, 50);
        add(toPage1Button);

        // add functionality so that when clicked it will launch the next page GUI
        toPage1Button.addActionListener(e -> {
            // dispose of this page
            RegisterPage0.this.dispose();

            // launch the next page
            new RegisterPage1().setVisible(true);
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
                RegisterPage0.this.dispose();

                // launch the login GUI
                new LoginFormGUI().setVisible(true);

            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);

    }
}
