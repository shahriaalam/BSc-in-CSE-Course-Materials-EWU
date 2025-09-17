package ca.mcgill.ecse321.TAMAS.persistence;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistence;

import java.util.StringTokenizer;
import ca.mcgill.ecse321.TAMAS.model.JobApplication;

public class JobApplicationPersistenceController {
	
	static String applicant_cv;
    static String applicant_first_name;
    static String applicant_last_name;
    static String applicant_status;
    static String applicant_email;
    static int job_id;
    static int applicant_id;
    
	public int submitJobApplication(JobApplication jApplication){
		applicant_cv=jApplication.getExperience();
		int feedback=1;
		String gradStatus = jApplication.getApplicant().getGradStatusFullName(); // Gets GradStatus as a String 
		if(gradStatus.equalsIgnoreCase("Grad")){
			applicant_status="GRAD";
		}else{
			applicant_status="UGRAD";
		}
		applicant_email=jApplication.getApplicant().getUsername();
		job_id=jApplication.getAppliedJob().getJobId();
		applicant_id=Integer.valueOf(jApplication.getApplicant().getApplicantId());	
		String fullname=jApplication.getApplicant().getName();
		StringTokenizer stringTokenizer=new StringTokenizer(fullname, " ");
		applicant_first_name=stringTokenizer.nextToken();
		applicant_last_name=stringTokenizer.nextToken();
		// submit information to database
		// submitToDB( int applicant_id,int job_id,String fname,String lname,String email,String status, String cv)
		feedback=JobApplicationPersistence.submitToDB(applicant_id, job_id, applicant_first_name, applicant_last_name, applicant_email, applicant_status, applicant_cv);
		return feedback;
	}
}
