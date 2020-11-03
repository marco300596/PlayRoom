public class HelloWorld {

	public static void main(String[] args) {
		int a = 23;
		int b = 44;
		System.out.println("Hello World!");
		int c= sum(a,b);
		System.out.print(c);
	}
	
	public static int sum(int a,int b) {
		return a+b;
	}

}
