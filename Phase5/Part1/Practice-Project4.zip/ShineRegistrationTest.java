package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShineRegistrationTest {
	
	public static void main(String[] args) {
		//step:1 declare the path
		String path="C:\\Users\\Admin\\Phase5\\chromedriver\\chromedriver.exe";
		
		//step:2 set system property
		System.setProperty("webdriver.chrome.driver", path);
		
		//step:3 give base url
		String url="https://www.shine.com/registration/";
		
		//step:4 initiate webdriver
		WebDriver driver= new ChromeDriver();
		
		driver.get(url);
		
		
		//locating web elements
		WebElement name= driver.findElement(By.id("id_name"));
		name.sendKeys("Murali");

		
		WebElement email= driver.findElement(By.id("id_email"));
		email.sendKeys("Murali@gmail.com");
		
		WebElement phoneno= driver.findElement(By.id("id_cell_phone"));
		phoneno.sendKeys("9876543211");
		
		WebElement password=driver.findElement(By.id("id_password"));
		password.sendKeys("Murali@123");
		
		WebElement checkbox= driver.findElement(By.id("id_privacy"));
		checkbox.sendKeys("");
		
		WebElement register=driver.findElement(By.name("registerButton"));
		register.click();
	}

}
