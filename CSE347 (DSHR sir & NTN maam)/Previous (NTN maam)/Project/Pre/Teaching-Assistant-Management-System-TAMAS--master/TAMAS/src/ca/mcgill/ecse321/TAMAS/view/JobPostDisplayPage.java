package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

//import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ca.mcgill.ecse321.TAMAS.controller.ApplicantController;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.persistence.JobPostingPersistence;

//import ca.mcgill.ecse223.tileo.view.AddConnectionView;

public class JobPostDisplayPage extends JFrame {
	
	ApplicantController ac = new ApplicantController();

	Applicant applicant;
	
	// labels
	private JLabel ApplicantLabel;
	private JLabel AvailableCourses; 
	private JLabel AvailableJobs;
	private JLabel Description;
	
	//blank line
    private JLabel blank;
	
	// combobox for list of courses
	private JComboBox coursesComboBox;
	
	// combobox for list of jobs under a specific course
	private JComboBox jobsComboBox;
	
	// array of courses
	private String[] courseList;
	
	// hashmap with key CourseCode and value list of Jobs
	private HashMap<String, ArrayList<Job>> courseAndJobs = new HashMap<String, ArrayList<Job>>();
	
	String selectedCourseCode;//selection of courseCode from coursesCombobox
	ArrayList<Job> selectedCourseJobs;//a list to store the Jobs associated with the selectedCourseCode
	String[] jobSummaries;//array to store the job summaries for the selected course (i.e. the words you see in job combobox)
	
	HashMap<String, Job> jobAndSummary;//hashmap with a job summary as key and Job as the value
	String selectedSummary;//the job summary you have selected in jobsCombobox
	Job selectedJob;//the Job associated with the job summary you have selected in jobsCombobox
	
	// scroll pane for job description
	String description;
	private JTextArea JobDescriptionText;
	private JScrollPane JobDescriptionScroll;
	
	// button to go to application page
	private JButton apply;
	
	public JobPostDisplayPage() {
		Tamas tamas = new Tamas();
		applicant = new Applicant("Bob Bash", "bobbash123", "password", tamas, "15423");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(); 
		refreshData();
	}
	
