package multiThread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MultiThread {
	private static int countNum =0;
	
	public static final File FASTA_DIR = new File("/users/cvettrai/someData/fasta");
	public static final File RDP_OUT_DIR = new File("/users/cvettrai/someData/rdpOut");
	public static final File RDP_RUN_DIR = new File("/users/cvettrai/someData/rdpRun");
	
	public static final String RDP_SUFFIX = "toRDP.txt";
	
	public static void main(String[] args) throws Exception
	{
		String[] files = FASTA_DIR.list();
		List<File> allShFiles = new ArrayList<File>();
		
		for(String s : files)
			if( s.endsWith("fasta"))
		{
			countNum++;
			File fastaFile = new File(FASTA_DIR.getAbsolutePath() + File.separator + s);
			
			File rdpOutFile = new File(RDP_OUT_DIR.getAbsolutePath() + File.separator + s + RDP_SUFFIX);
			
			File runFile = new File(RDP_RUN_DIR.getAbsoluteFile() + File.separator + "run_" + countNum + ".sh");
			
			BufferedWriter writer = new BufferedWriter( new FileWriter(runFile));
			
			writer.write("java -jar /users/cvettrai/rdp_classifier_2.12/dist/classifier.jar" + "-o \"" + rdpOutFile.getAbsolutePath() + "\" -q \"" + fastaFile + "\"\n");
			
			writer.write("gzip " + rdpOutFile.getAbsolutePath() + " \n");
			
			writer.flush();	writer.close();
			
			allShFiles.add(runFile);
			
			}
	}
}
