import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintSeriesLock implements Runnable{

	int n;
	Lock o;
	
	public PrintSeriesLock(int n,Lock o) {
		this.n=n;
		this.o=o;
	}


	@Override
	public void run() {
		try{
			o.lock();
			for(int i=n;i<=n*5;i+=n) {
				System.out.print(i+", ");
			}
			System.out.println();
		}catch (Exception e) {
			
		}finally {
			o.unlock();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		Lock o=new ReentrantLock();
		Thread th1=new Thread(new PrintSeriesLock(5,o));
		Thread th2=new Thread(new PrintSeriesLock(10,o));
		Thread th3=new Thread(new PrintSeriesLock(50,o));
		th1.start();
		th2.start();
		th3.start();
	}

}