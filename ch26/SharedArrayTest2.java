// SharedArrayTest.java
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest2
{
	public static void main(String[] args)
	{
		SimpleArray2 sharedSimpleArray = new SimpleArray2(6);
		
		ArrayWriter2 writer1 = new ArrayWriter2(1, sharedSimpleArray);
		ArrayWriter2 writer2 = new ArrayWriter2(11, sharedSimpleArray);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		
		executor.shutdown();
		
		try
		{
			boolean tasksEnded = executor.awaitTermination(
				1, TimeUnit.MINUTES);
				
			if(tasksEnded)
				System.out.println(sharedSimpleArray);
			else
				System.out.println(
					"Timed out while waiting for tasks to finish.");
		}
		catch(InterruptedException ex)
		{
			System.out.println(
				"Interrupted while waiting for tasks to finish.");
		}
	}
}