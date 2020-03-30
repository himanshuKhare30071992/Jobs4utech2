package operations;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WriteWebpageData 
{
	
	public static void main(String[] args) throws Exception
	{
		
		String currentprojectLocation = System.getProperty("user.dir");
		//System.out.println(currentprojectLocation);
		String temp="";
		WebDriver driver = new ChromeDriver();
		driver.get(currentprojectLocation+"\\InputFile\\divHierarchy.html");
		
		List<WebElement> div = 	driver.findElements(By.xpath("//div"));
		System.out.println("Total Div Size = "+div.size());
		File destinationFile = new File("../Jobs4utech/Output/WebpageData.txt");
		
		for(int i=0; i<div.size(); i++)
		{
		  String text = div.get(i).getText();
		  temp = temp + " \n " +text;
		  System.out.println(text);
		}
		
		System.out.println("------------");
		System.out.println(temp);
		
		FileUtils.writeStringToFile(destinationFile, temp);
	
		ProcessBuilder pb = new ProcessBuilder("notepad.exe", "../Jobs4utech/Output/WebpageData.txt");
		pb.start();
		driver.close();
	}

}
