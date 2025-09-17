package ca.mcgill.ecse321.TAMAS.controller;


public class DatabaseConnectionException extends Exception {

		private static final long serialVersionUID = -5633915762703837868L;

		public DatabaseConnectionException(String errorMessage){
			super(errorMessage); 
		}
}
