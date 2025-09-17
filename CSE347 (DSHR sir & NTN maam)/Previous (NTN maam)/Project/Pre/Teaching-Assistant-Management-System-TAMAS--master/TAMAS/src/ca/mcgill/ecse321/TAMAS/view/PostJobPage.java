package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ca.mcgill.ecse321.TAMAS.controller.InstructorController;
import ca.mcgill.ecse321.TAMAS.controller.InvalidInputException;
import ca.mcgill.ecse321.TAMAS.model.Instructor;
import ca.mcgill.ecse321.TAMAS.persistence.JobPostingPersistence;



public class PostJobPage extends javax.swing.JFrame {
	
	// labels
	private JLabel errorMessage;
	private JLabel instructorLabel;
	private JLabel instructorName;
	private JLabel courseLabel;
	private JLabel jobTypeLabel;
	private JLabel hoursLabel;
	private JLabel descriptionLabel;
	private JLabel scheduleLabel;
	private JLabel weekday;
	private JLabel startTime;
	private JLabel endTime;
	
	//number of hours spinner
	private JSpinner hoursSpinner;
	
	// description scrollpane
	private JTextArea descriptionText;
	private JScrollPane descriptionScroll;
	
	// checkboxes
	private JCheckBox monday;
	private JCheckBox tuesday;
	private JCheckBox wednesday;
	private JCheckBox thursday;
	private JCheckBox friday;
	private JLabel blank;//for blank lines
	
	// times for startTime/endTime combo boxes
	Integer[] times;
	
	//startTime combo boxes
	private JComboBox<Integer> startTimeMon;
	private JComboBox<Integer> startTimeTue;
	private JComboBox<Integer> startTimeWed;
	private JComboBox<Integer> startTimeThu;
	private JComboBox<Integer> startTimeFri;
	
	//endTime combo boxes
	private JComboBox<Integer> endTimeMon;
	private JComboBox<Integer> endTimeTue;
	private JComboBox<Integer> endTimeWed;
	private JComboBox<Integer> endTimeThu;
	private JComboBox<Integer> endTimeFri;

	// combo boxes for courses
	String[] courses;
	private JComboBox<String> courseList;
	
	// array for taJob vs graderJob
	String[] jobTypeList;
	
	//combo box for job type
	private JComboBox<String> jobType;
	
	//submit button
	private JButton submit;

	// message showing success
	private JLabel successMessage;
	
	// error
	private String error = null;
	
	// Controller
	InstructorController ic = new InstructorController();
	
	public PostJobPage(Instructor instructor) {
		initComponents(instructor);
		refreshData();
	}
	
