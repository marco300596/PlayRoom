package test.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLoginSelenium {
	//Flavio Pucci
	@Test
	void testLogin() {
		
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8080/PlayRoom/login.jsp");
		
		driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("a");
		driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys("a");
		driver.findElement(By.xpath("/html/body/form/input[3]")).click();
		driver.findElement(By.xpath("/html/body/form/input[5]")).click();
		
		
		String actualUrl="http://localhost:8080/PlayRoom/LoginServlet?uname=a&pass=a&user=player";
		String expectedUrl= driver.getCurrentUrl();
		driver.close();
		assertEquals(actualUrl, expectedUrl);
		
		
		
		
		
		
	}

}
