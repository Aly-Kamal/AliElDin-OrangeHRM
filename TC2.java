import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertTrue;

public class TC2 {
    public static void main(String[] args){
        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("alikamal");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        WebElement loginText = driver.findElement(By.tagName("h5"));
        boolean verifyInvalidMessage = driver.findElement(with(By.tagName("p")).below(loginText)).getText().equals("Invalid credentials");
        assertTrue(verifyInvalidMessage);
    }
}