	private void initComponents(Instructor instructor){
		// elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
				
		// labels
		instructorLabel = new JLabel("Instructor: ");
		String name = instructor.getName();
		instructorName = new JLabel(name);
		courseLabel = new JLabel("Course:");
		jobTypeLabel = new JLabel("Job type:");
		hoursLabel = new JLabel("Number of Hours:");
		descriptionLabel = new JLabel("Description:");
		scheduleLabel = new JLabel("Schedule:");
		weekday = new JLabel("Weekday");
		startTime = new JLabel("Start time");
		endTime = new JLabel("End time");
		blank = new JLabel(" ");
		
		//number of hours spinner
		SpinnerModel model =
		        new SpinnerNumberModel(45,    // Initial value
		                               0,    // Minimum cannot be less than zero
		                               1000, /* Overly generous maximum value 
		                               	      * Exact permitted value will be set in the controller */
		                               1     // Step
		                               );
		hoursSpinner = new JSpinner(model);
		hoursSpinner.setMaximumSize(new Dimension(50, 50));
		
		
		
		// description scrollpane
		descriptionText = new JTextArea("");
		descriptionScroll = new JScrollPane (descriptionText, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// check boxes
		monday = new JCheckBox("Monday");
		tuesday = new JCheckBox("Tuesday");
		wednesday = new JCheckBox("Wednesday");
		thursday = new JCheckBox("Thursday");
		friday = new JCheckBox("Friday");
		
		// times for startTime/endTime combo boxes
		times = new Integer[] {8,9,10,11,12,13,14,15,16,17};
				
		//startTime combo boxes	
		startTimeMon = new JComboBox<Integer>(times);
		startTimeTue = new JComboBox<Integer>(times);
		startTimeWed = new JComboBox<Integer>(times);
		startTimeThu = new JComboBox<Integer>(times);
		startTimeFri = new JComboBox<Integer>(times);
		
		//endTime combo boxes
		endTimeMon = new JComboBox<Integer>(times);
		endTimeTue = new JComboBox<Integer>(times);
		endTimeWed = new JComboBox<Integer>(times);
		endTimeThu = new JComboBox<Integer>(times);
		endTimeFri = new JComboBox<Integer>(times);
		
		// combo boxes for courses
		courses = ic.getCoursesByIntructor(instructor);
		courseList = new JComboBox<String>(courses);
		
		//combo box for job type
		// instructor will always have the possibility of requesting either a TA or Grader
		jobTypeList = new String[] {"TA", "Grader"};
		jobType = new JComboBox<String>(jobTypeList);
		
		//submit button
		submit = new JButton("SUBMIT");
		submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		// message showing success
		successMessage = new JLabel("Submission was successful!");
		
		 // global settings and listeners
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    setTitle("Post a Job");

	    // LAYOUT
	    GroupLayout layout = new GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	   layout.setHorizontalGroup(layout.createSequentialGroup()
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addComponent(errorMessage)
	            		.addComponent(courseLabel)
	            		.addComponent(jobTypeLabel)
	            		.addComponent(hoursLabel)
	            		.addComponent(descriptionLabel)
	            		.addComponent(blank)
	            		.addComponent(scheduleLabel))
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addComponent(courseList)
	            		.addComponent(jobType)
	            		.addComponent(hoursSpinner)
	            		.addComponent(descriptionScroll)
	            		.addComponent(weekday)
	            		.addGroup(layout.createSequentialGroup())
	            			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            					.addComponent(monday)
	            					.addComponent(tuesday)
	            					.addComponent(wednesday)
	            					.addComponent(thursday)
	            					.addComponent(friday)
	            			)
	            		)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            				.addComponent(startTime)
            					.addComponent(startTimeMon)
            					.addComponent(startTimeTue)
            					.addComponent(startTimeWed)
            					.addComponent(startTimeThu)
            					.addComponent(startTimeFri)
            		    )
	            		)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            				.addComponent(endTime)
            					.addComponent(endTimeMon)
            					.addComponent(endTimeTue)
            					.addComponent(endTimeWed)
            					.addComponent(endTimeThu)
            					.addComponent(endTimeFri)
            		    )
	            		)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addComponent(instructorLabel))
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            				.addComponent(instructorName)
	            				.addComponent(submit)
	            				)
	            		)
	            		);
	    
	    layout.setVerticalGroup(layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(instructorLabel)
	    				.addComponent(instructorName)
	    				)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(errorMessage)
	    				)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(courseLabel)
	    				.addComponent(courseList)
	    				)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(jobTypeLabel)
	    				.addComponent(jobType)
	    				)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(hoursLabel)
	    				.addComponent(hoursSpinner)
	    				)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(descriptionLabel)
	    				.addComponent(descriptionScroll)
	    				)
	    		.addComponent(blank)
	    		.addComponent(scheduleLabel)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addGroup(layout.createSequentialGroup()
	    						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    								.addComponent(weekday)
	    								.addComponent(startTime)
	    								.addComponent(endTime)
	    								)
	    						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    								.addComponent(monday)
	    								.addComponent(startTimeMon)
	    								.addComponent(endTimeMon)
	    								)
	    						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    								.addComponent(tuesday)
	    								.addComponent(startTimeTue)
	    								.addComponent(endTimeTue)
	    								)
	    						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    								.addComponent(wednesday)
	    								.addComponent(startTimeWed)
	    								.addComponent(endTimeWed)
	    								)
	    						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    								.addComponent(thursday)
	    								.addComponent(startTimeThu)
	    								.addComponent(endTimeThu)
	    								)
	    						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    								.addComponent(friday)
	    								.addComponent(startTimeFri)
	    								.addComponent(endTimeFri)
	    								)
	    						)
	    				)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(submit)
	    				)
	    		);
	    
	                    
	    
	   //layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {courseLabel, hoursLabel});
	  
	    
	    pack();
		
	}
	
	private void refreshData(){
		// error
		errorMessage.setText(error);
		
		//description.setText("");
		pack();
	}
	
	private void submitActionPerformed(java.awt.event.ActionEvent evt){
		//STORE ALL DATA INTO VARIABLES
		
		String instructor_name = instructorName.getText();
		String course = (String)courseList.getSelectedItem();
		String job_type = (String)jobType.getSelectedItem();
		int hour = (int)hoursSpinner.getValue();
		String description = (String)descriptionText.getText();
		
		String daysofweek="";// fill according to checkboxes
		if(monday.isSelected())
			daysofweek+="Monday ";
		if(tuesday.isSelected())
			daysofweek+="Tuesday ";
		if(wednesday.isSelected())
			daysofweek+="Wednesday ";
		if(thursday.isSelected())
			daysofweek+="Thursday ";
		if(friday.isSelected())
			daysofweek+="Friday ";
		
		//start times and end times
		int mst = (int)startTimeMon.getSelectedItem();
		int met = (int)endTimeMon.getSelectedItem();
		int tst = (int)startTimeTue.getSelectedItem();
		int tet = (int)endTimeTue.getSelectedItem();
		int wst = (int)startTimeWed.getSelectedItem();
		int wet = (int)endTimeWed.getSelectedItem();
		int thst = (int)startTimeThu.getSelectedItem();
		int thet = (int)endTimeThu.getSelectedItem();
		int fst = (int)startTimeFri.getSelectedItem();
		int fet = (int)endTimeFri.getSelectedItem();
		
		int times[] = {mst,met, tst,tet, wst,wet, thst,thet, fst,fet};
		
		// Send to controller, then call submitJobPostingtoDB from there
		try {
			ic.postJob(instructor_name, course, job_type, hour, description, daysofweek, times);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// update visuals
		refreshData();
	}
	
}
