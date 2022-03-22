public class PrintSeriesSynchonized implements Runnable{

	int start;
	int end;
	int diff;
	Object o;
	
	public PrintSeriesSynchonized(int start,int end,int diff,Object o) {
		this.start=start;
		this.end=end;
		this.diff=diff;
		this.o=o;
	}


	@Override
	public void run() {
		synchronized (o) {
			for(int i=start;i<=end;i+=diff) {
				System.out.print(i+", ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		Object o=new Object();
		Thread th1=new Thread(new PrintSeriesSynchonized(5,25,5,o));
		Thread th2=new Thread(new PrintSeriesSynchonized(10,50,10,o));
		Thread th3=new Thread(new PrintSeriesSynchonized(50,250,50,o));
		th1.start();
		th2.start();
		th3.start();
	}

}