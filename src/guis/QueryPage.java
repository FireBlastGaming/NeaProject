package guis;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class QueryPage extends Form implements ActionListener {
    public QueryPage(String queryName) {
        super("Query");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addGuiComponents(queryName);
    }
    public static String query;
    JLabel searchingLabel = new JLabel("Searching Parameters:");
    JTextField searchingField = new JTextField();
    JLabel sortingLabel = new JLabel("Sorting Parameters:");
    JTextField sortingField = new JTextField();
    JLabel deletingLabel = new JLabel("Deleting Parameters:");
    JTextField deletingField = new JTextField();
    JLabel orderLabel = new JLabel("Order:");
    JTextField orderField = new JTextField();
    JButton searchButton = new JButton("Search");
    JButton sortButton = new JButton("Sort");
    JButton deleteButton = new JButton("Delete");
    JButton orderButton = new JButton("Order");
    public static String orderText;
    
    private void addGuiComponents(String queryName){
        if (Objects.equals(queryName, "Search")) {
            // configure component's x, y position and width/height values relative to the GUI
            searchButton.setBounds(0, 25, 520, 100);

            //change the font colour
            searchButton.setForeground(CommonConstants.TEXT_COLOUR);

            // change the font size
            searchButton.setFont(new Font("Dialog", Font.BOLD, 40));

            // centre text
            searchButton.setHorizontalAlignment(SwingConstants.CENTER);
            searchButton.addActionListener(this);

            // add component to GUI
            add(searchButton);

            // create search label

            searchingLabel.setBounds(0, 150, 520, 25);
            searchingLabel.setForeground(CommonConstants.TEXT_COLOUR);
            searchingLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
            searchingLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // create search field

            searchingField.setBounds(55, 185, 400, 55);
            searchingField.setBackground(CommonConstants.SECONDARY_COLOUR);
            searchingField.setForeground(CommonConstants.TEXT_COLOUR);
            searchingField.setFont(new Font("Dialog", Font.PLAIN, 24));
            searchingField.setHorizontalAlignment(SwingConstants.CENTER);

            add(searchingLabel);
            add(searchingField);
        }
        if (Objects.equals(queryName, "Sort")) {
            // configure component's x, y position and width/height values relative to the GUI
            sortButton.setBounds(0, 25, 520, 100);

            //change the font colour
            sortButton.setForeground(CommonConstants.TEXT_COLOUR);

            // change the font size
            sortButton.setFont(new Font("Dialog", Font.BOLD, 40));

            // centre text
            sortButton.setHorizontalAlignment(SwingConstants.CENTER);
            sortButton.addActionListener(this);

            // add component to GUI
            add(sortButton);

            // create sort label

            sortingLabel.setBounds(0, 150, 520, 25);
            sortingLabel.setForeground(CommonConstants.TEXT_COLOUR);
            sortingLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
            sortingLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // create sort field

            sortingField.setBounds(55, 185, 400, 55);
            sortingField.setBackground(CommonConstants.SECONDARY_COLOUR);
            sortingField.setForeground(CommonConstants.TEXT_COLOUR);
            sortingField.setFont(new Font("Dialog", Font.PLAIN, 24));
            sortingField.setHorizontalAlignment(SwingConstants.CENTER);

            add(sortingLabel);
            add(sortingField);
        }
        if (Objects.equals(queryName, "Delete")) {

            // configure component's x, y position and width/height values relative to the GUI
            deleteButton.setBounds(0, 25, 520, 100);

            //change the font colour
            deleteButton.setForeground(CommonConstants.TEXT_COLOUR);

            // change the font size
            deleteButton.setFont(new Font("Dialog", Font.BOLD, 40));

            // centre text
            deleteButton.setHorizontalAlignment(SwingConstants.CENTER);
            deleteButton.addActionListener(this);

            // add component to GUI
            add(deleteButton);

            // create delete label

            deletingLabel.setBounds(0, 150, 520, 25);
            deletingLabel.setForeground(CommonConstants.TEXT_COLOUR);
            deletingLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
            deletingLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // create delete field

            deletingField.setBounds(55, 185, 400, 55);
            deletingField.setBackground(CommonConstants.SECONDARY_COLOUR);
            deletingField.setForeground(CommonConstants.TEXT_COLOUR);
            deletingField.setFont(new Font("Dialog", Font.PLAIN, 24));
            deletingField.setHorizontalAlignment(SwingConstants.CENTER);

            add(deletingLabel);
            add(deletingField);
        }
        else if (Objects.equals(queryName, "Order")){

            // configure component's x, y position and width/height values relative to the GUI
            orderButton.setBounds(0, 25, 520, 100);

            //change the font colour
            orderButton.setForeground(CommonConstants.TEXT_COLOUR);

            // change the font size
            orderButton.setFont(new Font("Dialog", Font.BOLD, 40));

            // centre text
            orderButton.setHorizontalAlignment(SwingConstants.CENTER);
            orderButton.addActionListener(this);

            // add component to GUI
            add(orderButton);

            // create order label

            orderLabel.setBounds(0, 150, 520, 25);
            orderLabel.setForeground(CommonConstants.TEXT_COLOUR);
            orderLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
            orderLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // create order field

            orderField.setBounds(55, 185, 400, 55);
            orderField.setBackground(CommonConstants.SECONDARY_COLOUR);
            orderField.setForeground(CommonConstants.TEXT_COLOUR);
            orderField.setFont(new Font("Dialog", Font.PLAIN, 24));
            orderField.setHorizontalAlignment(SwingConstants.CENTER);

            add(orderLabel);
            add(orderField);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton){
            query = searchingField.getText();
            try {
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                        CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

                PreparedStatement que = connection.prepareStatement(query);
                ResultSet resultSet = que.executeQuery();
                if (Objects.equals(HomePage.selectedTable, "Staff")) {
                    while (resultSet.next()) {
                        String u;
                        String p;
                        String f;
                        String l;
                        String s;
                        String n;
                        String d;
                        String a;
                        String r;
                        try {
                            u = resultSet.getString("Username");
                        } catch (SQLException k ) {
                            u = "";
                        }
                        try {
                            p = resultSet.getString("Password");
                        } catch (SQLException q){
                            p = "";
                        }
                        try {
                            f = resultSet.getString("FirstName");
                        } catch (SQLException q){
                            f = "";
                        }
                        try {
                            l = resultSet.getString("LastName");
                        } catch (SQLException q){
                            l = "";
                        }
                        try {
                            s = resultSet.getString("Sex");
                        } catch (SQLException q){
                            s = "";
                        }
                        try {
                            n = resultSet.getString("Nationality");
                        } catch (SQLException q){
                            n = "";
                        }
                        try {
                            d = resultSet.getString("DateOfBirth");
                        } catch (SQLException q){
                            d = "";
                        }
                        try {
                            a = resultSet.getString("Address");
                        } catch (SQLException q){
                            a = "";
                        }
                        try {
                            r = resultSet.getString("RoleDesignation");
                        } catch (SQLException q){
                            r = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                            HomePage.model.addRow(new Object[]{u, p, f, l, s, n, d, a, r});
                    }
                } else if (Objects.equals(HomePage.selectedTable, "Customer")) {
                    while (resultSet.next()) {
                        String u;
                        String p;
                        String f;
                        String l;
                        String c;
                        String t;
                        try {
                            u = resultSet.getString("Username");
                        } catch (SQLException k ) {
                            u = "";
                        }
                        try {
                            p = resultSet.getString("Password");
                        } catch (SQLException q){
                            p = "";
                        }
                        try {
                            f = resultSet.getString("FirstName");
                        } catch (SQLException q){
                            f = "";
                        }
                        try {
                            l = resultSet.getString("LastName");
                        } catch (SQLException q){
                            l = "";
                        }
                        try {
                            c = resultSet.getString("CompanyName");
                        } catch (SQLException q){
                            c = "";
                        }
                        try {
                            t = resultSet.getString("TaxRegistrationNo");
                        } catch (SQLException q){
                            t = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                        HomePage.model.addRow(new Object[]{u, p, f, l, c, t});
                    }
                }else if (Objects.equals(HomePage.selectedTable, "Client Companies")) {
                    while (resultSet.next()) {
                        String c;
                        String cA;
                        try {
                            c = resultSet.getString("CompanyName");
                        } catch (SQLException q){
                            c = "";
                        }
                        try {
                            cA = resultSet.getString("CompanyAddress");
                        } catch (SQLException q){
                            cA = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                        HomePage.model.addRow(new Object[]{c, cA});
                    }
                }else if (Objects.equals(HomePage.selectedTable, "Stock")) {
                    while (resultSet.next()) {
                        String m;
                        String b;
                        String qu;
                        String d;
                        String u;
                        String s;
                        String o;
                        String w;
                        try {
                            m = resultSet.getString("ModelNo");
                        } catch (SQLException q){
                            m = "";
                        }
                        try {
                            b = resultSet.getString("BrandName");
                        } catch (SQLException q){
                            b = "";
                        }
                        try {
                            d = resultSet.getString("Description");
                        } catch (SQLException q){
                            d = "";
                        }
                        try {
                            qu = resultSet.getString("Quantity");
                        } catch (SQLException q){
                            qu = "";
                        }
                        try {
                            u = resultSet.getString("UnitPrice");
                        } catch (SQLException q){
                            u   = "";
                        }
                        try {
                            s = resultSet.getString("AvailableInStore");
                        } catch (SQLException q){
                            s = "";
                        }
                        try {
                            o = resultSet.getString("AvailableInOnline");
                        } catch (SQLException q){
                            o = "";
                        }
                        try {
                            w = resultSet.getString("AvailableInWarehouse");
                        } catch (SQLException q){
                            w = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                        HomePage.model.addRow(new Object[]{m, b, d, qu, u, s, o, w});
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            QueryPage.this.dispose();
        }
        if (e.getSource() == sortButton){
            query = sortingField.getText();
            try {
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                        CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

                PreparedStatement que = connection.prepareStatement(query);
                ResultSet resultSet = que.executeQuery();
                if (Objects.equals(HomePage.selectedTable, "Staff")) {
                    while (resultSet.next()) {
                        String u;
                        String p;
                        String f;
                        String l;
                        String s;
                        String n;
                        String d;
                        String a;
                        String r;
                        try {
                            u = resultSet.getString("Username");
                        } catch (SQLException k ) {
                            u = "";
                        }
                        try {
                            p = resultSet.getString("Password");
                        } catch (SQLException q){
                            p = "";
                        }
                        try {
                            f = resultSet.getString("FirstName");
                        } catch (SQLException q){
                            f = "";
                        }
                        try {
                            l = resultSet.getString("LastName");
                        } catch (SQLException q){
                            l = "";
                        }
                        try {
                            s = resultSet.getString("Sex");
                        } catch (SQLException q){
                            s = "";
                        }
                        try {
                            n = resultSet.getString("Nationality");
                        } catch (SQLException q){
                            n = "";
                        }
                        try {
                            d = resultSet.getString("DateOfBirth");
                        } catch (SQLException q){
                            d = "";
                        }
                        try {
                            a = resultSet.getString("Address");
                        } catch (SQLException q){
                            a = "";
                        }
                        try {
                            r = resultSet.getString("RoleDesignation");
                        } catch (SQLException q){
                            r = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                        HomePage.model.addRow(new Object[]{u, p, f, l, s, n, d, a, r});
                    }
                } else if (Objects.equals(HomePage.selectedTable, "Customer")) {
                    while (resultSet.next()) {
                        String u;
                        String p;
                        String f;
                        String l;
                        String c;
                        String t;
                        try {
                            u = resultSet.getString("Username");
                        } catch (SQLException k ) {
                            u = "";
                        }
                        try {
                            p = resultSet.getString("Password");
                        } catch (SQLException q){
                            p = "";
                        }
                        try {
                            f = resultSet.getString("FirstName");
                        } catch (SQLException q){
                            f = "";
                        }
                        try {
                            l = resultSet.getString("LastName");
                        } catch (SQLException q){
                            l = "";
                        }
                        try {
                            c = resultSet.getString("CompanyName");
                        } catch (SQLException q){
                            c = "";
                        }
                        try {
                            t = resultSet.getString("TaxRegistrationNo");
                        } catch (SQLException q){
                            t = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                        HomePage.model.addRow(new Object[]{u, p, f, l, c, t});
                    }
                }else if (Objects.equals(HomePage.selectedTable, "Client Companies")) {
                    while (resultSet.next()) {
                        String c;
                        String cA;
                        try {
                            c = resultSet.getString("CompanyName");
                        } catch (SQLException q){
                            c = "";
                        }
                        try {
                            cA = resultSet.getString("CompanyAddress");
                        } catch (SQLException q){
                            cA = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                        HomePage.model.addRow(new Object[]{c, cA});
                    }
                }else if (Objects.equals(HomePage.selectedTable, "Stock")) {
                    while (resultSet.next()) {
                        String m;
                        String b;
                        String qu;
                        String d;
                        String u;
                        String s;
                        String o;
                        String w;
                        try {
                            m = resultSet.getString("ModelNo");
                        } catch (SQLException q){
                            m = "";
                        }
                        try {
                            b = resultSet.getString("BrandName");
                        } catch (SQLException q){
                            b = "";
                        }
                        try {
                            d = resultSet.getString("Description");
                        } catch (SQLException q){
                            d = "";
                        }
                        try {
                            qu = resultSet.getString("Quantity");
                        } catch (SQLException q){
                            qu = "";
                        }
                        try {
                            u = resultSet.getString("UnitPrice");
                        } catch (SQLException q){
                            u   = "";
                        }
                        try {
                            s = resultSet.getString("AvailableInStore");
                        } catch (SQLException q){
                            s = "";
                        }
                        try {
                            o = resultSet.getString("AvailableInOnline");
                        } catch (SQLException q){
                            o = "";
                        }
                        try {
                            w = resultSet.getString("AvailableInWarehouse");
                        } catch (SQLException q){
                            w = "";
                        }
                        for (int i = 0; i < HomePage.model.getRowCount(); i++) {
                            HomePage.model.removeRow(i);
                        }
                        HomePage.model.addRow(new Object[]{m, b, d, qu, u, s, o, w});
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            QueryPage.this.dispose();
        }
        if (e.getSource() == deleteButton){
            query = deletingField.getText();
            try {
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                        CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

                PreparedStatement que = connection.prepareStatement(query);
                que.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            QueryPage.this.dispose();
        }
        if (e.getSource() == orderButton){
            orderText = orderField.getText();
            new NotificationPanel(orderText).setVisible(true);
            QueryPage.this.dispose();
        }
    }
}
