public class Test0 extends Thread {
	

	public Test0(Runnable runnable) {
		super(runnable);
	}
	
	
	
	public static void main(String[] args) {
		
		Test0 test0=new Test0(()->System.out.println("My Runnable called"));
		test0.start();
		
		Test0 test1=new Test0(()->System.out.println("My Runnable has a adhoc change"));
		test1.start();
	}

}
