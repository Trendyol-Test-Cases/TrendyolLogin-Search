import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPageTrendyol   {

    protected WebDriver driver;
    public static String loginUrl = "https://www.trendyol.com";
    protected static WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/buketacl/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();
    }

    @Test
    public void correctLogin() throws InterruptedException {

        driver.get(loginUrl);
        driver.findElement(By.className("homepage-popup-gender")).click();
        driver.findElement(By.cssSelector(".navigation-icon-user")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navigation-icon-user")));
        driver.findElement(By.className("login-link")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        driver.findElement(By.cssSelector("#email")).sendKeys("buket.acl@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("DENEMESIFREGIRISI");
        driver.findElement(By.id("loginbutton")).click();

        Assert.assertEquals(driver.getTitle(),"Kadın, Moda, Giyim, Stil, Giyim Markaları | Trendyol");
        System.out.println("Facebook ile giriş yapıldığı görüldü");
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
