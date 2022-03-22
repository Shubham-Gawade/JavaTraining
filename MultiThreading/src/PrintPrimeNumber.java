import java.util.Scanner;

public class PrintPrimeNumber implements Runnable{
	
	int n;
	
	public PrintPrimeNumber(int n) {
		this.n = n;
	}


	@Override
	public void run() {
		int primeNo=PrimeNumberCalculator.claculatePrime(n);
		System.out.println("The prime number is: "+primeNo);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner scanner=new Scanner(System.in);
		int n;
		
		while(true) {
			System.out.println("Enter the value for n, for exit enter 0");
			n=scanner.nextInt();
			
			if(n==0) {
				break;
			}
			Thread th=new Thread(new PrintPrimeNumber(n));
			th.setDaemon(true);
			th.getState();
			th.start();
		}
		
	}

	
	
}
