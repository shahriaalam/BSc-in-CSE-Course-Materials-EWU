package tamas.a321.ecse.ca.persistence;
import java.sql.*;

public class StudentRecordPersistence {
    static String[] student_password = new String[20];
    static String[] student_email = new String[20];
    static String[] student_status = new String[20];
    static String[] student_lname = new String[20];
    static String[] student_fname = new String[20];
    static int[] student_id = new int[20];

    // define db access key
    static String dbURL = "jdbc:mysql://jamesgtang.com:3306/TAMAS_ECSE321";
    static String user = "TAMAS_DATA_ADMIN";
    static String pass = "ECSE_ADMIN";

    // submit an application to database, must the input be checked before calling this function
    public static int registerStudentToDB(int id, String first_name, String last_name, String status, String email, String password) {

        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql = "INSERT INTO StudentRecord "
                    + " (STUDENT_ID ,FNAME ,LNAME ,STATUS , EMAIL ,PASSWORD)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, id);
            mystatement.setString(2, first_name);
            mystatement.setString(3, last_name);
            mystatement.setString(4, status);
            mystatement.setString(5, email);
            mystatement.setString(6, password);
            mystatement.executeUpdate();

            System.out.println("Update Success! ");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            return 1;
        }
        return 0;
    }

    public static String getStudentPasswordByID(int student_ID) {
        // keep track of the the size of the ResultSet
        int i = 0;
        int size;
        String pwd = null;
        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql = "SELECT * FROM  StudentRecord WHERE STUDENT_ID=?";
            PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, student_ID);
            ResultSet myResultSet = mystatement.executeQuery();

            while (myResultSet.next()) {
                student_password[0] = myResultSet.getString("PASSWORD");
                i++;
            }
            size = i;
            //System.out.println("The password is "+student_password[0]);
            //System.out.println("The size of the the dataset is "+size);
            pwd = student_password[0];
            System.out.println("Get Success! ");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            return pwd;
        }
        return pwd;
    }

    public static String getStudentEmailByID(int student_ID) {
        String email = null;
        int i = 0;
        int size;
        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql = "SELECT * FROM  StudentRecord WHERE STUDENT_ID=?";
            PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, student_ID);
            ResultSet myResultSet = mystatement.executeQuery();

            while (myResultSet.next()) {
                student_email[0] = myResultSet.getString("EMAIL");
                i++;
            }
            size = i;
            //System.out.println("The password is "+student_password[0]);
            //System.out.println("The size of the the dataset is "+size);
            email = student_email[0];
            System.out.println("Get Success! ");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            return email;
        }
        return email;
    }

    public static String getStudentNameByID(int student_ID) {
        String fullname = null;
        int i = 0;
        int size;
        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql = "SELECT * FROM  StudentRecord WHERE STUDENT_ID=?";
            PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, student_ID);
            ResultSet myResultSet = mystatement.executeQuery();

            while (myResultSet.next()) {
                student_fname[i] = myResultSet.getString("FNAME");
                student_lname[i] = myResultSet.getString("LNAME");
                i++;
            }
            size = i;
            //System.out.println("The password is "+student_password[0]);
            //System.out.println("The size of the the dataset is "+size);
            fullname = student_fname[0] + " " + student_lname[0];
            System.out.println("Get Success! ");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            return fullname;
        }
        return fullname;
    }

    public static String getStudentStatusByID(int student_ID) {
        String status = null;
        int i = 0;
        int size;
        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql = "SELECT * FROM  StudentRecord WHERE STUDENT_ID=?";
            PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, student_ID);
            ResultSet myResultSet = mystatement.executeQuery();

            while (myResultSet.next()) {
                student_status[i] = myResultSet.getString("STATUS");
                i++;
            }
            size = i;
            //System.out.println("The password is "+student_password[0]);
            //System.out.println("The size of the the dataset is "+size);
            status = student_status[0];
            System.out.println("Get Success! ");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            return status;
        }
        return status;
    }
    /* for testing the methods
    public static void main(String[] args) {
        /* test methods
         //registerStudentToDB(12312021, "James", "Java", "UGRAD","Jame.java@java.com", "jamesjava123");
        s
        String pwd=getStudentPasswordByID(13124);
        System.out.println(pwd);
        
        String email=getStudentEmailByID(13124);
        System.out.println(email);
        
        String fullname=getStudentNameByID(13124);
        System.out.println(fullname);
        
        String status=getStudentStatusByID(13124);
        System.out.println(status);
    }*/
}
