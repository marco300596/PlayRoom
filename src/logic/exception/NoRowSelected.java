package logic.exception;

import javax.swing.JOptionPane;

public class NoRowSelected extends Exception {
	private static final long serialVersionUID =  -811228214149798510L;
	
	public NoRowSelected() {
		super();
		new Thread(() -> JOptionPane.showMessageDialog(null, "No row selected,please select a row","Error", JOptionPane.INFORMATION_MESSAGE)).start();
		
}
}
