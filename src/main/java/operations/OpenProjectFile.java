package operations;


public class OpenProjectFile 
{
	public static void main(String[] args) throws Exception
	{
		String currentprojectLocation = System.getProperty("user.dir");
		//System.out.println(projectFile);
		
		ProcessBuilder	pb = new ProcessBuilder("notepad.exe", currentprojectLocation+"\\OutputFile\\demoFile.txt");
		pb.start();
	}

}
