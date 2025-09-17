package ca.mcgill.ecse321.TAMAS.persistence;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// import the model controller and persistence controller
import ca.mcgill.ecse321.TAMAS.controller.JobApplicationController;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistenceController;
import ca.mcgill.ecse321.TAMAS.model.*;
import ca.mcgill.ecse321.TAMAS.application.*;
/**
 * A JUnit test case for JobApplication Controller
 * Use as an example for other test cases
 * @author James Tang
 *
 */
public class JopApplicationPersistenceTest {
	private JobApplicationController jac;
	JobApplication ja1;
	JobApplication ja2;
	TamasApplication tApplication=new TamasApplication();
	JobApplicationPersistenceController jobApplicationPersistenceController=new JobApplicationPersistenceController();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		// create a new Tamas object
		Tamas aTamas=TamasApplication.getTamas();
		
		// Now the TAMAS is null
		EceAdmin ece = new EceAdmin("Those People", "those.people@mcgill.ca", "none", aTamas);

		// (String aCourseCode, int aCourseCredit, Tamas aTamas, EceAdmin aEceAdmin
		Course aCourse = new Course("ECSE321", 3, aTamas, ece);

	    Course bCourse = new Course("ECSE223", 3, aTamas, ece);
		Course cCourse = new Course("ECSE324", 4, aTamas, ece);


		Applicant Applicant = new Applicant
				("Guntera Fiesta", "guntera.fiesta@mail.mcgill.ca", "lolpassword", aTamas, "260223321", false);

		Job job = new Job(8, 21, true, false, false, "Most boring job ever!", "2017-02-28", aCourse, aTamas);
		int applicant_id = Integer.parseInt(Applicant.getApplicantId());
		int job_id = job.getJobId();

		// Add elements to null aTamas
	    aTamas.addCourse(aCourse);
		aTamas.addCourse(bCourse);
		aTamas.addCourse(cCourse);
		aTamas.addPerson(ece);
		aTamas.addPerson(Applicant);
		aTamas.addJob(job);
		
		// create a Applicant
		String aName; 
		String aUsername;
		String aPassword;
		String  aApplicantId;
		boolean aIsGrad; 
		
		aName="Janet Mraz";
		aUsername="jmraz@ece.mcgill.com";
		aPassword="jmarz1234";
		aApplicantId="1312232";
		aIsGrad=true;
		Applicant Applicant1=new Applicant(aName, aUsername, aPassword, aTamas, aApplicantId, aIsGrad);
		
		aName="Katherine Watkins";
		aUsername="kwatkins@ece.mcgill.com";
		aPassword="kwatkins1234";
		aApplicantId="930182231";
		aIsGrad=false;
		Applicant Applicant2=new Applicant(aName, aUsername, aPassword, aTamas, aApplicantId, aIsGrad);
		
		// create a EceAdmin
		ece = new EceAdmin("Those People", "those.people@mcgill.ca", "none", aTamas);
		aCourse = new Course("ECSE321", 3, aTamas, ece);		
		bCourse= new Course("ECSE223", 3, aTamas, ece);
		cCourse= new Course("ECSE324", 4, aTamas, ece);
		
		// create experience
		String experience1="Experience of the Applicant1";
		String experience2="Experience of the Applicant2";
				
		// create job post
		int aNumberOfHours=18;
		int aSalary=13;
		boolean aIsTaJob=true;
		boolean aIsAssignedToApplicant=false;
		boolean aIsAllocatedToApplicant=false;
		String aDescription="A test description!"; 
		String aDeadline="2019/May/15th";
		
		// ToDo:  why is ECEAdmin required for a Job Constructor? 
		EceAdmin aEceAdmin=new EceAdmin("Dylon Johns", "dj@ece.mcgill.ca", "dj231", aTamas); 
		Job job1=new Job(aNumberOfHours, aSalary, aIsTaJob, aIsAssignedToApplicant, aIsAllocatedToApplicant, aDescription, aDeadline, aCourse, aTamas);

		aNumberOfHours=10;
		aSalary=15;
		aIsTaJob=true;
		aIsAssignedToApplicant=false;
		aIsAllocatedToApplicant=false;
		aDescription="A test description!"; 
		aDeadline="2019/April/12th";
		
		// ToDo:  why is ECEAdmin required for a Job Constructor?  name = new ();
		ece=new EceAdmin("John Kimmel", "jk@ece.mcgill.ca", "jk123", aTamas); 
		aCourse=new Course("ECSE411",3, aTamas,aEceAdmin);
		//ToDo: add Job_Post_Id and schedule to umple
		Job job2=new Job(aNumberOfHours, aSalary, aIsTaJob, aIsAssignedToApplicant, aIsAllocatedToApplicant, aDescription, aDeadline, aCourse, aTamas);		
		
		
		aTamas.addCourse(aCourse);
		aTamas.addCourse(bCourse);
		aTamas.addCourse(cCourse);
		aTamas.addJob(job1);
		aTamas.addJob(job2);
		aTamas.addPerson(ece);
		aTamas.addPerson(Applicant1);
		aTamas.addPerson(Applicant2);
		
		// add Applicant
		ja1=new JobApplication(experience1, Applicant1, job1);
		ja2=new JobApplication(experience2,Applicant2,job2);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		String feedback="";
		feedback=jobApplicationPersistenceController.submitJobApplication(ja2); 
		if(feedback.equals("Submission failed!")) fail("Submission failed!");
		assertEquals("Submission success!",feedback);
	}

}
