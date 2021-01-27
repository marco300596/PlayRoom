package logic.exception;

import javax.swing.JOptionPane;

public class StringIsEmptyException extends Exception{
	
	private static final long serialVersionUID = -811228214149798510L;

	public StringIsEmptyException() {
		super();
		new Thread(() ->
    	JOptionPane.showMessageDialog(null, "Empty string! Please fill the textfield","Error", JOptionPane.INFORMATION_MESSAGE)).start();
	}
}
