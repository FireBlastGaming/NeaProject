package db;

import constants.CommonConstants;

import java.sql.*;
import java.util.Objects;

// JDBC - Java Database Connectivity
// this class will be our gateway in accessing our MYSQL database
@SuppressWarnings("ALL")
public class MyJDBC {

    // initialize the tables
    public static boolean checkTable(String table){
        try{
            // connects to the database
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

            PreparedStatement checkTableExists = connection.prepareStatement(
                    " SELECT EXISTS (" +
                            "SELECT * " +
                            " FROM information_schema.tables " +
                            " WHERE table_schema = 'nea_project_schema' " +
                            " AND table_name = ? )"
            );
            checkTableExists.setString(1, table);


            ResultSet resultSet = checkTableExists.executeQuery();
            resultSet.next();
            String checkTableResult = resultSet.getString(1);


            // checks to see if the table exists
            // if it doesn't then it calls the createStaffTable method
            if (Objects.equals(checkTableResult, "0")){
                if (Objects.equals(table, "STAFF")){
                    createStaffTable();
                } else if (Objects.equals(table, "CUSTOMERS")) {
                    createCustomersTable();
                } else if (Objects.equals(table, "CLIENT_COMPANIES")) {
                    createClientCompaniesTable();
                } else if (Objects.equals(table, "STOCK")) {
                    createStockTable();
                }
                return true;
            }
            else {
                System.out.println("Table already exists...");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    // create the staff table
    public static void createStaffTable (){
        // open a connection
        try(Connection conn = DriverManager.getConnection(CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            Statement createTableQuery = conn.createStatement();
        ) {
            String tableQuery = "CREATE TABLE staff " +
                    "(Username VARCHAR(50) NOT NULL, " +
                    " Password VARCHAR(50) NOT NULL, " +
                    " FirstName VARCHAR(25) NOT NULL, " +
                    " LastName VARCHAR(25) NOT NULL, " +
                    " Sex VARCHAR(6) NOT NULL, " +
                    " Nationality VARCHAR(50) NOT NULL, " +
                    " DateOfBirth DATE NOT NULL, " +
                    " Address VARCHAR(100) NOT NULL, " +
                    " TelephoneNo INTEGER NOT NULL, " +
                    " EmergencyContactNo INTEGER NOT NULL, " +
                    " RoleDesignation VARCHAR(10) NOT NULL, " +
                    " DateJoined DATE NOT NULL, " +
                    " DateLeft DATE NOT NULL, " +
                    " VisaStatus BOOL NOT NULL, " +
                    " VisaIssueDate DATE NOT NULL, " +
                    " VisaExpiryDate DATE NOT NULL, " +
                    " EmiratesIDNo VARCHAR(30) NOT NULL, " +
                    " HealthInsuranceNo VARCHAR(35) NOT NULL, " +
                    " PassportNo VARCHAR(35) NOT NULL, " +
                    " PRIMARY KEY(Username))";

            createTableQuery.executeUpdate(tableQuery);
            System.out.println("Created staff table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // create the customers table
    public static void createCustomersTable (){
        // open a connection
        try(Connection conn = DriverManager.getConnection(CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            Statement createTableQuery = conn.createStatement();
        ) {
            String tableQuery = "CREATE TABLE customers " +
                    "(Username VARCHAR(50) NOT NULL, " +
                    " Password VARCHAR(50) NOT NULL, " +
                    " FirstName VARCHAR(25) NOT NULL, " +
                    " LastName VARCHAR(25) NOT NULL, " +
                    " Address VARCHAR(100) NOT NULL, " +
                    " TelephoneNo INTEGER NOT NULL, " +
                    " CompanyName VARCHAR(50) NOT NULL, " +
                    " TaxRegistrationNo VARCHAR(50) NOT NULL, " +
                    " PRIMARY KEY(USERNAME), " +
                    " FOREIGN KEY(CompanyName) REFERENCES client_companies(CompanyName))";

            createTableQuery.executeUpdate(tableQuery);
            System.out.println("Created customer table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // create the customers table
    public static void createClientCompaniesTable (){
        // open a connection
        try(Connection conn = DriverManager.getConnection(CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            Statement createTableQuery = conn.createStatement();
        ) {
            String tableQuery = "CREATE TABLE client_companies " +
                    "(CompanyName VARCHAR(50) NOT NULL, " +
                    " CompanyAddress VARCHAR(100) NOT NULL, " +
                    " PRIMARY KEY(CompanyName))";

            createTableQuery.executeUpdate(tableQuery);
            System.out.println("Created client companies table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // create the stock table
    public static void createStockTable (){
        // open a connection
        try(Connection conn = DriverManager.getConnection(CommonConstants.DB_URL,
                CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            Statement createTableQuery = conn.createStatement();
        ) {
            String tableQuery = "CREATE TABLE stock " +
                    "(ModelNo VARCHAR(50) NOT NULL, " +
                    " BrandName VARCHAR(30) NOT NULL, " +
                    " Description VARCHAR(500), " +
                    " Quantity INTEGER NOT NULL, " +
                    " UnitPrice DECIMAL(19,4) NOT NULL, " +
                    " AvailableInStore BOOL NOT NULL, " +
                    " AvailableInOnline BOOL NOT NULL, " +
                    " AvailableInWarehouse BOOL NOT NULL, " +
                    " PRIMARY KEY(ModelNo))";

            createTableQuery.executeUpdate(tableQuery);
            System.out.println("Created stock table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // register new user to the database
    // true - register success
    // false - register failure


    public static boolean register(String username, String password){
        return false;
    }

    // check if user already exists in the database
    // false - user doesn't exist
    // true - user exists in the database
    public static boolean checkUser(String username){
        try{
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstants.DB_STAFF_TABLE +
                            " WHERE USERNAME = ?"
            );
            checkUserExists.setString(1, username);

            ResultSet resultSet = checkUserExists.executeQuery();

            // check to see if the result set is empty
            // if it is empty it means that there was no data row that contains the username
            // (i.e. user does not exist)
            if(!resultSet.isBeforeFirst()){
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;

    }
}
