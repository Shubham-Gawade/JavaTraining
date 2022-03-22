

public class Test3 implements Runnable{
	
	
	void call() {
		System.out.println("Call method Executed by "+Thread.currentThread());
	}
	
	

	public void run() {
		call();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Main Started");
		Test3 t=new Test3();
		Thread ch1=new Thread(t);
		ch1.setName("CH1");
		ch1.start();
		Thread ch2=new Thread(t);
		ch2.setName("CH2");
		ch2.start();
		try {
			ch1.join();
			ch2.join();
		} catch (InterruptedException e) {
			System.out.println("Join Interrupted "+e);
		}
		System.out.println("Main Ended");
		
	}

}
