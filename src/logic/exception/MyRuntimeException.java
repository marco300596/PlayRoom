package logic.exception;

public class MyRuntimeException extends Exception {
	private static final long serialVersionUID = 1L;

	public MyRuntimeException (String message){
		super("Error connecting to the database" + message);
	}
}
