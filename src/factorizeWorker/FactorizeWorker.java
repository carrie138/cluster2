package factorizeWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class FactorizeWorker implements Runnable 
{
	private final int someBigNum;
	private final Semaphore semaphore;
	
	public FactorizeWorker(int someBigNum, Semaphore semaphore)
	{
		this.someBigNum = someBigNum;
		this.semaphore = semaphore;
	}
	
	@Override
	public void run()
	{
		try
		{
			List<Long> factors = new ArrayList<Long>();
		
			int half = someBigNum /2 + 1;
		
			for( long x=2 ; x < half; x++)
				if( someBigNum % x == 0 )
					factors.add(x);
		
			System.out.print(someBigNum + " ");
		
			if( factors.size() == 0 )
				System.out.println(" prime ");
			else
				System.out.println( factors.toString());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("exit");
			System.exit(1);
		}
		finally
		{
			semaphore.release();
		}
	}	
	public static void main(String[] args) throws Exception
	{
		Random r = new Random();
		long startTime = System.currentTimeMillis();
	
		int numIterations = 100;
		int numThreads = 100;
			
		Semaphore s = new Semaphore(numThreads);
			
		for( int x=0; x < numIterations; x++)
		{
			s.acquire();
			FactorizeWorker bf = new FactorizeWorker(Math.abs(r.nextInt()), s);
			new Thread( bf).start();
			System.out.println( "count: " + x + " " + (System.currentTimeMillis() - startTime) / 1000f );
		}
			
		for( int x=0; x < numThreads; x++)
			s.acquire();
			
		System.out.println("Total time : " + (System.currentTimeMillis() - startTime) / 1000f );
	
	}

}
