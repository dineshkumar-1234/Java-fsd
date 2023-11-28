package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverLocators {
	
	public static void main(String[] args) {
		//step:1 declare the path
		String path="C:\\Users\\Admin\\Phase5\\chromedriver\\chromedriver.exe";
		
		//step:2 set system property
		System.setProperty("webdriver.chrome.driver", path);
		
		//step:3 give base url
		String url="https://www.facebook.com/";
		
		//step:4 initiate webdriver
		WebDriver driver= new ChromeDriver();
		
		driver.get(url);
		
		
		//locating web elements
		
		//by id
		WebElement email_id= driver.findElement(By.id("email"));
		
		//by name
		WebElement email_name=driver.findElement(By.name("email"));
		
		System.out.println("Email by Id And Name is: "+email_id.equals(email_name));
		
		//link text 
		WebElement link=driver.findElement(By.linkText("Forgotten password?"));
		
		//link.click();
		
		//by relative path (x path)
		
		WebElement email_xpath=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		
		System.out.println("Email by id and Xpath  is: "+email_id.equals(email_xpath));
		
		
		//by full x path
		
		WebElement email_fullxpath=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input"));
		
		System.out.println("Email by xpath and fullXpath  is: "+email_fullxpath.equals(email_xpath));
		
				
		//by selector
		
		WebElement email_cssSelector=driver.findElement(By.cssSelector("#email"));
		System.out.println("Email by id and Selector is :"+email_id.equals(email_cssSelector));
		
		
		//by tag
		
		WebElement pass_tag=driver.findElement(By.cssSelector("input[name=pass]"));
		System.out.println("Password using Tag: "+pass_tag.getAttribute("placeholder"));
		
		//get the list of webelements
		List<WebElement> list=driver.findElements(By.cssSelector("input.inputtext"));
		
		for(WebElement e:list) {
			System.out.println("List of WebElements:"+e.getAttribute("placeholder"));
		}
		
		 driver.close();
		
		
		//login.submit();
	}

}
