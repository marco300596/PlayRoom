package test.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class JoinTournamentSelenium {
	//Marco Casentini
	@Test
	void joinTournamentTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");//ricordarsi di togliere .exe per chi lavopra con linux
		WebDriver page = new ChromeDriver();
		page.get("http://localhost:8080/PlayRoom/login.jsp");
		
		page.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("a");
		page.findElement(By.xpath("/html/body/form/input[2]")).sendKeys("a");
		page.findElement(By.xpath("/html/body/form/input[3]")).click();
		page.findElement(By.xpath("/html/body/form/input[5]")).click();
		
		Thread.sleep(1500);
		page.findElement(By.xpath("/html/body/nav/div/ul/li[1]/a")).click();
		
		page.findElement(By.xpath("/html/body/div/form/input[1]")).sendKeys("roma");
		page.findElement(By.xpath("/html/body/div/form/input[2]")).click();
		
		page.findElement(By.xpath("/html/body/div/table/tbody/tr[7]/td[5]/form/input[1]")).click();
		
		String expectedUrl = page.getCurrentUrl();
		String actualUrl = "http://localhost:8080/PlayRoom/Player.jsp";
		page.close();
		assertEquals(actualUrl, expectedUrl);
	}

}
