import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableServiceExample {
	public class MyCallable implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName() + " -->Start  thread");
			
			int sum=0;
			try {
				Thread.sleep(1000);
				for(int i=0;i<100;i++)
				{
					sum=sum+i;
					System.out.println(Thread.currentThread().getName()+" "+sum);
				}
			} catch (InterruptedException e) {
				//throw new MyException();
			}
			
			return "Hii";
		}
	}

	public static void main(String[] args) {
		CallableServiceExample eg = new CallableServiceExample();
		

		Callable<String> c1 = eg.new MyCallable();
		Callable<String>c2=eg.new MyCallable();		

		
		ExecutorService e = Executors.newFixedThreadPool(2);

		Future<String> f = e.submit(c1);
		Future<String> f1 = e.submit(c2);

			while(!f.isDone()&& !f1.isDone()) {
				System.out.println(Thread.currentThread().getName() + " -->Wait");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			String s = null;
			
			try {
				s = f.get();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " +s);
	}

}
