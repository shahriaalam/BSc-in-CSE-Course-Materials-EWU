package ca.mcgill.ecse321.TAMAS.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ca.mcgill.ecse321.TAMAS.application.TamasApplication;
import ca.mcgill.ecse321.TAMAS.controller.InstructorController;
import ca.mcgill.ecse321.TAMAS.controller.InvalidInputException;
import ca.mcgill.ecse321.TAMAS.controller.ApplicantController;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.EceAdmin;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.model.Applicant.GradStatus;
import ca.mcgill.ecse321.TAMAS.persistence.JobPostingPersistence;

import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistence;

public class JobApplicationPage extends JFrame {
	//error message
	private JLabel errorMessage;
	
	// error
	private String error = null;
	
	// scrollpane for CV
	private JTextArea cvText;
	private JScrollPane cvScroll;
			
	// Label for CV
	private JLabel cvLabel;
	
	// message showing success
	private JLabel successMessage;
	
	
	private JButton apply;
	
	// enum for applicant's gradStatus
	/* public enum GradStatus { Undergrad, Grad }
	private GradStatus gradStatus; */

	public JobApplicationPage() {
		initComponents();
		refreshData();	
	}
	
	private void initComponents(){
		// elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);

		// cv label
		cvLabel = new JLabel("Paste your CV here:");
		
		// apply button
		apply = new JButton("APPLY");
		apply.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				applyActionPerformed(evt);
			}
		});

		// message showing success
		successMessage = new JLabel("Submission was successful!");
		
		// cv scrollpane
		cvText = new JTextArea("");
		cvScroll = new JScrollPane (cvText, 
					 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Apply for a Job");
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		 layout.setHorizontalGroup(layout.createSequentialGroup()
		            		.addComponent(cvLabel)
		            		.addComponent(cvScroll)
		            		.addComponent(apply)
		 );
		 
		 layout.setVerticalGroup(layout.createSequentialGroup()
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            		.addComponent(cvLabel)
		            		.addComponent(cvScroll))
		         .addComponent(apply)		
		 );
		
		pack();
	}
	
	private void refreshData(){
		// error
		errorMessage.setText(error);
		
		//description.setText("");
		pack();
	}
	
	private void applyActionPerformed(java.awt.event.ActionEvent evt){
		//STORE ALL DATA INTO VARIABLES
				
		//( int applicant_id,int job_id,String fname,String lname,String email,String status, String cv)
		TamasApplication ta = new TamasApplication();
		Tamas aTamas = ta.getTamas();
		EceAdmin ece = new EceAdmin("Those People", "those.people@mcgill.ca", "none", aTamas);
		
		// (String aCourseCode, int aCourseCredit, int aNumberOfHours, int aCourseBudget, Tamas aTamas, EceAdmin aEceAdmin)
		Course aCourse = new Course("ECSE321", 3, 10, 1200, aTamas, ece);
		
		Course bCourse = new Course("ECSE223", 3, 10, 1200, aTamas, ece);
		Course cCourse = new Course("ECSE324", 4, 12, 1600, aTamas, ece);
		
		// (String aName, String aUsername, String aPassword, Tamas aTamas, String aApplicantId)
		Applicant applicant = new Applicant
				("Guntera Fiesta", "guntera.fiesta@mail.mcgill.ca", "lolpassword", aTamas, "260223321");
		// This applicant is Undergrad by default. To change to Grad, uncomment the following line:
		// applicant.setGradStatus(GradStatus.Grad);
		
		// (int aNumberOfHours, int aSalary, boolean aIsAssignedToApplicant, boolean aIsAllocatedToApplicant, 
		// String aDescription, String aDeadline, String aSchedule, Course aCourse, Tamas aTamas)
		Job job = new Job(8, 21, true, false,
				"Most boring job ever!", "2017-02-28", "INSERT SCHEDULE HERE", aCourse, aTamas);
		int applicant_id = Integer.parseInt(applicant.getApplicantId());
		int job_id = job.getJobId();
		
		// Add elements to null aTamas
		aTamas.addCourse(aCourse);
		aTamas.addCourse(bCourse);
		aTamas.addCourse(cCourse);
		aTamas.addPerson(ece);
		aTamas.addPerson(applicant);
		aTamas.addJob(job);
		
		// Now aTamas is nonnull
		aCourse = new Course("ECSE321", 3, 10, 1200, aTamas, ece);
		bCourse = new Course("ECSE223", 3, 10, 1200, aTamas, ece);
		cCourse = new Course("ECSE324", 4, 12, 1600, aTamas, ece);
		ece = new EceAdmin("Those People", "those.people@mcgill.ca", "none", aTamas);
		applicant = new Applicant
				("Guntera Fiesta", "guntera.fiesta@mail.mcgill.ca", "lolpassword", aTamas, "260223321");
		// This applicant is Undergrad by default. To change to Grad, uncomment the following line:
		// applicant.setGradStatus(GradStatus.Grad);
		job = new Job(8, 21, true, false,
				"Most boring job ever!", "2017-02-28", "INSERT SCHEDULE HERE", aCourse, aTamas);
		
		// Get fname and lname. Assume no spaces in lname.
		String[] names = applicant.getName().split(" ");
		int numNames = names.length;
		
		String fname = names[0];
		String lname = names[numNames-1];
		String email = applicant.getUsername();
		
		String gradStatus = applicant.getGradStatusFullName(); // Gets GradStatus as a String 
		
		String cv = (String)cvText.getText();
		
		// Send to controller, then call submitToDB from there
		ApplicantController sc = new ApplicantController();
		sc.applyForJob( applicant_id, job_id, fname, lname, email, gradStatus, cv);
		
	
		// update visuals
		refreshData();
	}
	

}
