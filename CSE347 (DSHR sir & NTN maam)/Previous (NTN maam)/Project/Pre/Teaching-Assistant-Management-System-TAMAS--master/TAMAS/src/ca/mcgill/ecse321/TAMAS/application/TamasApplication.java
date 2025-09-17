package ca.mcgill.ecse321.TAMAS.application;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.org.apache.bcel.internal.generic.NEW;

import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.EceAdmin;
import ca.mcgill.ecse321.TAMAS.model.Instructor;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.Person;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.view.ECEAdminPage;
import ca.mcgill.ecse321.TAMAS.view.PostJobPage;


public class TamasApplication {
	
	private static Tamas tamas;
	private static String filename = "data.tamas";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//PostJobPage page = new PostJobPage();

		/*****/
		// Make UI look like a native application
	    try {
            // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) { /* handle exception */ }
	
		/*****/
		
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Uncomment the page you want to see
            	
//            	LoginPage page = new LoginPage();
            	
            	// Temporary hack: 
            	Tamas aTamas = new Tamas();
            	Instructor instructor = new Instructor
            			("Gunter Mussbacher", "gmussbacher@mcgill.ca", "gmussbacher123", aTamas);
            	aTamas.addPerson(instructor);
            	
            	// PostJobPage page = new PostJobPage(instructor);
            	
//            	JobPostDisplayPage page = new JobPostDisplayPage();

//            	JobApplicationPage page = new JobApplicationPage();
            	
            	ECEAdminPage page=new ECEAdminPage(); 
            	
            	page.setVisible(true);
            	// setSize(length, width)
            	((JFrame) page).setSize(1000,800);
            }
        });
		
		/* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Uncomment the page you want to see
//            	LoginPage page = new LoginPage();
            	
//            	PostJobPage page = new PostJobPage();
            	
//            	JobPostDisplayPage page = new JobPostDisplayPage();

            	JobApplicationPage page = new JobApplicationPage();

            	page.setVisible(true);
            	// setSize(length, width)
            	((JFrame) page).setSize(1200,1200);
            }
        }); */

	}

	public static Tamas getTamas() {
		if (tamas == null) {
			// load model
			tamas = load();
		}
		return tamas;
	}

	public static void save() {
		
	}

	public static Tamas load() {
		
		
		// model cannot be loaded - create empty Tamas
		if (tamas == null) {
			tamas = new Tamas();
		} else {
			// Based on methods in TAMASPersistence.ump
			Job.reinitializeAutouniqueID(tamas.getJobs());
			Course.reinitializeCourse(tamas.getCourses());
			Person.reinitializeUsername(tamas.getPersons());
		}
		return tamas;
	}

	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}
