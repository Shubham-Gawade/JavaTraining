

public class Test4 implements Runnable{
	
	
	void call() {
		System.out.println("Call method Executed by "+Thread.currentThread());
	}
	
	

	public void run() {
		call();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Main Started");
		Test4 t=new Test4();
		Thread ch1=new Thread(t);
		ch1.setName("CH1");
		ch1.setPriority(1);
		Thread ch2=new Thread(t);
		ch2.setName("CH2");
		ch2.setPriority(1);
		Thread ch3=new Thread(t);
		ch3.setName("CH3");
		ch3.setPriority(10);
		ch1.start();
		ch2.start();
		ch3.start();
		
		System.out.println("Main Ended");
		
	}

}
