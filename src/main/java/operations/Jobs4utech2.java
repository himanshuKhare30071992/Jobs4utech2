package operations;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Jobs4utech2 
{
	public static void main(String[] args) throws Exception
	{
		String currentprojectLocation = System.getProperty("user.dir");
		System.out.println(currentprojectLocation);
		
		File destinationFile = new File("..\\Jobs4utech\\OutputFile\\PuneJobsData.txt");
		
		String completeData ="";

		WebDriver driver = new ChromeDriver();
		driver.get("https://jobs4utech.in/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement technicalJobsLink = driver.findElement(By.xpath("//a[text()='Technical Jobs']"));
		Actions act = new Actions(driver);
		act.moveToElement(technicalJobsLink).build().perform();
		
		WebElement testingJobLink = driver.findElement(By.xpath("//a[text()='Software Testing']"));
		testingJobLink.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for(int i=1; i<=150; i++)
		{
			//System.out.println(i+">"+js.executeScript("scroll(0,"+i*1000+")"));
			js.executeScript("scroll(0,"+i*1000+")");
			Thread.sleep(10);
		}
			
		List<WebElement> listOfPune =	driver.findElements(By.xpath("//a[text()='Pune, India']//following::span[@class='pl-1'][1]"));
		int listSize = listOfPune.size();
		System.out.println("Total Software Testing Jobs available for Pune city = "+listSize);	
		System.out.println("--------------------------------------------------------------");
		
		for(int  i=0; i<listSize; i++)
		{
			WebElement ele =	listOfPune.get(i);
			String eleText = ele.getText();
			System.out.println("#"+i+"--->>> "+eleText);
			System.out.println("--------------------------------------------------------------");
			completeData = completeData+"\n"+ eleText;
		}
			//System.out.println("--------------------------------------------------------------");
		
			System.out.println("Temp = "+completeData);
	
			FileUtils.writeStringToFile(destinationFile, "Total Pune Jobs = "+listSize+"\n"+completeData);
			
			ProcessBuilder	pb = new ProcessBuilder("notepad.exe", "..\\Jobs4utech\\\\OutputFile\\\\PuneJobsData.txt");
			pb.start();	
			
			driver.close();
	
	}

}
