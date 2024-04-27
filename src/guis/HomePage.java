package guis;

import constants.CommonConstants;
import db.MyJDBC;
import guis.registerPages.RegisterPage0;

import javax.swing.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public final class HomePage extends Form implements ActionListener {

    JScrollPane jScrollPane;
    JTable table = new JTable();
    DefaultTableModel model;
    DefaultTableCellRenderer defaultTableCellRenderer;
    JToggleButton staffButton = new JToggleButton("Staff");
    JToggleButton customerButton = new JToggleButton("Customer");
    JToggleButton clientCompaniesButton = new JToggleButton("Client Companies");
    JToggleButton stockButton = new JToggleButton("Stock");
    String selectedTable = RegisterPage0.role;

    public HomePage() {
        super("Home");
        setSize(920, 880);
        setLocationRelativeTo(null);
        addGuiComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == staffButton) {
            if (staffButton.isSelected()) {
                selectedTable = "Staff";
                model = new DefaultTableModel(new String[]{"Username", "Password", "FirstName", "LastName", "Sex", "Nationality", "DateOfBirth", "Address", "RoleDesignation"}, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table.setModel(model);
                table.updateUI();
                MyJDBC.createTable(CommonConstants.DB_STAFF_TABLE, model);
            }
        }
        if (e.getSource() == clientCompaniesButton) {
            if (clientCompaniesButton.isSelected()) {
                selectedTable = "Client Companies";
                model = new DefaultTableModel(new String[]{"CompanyName", "CompanyAddress"}, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table.setModel(model);
                table.updateUI();
                MyJDBC.createTable(CommonConstants.DB_CLIENT_COMPANIES_TABLE, model);
            }
        }
        if (e.getSource() == customerButton) {
            if (customerButton.isSelected()) {
                selectedTable = "Customer";
                model = new DefaultTableModel(new String[]{"Username", "Password", "FirstName", "LastName", "CompanyName", "TaxRegistrationNo"}, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table.setModel(model);
                table.updateUI();
                MyJDBC.createTable(CommonConstants.DB_CUSTOMERS_TABLE, model);
            }
        }
        if (e.getSource() == stockButton) {
            if (stockButton.isSelected()) {
                selectedTable = "Stock";
                model = new DefaultTableModel(new String[]{"ModelNo", "BrandName", "Description", "Quantity", "UnitPrice", "AvailableInStore", "AvailableInOnline", "AvailableInWarehouse"}, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table.setModel(model);
                table.updateUI();
                MyJDBC.createTable(CommonConstants.DB_STOCK_TABLE, model);
            }
        }
    }

    private void addGuiComponents(){

        // create home label
        JLabel homeLabel = new JLabel("Home");

        // configure component's x, y position and width/height values relative to the GUI
        homeLabel.setBounds(0, 25, 920, 100);

        //change the font colour
        homeLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // change the font size
        homeLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // centre text
        homeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add component to GUI
        add(homeLabel);

        // create staff button
        staffButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        staffButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        staffButton.setBackground(CommonConstants.TEXT_COLOUR);
        staffButton.setBounds(30, 185, 190, 55);
        staffButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(staffButton);

        // create client companies button
        clientCompaniesButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        clientCompaniesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clientCompaniesButton.setBackground(CommonConstants.TEXT_COLOUR);
        clientCompaniesButton.setBounds(470, 185, 190, 55);
        clientCompaniesButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(clientCompaniesButton);

        // create customer button
        customerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        customerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        customerButton.setBackground(CommonConstants.TEXT_COLOUR);
        customerButton.setBounds(250, 185, 190, 55);
        customerButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(customerButton);

        // create stock button
        stockButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        stockButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        stockButton.setBackground(CommonConstants.TEXT_COLOUR);
        stockButton.setBounds(690, 185, 190, 55);
        stockButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(stockButton);

        // create a button group so only one button can be toggled at one time
        ButtonGroup roleButtonGroup = new ButtonGroup();
        roleButtonGroup.add(staffButton);
        roleButtonGroup.add(clientCompaniesButton);
        roleButtonGroup.add(customerButton);
        roleButtonGroup.add(stockButton);

        staffButton.addActionListener(this);
        clientCompaniesButton.addActionListener(this);
        customerButton.addActionListener(this);
        stockButton.addActionListener(this);

        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(25, 300, 850, 500);
        jScrollPane.getViewport().setForeground(CommonConstants.TEXT_COLOUR);
        jScrollPane.getViewport().setFont(new Font("Dialog", Font.BOLD, 15));
        jScrollPane.getViewport().setBackground(CommonConstants.SECONDARY_COLOUR);
        jScrollPane.getVerticalScrollBar().setBackground(CommonConstants.TEXT_COLOUR);
        jScrollPane.getHorizontalScrollBar().setBackground(CommonConstants.TEXT_COLOUR);
        getContentPane().add(jScrollPane);

        table.setBounds(25, 300, 850, 225);
        table.setForeground(CommonConstants.TEXT_COLOUR);
        table.setFont(new Font("Dialog", Font.BOLD, 15));
        table.setBackground(CommonConstants.SECONDARY_COLOUR);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(CommonConstants.TEXT_COLOUR);
        table.getTableHeader().setReorderingAllowed(false);

        // test out the table creator
        if (Objects.equals(selectedTable, "Staff")) {
            model = new DefaultTableModel(new String[]{"Username", "Password", "FirstName", "LastName", "Sex", "Nationality", "DateOfBirth", "Address", "RoleDesignation"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table.setModel(model);
        }
        else if (Objects.equals(selectedTable, "Customer")) {
            model = new DefaultTableModel(new String[]{"Username", "Password", "FirstName", "LastName", "CompanyName", "TaxRegistrationNo"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table.setModel(model);
        }
        else if (Objects.equals(selectedTable, "Client Companies")) {
            model = new DefaultTableModel(new String[]{"CompanyName", "CompanyAddress"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table.setModel(model);
        }
        else if (Objects.equals(selectedTable, "Stock")) {
            model = new DefaultTableModel(new String[]{"ModelNo", "BrandName", "Description", "Quantity", "UnitPrice", "AvailableInStore", "AvailableInOnline", "AvailableInWarehouse"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table.setModel(model);
        }

        defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Center the data within the cells
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.setDefaultRenderer(table.getColumnClass(i), defaultTableCellRenderer);
        }
        table.updateUI();
        if (Objects.equals(selectedTable, "Staff")) {
            MyJDBC.createTable(CommonConstants.DB_STAFF_TABLE, model);
        }
        else if (Objects.equals(selectedTable, "Customer")) {
            MyJDBC.createTable(CommonConstants.DB_CUSTOMERS_TABLE, model);
        }
    }
}

