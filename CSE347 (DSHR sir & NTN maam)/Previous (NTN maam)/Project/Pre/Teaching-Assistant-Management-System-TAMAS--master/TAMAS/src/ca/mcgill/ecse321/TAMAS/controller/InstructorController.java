package ca.mcgill.ecse321.TAMAS.controller;

import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.EceAdmin;
import ca.mcgill.ecse321.TAMAS.model.Evaluation;
import ca.mcgill.ecse321.TAMAS.model.Instructor;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.JobApplication;
import ca.mcgill.ecse321.TAMAS.model.Person;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistenceController;
import ca.mcgill.ecse321.TAMAS.persistence.JobPostingPersistence;
import ca.mcgill.ecse321.TAMAS.controller.InvalidInputException;
import ca.mcgill.ecse321.TAMAS.application.TamasApplication;

public class InstructorController {
	// The InstructorController
	
	private JobPostingPersistence jpp = new JobPostingPersistence();
	public InstructorController(){
		
	}
	
	public String[] getCoursesByIntructor(Instructor instructor){
		// Temporary fix:
		String[] a = {"ECSE 222", "ECSE 223", "ECSE 326"};
		//String[] a = {};
		return a;
	}
	
	
	public void postJob(String instructor_name, String course, String job_type, int hour,
			String description, String daysofweek, int[] times) 
					throws InvalidInputException {
		
		// Definitions
		String name = instructor_name;
		String descr = description;
		String error = "";
		
		// Do checks here
		// Check name not null or empty
		if(name.equals(null) || name.length()==0){
		// This should never happen
			error = error + "Login problem. Please try again later. ";
			throw new InvalidInputException(error);
		}
		
		// Check that a course is selected
		// This is always true unless instructor has no courses
		try {
			if (!course.equals(null) && course.length() != 0) {
				// Good :)
			}
		} catch (Exception e) {
			error = error + "Found no courses! ";
			throw new InvalidInputException(error);
		}
		
		// JobType is automatically TA, unless instructor selects otherwise
		
		// Check number of hours
		if(hour<45 || hour>180){
				error = error + "The number of hours should be between 45 and 180. ";
				throw new InvalidInputException(error);
		}
		
		// For greater flexibility, the description is not required
		if(descr.equals(null)){
			descr = "";
		}
		
		if(daysofweek.equals(null) || daysofweek.length()==0){
			error = error + "Please select at least one day. ";
			throw new InvalidInputException(error);
		}
		
		// Check that start and end times are valid
		String days[] = daysofweek.split(" ");
		int st,et;
		for(int i=0; i<days.length; i++){
			// Monday
			st = times[0]; et = times[1];
			if(days[i].equalsIgnoreCase("Monday")){
				if(et - st == 0){
					error = error + "TA must be assigned for at least one hour! ";
					throw new InvalidInputException(error);
				}
				else if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			else{
				if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			
			// Tuesday
			st = times[2]; et = times[3];
			if(days[i].equalsIgnoreCase("Tuesday")){
				if(et - st == 0){
					error = error + "TA must be assigned for at least one hour! ";
					throw new InvalidInputException(error);
				}
				else if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			else{
				if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			
			// Wednesday
			st = times[4]; et = times[5];
			if(days[i].equalsIgnoreCase("Wednesday")){
				if(et - st == 0){
					error = error + "TA must be assigned for at least one hour! ";
					throw new InvalidInputException(error);
				}
				else if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			else{
				if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			
			// Thursday
			st = times[6]; et = times[7];
			if(days[i].equalsIgnoreCase("Thursday")){
				if(et - st == 0){
					error = error + "TA must be assigned for at least one hour! ";
					throw new InvalidInputException(error);
				}
				else if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			else{
				if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			
			// Friday
			st = times[8]; et = times[9];
			if(days[i].equalsIgnoreCase("Friday")){
				if(et - st == 0){
					error = error + "TA must be assigned for at least one hour! ";
					throw new InvalidInputException(error);
				}
				else if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			else{
				if(et - st < 0){
					error = error + "Cannot end a shift before its start time! ";
					throw new InvalidInputException(error);
				}
			}
			
		}
		
		jpp.submitJobPostingtoDB(name, course, job_type, hour, descr, daysofweek, times);
	}
	


	/******************************************************************/
	
	// Legacy postJob method included below. Do not remove until further notice 
	
		/*public void postJob(String instructorName, String courseName, String jobType, int numHours, String description)
				throws InvalidInputException {
			Tamas tamas = TamasApplication.getTamas();

			// check if the job is for TA or Grader
			boolean isTaJob = false;
			if (jobType.equals("TA"))
				isTaJob = true;

			// finding the instructor in tamas
			Instructor instructor = null;
			for (Person person : tamas.getPersons()) {
				if (person.getName().equals(instructorName) && person instanceof Instructor) {
					instructor = (Instructor) person;
				}
			}

			// finding the course in tamas
			Course course = null;
			for (Course c : tamas.getCourses()) {
				if (c.getCourseCode().equals(courseName))
					course = c;
			}

			// add the job to tamas
			try {
				//(boolean aIsAssignedToApplicant, boolean aIsAllocatedToApplicant,
				// String aDescription, String aDeadline, String aSchedule, Course aCourse, Tamas aTamas)
				  
				Job job = new Job(numHours, 0, false, false, //(numHours, salary, isAssigned2A, isAllocated2A,
						description, "", "", course, tamas); // description, deadline, schedule, crs, tamas)
				tamas.addJob(job);
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
		}*/
	
	
	
}
