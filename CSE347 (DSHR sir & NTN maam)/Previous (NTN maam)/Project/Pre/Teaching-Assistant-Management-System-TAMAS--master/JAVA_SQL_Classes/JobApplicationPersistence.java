package tamas.a321.ecse.ca.persistence;

import java.sql.*;

public class  JobApplicationPersistence {
    static String[] applicanty_cv=new String[20];
    static String[] applicant_first_name=new String[20];
    static String[] applicant_last_name=new String[20];
    static String[] applicant_status=new String[20];
    static String[] applicant_email=new String[20];
    static int[] job_id=new int[20];
    static int[] applicant_id=new int[20];

    // define db access key
    static String dbURL="jdbc:mysql://jamesgtang.com:3306/TAMAS_ECSE321";
    static String user="TAMAS_DATA_ADMIN";
    static String pass= "ECSE_ADMIN";

    // submit an application to database, must the input be checked before calling this function
    private static int submitToDB( int applicant_id,int job_id,String fname,String lname,String email,String status, String cv){

        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql="INSERT INTO ApplicationData "
                    + " (APPLICANT_ID ,APPLICANT_FNAME ,APPLICANT_LNAME ,JOB_POSTING_ID ,CV ,APPLICANT_EMAIL,STATUS)"
                    + " VALUES (?, ?,?,?,?,?,?)";
            PreparedStatement mystatement=myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, applicant_id);
            mystatement.setString(2, fname);
            mystatement.setString(3, lname);
            mystatement.setInt(4, job_id);
            mystatement.setString(5, cv);
            mystatement.setString(6, email);
            mystatement.setString(7, status);
            mystatement.executeUpdate();

            System.out.println("Update Success! ");
        }catch (SQLException e){
            System.out.println("Connection failed");
            return 1;
        }
        return 0;
    }
    // retrieve application by student ID
    private static int getApplicationByStudentID(int student_ID){
        // keep track of the the size of the ResultSet
        int i=0;int size;
        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql="SELECT * FROM  ApplicationData WHERE APPLICANT_ID=?";
            PreparedStatement mystatement=myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, student_ID);
            ResultSet myResultSet=mystatement.executeQuery();

            while (myResultSet.next()) {
                applicant_id[i]=student_ID;
                applicant_email[i]=myResultSet.getString("APPLICANT_EMAIL");
                applicant_first_name[i]=myResultSet.getString("APPLICANT_FNAME");
                applicant_last_name[i]=myResultSet.getString("APPLICANT_LNAME");
                applicanty_cv[i]=myResultSet.getString("CV");
                applicant_status[i]=myResultSet.getString("STATUS");
                job_id[i]=myResultSet.getInt("JOB_POSTING_ID");
                i++;
            }
            size=i+1;
            System.out.println("The email is "+applicant_email[0]);
            System.out.println("The size of the the dataset is "+size);
            System.out.println("Update Success! ");
        }catch (SQLException e){
            System.out.println("Connection failed");
            return -1;
        }
        return i;
    }
    private static int getApplicationByJobID(int job_ID){
        // keep track of the the size of the ResultSet
        int i=0;int size;
        try {
            Connection myConn = DriverManager.getConnection(dbURL, user, pass);
            String preparedsql="SELECT * FROM  ApplicationData WHERE JOB_POSTING_ID=?";
            PreparedStatement mystatement=myConn.prepareStatement(preparedsql);
            mystatement.setInt(1, job_ID);
            ResultSet myResultSet=mystatement.executeQuery();

            while (myResultSet.next()) {
                job_id[i]=job_ID;
                applicant_id[i]=myResultSet.getInt("APPLICANT_ID");
                applicant_email[i]=myResultSet.getString("APPLICANT_EMAIL");
                applicant_first_name[i]=myResultSet.getString("APPLICANT_FNAME");
                applicant_last_name[i]=myResultSet.getString("APPLICANT_LNAME");
                applicanty_cv[i]=myResultSet.getString("CV");
                applicant_status[i]=myResultSet.getString("STATUS");
                i++;
            }
            size=i+1;
            System.out.println("The email is "+applicant_email[0]);
            System.out.println("The size of the the dataset is "+size);
            System.out.println("Update Success! ");
        }catch (SQLException e){
            System.out.println("Connection failed");
            return -1;
        }
        return i;
    }}