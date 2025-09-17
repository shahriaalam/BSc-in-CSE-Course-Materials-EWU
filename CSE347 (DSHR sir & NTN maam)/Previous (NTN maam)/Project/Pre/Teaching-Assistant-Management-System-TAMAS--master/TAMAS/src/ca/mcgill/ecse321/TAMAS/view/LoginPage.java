package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ca.mcgill.ecse321.TAMAS.persistence.StudentRecordPersistenceController;

public class LoginPage extends JFrame{
		
	    private JLabel feedbackMessage;
		private String error = null;
		private JLabel tamasLabel; 
		private JLabel feedback;
		private JLabel usernameLabel;
		private JLabel passwordLabel;
		private JTextField username;
		private JPasswordField password;
		private JButton login;
		private JButton registerButton;
		
		public LoginPage() {
			initComponents();
			refreshData();	
		}
		
		private void initComponents(){
			
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
			int screenHeight=gd.getDisplayMode().getHeight();
			
			
			getContentPane().setBackground(Color.decode("#C63D0F"));
						
			// label for username and password
			usernameLabel = new JLabel("Username (ID):");
			passwordLabel = new JLabel("Password:");
			feedback=new JLabel("Please signin!");
			tamasLabel=new JLabel("TAMAS");
			
			// define font properties for Labels
			tamasLabel.setFont(new Font("Gotham",Font.BOLD,50));
			usernameLabel.setFont(new Font("Gotham",Font.BOLD,12));
			passwordLabel.setFont(new Font("Gotham",Font.BOLD,12));
			
			tamasLabel.setForeground(Color.white);
			feedback.setForeground(Color.white);
			usernameLabel.setForeground(Color.white);
			passwordLabel.setForeground(Color.white);
		
			// textfield for username
			username = new JTextField();
			
			// password field for password
			password = new JPasswordField();
			
			// register b
			// login button
			login = new JButton("Login");
			registerButton=new JButton("Register");
			login.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					loginActionPerformed(evt);
				}});

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Login Page");
			
			GroupLayout layout = new GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			
			 layout.setHorizontalGroup(layout.createSequentialGroup()
			
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(usernameLabel)
			            	.addComponent(passwordLabel)
			            	.addComponent(tamasLabel)
							.addComponent(feedback))
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(username)
				            	.addComponent(password)
				            	.addComponent(login)
				            	
							 )	
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            	.addComponent(registerButton)
							 )	
			 );
			 
			 layout.setVerticalGroup(layout.createSequentialGroup()
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(tamasLabel))
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(feedback))
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(usernameLabel)
			            		.addComponent(username))
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(passwordLabel)
			            		.addComponent(password))
			         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        		 .addComponent(login)
			        		 .addComponent(registerButton)
			        		 )
			 );
			
			pack();
			
			registerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					registerButtonActionPerformed(e);
				}
			});
	
		}

		private void refreshData(){
			
		}
		
		private void loginActionPerformed(java.awt.event.ActionEvent evt){
			int status, idInput=0;
			String feedbackString="";
			String user_name = username.getText();
			char[] pass_word = password.getPassword();
			try {
				idInput=Integer.valueOf(user_name);
			} catch (NumberFormatException e) {
				
			}
			
			StudentRecordPersistenceController srpController=new StudentRecordPersistenceController(idInput,pass_word);			//if numeric getStudentPasswordByID 
			status=srpController.checkLoginInfo();
			System.out.println("Status is: "+status);
			switch (status) {
			case 0:
				feedbackString=feedbackString+"Successfully signed in!";
				feedback.setText(feedbackString);
				System.out.println("Switching to JobPostDispaly");
				JobPostDisplayPage page = new JobPostDisplayPage();
	           	page.setVisible(true);
				break;
			case 1:
				feedbackString=feedbackString+"Id not formated correctly!";
				feedback.setText(feedbackString);
				break;
			case 2:
				feedbackString=feedbackString+"Connection failed!";
				feedback.setText(feedbackString);
				break;
			default:
				feedbackString=feedbackString+"Wrong password, try again!";
				feedback.setText(feedbackString);
			}
				
			refreshData();
		}
		private void registerButtonActionPerformed(java.awt.event.ActionEvent evt){
			System.out.println("Switching to register view");
			RegisterPage page = new RegisterPage();
           	page.setVisible(true);
           	
           	// get height and width of display
           	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
    		int height=gd.getDisplayMode().getHeight();

    		// set the size of the JFrame
           	((JFrame) page).setSize(height*9/16,height);
		}
}
