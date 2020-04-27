package relatedOperations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Table2
{
	public static void main(String[] args) throws IOException 
	{
	
		//File destinationFile = new File("../Jobs4utech/src/main/resources/TextFile/TableData.txt");
		File destinationFile = new File("../Jobs4utech/Output/TableData.txt");
		String temp ="";
		
		for (int i=1; i<=10; i++)
		{
			int mul = i*2;
			temp = temp+"\n"+ mul;
			//System.out.println(mul);
		}
		//System.out.println("temp ="+temp);
		FileUtils.writeStringToFile(destinationFile, temp);
		
		//ProcessBuilder	pb = new ProcessBuilder("notepad.exe", "C:\\\\Users\\\\SonyVaio-HK\\\\Desktop\\\\TableData.txt");
		ProcessBuilder	pb = new ProcessBuilder("notepad.exe", "../Jobs4utech/Output/TableData.txt");
		pb.start();
	
	
	}
}