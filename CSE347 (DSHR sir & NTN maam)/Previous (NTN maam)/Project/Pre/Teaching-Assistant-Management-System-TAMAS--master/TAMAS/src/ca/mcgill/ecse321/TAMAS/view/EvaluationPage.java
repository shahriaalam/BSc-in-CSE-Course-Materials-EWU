package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EvaluationPage extends JFrame {
	
	private JLabel name1;
	private JLabel position1;
	private JLabel course1 ;
	private JLabel evaluation1;
	private JComboBox name2;
	private JComboBox position2;
	private JComboBox course2;
	private JScrollPane description2;
	private JButton submit;
	
	
	public EvaluationPage(){
		initComponents();
	}
	
	public void initComponents() {
		getContentPane().setBackground(Color.decode("#C63D0F"));
		name1 = new JLabel("Choose a TA or Grader :");
		position1 = new JLabel("Position :");
		course1 = new JLabel("Course :");
		evaluation1 = new JLabel("Evaluation :");
		
		name1.setFont(new Font("Gotham",Font.BOLD, 12));
		name1.setForeground(Color.white);
		position1.setFont(new Font("Gotham",Font.BOLD, 12));
		position1.setForeground(Color.white);
		course1.setFont(new Font("Gotham",Font.BOLD, 12));
		course1.setForeground(Color.white);
		evaluation1.setFont(new Font("Gotham",Font.BOLD, 12));
		evaluation1.setForeground(Color.white);
		
		
		name2 = new JComboBox<String>();
		position2 = new JComboBox<String>();
		course2 = new JComboBox<String>();
		description2 = new JScrollPane();
		
		submit = new JButton("Submit");
		
		submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//submitActionPerformed(evt);
			}
			});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Submit an evaluation");
		
		JPanel panel = new JPanel();
		panel.add(name1);
		panel.add(name2);
		panel.add(course1);
		panel.add(course2);
		panel.add(evaluation1);
		panel.add(description2);
		panel.add(position1);
		panel.add(position2);
		panel.add(submit);
		
		getContentPane().add(panel);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	    layout.setHorizontalGroup(layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(name1)
	    				.addComponent(position1)
	    				.addComponent(course1)
	    				.addComponent(evaluation1)
	    				)
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(name2)
	    				.addComponent(position2)
	    				.addComponent(course2)
	    				.addComponent(description2)
	    		)
	    		.addComponent(submit)
	    		
	    		);
	    
	    layout.setVerticalGroup(layout.createSequentialGroup()
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(name1)
	    				.addComponent(name2))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(position1)
	    				.addComponent(position2))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(course1)
	    				.addComponent(course2))
	    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    				.addComponent(evaluation1)
	    				.addComponent(description2))
	    		.addComponent(submit)
	    		
	    		);
	    				
	    				
	    			
	    				
	    		
	    		
	    		
	    
	    
		
		
		
	pack();	
	}
	
	
}
