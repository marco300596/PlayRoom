package logic.exception;

import javax.swing.JOptionPane;

public class WrongInputException extends Exception {
	private static final long serialVersionUID =  -811228214149798510L;
	
		public WrongInputException(String message) {
			super(message);
			new Thread(() ->
	    	JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.INFORMATION_MESSAGE)).start();
	}

}
