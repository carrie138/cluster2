package multiThread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MultiThread {
		
	public static void main(String[] args) throws Exception
	
	{
		try(BufferedReader reader = new BufferedReader(String))
		{
					
			reader.("factorizeWorker.FactorizeWorker");
			BufferedWriter writer = new BufferedWriter();
			writer.("qsub " + "java -jar " + factorizeWorker.FactorizeWorker);
		}
		
		catch( IOException e)
		{
			e.printStackTrace();
		}
	}
}