	public void initComponents(){
		setTitle("View Job Postings");
		setSize(700,700);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// labels
		ApplicantLabel = new JLabel("Applicant: " + applicant.getName().toUpperCase());
		AvailableCourses = new JLabel("Available Courses:", SwingConstants.RIGHT);
		AvailableJobs = new JLabel("Available Positions:", SwingConstants.RIGHT);
		Description = new JLabel("Description:", SwingConstants.RIGHT);
		blank = new JLabel(" ");
		
		// initialize array for courses
		// fill up hashmap containing key courseCode and object list of jobs
		courseList = new String[] {"ECSE222", "ECSE321"};//get courses from persistence (eventually)
		for(String courseCode : courseList){
			ArrayList<Job> courseJobs = ac.getJobsByCourse(courseCode);
			courseAndJobs.put(courseCode, courseJobs);
		}
		
		// combobox for list of courses
		coursesComboBox = new JComboBox<String>(courseList);
		coursesComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				courseSelectedActionPerformed(evt);
			}
			});
		
		

		//CODE THAT MUST BE REFRESHED EVERYTIME A SELECTION IS MADE IN COMBOBOX
		
		selectedCourseCode = (String)coursesComboBox.getSelectedItem();
		selectedCourseJobs = courseAndJobs.get(selectedCourseCode);
		jobSummaries = new String[selectedCourseJobs.size()];
		jobAndSummary = new HashMap<String, Job>();
		for(int i=0; i<selectedCourseJobs.size(); i++){
			jobSummaries[i] = ac.getJobSummaryByJob(selectedCourseJobs.get(i));
			jobAndSummary.put(jobSummaries[i], selectedCourseJobs.get(i));
		}
		
		jobsComboBox = new JComboBox<String>(jobSummaries);
		jobsComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jobSelectedActionPerformed(evt);
			}
			});
		
		// scroll pane for description of the selected job
		selectedSummary = (String)jobsComboBox.getSelectedItem();
		selectedJob = jobAndSummary.get(selectedSummary);
		description = selectedJob.getDescription();
		JobDescriptionText = new JTextArea(description);
		JobDescriptionText.setMargin( new Insets(10,10,10,10) );
		JobDescriptionText.setWrapStyleWord(true);
		JobDescriptionText.setLineWrap(true);
		JobDescriptionText.setEditable(false);
		JobDescriptionScroll = new JScrollPane (JobDescriptionText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//END OF CODE THAT MUST BE REFRESHED EVERYTIME A SELECTION IS MADE IN COMBOBOX
		
		
		// button to go to application page
		apply = new JButton("Apply");
		apply.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				applyActionPerformed(evt);
			}
			});
		
	/*	JPanel panel = new JPanel();
		panel.add(AvailableCourses);
		panel.add(courses);
		panel.add(AvailableJobs);
		panel.add(jobs);
		panel.add(Description);
		panel.add(apply);
		panel.add(JobDescription);
		
		getContentPane().add(panel);*/
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
		
	    layout.setHorizontalGroup(layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	    				.addComponent(AvailableCourses)
	    				.addComponent(AvailableJobs)
	    				.addComponent(Description))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	    				.addComponent(ApplicantLabel)
	    				.addComponent(blank)
	    				.addComponent(coursesComboBox)
	    				.addComponent(jobsComboBox)
	    				.addComponent(JobDescriptionScroll)
	    				.addComponent(apply))
	    		);
	    
	    layout.setVerticalGroup(layout.createSequentialGroup()
	    		.addComponent(ApplicantLabel)
	    		.addComponent(blank)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(AvailableCourses)
	    				.addComponent(coursesComboBox))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(AvailableJobs)
	    				.addComponent(jobsComboBox))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    					.addComponent(Description)
	    					.addComponent(JobDescriptionScroll))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	    					.addComponent(apply))	
	    		);
	    
	  
	   
	    				
	    			
	    	//pack();		
	    			
	    		
	    				
	   	
	}
	
	private void refreshData(){

		//pack();
	}
	
	//the method that is called when you select an item in coursesComboBox [INCOMPLETE]
	private void courseSelectedActionPerformed(java.awt.event.ActionEvent evt){
		selectedCourseCode = (String)coursesComboBox.getSelectedItem();
		selectedCourseJobs = courseAndJobs.get(selectedCourseCode);
		jobSummaries = new String[selectedCourseJobs.size()];
		jobAndSummary = new HashMap<String, Job>();
		for(int i=0; i<selectedCourseJobs.size(); i++){
			jobSummaries[i] = ac.getJobSummaryByJob(selectedCourseJobs.get(i));
			jobAndSummary.put(jobSummaries[i], selectedCourseJobs.get(i));
		}
		
		DefaultComboBoxModel model = new DefaultComboBoxModel(jobSummaries);
		jobsComboBox.setModel( model );

		selectedSummary = (String)jobsComboBox.getSelectedItem();
		selectedJob = jobAndSummary.get(selectedSummary);
		description = selectedJob.getDescription();
					
		JobDescriptionText.setText(description);
		JobDescriptionScroll.removeAll();
		JobDescriptionScroll.add(JobDescriptionText);
		refreshData();
	}
	
	//the method that is called when you select an item in jobsComboBox [INCOMPLETE]
	private void jobSelectedActionPerformed(java.awt.event.ActionEvent evt){
		int jobIndex = jobsComboBox.getSelectedIndex();
		if(jobIndex != -1){//because jobIndex is -1 if you select a course in coursesComboBox (not sure why)
			selectedCourseCode = (String)coursesComboBox.getSelectedItem();
			selectedCourseJobs = courseAndJobs.get(selectedCourseCode);

			// scroll pane for description of the selected job
			selectedSummary = (String)jobsComboBox.getSelectedItem();
			selectedJob = jobAndSummary.get(selectedSummary);
			description = selectedJob.getDescription();
			
			JobDescriptionText.setText(description);
			JobDescriptionScroll.removeAll();
			JobDescriptionScroll.add(JobDescriptionText);
		}
		
		refreshData();
	}
	
	private void applyActionPerformed(java.awt.event.ActionEvent evt){
		//initialize a popup page to apply for the selected job
		JobApplicationPage page = new JobApplicationPage(applicant, selectedCourseCode, selectedJob);
       	page.setVisible(true);
       	page.setLocation(this.getX()+20, this.getY()+20);
		page.setSize(700,700);
		refreshData();
	}
}