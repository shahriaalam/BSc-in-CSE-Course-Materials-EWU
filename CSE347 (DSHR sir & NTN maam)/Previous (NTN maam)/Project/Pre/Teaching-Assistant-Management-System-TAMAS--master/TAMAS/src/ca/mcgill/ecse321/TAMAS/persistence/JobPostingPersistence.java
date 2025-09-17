package ca.mcgill.ecse321.TAMAS.persistence;

import java.sql.*;
import java.util.ArrayList;

public class JobPostingPersistence {
	static String dbURL = "jdbc:mysql://jamesgtang.com:3306/TAMAS_ECSE321";
	static String user = "TAMAS_DATA_ADMIN";
	static String pass = "ECSE_ADMIN";

	static ArrayList<Integer> post_id = new ArrayList<Integer>();
	static ArrayList<String> instructor_name = new ArrayList<String>();
	static ArrayList<String> course = new ArrayList<String>();
	static ArrayList<String> job_type = new ArrayList<String>();
	static ArrayList<Integer> hour = new ArrayList<Integer>();
	static ArrayList<String> description = new ArrayList<String>();
	static ArrayList<Integer> mon_st = new ArrayList<Integer>();
	static ArrayList<Integer> mon_et = new ArrayList<Integer>();
	static ArrayList<Integer> tue_st = new ArrayList<Integer>();
	static ArrayList<Integer> tue_et = new ArrayList<Integer>();
	static ArrayList<Integer> wed_st = new ArrayList<Integer>();
	static ArrayList<Integer> wed_et = new ArrayList<Integer>();
	static ArrayList<Integer> thu_st = new ArrayList<Integer>(); 
	static ArrayList<Integer> thu_et = new ArrayList<Integer>();
	static ArrayList<Integer> fri_st = new ArrayList<Integer>();
	static ArrayList<Integer> fri_et = new ArrayList<Integer>();
	static ArrayList<String> days_of_week = new ArrayList<String>();
	
	public static void main(String[] args){
		getJobPostingByCourse("ECSE 222");
		for(int i=0; i<post_id.size(); i++){
			System.out.println("Post id: " + post_id.get(i));
			System.out.println("Instructor: " + instructor_name.get(i));
			System.out.println("Course: " + course.get(i));
			System.out.println("Job_type: " + job_type.get(i));
			System.out.println("Description: " + description.get(i));
			System.out.println("Monday start time: " + mon_st.get(i));
			System.out.println("Monday end time: " + mon_st.get(i));
			System.out.println("Tuesday start time: " + mon_st.get(i));
			System.out.println("Tuesday end time: " + mon_st.get(i));
			System.out.println("Wednesday start time: " + mon_st.get(i));
			System.out.println("Wednesday end time: " + mon_st.get(i));
			System.out.println("Thursday start time: " + mon_st.get(i));
			System.out.println("Thursday end time: " + mon_st.get(i));
			System.out.println("Friday start time: " + mon_st.get(i));
			System.out.println("Friday end time: " + mon_st.get(i));
			System.out.println("");
		}
	}
	
	public ArrayList<Integer> getPostId(){
		return post_id;
	}
	
	public ArrayList<String> getInstructorName(){
		return instructor_name;
	}
	
	public ArrayList<String> getCourse(){
		return course;
	}
	
	public ArrayList<String> getJobType(){
		return job_type;
	}
	
	public ArrayList<Integer> getHour(){
		return hour;
	}
	
	public ArrayList<String> getDescription(){
		return description;
	}
	
	public ArrayList<Integer> getMonSt(){
		return mon_st;
	}
	
	public ArrayList<Integer> getMonEt(){
		return mon_et;
	}
	
	public ArrayList<Integer> getTueSt(){
		return tue_st;
	}
	
	public ArrayList<Integer> getTueEt(){
		return tue_et;
	}
	
	public ArrayList<Integer> getWedSt(){
		return wed_st;
	}
	
	public ArrayList<Integer> getWedEt(){
		return wed_et;
	}
	
	public ArrayList<Integer> getThuSt(){
		return thu_st;
	}
	
	public ArrayList<Integer> getThuEt(){
		return thu_et;
	}
	
	public ArrayList<Integer> getFriSt(){
		return fri_st;
	}
	
