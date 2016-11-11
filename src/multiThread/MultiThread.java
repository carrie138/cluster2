package multiThread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MultiThread {
		
	public static void main(String[] args) throws Exception
	
	{
		String st = ("qsub " + "java -jar " + factorizeWorker.FactorizeWorker)
		
		BufferedWriter writer = new BufferedWriter(st);
		
		writer.flush();	writer.close();
			
		
	}
}
