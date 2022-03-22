

public class Test2 implements Runnable{
	
	
	void call() {
		System.out.println("Call method Executed by "+Thread.currentThread());
	}
	
	

	public void run() {
		call();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Main Started");
		Test2 t=new Test2();
		Thread ch1=new Thread(t);
		ch1.setName("CH1");
		ch1.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted "+ e);
		}
		System.out.println("Main Ended");
		
	}

}