	public ArrayList<Integer> getFriEt(){
		return fri_et;
	}

	public ArrayList<String> getDaysOfWeek(){
		return days_of_week;
	}
	
	public static void submitJobPostingtoDB(String instructor_name, String course, String job_type, int hour,
			String description, String daysofweek, int[] times) {
		try {
			Connection connection = DriverManager.getConnection(dbURL, user, pass);
			String preparedsql = " INSERT INTO JobPostData " + " (INSTRUCTOR_NAME,COURSE,JOB_TYPE,HOUR,DESCRIPTION,"
					+ "DAYS_OF_WEEK,MON_START_TIME,MON_END_TIME,TUE_START_TIME,"
					+ "TUE_END_TIME,WED_START_TIME,WED_END_TIME,THU_START_TIME,"
					+ "THU_END_TIME,FRI_START_TIME,FRI_END_TIME)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement myStatement = connection.prepareStatement(preparedsql);
			myStatement.setString(1, instructor_name);
			myStatement.setString(2, course);
			myStatement.setString(3, job_type);
			myStatement.setInt(4, hour);
			myStatement.setString(5, description);
			myStatement.setString(6, daysofweek);
			myStatement.setInt(7, times[0]);
			myStatement.setInt(8, times[1]);
			myStatement.setInt(9, times[2]);
			myStatement.setInt(10, times[3]);
			myStatement.setInt(11, times[4]);
			myStatement.setInt(12, times[5]);
			myStatement.setInt(13, times[6]);
			myStatement.setInt(14, times[7]);
			myStatement.setInt(15, times[8]);
			myStatement.setInt(16, times[9]);
			myStatement.executeUpdate();
			System.out.println("Update success! ");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed");
		}
	}

