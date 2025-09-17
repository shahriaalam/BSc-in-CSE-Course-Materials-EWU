package tamas.a321.ecse.ca.persistence;
import java.sql.*;
public class JobPostingPersistence{
	static String dbURL = "jdbc:mysql://jamesgtang.com:3306/TAMAS_ECSE321";
    static String user = "TAMAS_DATA_ADMIN";
    static String pass = "ECSE_ADMIN";
    
    static int[] post_id = new int[20];
    static String[]  instructor_name= new String[20];
    static String[] course = new String[20];
    static String[] job_type= new String[20];
    static int[] hour = new int[20];
    static String[] description = new String[20];
    static int[] mon_st=new int[20];
    static int[] mon_et=new int[20];
    static int[] tue_st=new int[20];
    static int[] tue_et=new int[20];
    static int[] wed_st=new int[20];
    static int[] wed_et=new int[20];
    static int[] thu_st=new int[20];
    static int[] thu_et=new int[20];
    static int[] fri_st=new int[20];
    static int[] fri_et=new int[20];
    
    public static void submitJobPostingtoDB(String instructor_name,String course,
    		String job_type,int hour,String description,String daysofweek,int mst,int met,int tst,int tet,int wst,int wet,
    		int thst,int thet,int fst, int fet){
    	try{
    		Connection connection=DriverManager.getConnection(dbURL,user,pass);
    		String preparedsql=" INSERT INTO JobPostData "
    				+ " (INSTRUCTOR_NAME,COURSE,JOB_TYPE,HOUR,DESCRIPTION,"
    				+ "DAYS_OF_WEEK,MON_START_TIME,MON_END_TIME,TUE_START_TIME,"
    				+ "TUE_END_TIME,WED_START_TIME,WED_END_TIME,THU_START_TIME,"
    				+ "THU_END_TIME,FRI_START_TIME,FRI_END_TIME)"
    				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    		PreparedStatement myStatement=connection.prepareStatement(preparedsql);
    		myStatement.setString(1, instructor_name);
    		myStatement.setString(2, course);
    		myStatement.setString(3, job_type);
    		myStatement.setInt(4,hour);
    		myStatement.setString(5, description);
    		myStatement.setString(6, daysofweek);
    		myStatement.setInt(7,mst);
    		myStatement.setInt(8,met);
    		myStatement.setInt(9,tst);
    		myStatement.setInt(10,tet);
    		myStatement.setInt(11,wst);
    		myStatement.setInt(12,wet);
    		myStatement.setInt(13,thst);
    		myStatement.setInt(14,thet);
    		myStatement.setInt(15,fst);
    		myStatement.setInt(16,fet);
    		myStatement.executeUpdate();
    		System.out.println("Update success! ");
    	}catch(SQLException e){
    		e.printStackTrace();
    		System.out.println("Update failed");
    	}
}
    public static void getJobPostingbyID(int postid){
    	try{
    		Connection myConn = DriverManager.getConnection(dbURL, user, pass);
    		String preparedsql = "SELECT * FROM  JobPostData WHERE POST_ID=?";
    		PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
    		mystatement.setInt(1, postid);
    		ResultSet myResultSet = mystatement.executeQuery();
    		while(myResultSet.next()){
    		post_id[0] = myResultSet.getInt("POST_ID");
    		instructor_name[0]= myResultSet.getString("INSTRUCTOR_NAME");
    		course[0] = myResultSet.getString("COURSE");
    		job_type[0]=myResultSet.getString("JOB_TYPE");
    		hour[0] =myResultSet.getInt("HOUR") ;
    		description[0] = myResultSet.getString("DESCRIPTION");
    		mon_st[0]=myResultSet.getInt("MON_START_TIME");
    		mon_et[0]=myResultSet.getInt("MON_END_TIME");
    		tue_st[0]=myResultSet.getInt("TUE_START_TIME");
    		tue_et[0]=myResultSet.getInt("TUE_END_TIME");
    		wed_st[0]=myResultSet.getInt("WED_START_TIME");
    		wed_et[0]=myResultSet.getInt("WED_END_TIME");
    		thu_st[0]=myResultSet.getInt("THU_START_TIME");
    		thu_et[0]=myResultSet.getInt("THU_END_TIME");
    		fri_st[0]=myResultSet.getInt("FRI_START_TIME");
    		fri_et[0]=myResultSet.getInt("FRI_END_TIME");
    		System.out.println(hour[0]);
    		System.out.println(mon_et[0]);
    		}
    		}catch (SQLException e) {
				// TODO: handle exception
    			e.printStackTrace();
		}
    	}
    
