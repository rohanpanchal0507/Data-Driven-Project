package Alphanorth.GamerzArena;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel_Sign_in {

    private static long DELAY_SECONDS = 850;
    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

    @Test
    public void Login() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://testing.gamerzarena.com/tournaments");

        Thread.sleep(DELAY_SECONDS);

        // Click on Sign In button
        driver.findElement(By.cssSelector("button[class^='button-shadow btn btn-primary']")).click();

        // get excel file
        File src = new File("C:\\Users\\Admin\\Downloads\\Untitled 1.xlsx");
        FileInputStream finput = new FileInputStream(src);

        workbook = new XSSFWorkbook(finput);
        sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= 1; i++) {

            // Enter Username
            cell = sheet.getRow(i).getCell(0);
            cell.setCellType(CellType.STRING);
            driver.findElement(By.cssSelector("input[placeholder^='User name or Email Address']")).clear();
            driver.findElement(By.cssSelector("input[placeholder^='User name or Email Address']"))
                    .sendKeys(cell.getStringCellValue());
            Thread.sleep(DELAY_SECONDS);

            // Enter Password
            cell = sheet.getRow(i).getCell(1);
            cell.setCellType(CellType.STRING);
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());

            // Click on SignIn
            driver.findElement(By.cssSelector("button[type^='submit']")).click();

            Thread.sleep(2000);

        }

        // Click on Account Button
        driver.findElement(By.cssSelector("div[class^='HeaderMenu_profileMenu__2umIR']")).click();

        // Click on Logout button
        driver.findElement(By.linkText("Logout")).click();

    }

}
