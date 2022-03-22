import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintThreadStatus {
	
    static void printList(List<Thread> threads){
		for(Thread t : threads) {
			System.out.println(t.getState());
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		List<Thread> threads = new ArrayList<>();
		Thread showStatus = new Thread(()->{
			
			while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Report thread interrupted");
			}
			printList(threads);}
			}
		);
		showStatus.setDaemon(true);
		showStatus.start();
		while(true) {
			
			System.out.println("Enter the nth prime number to be found:");
			int num = scan.nextInt();
			
			if(num == 0) 
				break;
			
			Runnable r=()->{
					int primeNumber = PrimeNumberCalculator.claculatePrime(num);
					System.out.println(num+"th prime number is: "+primeNumber);
					
			};
			
			Thread th = new Thread(r);
			threads.add(th);
			th.start();
					
		}
		
		scan.close();
	}


}
