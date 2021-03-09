package Alphanorth.GamerzArena;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	private static long DELAY_SECONDS = 2000;

	public static void main(String[] args) throws InterruptedException, Throwable {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://testing.gamerzarena.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Click on accept button
		// Sikuli
		Thread.sleep(DELAY_SECONDS);
		Screen acceptBTN = new Screen();
		acceptBTN.click("C:\\Users\\Admin\\Downloads\\Game Images\\AcceptBtn.png");
		
		// Click on Login button
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/header/div[2]/a/button")).click();

		// Enter Email
		driver.findElement(By.name("email")).sendKeys("mytest.qatesting+01@gmail.com");

		// Enter Password
		driver.findElement(By.name("password")).sendKeys("Gamer@23");

		// Click on Login button
		Screen Login = new Screen();
		Login.click("C:\\Users\\Admin\\Downloads\\Game Images\\Login_btn.png");
		Thread.sleep(3000);
		
		//Click on Profile icon
		driver.findElement(By.cssSelector("div[class^='HeaderMenu_menu__3Np2Y']")).click();
		//driver.findElement(By.linkText("Profile")).click();
		
		//Click on Logout button
		Screen Logout = new Screen();
		Logout.click("C:\\Users\\Admin\\Downloads\\Game Images\\LogOut_btn.png");
//		
//		// Scroll till footer(with cssSelector<formcontrolname>)
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		WebElement element = driver.findElement(By.id("footer-button-wrapper"));
//		je.executeScript("arguments[0].scrollIntoView();", element);
//		System.out.println(element.getText());
//		
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/footer/nav/ul[1]/li[1]/a")).click();
		Thread.sleep(5000);
		
		driver.close();

	}

}
