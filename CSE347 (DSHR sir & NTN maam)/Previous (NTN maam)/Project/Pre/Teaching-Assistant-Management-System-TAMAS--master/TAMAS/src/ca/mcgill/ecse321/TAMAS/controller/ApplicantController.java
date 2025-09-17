package ca.mcgill.ecse321.TAMAS.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import ca.mcgill.ecse321.TAMAS.application.TamasApplication;
import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.EceAdmin;
import ca.mcgill.ecse321.TAMAS.model.Instructor;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.JobApplication;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistence;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistenceController;
import ca.mcgill.ecse321.TAMAS.persistence.JobPostingPersistence;


public class ApplicantController {
	private JobApplication ja;
	private JobApplicationPersistenceController japc = new JobApplicationPersistenceController();
	Tamas tamas = TamasApplication.getTamas();
	EceAdmin e = new EceAdmin("Bob", "Bob", "12345", tamas);
	
	public ApplicantController(){
	}
	
	public ApplicantController(JobApplication ja){
		this.ja=ja;
	}
	
	
	public List<Course> getListOfCoursesWithOpenPositions(){
		ArrayList<Course> listOfCourses = new ArrayList<Course>();
		for (Course course : TamasApplication.getTamas().getCourses()) {
			// A Course hasOpenPositions when it has at least one Job IsPosted or AppliedTo
			int openPositions = 0;
			// Get the Jobs for each course
			for(Job job : course.getJobs()){
				String jobState = job.getJobStateFullName();
				if(jobState.equalsIgnoreCase("IsPosted") || jobState.equalsIgnoreCase("AppliedTo")){
					openPositions++;
				}
			}
			if (openPositions > 0) {
				listOfCourses.add(course);				
			}
		}
		return listOfCourses;
	}
	
	public List<Job> getAvailableJobs(Course course) {
		ArrayList<Job> listOfJobs = new ArrayList<Job>();
		for(Job job : course.getJobs()){
			String jobState = job.getJobStateFullName();
			if(jobState.equalsIgnoreCase("IsPosted") || jobState.equalsIgnoreCase("AppliedTo")){
			// job is open for applications
				listOfJobs.add(job);
			}
		}
		return listOfJobs;
	}
	
	public String displayJob(Job job){
		String jobTitle = job.getCourse().getCourseCode();
		String jobType = job.getJobTypeFullName(); // Get jobType as a String
		if(jobType.equalsIgnoreCase("TaJob")){
			return jobTitle + " TA "; 
		}
		else{
			return jobTitle + " Marker ";
		}
	}
	
	public String getDetailsOfJob(Job job){
		String Instructors = "";
		int nIns = job.getCourse().numberOfInstructors();
		if(nIns == 1){
			String name = job.getCourse().getInstructor(0).getName();
			Instructors = "Instructor: " + name + " ";
		}
		else{
			Instructors = "Instructors: ";
			for(int i=0; i<nIns; i++){
				String name = job.getCourse().getInstructor(i).getName();
				if (i<nIns-1){
					Instructors = Instructors + name + ", ";
				}
				else{
					Instructors = Instructors + name + " ";
				}
			}
		}
		
		// Add hours
		String details = "\n" + Instructors + "\n\nDescription: " + job.getDescription() + "\n";
		return details;
	}
	
	public JobApplication initialApplyForJob(String experience, Applicant applicant, Job job){
		// This method takes the Applicant info+CV and the job, then creates a JobApplication 
		// Applicant info+CV is the Applicant's attributes and their experience
		JobApplication jobApplication = new JobApplication(experience, applicant, job);

		return jobApplication;
	}
	
	public void applyForJob( int applicant_id,int job_id,String fname,String lname,
			String email,String status, String cv){

		JobApplicationPersistence jap = new JobApplicationPersistence();
		jap.submitToDB( applicant_id, job_id, fname, lname, email, status, cv);
	}

	public JobApplication applyForJob(String experience, Applicant applicant, Job job){
		// This method takes the Applicant info+CV and the job, then creates a JobApplication 
		// Applicant info+CV is the Applicant's attributes and their experience
		JobApplication jobApplication = new JobApplication(experience, applicant, job);

		return jobApplication;
	}
	
