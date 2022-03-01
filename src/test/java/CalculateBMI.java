import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculateBMI {

    WebDriver driver;

    @BeforeMethod

    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Normal(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("75");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Normal");
    }

    @Test
    public void Obese(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("98");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Obese");
    }

    @Test
    public  void Overweight(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("82");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Overweight");
    }

    @Test
    public void Starvation(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("45");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category,"Your category is Starvation");
    }

    @Test
    public void AlertWg(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("9");
        driver.findElement(By.name("ht")).sendKeys("180");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();

        Alert alert = driver.switchTo().alert();
        alert.getText();

        //Assert.assertEquals(alert,"Weight should be greater than 10kgs");
    }

    @Test
    public void AlertHt(){
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("90");
        driver.findElement(By.name("ht")).sendKeys("19");
        driver.findElement(By.cssSelector("[value = Calculate]")).click();

        Alert alert = driver.switchTo().alert();
        alert.getText();

        //Assert.assertEquals(alert,"Height should be taller than 33cms");
    }

    @AfterMethod(alwaysRun = true)

    public void tearDown(){
        driver.quit();
    }

}
