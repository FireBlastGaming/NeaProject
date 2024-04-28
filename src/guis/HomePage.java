package guis;

import constants.CommonConstants;
import db.MyJDBC;
import guis.registerPages.RegisterPage0;

import javax.swing.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


public final class HomePage extends Form implements ActionListener, WindowListener {

    JScrollPane jScrollPane;
    JTable table = new JTable();
    JLabel shopImage;
    JLabel notifImage;
    JLabel homeImage;
    static DefaultTableModel model;
    DefaultTableCellRenderer defaultTableCellRenderer;
    JToggleButton staffButton = new JToggleButton("Staff");
    JToggleButton customerButton = new JToggleButton("Customer");
    JToggleButton clientCompaniesButton = new JToggleButton("Client Companies");
    JToggleButton stockButton = new JToggleButton("Stock");
    JButton searchButton = new JButton("Search");
    JButton sortButton = new JButton("Sort");
    JButton deleteButton = new JButton("Delete");
    JButton orderButton = new JButton("Order");
    static String selectedTable = RegisterPage0.role;
    public HomePage() {
        super("Home");
        setSize(920, 880);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        addGuiComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == staffButton) {
            if (!Objects.equals(RegisterPage0.role, "Customer")) {
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
            else {JOptionPane.showMessageDialog(this, "Do not have the perms! Sorry!");}
        }
        if (e.getSource() == clientCompaniesButton) {
            if (!Objects.equals(RegisterPage0.role, "Customer")) {
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
            else {JOptionPane.showMessageDialog(this, "Do not have the perms! Sorry!");}
        }
        if (e.getSource() == customerButton) {
            if (!Objects.equals(RegisterPage0.role, "Customer")) {
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
            else {JOptionPane.showMessageDialog(this, "Do not have the perms! Sorry!");}
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
        if (e.getSource() == searchButton){
            new QueryPage("Search").setVisible(true);
            table.updateUI();
        }
        if (e.getSource() == sortButton){
            new QueryPage("Sort").setVisible(true);
            table.updateUI();
        }
        if (e.getSource() == deleteButton){
            if (!Objects.equals(RegisterPage0.role, "Customer")) {
                new QueryPage("Delete").setVisible(true);
                table.updateUI();
            }
            else {JOptionPane.showMessageDialog(this, "Do not have the perms! Sorry!");}
        }
        if (e.getSource() == orderButton){
            new QueryPage("Order").setVisible(true);
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

        // create shop button
        shopImage = new JLabel(new ImageIcon("src/resources/shopIcon.png"));
        shopImage.setBounds(845, 15, 40, 50);
        shopImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                remove(homeLabel);
                remove(shopImage);
                remove(notifImage);
                remove(staffButton);
                remove(customerButton);
                remove(clientCompaniesButton);
                remove(stockButton);

                // launch the shop page
                addGuiComponentsShop();
                repaint();

            }
        });
        add(shopImage);

        // create notification panel button
        notifImage = new JLabel(new ImageIcon("src/resources/notifIcon.png"));
        notifImage.setBounds(800, 15, 40, 50);
        notifImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // launch the notif page
                new NotificationPanel("").setVisible(true);
                repaint();
            }
        });
        add(notifImage);

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

    private void addGuiComponentsShop(){
        // create shop label
        JLabel shopLabel = new JLabel("Shop");

        // configure component's x, y position and width/height values relative to the GUI
        shopLabel.setBounds(0, 25, 920, 100);

        //change the font colour
        shopLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // change the font size
        shopLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // centre text
        shopLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add component to GUI
        add(shopLabel);

        // create home button
        homeImage = new JLabel(new ImageIcon("src/resources/homeIcon.png"));
        homeImage.setBounds(845, 15, 40, 50);
        homeImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose of this GUI
                remove(shopLabel);
                remove(homeImage);
                remove(searchButton);
                remove(sortButton);
                remove(deleteButton);
                remove(orderButton);
                // launch the home page
                addGuiComponents();
                repaint();
            }
        });
        add(homeImage);

        // create search button
        searchButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBackground(CommonConstants.TEXT_COLOUR);
        searchButton.setBounds(30, 185, 190, 55);
        searchButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(searchButton);

        // create sort button
        sortButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        sortButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sortButton.setBackground(CommonConstants.TEXT_COLOUR);
        sortButton.setBounds(470, 185, 190, 55);
        sortButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(sortButton);

        // create customer button
        deleteButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.setBackground(CommonConstants.TEXT_COLOUR);
        deleteButton.setBounds(250, 185, 190, 55);
        deleteButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(deleteButton);

        // create order button
        orderButton.setFont(new Font("Dialog", Font.BOLD, 18));

        // change the cursor to a hand when hover over the button
        orderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        orderButton.setBackground(CommonConstants.TEXT_COLOUR);
        orderButton.setBounds(690, 185, 190, 55);
        orderButton.setUI(new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return CommonConstants.SECONDARY_COLOUR;
            }
        });
        add(orderButton);
        add(notifImage);

        searchButton.addActionListener(this);
        sortButton.addActionListener(this);
        deleteButton.addActionListener(this);
        orderButton.addActionListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(this, "Welcome " + LoginFormGUI.username + "!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException k) {
            Thread.currentThread().interrupt();
        }
        table.updateUI();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(this, "Saving...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException k) {
            Thread.currentThread().interrupt();
        }
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException k) {
            Thread.currentThread().interrupt();
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}