    public static void getJobPostingByInstructorName(String name){
    
       	try{
    		Connection myConn = DriverManager.getConnection(dbURL, user, pass);
    		String preparedsql = "SELECT * FROM  JobPostData WHERE INSTRUCTOR_NAME=?";
    		PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
    		mystatement.setString(1, name);
    		ResultSet myResultSet = mystatement.executeQuery();
    		while(myResultSet.next()){
    		post_id[0] = myResultSet.getInt("POST_ID");
    		instructor_name[0]= myResultSet.getString("INSTRUCTOR_NAME");
    		course[0] = myResultSet.getString("COURSE");
    		job_type[0]=myResultSet.getString("JOB_TYPE");
    		hour[0] =myResultSet.getInt("HOUR") ;
    		description[0] = myResultSet.getString("DESCRIPTION");
    		mon_st[0]=myResultSet.getInt("MON_START_TIME");
    		mon_et[0]=myResultSet.getInt("MON_END_TIME");
    		tue_st[0]=myResultSet.getInt("TUE_START_TIME");
    		tue_et[0]=myResultSet.getInt("TUE_END_TIME");
    		wed_st[0]=myResultSet.getInt("WED_START_TIME");
    		wed_et[0]=myResultSet.getInt("WED_END_TIME");
    		thu_st[0]=myResultSet.getInt("THU_START_TIME");
    		thu_et[0]=myResultSet.getInt("THU_END_TIME");
    		fri_st[0]=myResultSet.getInt("FRI_START_TIME");
    		fri_et[0]=myResultSet.getInt("FRI_END_TIME");
    		System.out.println(description[0]);
    		System.out.println(mon_et[0]);
    		}
    		}catch (SQLException e) {
				// TODO: handle exception
    			e.printStackTrace();
		}
    }
    
    public static void getJobPostingByCourse(String coursename){
       	try{
    		Connection myConn = DriverManager.getConnection(dbURL, user, pass);
    		String preparedsql = "SELECT * FROM  JobPostData WHERE COURSE=?";
    		PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
    		mystatement.setString(1, coursename);
    		ResultSet myResultSet = mystatement.executeQuery();
    		while(myResultSet.next()){
    		post_id[0] = myResultSet.getInt("POST_ID");
    		instructor_name[0]= myResultSet.getString("INSTRUCTOR_NAME");
    		course[0] = myResultSet.getString("COURSE");
    		job_type[0]=myResultSet.getString("JOB_TYPE");
    		hour[0] =myResultSet.getInt("HOUR") ;
    		description[0] = myResultSet.getString("DESCRIPTION");
    		mon_st[0]=myResultSet.getInt("MON_START_TIME");
    		mon_et[0]=myResultSet.getInt("MON_END_TIME");
    		tue_st[0]=myResultSet.getInt("TUE_START_TIME");s
    		tue_et[0]=myResultSet.getInt("TUE_END_TIME");
    		wed_st[0]=myResultSet.getInt("WED_START_TIME");
    		wed_et[0]=myResultSet.getInt("WED_END_TIME");
    		thu_st[0]=myResultSet.getInt("THU_START_TIME");
    		thu_et[0]=myResultSet.getInt("THU_END_TIME");
    		fri_st[0]=myResultSet.getInt("FRI_START_TIME");
    		fri_et[0]=myResultSet.getInt("FRI_END_TIME");
    		System.out.println(description[0]);
    		System.out.println(mon_et[0]);
    		}
    		}catch (SQLException e) {
				// TODO: handle exception
    			e.printStackTrace();
		}
    }
    public static void getJobPostingByHour(int hourofcourse){
       	try{
    		Connection myConn = DriverManager.getConnection(dbURL, user, pass);
    		String preparedsql = "SELECT * FROM  JobPostData WHERE HOUR=?";
    		PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
    		mystatement.setInt(1, hourofcourse);
    		ResultSet myResultSet = mystatement.executeQuery();
    		while(myResultSet.next()){
    		post_id[0] = myResultSet.getInt("POST_ID");
    		instructor_name[0]= myResultSet.getString("INSTRUCTOR_NAME");
    		course[0] = myResultSet.getString("COURSE");
    		job_type[0]=myResultSet.getString("JOB_TYPE");
    		hour[0] =myResultSet.getInt("HOUR") ;
    		description[0] = myResultSet.getString("DESCRIPTION");
    		mon_st[0]=myResultSet.getInt("MON_START_TIME");
    		mon_et[0]=myResultSet.getInt("MON_END_TIME");
    		tue_st[0]=myResultSet.getInt("TUE_START_TIME");
    		tue_et[0]=myResultSet.getInt("TUE_END_TIME");
    		wed_st[0]=myResultSet.getInt("WED_START_TIME");
    		wed_et[0]=myResultSet.getInt("WED_END_TIME");
    		thu_st[0]=myResultSet.getInt("THU_START_TIME");
    		thu_et[0]=myResultSet.getInt("THU_END_TIME");
    		fri_st[0]=myResultSet.getInt("FRI_START_TIME");
    		fri_et[0]=myResultSet.getInt("FRI_END_TIME");
    		System.out.println(description[0]);
    		System.out.println(mon_et[0]);
    		}
    		}catch (SQLException e) {
				// TODO: handle exception
    			e.printStackTrace();
		}
    }
    /* test the class 
    public static void main(String [] args){
    //	submitJobPostingtoDB("James McGill", "ECSE333", "GRADER",20, "This is a cool class", "Monday Tuesday", 800, 800,1000, 800, 900, 800, 900, 900, 1000, 1100);
    	//getJobPostingbyID(2);
    	//getJobPostingByInstructorName("Proferssor Paul Python");
    	getJobPostingByCourse("ECSE333");
    	//getJobPostingByHour(14);
    }*/
}