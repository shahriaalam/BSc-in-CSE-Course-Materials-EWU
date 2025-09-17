package ca.mcgill.ecse321.TAMAS.controller;

import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.JobApplication;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistenceController;

public class JobApplicationController {
	private JobApplication ja;
	private JobApplicationPersistenceController japc = new JobApplicationPersistenceController();
	public JobApplicationController(JobApplication ja){
		this.ja=ja;
	}
	public void addApplicant(Applicant Applicant) throws InvalidInputException{
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
	public void addExperience(String experience) throws InvalidInputException {
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
	public void addJob(Job aJob) throws InvalidInputException {
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
}
