package javaApi.utilities;

import com.aventstack.extentreports.Status;
import javaApi.test.TestBaseBrowser;

import java.sql.*;

public class DatabaseUtil extends TestBaseBrowser {

    public static String query1 = "select * from employer where employerName ='keshav';";
    public static Connection connection = null;
    public static Statement stmt;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;



    public static String selectQuery(String QUERY) throws SQLException{

        String dbOutput = null;
        stmt = connection.createStatement();
        resultSet = stmt.executeQuery(QUERY);
        //int count = stmt.executeUpdate(QUERY);

        while ( resultSet.next()) {
            dbOutput = resultSet.getString(1);
            System.out.println("Output: " + resultSet.getString(1));
            Reporter.test.log(Status.INFO,"Output: " + resultSet.getString(1));
            //System.out.println("Row update count :: "+count);
        }
        //resultSet.close();


        return dbOutput;
    }

    public static String selectQuery1(String QUERY) throws SQLException{

        String dbOutput = null;
        //preparedStatement = connection.createStatement();
        resultSet = preparedStatement.executeQuery(QUERY);
        //int count = stmt.executeUpdate(QUERY);

        while ( resultSet.next()) {
            dbOutput = resultSet.getString(1);
            System.out.println("Output: " + resultSet.getString(1));
            Reporter.test.log(Status.INFO,"Output: " + resultSet.getString(1));
            //System.out.println("Row update count :: "+count);
        }
        //resultSet.close();


        return dbOutput;
    }

    public static void closeResultSet(){

        try {
            resultSet.close();
            System.out.println("Result set Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(){

        try {
            stmt.close();
            System.out.println("Statement Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try
        {
            if(connection != null)
                connection.close();
            System.out.println("Connection closed !!");
            Reporter.test.log(Status.PASS,"Connection closed !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void getDriver(){

        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try {
                Class.forName("com.mysql.jdbc.Driver");
            }
        catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found !!");
                Reporter.test.log(Status.ERROR,"MySQL JDBC Driver not found !!");
                return;
            }

        System.out.println("MySQL JDBC Driver Registered!");
        Reporter.test.log(Status.INFO,"MySQL JDBC Driver Registered!");

    }

    public static void establishConnection(String DATABASE_URL,String DATABASE_USERNAME, String DATABASE_PASSWORD, String QUERY){
        try {
            connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);

            System.out.println("SQL Connection to database established!");
            Reporter.test.log(Status.PASS,"SQL Connection to database established!");

            //selectQuery(QUERY);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            Reporter.test.log(Status.ERROR,"Connection Failed! Check output console");
            return;
        }
    }

    public static String Sample(String query) throws Exception{

        getDriver();
        Thread.sleep(50000);
        establishConnection(GlobalVars.DATABASE_URL,GlobalVars.DATABASE_USERNAME, GlobalVars.DATABASE_PASSWORD,query);
        System.out.println("Hit Query");
        Thread.sleep(50000);
        String dbOutput = selectQuery(query);
        System.out.println("???????????????????>"+dbOutput);
        closeResultSet();
        closeStatement();
        closeConnection();

        return dbOutput;

    }

}
