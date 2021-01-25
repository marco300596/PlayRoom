package logic.exception;

import javax.swing.JOptionPane;

public class UserDoesNotExist extends Exception{

	private static final long serialVersionUID = -811228214149798510L;

	public UserDoesNotExist() {
		super();
		new Thread(() ->
    	JOptionPane.showMessageDialog(null, "User does not exist!","Error", JOptionPane.INFORMATION_MESSAGE)).start();
	}
}