	/***************/
	// Added JobApplicationController
	public void addApplicantToJobApplication(Applicant Applicant) throws InvalidInputException{
		String error="";
		
		String aApplicantId;
		String aName;
		String aPassword;
		String gradStatus;
		Boolean aIsGrad;
		String aUsername;
		
	    aApplicantId=Applicant.getApplicantId();
		aName=Applicant.getName();
		aPassword=Applicant.getPassword();
		aUsername=Applicant.getUsername();
		
		gradStatus=Applicant.getGradStatusFullName();
		if(gradStatus.equalsIgnoreCase("Grad")){
			aIsGrad=true;
		}else{
			aIsGrad=false;
		}
		
		if(aApplicantId==null||aApplicantId.trim().length()==0){
			error=error+"Applicant ID cannot be empty! ";
		}
		if(aName==null||aName.trim().length()==0){
			error=error+"Applicant name cannot be empty! ";
		}
		if(aPassword==null||aPassword.trim().length()==0){
			error=error+"Applicant password cannot be empty! ";
		}
		if(aUsername==null||aUsername.trim().length()==0){
			error=error+"Applicant email cannot be empty! ";
		}
		if(aIsGrad!=true||aIsGrad!=false){
			error=error+"Applicant status cannot be empty! ";
		}
	
		ja.setApplicant(Applicant);
	}
	public void addExperienceToJobApplication(String experience) throws InvalidInputException {
		String error="";
		if(experience==null||experience.length()==0){
			error=error+"Experience cannot be empty! ";
		}
		if(experience.length()<=20){
			error=error+"Experience cannot be less than 20 characters! ";
		}
		if(experience.length()>=2000){
			error=error+"Experience cannot be more than 2000 characters!";
		}
		error=error.trim();
		if(error.length()>0){
			throw new InvalidInputException(error);
		}
		ja.setExperience(experience);
	}
	// ToDo: add schedule to model
	public void addJobToJobApplication(Job aJob) throws InvalidInputException {
		String error="";
		int aNumberOfHours; 
		int aSalary;
		String aDescription;
		String aDeadline;
		Course aCourse;

		aNumberOfHours=aJob.getNumberOfHours();
		aSalary=aJob.getSalary();
		aDescription=aJob.getDescription();
		aDeadline=aJob.getDeadline();
		aCourse=aJob.getCourse();
		
		//ToDo: check the requirement for min hour
		if(aNumberOfHours<=45){
			error=error+"Number of hours cannot be less than or equal to 0! ";
		}
		if(aSalary<=0){
			error=error+"Salary cannot be less than or equal to 0! ";
		}
		// ToDo: check the requirement for max hour
		if(aNumberOfHours>=180){
			error=error+"Number of hours cannot be greater than 180! ";
		}

		if(aDescription.length()<=10){
			error=error+"Job description must have more than 10 characters! ";
		}
		if(aDescription.length()>=2000){
			error=error+"Job description must have less than 2000 characters! ";
		}
		if(aDeadline==null){
			error=error+"Deadline not specified! ";
		}
		if(aCourse==null){
			error=error+"Course not specified! "; 
		}
		if(error.length()>0) throw new InvalidInputException(error);
		ja.setAppliedJob(aJob);
	}
	public void submitJobApplication(JobApplication ja) throws InvalidInputException{
		String errorstring="";
		
		if(ja.getApplicant()==null){
			errorstring=errorstring+"Applicant must specifed before submission! ";
		}else if(ja.getExperience()==null){
			errorstring=errorstring+"Experience must be specified before submission! ";
		}else if(ja.getAppliedJob()==null){
			errorstring=errorstring+"Job must be specified before submission! "; 
		}
		if(errorstring.length()>0) throw new InvalidInputException(errorstring);
		else{
			japc.submitJobApplication(ja);
		}
		
	}

