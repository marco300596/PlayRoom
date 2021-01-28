package logic.exception;

import javax.swing.JOptionPane;

public class WrongInputException extends Exception {
	private static final long serialVersionUID =  -811228214149798510L;
	
		public WrongInputException() {
			super();
			new Thread(() ->
	    	JOptionPane.showMessageDialog(null, "Wrong input!change the type of input","Error", JOptionPane.INFORMATION_MESSAGE)).start();
	}

}
