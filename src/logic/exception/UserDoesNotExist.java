package logic.exception;

public class UserDoesNotExist extends Exception{

	private static final long serialVersionUID = -811228214149798510L;

	public UserDoesNotExist(String message) {
		super(message);
	}
}
