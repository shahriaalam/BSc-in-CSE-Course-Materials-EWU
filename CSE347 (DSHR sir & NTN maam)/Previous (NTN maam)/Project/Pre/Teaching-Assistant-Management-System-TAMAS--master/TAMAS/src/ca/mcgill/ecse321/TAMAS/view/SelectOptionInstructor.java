package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectOptionInstructor extends JFrame {
	private JLabel select ;
	private JButton postAJob;
	private JButton makeAnEvaluation;
	
	public SelectOptionInstructor() {
		initComponents();
	
	}
	
	public void initComponents() {
		getContentPane().setBackground(Color.decode("#C63D0F"));
		select = new JLabel("Select an option :");
		postAJob = new JButton("Post a new job");
		makeAnEvaluation = new JButton("Make an evaluation");
		
		select.setFont(new Font("Gotham",Font.BOLD, 12));
		select.setForeground(Color.white);
		
		postAJob.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//postAJobActionPerformed(evt);
			}
			});
		
		makeAnEvaluation.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//makeAnEvaluationActionPerformed(evt);
			}
			});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Submit an evaluation");
		
		JPanel panel = new JPanel();
		panel.add(select);
		panel.add(postAJob);
		panel.add(makeAnEvaluation);
		
		getContentPane().add(panel);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	   layout.setHorizontalGroup(layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    		.addComponent(select))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    		.addComponent(postAJob)
	    		.addComponent(makeAnEvaluation))
	    		
	    		);
	    
	    layout.setVerticalGroup(layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    		.addComponent(select)
	  
	    		.addComponent(postAJob))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    		.addComponent(makeAnEvaluation))
	    		);
	    
	    pack();
		
	}
	
	
}
