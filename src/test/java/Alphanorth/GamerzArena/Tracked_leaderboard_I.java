package Alphanorth.GamerzArena;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tracked_leaderboard_I {
	
	private static long DELAY_SECONDS = 2000;

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://testingconsole.gamerzarena.com/login");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Enter Email
		driver.findElement(By.id("email")).sendKeys("mytest.qatesting+01@gmail.com");

		// Enter Password
		driver.findElement(By.id("password")).sendKeys("Gamer@23");

		Thread.sleep(1000);
		
		// Click on Login button
		driver.findElement(By.cssSelector("button[class^='btn btn-primary btn-md btn-block waves-effect text-center m-b-20']")).click();
		//driver.findElement(By.xpath("/html/body/section/div/div/div/div/form/div/div[5]/div/button")).click();
		
		// Click on Gameplay dropdown
		driver.findElement(By.linkText("Gameplay")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/nav/div[2]/div/div[1]/div/ul/li[4]/a")).click();	
		
		// Click on Contests button
		// Sikuli
		//Screen search = new Screen();
		driver.findElement(By.linkText("Contests")).click();
		//search.click("C:\\Users\\Admin\\Downloads\\Game Images\\ContestBtn.png");
		
		// Click on Create button
		driver.findElement(By.linkText("Create")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/ul/li[4]/a[1]")).click();
		
		// Enter Contest name
		driver.findElement(By.name("name")).sendKeys("Tracked leaderboard contest1");
		
		// Click on action checkbox(Featured)
		Screen action = new Screen();
		action.click("C:\\Users\\Admin\\Downloads\\Game Images\\featured.png");
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/label/span[1]/i")).click();	
	
		// Click on platform checkbox
		action.click("C:\\Users\\Admin\\Downloads\\Game Images\\PS5.png");
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[2]/div[3]/div/div[3]/label/span[1]/i")).click();
				
		// Click on Stream option
		action.click("C:\\Users\\Admin\\Downloads\\Game Images\\tracked.png");
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[2]/div[4]/div/div/div[1]/label")).click();
				
		// Click on Contest status dropdown
		driver.findElement(By.id("status")).click();	
		// Click on Contest enable button		
		Select s = new Select(driver.findElement(By.id("status")));
		s.selectByIndex(0);
		
		// Click on Game dropdown
		driver.findElement(By.id("select2-game-id-container")).click();
		Actions enter = new Actions(driver);
		driver.findElement(By.xpath("/html/body/span[3]/span/span[1]/input")).sendKeys("fifa");
		enter.sendKeys(Keys.ENTER).build().perform();
		
		// Scroll till min ages
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("min-age"));
		je.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println(element.getText());
		
		//Get Current date & time
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String currentDate= dateFormat.format(date);
		
		//Click & enter current time-date on Visible time
		driver.findElement(By.xpath("//form/div[3]/div[1]/div[2]/div/div/div[3]/div[3]/div/div/input[2]")).sendKeys(currentDate);
	//	/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div
		//Click & enter current time-date on Start time
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[3]/div[1]/div/div/input[2]")).sendKeys(currentDate);

		//Get future date & time
		Date date2 = new Date(date.getTime() + (1000 * 60 * 60 * 24 * 7));
		String FutureDate = dateFormat.format(date2);
		
		//Click & enter next month same time-date on End time 
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[3]/div[2]/div/div/input[2]")).sendKeys(FutureDate);

		//Upload contest Images
		//Arena small Image
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[7]/div[1]/div/button[1]")).click();
		Thread.sleep(500);
		Screen Arena_s = new Screen();
		//Arena_s.click("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\down_arrw_btn.png");
		Arena_s.type("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\down_arrw_btn.png","C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images");
		Arena_s.click("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\Path_img1.png");
		//Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\Game_img.png");
	    //Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\Contest_Images.png");
		Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\A_S_imag.png");
		
		//Arena large image/video
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[7]/div[2]/div/button[1]")).click();
		Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\A_L_img.png");
		
		//Lobby cover image/video
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[7]/div[3]/div/button[1]")).click();
		Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\L_C_img.png");
		
		//Tournament cover image/video
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[8]/div[1]/div/button[1]")).click();
		Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\T_C_img.png");
		
		//Landing page image/video
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[8]/div[2]/div/button[1]")).click();
		Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\Landing_img.png");
		
		//Game setting image
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[2]/div/div/div[8]/div[3]/div/button[1]")).click();
		Arena_s.doubleClick("C:\\Users\\Admin\\Downloads\\Game Images\\Contest_Images\\G_S_img.png");
		
		// Click on Entry fee type dropdown
		driver.findElement(By.name("entry_fee_type")).click();	
		// Click on amount based option		
		Select s1 = new Select(driver.findElement(By.name("entry_fee_type")));
		s1.selectByIndex(0);
		
		//Enter Entry fee
		driver.findElement(By.name("entry_fee")).sendKeys("2");
		
		//Clear Entry-GamerzArena%
		driver.findElement(By.name("prize[gamerz_percent]")).clear();
		//Enter Entry-GamerzArena%
		driver.findElement(By.name("prize[gamerz_percent]")).sendKeys("0");
		
		//Enter Re-Entry fee
		driver.findElement(By.name("reentry_fee")).sendKeys("2");
				
		//Clear Re-Entry GamerzArena%
		driver.findElement(By.name("prize[gamerz_reentry_percent]")).clear();
		//Enter Re-Entry GamerzArena%
		driver.findElement(By.name("prize[gamerz_reentry_percent]")).sendKeys("0");
		
		// Click on Entry fee type dropdown
		driver.findElement(By.name("prize_type")).click();	
		// Click on amount based option		
		Select s2 = new Select(driver.findElement(By.name("prize_type")));
		s2.selectByIndex(0);
		
		//Clear Initial prize pool
		driver.findElement(By.name("prize[initial_prize_pool]")).clear();
		//Enter Initial prize pool
		driver.findElement(By.name("prize[initial_prize_pool]")).sendKeys("100");
		
		// Click on Prize Distribution Type dropdown
		driver.findElement(By.name("prize_distribute_type")).click();	
		// Click on slip with next position option		
		Select s3 = new Select(driver.findElement(By.name("prize_distribute_type")));
		s3.selectByIndex(0);

		// Click on How to win Type dropdown
		driver.findElement(By.name("result_type_id")).click();	
		// Click on best score option		
		Select s4 = new Select(driver.findElement(By.name("result_type_id")));
		s4.selectByIndex(0);
		
		//Clear How to win label
		driver.findElement(By.name("result_label")).clear();
		//Enter How to win label
		driver.findElement(By.name("result_label")).sendKeys("Best Score");
		
		//Clear time from Entry time limit
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[3]/div[1]/div/div[7]/div[1]/div/div/input[2]")).clear();
		//Enter time in Entry time limit
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[3]/div[1]/div/div[7]/div[1]/div/div/input[2]")).sendKeys("01:05:00");
		
		//Click on Recoup Initial Pot checkbox
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/form/div[3]/div[1]/div[3]/div[1]/div/div[8]/div/div/div/label/span[1]/i")).click();	

		//Enter prize places
		driver.findElement(By.name("prize[tiers][0][percent]")).sendKeys("50");
		driver.findElement(By.name("prize[tiers][1][percent]")).sendKeys("30");
		driver.findElement(By.name("prize[tiers][2][percent]")).sendKeys("20");

		// Scroll till Contest rules
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.id("contest-rules-editor-box"));
		je1.executeScript("arguments[0].scrollIntoView();", element1);
		System.out.println(element1.getText());
			
		//Enter Rules in Contest Rules
		driver.findElement(By.xpath("//*[@id=\"contest_rule_ifr\"]")).sendKeys(" Don’t cheat in-game\r\n"
				+ "\r\n"
				+ "We want the Battlefield V play experience to be fair and fun for everyone. To do that, we consider removing anyone who tries to give unfair advantages to themselves or others by cheating.\r\n"
				+ "\r\n"
				+ "Such behavior can include, but isn’t limited to:\r\n"
				+ "\r\n"
				+ "    using third-party software, such as aimbots, wallhacks, and other similar cheats in order to gain an unfair advantage over other players.\r\n"
				+ "    performing in-game exploits, or abusing glitches or bugs\r\n"
				+ "    stat padding (abusing game features in an unintended manner to artificially stack on scores)\r\n"
				+ "    win-trading or otherwise manipulating in-game ranking systems with the collaboration of others\r\n"
				+ "        This includes unfair play in Firestorm, like teaming up with another player in Solo, or squads collaborating with other squads.\r\n"
				+ "\r\n"
				+ "Using software or cheat tools that disconnect other players from the EA servers is also against the rules.\r\n"
				+ "\r\n"
				+ "Similarly, win-trading with other players or squads has a bad effect on competition and makes the game experience a lot less fun for players who are playing fairly.\r\n"
				+ "\r\n"
				+ "In-game cheating is not fair play and hurts the experience for the players you are playing against.\r\n"
				+ "Mind where you buy your Battlefield Currency\r\n"
				+ "\r\n"
				+ "We’ve all seen offers online for cheap in-game currency. The only way to be certain that you’re buying Battlefield Currency in accordance with the rules is to buy it from within the game or the Origin, PlayStation, or Xbox One stores.\r\n"
				+ "\r\n"
				+ "If you buy Battlefield Currency from an unauthorized third-party site, you’re at risk of having your account information stolen by phishers. Some of these sites ask for your login information so they can “add the Currency to your account”, but once they have your account info, they have access to your account whenever they want it.\r\n"
				+ "\r\n"
				+ "This means they can compromise your account, lock you out of it, and even get you banned.\r\n"
				+ "\r\n"
				+ "Whatever the deal they’re offering is, in the long term, it’s not worth it.\r\n"
				+ "Don’t make false claims\r\n"
				+ "\r\n"
				+ "Making a false claim to EA Help Advisors or any other EA representative is against our gameplay rules, and it’s not cool. That’s why we warn you that making a false claim can lead to us taking action on your account.\r\n"
				+ "Don’t hack other players' accounts\r\n"
				+ "\r\n"
				+ "It might seem like a no-brainer, but accessing another player’s account is totally and completely against the rules.\r\n"
				+ "Don’t be a troll\r\n"
				+ "\r\n"
				+ "Hate speech and offensive emblems are not cool, and we won’t accept “But I was role-playing!” as an excuse.  Harassment of other players will earn you a time-out.\r\n"
				+ "Don’t get a dishonorable discharge\r\n"
				+ "\r\n"
				+ "We’re serious about the rules, and our penalty system is cumulative. This means that if you keep breaking the rules, we may need to close your EA Account");
		//driver.findElement(By.cssSelector("input[placeholder^='Write rule here']")).sendKeys("Test");

		//Scroll till Social URLs
		JavascriptExecutor je2 = (JavascriptExecutor) driver;
		WebElement element2 = driver.findElement(By.name("facebook_url"));
		je2.executeScript("arguments[0].scrollIntoView();", element2);
		System.out.println(element2.getText());
				
		//Enter Facebook, Twitter, Twitch & Discord URL
		driver.findElement(By.name("facebook_url")).sendKeys("https://facebook.com/");
		driver.findElement(By.name("twitter_url")).sendKeys("https://twitter.com/");
		driver.findElement(By.name("twitch_url")).sendKeys("https://twitch.tv/");
		driver.findElement(By.name("discord_url")).sendKeys("https://discord.com/");

		//Enter text in Description
		driver.findElement(By.xpath("//*[@id=\"description_ifr\"]")).sendKeys(" NHL 21 is an ice hockey simulation video game developed by EA Vancouver and published by EA Sports. It is the 30th installment in the NHL game series and was released for the PlayStation 4 and Xbox One consoles in October 2020.");
		
		//Enter Text in Contact
		driver.findElement(By.xpath("//*[@id=\"contact_text_ifr\"]")).sendKeys(" After joining the Discord server you will see only the #announcements channel. You need to click on this games icon under the region you are playing in. After doing this, you will then see the chat channels for your game.");
		
		//Click on Save contest button
		driver.findElement(By.cssSelector("input[class^='btn btn-primary']")).click();
		
		Thread.sleep(DELAY_SECONDS);
		
		driver.close();

	}

}