	public static void getJobPostingbyID(int postid) {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			String preparedsql = "SELECT * FROM  JobPostData WHERE POST_ID=?";
			PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
			mystatement.setInt(1, postid);
			ResultSet myResultSet = mystatement.executeQuery();
			while (myResultSet.next()) {
				post_id.add(myResultSet.getInt("POST_ID"));
				instructor_name.add(myResultSet.getString("INSTRUCTOR_NAME"));
				course.add(myResultSet.getString("COURSE"));
				job_type.add(myResultSet.getString("JOB_TYPE"));
				hour.add(myResultSet.getInt("HOUR"));
				description.add(myResultSet.getString("DESCRIPTION"));
				mon_st.add(myResultSet.getInt("MON_START_TIME"));
				mon_et.add(myResultSet.getInt("MON_END_TIME"));
				tue_st.add(myResultSet.getInt("TUE_START_TIME"));
				tue_et.add(myResultSet.getInt("TUE_END_TIME"));
				wed_st.add(myResultSet.getInt("WED_START_TIME"));
				wed_et.add(myResultSet.getInt("WED_END_TIME"));
				thu_st.add(myResultSet.getInt("THU_START_TIME"));
				thu_et.add(myResultSet.getInt("THU_END_TIME"));
				fri_st.add(myResultSet.getInt("FRI_START_TIME"));
				fri_et.add(myResultSet.getInt("FRI_END_TIME"));
				days_of_week.add(myResultSet.getString("DAYS_OF_WEEK"));
				//System.out.println(hour[0]);
				//System.out.println(mon_et[0]);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void getJobPostingByInstructorName(String name) {

		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			String preparedsql = "SELECT * FROM  JobPostData WHERE INSTRUCTOR_NAME=?";
			PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
			mystatement.setString(1, name);
			ResultSet myResultSet = mystatement.executeQuery();
			while (myResultSet.next()) {
				post_id.add(myResultSet.getInt("POST_ID"));
				instructor_name.add(myResultSet.getString("INSTRUCTOR_NAME"));
				course.add(myResultSet.getString("COURSE"));
				job_type.add(myResultSet.getString("JOB_TYPE"));
				hour.add(myResultSet.getInt("HOUR"));
				description.add(myResultSet.getString("DESCRIPTION"));
				mon_st.add(myResultSet.getInt("MON_START_TIME"));
				mon_et.add(myResultSet.getInt("MON_END_TIME"));
				tue_st.add(myResultSet.getInt("TUE_START_TIME"));
				tue_et.add(myResultSet.getInt("TUE_END_TIME"));
				wed_st.add(myResultSet.getInt("WED_START_TIME"));
				wed_et.add(myResultSet.getInt("WED_END_TIME"));
				thu_st.add(myResultSet.getInt("THU_START_TIME"));
				thu_et.add(myResultSet.getInt("THU_END_TIME"));
				fri_st.add(myResultSet.getInt("FRI_START_TIME"));
				fri_et.add(myResultSet.getInt("FRI_END_TIME"));
				days_of_week.add(myResultSet.getString("DAYS_OF_WEEK"));
				//System.out.println(description[0]);
				//System.out.println(mon_et[0]);
			}
		} catch (SQLException e) {
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
			int i = 0;
			while(myResultSet.next()){
				post_id.add(myResultSet.getInt("POST_ID"));
				instructor_name.add(myResultSet.getString("INSTRUCTOR_NAME"));
				course.add(myResultSet.getString("COURSE"));
				job_type.add(myResultSet.getString("JOB_TYPE"));
				hour.add(myResultSet.getInt("HOUR"));
				description.add(myResultSet.getString("DESCRIPTION"));
				mon_st.add(myResultSet.getInt("MON_START_TIME"));
				mon_et.add(myResultSet.getInt("MON_END_TIME"));
				tue_st.add(myResultSet.getInt("TUE_START_TIME"));
				tue_et.add(myResultSet.getInt("TUE_END_TIME"));
				wed_st.add(myResultSet.getInt("WED_START_TIME"));
				wed_et.add(myResultSet.getInt("WED_END_TIME"));
				thu_st.add(myResultSet.getInt("THU_START_TIME"));
				thu_et.add(myResultSet.getInt("THU_END_TIME"));
				fri_st.add(myResultSet.getInt("FRI_START_TIME"));
				fri_et.add(myResultSet.getInt("FRI_END_TIME"));
				days_of_week.add(myResultSet.getString("DAYS_OF_WEEK"));
				//System.out.println(description[i]);
				//System.out.println(mon_et[i]);
				i++;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void getJobPostingByHour(int hourofcourse) {
		try {
			Connection myConn = DriverManager.getConnection(dbURL, user, pass);
			String preparedsql = "SELECT * FROM  JobPostData WHERE HOUR=?";
			PreparedStatement mystatement = myConn.prepareStatement(preparedsql);
			mystatement.setInt(1, hourofcourse);
			ResultSet myResultSet = mystatement.executeQuery();
			while (myResultSet.next()) {
				post_id.add(myResultSet.getInt("POST_ID"));
				instructor_name.add(myResultSet.getString("INSTRUCTOR_NAME"));
				course.add(myResultSet.getString("COURSE"));
				job_type.add(myResultSet.getString("JOB_TYPE"));
				hour.add(myResultSet.getInt("HOUR"));
				description.add(myResultSet.getString("DESCRIPTION"));
				mon_st.add(myResultSet.getInt("MON_START_TIME"));
				mon_et.add(myResultSet.getInt("MON_END_TIME"));
				tue_st.add(myResultSet.getInt("TUE_START_TIME"));
				tue_et.add(myResultSet.getInt("TUE_END_TIME"));
				wed_st.add(myResultSet.getInt("WED_START_TIME"));
				wed_et.add(myResultSet.getInt("WED_END_TIME"));
				thu_st.add(myResultSet.getInt("THU_START_TIME"));
				thu_et.add(myResultSet.getInt("THU_END_TIME"));
				fri_st.add(myResultSet.getInt("FRI_START_TIME"));
				fri_et.add(myResultSet.getInt("FRI_END_TIME"));
				days_of_week.add(myResultSet.getString("DAYS_OF_WEEK"));
				//System.out.println(description[0];
				//System.out.println(mon_et[0]);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * test the class public static void main(String [] args){ //
	 * submitJobPostingtoDB("James McGill", "ECSE333", "GRADER",20,
	 * "This is a cool class", "Monday Tuesday", 800, 800,1000, 800, 900, 800,
	 * 900, 900, 1000, 1100); //getJobPostingbyID(2);
	 * //getJobPostingByInstructorName("Proferssor Paul Python");
	 * getJobPostingByCourse("ECSE333"); //getJobPostingByHour(14); }
	 */
}