	/*//for model
	public List<Course> getListOfCoursesThatHaveOpenPositions(){
		ArrayList<Course> listOfCourses = new ArrayList<Course>();
		for (Course course : TamasApplication.getTamas().getCourses()) {
			// A Course hasOpenPositions when it has at least one Job IsPosted or AppliedTo
			int openPositions = 0;
			// Get the Jobs for each course
			for(Job job : course.getJobs()){
				String jobState = job.getJobStateFullName();
				if(jobState.equalsIgnoreCase("IsPosted") || jobState.equalsIgnoreCase("AppliedTo")){
					openPositions++;
				}
			}
			if (openPositions > 0) {
				listOfCourses.add(course);				
			}
		}
		return listOfCourses;
	}
	//model
	public List<Job> getAvailableJobs(Course course) {
		ArrayList<Job> listOfJobs = new ArrayList<Job>();
		for(Job job : course.getJobs()){
			String jobState = job.getJobStateFullName();
			if(jobState.equalsIgnoreCase("IsPosted") || jobState.equalsIgnoreCase("AppliedTo")){
			// job is open for applications
				listOfJobs.add(job);
			}
		}
		return listOfJobs;
	}*/

	//return a list of jobs based on a course code
	public ArrayList<Job> getJobsByCourse(String courseCode){
		JobPostingPersistence jp = new JobPostingPersistence();
		jp.getJobPostingByCourse(courseCode);
		ArrayList<Job> jobs = new ArrayList<Job>();

		for(int i=0; i<jp.getPostId().size(); i++){
			int numHours = jp.getHour().get(i);
			String jobType = jp.getJobType().get(i);
			boolean isTaJob;
			if(jobType.equals("TA")){
				isTaJob = true;
			}
			else{
				isTaJob = false;
			}
			boolean isAssigned = false;
			boolean isAllocated = false;
			String description = jp.getDescription().get(i);
			
			String schedule = "";
			String delimiters = " ";
			StringTokenizer st = new StringTokenizer(jp.getDaysOfWeek().get(i), delimiters , true );
			String token = st.nextToken();
			while ( st.hasMoreTokens() ) {
				if(token.equals("MONDAY")){
					schedule+="MON-" + jp.getMonSt() + "-" + jp.getMonEt() + ";";
				}
				if(token.equals("TUESDAY")){
					schedule+="TUE-" + jp.getTueSt() + "-" + jp.getTueEt() + ";";
				}
				if(token.equals("WEDNESDAY")){
					schedule+="WED-" + jp.getWedSt() + "-" + jp.getWedEt() + ";";
				}
				if(token.equals("THURSDAY")){
					schedule+="THU-" + jp.getThuSt() + "-" + jp.getThuEt() + ";";
				}
				if(token.equals("FRIDAY")){
					schedule+="FRI-" + jp.getFriSt() + "-" + jp.getFriEt() + ";";
				}
				token = st.nextToken();
			}
			
		    //Course course = getCourseByCourseCode(courseCode);
		    Course course = new Course(courseCode, 0, tamas, e);
			
		    //can now create the job and add it to jobs
		    Job job = new Job(numHours, isTaJob, isAssigned, isAllocated, description, schedule, course, tamas);
		    jobs.add(job);
		}
		
		return jobs;
	}
	
	/*public HashMap<Integer, String> getJobSummariesByCourseCode(String courseCode){
		ArrayList<Job> jobs = getJobsByCourse(courseCode);
		HashMap<Integer, String> jobIdAndSummary = new HashMap<Integer, String>();
		
		for(Job job : jobs){
			String summary = "";
			summary+="Job Type: " + job.getJobTypeFullName() +  "       Hours: " + job.getNumberOfHours() + "       Instructor Name: n/a";
			jobIdAndSummary.put(job.getJobId(), summary);
		}
		
		return jobIdAndSummary;
	}*/
	
	public String getJobSummaryByJob(Job job){
		String summary = "";
		if(job.getJobTypeFullName().equals("TaJob")){
			summary+="Job Type: TA";
		}
		else{
			summary+="Job Type: Grader";
		}
		summary+="\t" + "Hours: " + job.getNumberOfHours() + "\t" + "Instructor Name: n/a";
		summary = summary.replaceAll("\t", "              ");
		return summary;
	}
	
	public Course getCourseByCourseCode(String courseCode){
		//ideally get from persistence (getCourseByCourseCode persistence method)
		for(Course c : tamas.getCourses()){
			if(c.getCourseCode().equals(courseCode))
				return c;
		}
		return null;
	}

	public void applyForJob(Applicant applicant, Job job, String resume){

	}
	
}
