import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TC1 {



    public static void main(String[] args){
        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        boolean verifyTitle = driver.getTitle().equals("OrangeHRM");
        assertTrue(verifyTitle);
    }
}
