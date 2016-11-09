package multiThread;

import java.io.BufferedWriter;

public class MultiThread {
		
	public static void main(String[] args) throws Exception
	{
		 	
		BufferedWriter writer = new BufferedWriter(null);
			
		writer.write("java -jar /users/cvettrai/rdp_classifier_2.12/dist/classifier.jar" + "-o \"" + "factorizeWorker.FactorizeWorker" + "\"\n");
		
		writer.flush();	writer.close();
			
		
	}
}
