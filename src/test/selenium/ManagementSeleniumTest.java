package test.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ManagementSeleniumTest {
	//Alessandro Picco
	@Test
	void testSearch() {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8080/PlayRoom/DeletePlayer.jsp");
		
		driver.findElement(By.xpath("/html/body/div/form/input")).click();
		WebElement content = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[7]/td[1]"));
		String actual = content.getText();
		driver.close();
		assertEquals(actual,"n");
		
	}

}
