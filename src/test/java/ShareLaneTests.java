import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShareLaneTests {

    @Test
    public void signUpPositiveTest(){
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py?");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        driver.findElement(By.cssSelector("input[value=Continue]")).click();

        Assert.assertTrue(driver.findElement(By.name("first_name")).isDisplayed());

        driver.quit();
    }

    // #1 Positive test. Zip_code
    @Test
    public void signUpSecondPositiveTest(){
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py?");

        driver.findElement(By.name("zip_code")).sendKeys("56452");

        driver.findElement(By.cssSelector("input[value=Continue]")).click();

        Assert.assertTrue(driver.findElement(By.name("first_name")).isDisplayed());

        driver.quit();
    }

    // #2 Negative test. Zip_code
    @Test
    public void signUpNegativeTest(){
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py?");

        driver.findElement(By.name("zip_code")).sendKeys("awawaw");

        driver.findElement(By.cssSelector("input[value=Continue]")).click();

        Assert.assertTrue(driver.findElement(By.className("error_message")).isDisplayed());

        driver.quit();
    }

    // #3 Positive test. Register
    @Test
    public void signUpRegisterPositiveTest(){
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py?");

        driver.findElement(By.name("zip_code")).sendKeys("56452");

        driver.findElement(By.cssSelector("input[value=Continue]")).click();

        driver.findElement(By.name("first_name")).sendKeys("Joe");
        driver.findElement(By.name("email")).sendKeys("joe@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("Password94");
        driver.findElement(By.name("password2")).sendKeys("Password94");

        driver.findElement(By.cssSelector("input[value=Register]")).click();

        Assert.assertTrue(driver.findElement(By.className("confirmation_message")).isDisplayed());

        driver.quit();
    }

    // #4 Negative test. Register
    @Test
    public void signUpRegisterNegativeTest(){
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py?");

        driver.findElement(By.name("zip_code")).sendKeys("56452");

        driver.findElement(By.cssSelector("input[value=Continue]")).click();

        driver.findElement(By.name("email")).sendKeys("joe@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("Password94");
        driver.findElement(By.name("password2")).sendKeys("Password94");

        driver.findElement(By.cssSelector("input[value=Register]")).click();

        Assert.assertTrue(driver.findElement(By.className("error_message")).isDisplayed());

        driver.quit();
    }
}