import java.lang.Thread.State;

public class Test1 {
	
	
	
	
	public static void main(String[] args) {
		
		Thread th=Thread.currentThread();
		th.setName("Saheer");
		th.setPriority(3);
		String threadName=th.getName();
		System.out.println(threadName);
		State state=th.getState();
		System.out.println(state);
		
		System.out.println("isAlive: "+th.isAlive());
		System.out.println("isDaemon: "+th.isDaemon());
		System.out.println("isInterrupted: "+th.isInterrupted());
		
		System.out.println(th.getPriority());
		System.out.println(th);
		
	}

}
