package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndPopups {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Phase5\\chromedriver\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		
		
		//simple alert box
		driver.findElement(By.name("alertbox")).click();
		driver.switchTo().alert().accept();
		
		//confirm alert box
		driver.findElement(By.name("confirmalertbox")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Confirm Alerbox text: "+driver.findElement(By.id("demo")).getText());
		
		//propmt alert box 
		
		driver.findElement(By.name("promptalertbox1234")).click();
		driver.switchTo().alert().sendKeys("Yes");
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
		System.out.println("Prompt Alert Text: "+driver.findElement(By.id("demoone")).getText());
		
		
		driver.close();
		
		
		
	}

}
